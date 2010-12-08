package eu.evesuite.eve.ui.views;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;

import eu.evesuite.eve.bean.TechTreeNode;
import eu.evesuite.eve.jpa.EVEModelServiceImpl;
import eu.evesuite.eve.jpa.EveIcon;
import eu.evesuite.eve.jpa.InvBlueprintType;
import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.ui.Activator;

public class TechTreeItemView extends ViewPart implements IZoomableWorkbenchPart {

	public static final String ID = "eu.evesuite.eve.ui.views.TechTreeItemView";

	private ISelectionListener listener = new ISelectionListener() {

		public void selectionChanged(IWorkbenchPart part, ISelection sel) {
			
			if (!(sel instanceof IStructuredSelection))
				return;
			
			IStructuredSelection ss = (IStructuredSelection) sel;
			
			Object o = ss.getFirstElement();

			if (o instanceof InvType) {
				
				EVEModelServiceImpl service = (EVEModelServiceImpl) Activator.getDefault().getModelService();
				
				InvType entity = (InvType)o;
				Collection<TechTreeNode> techTree = null;
				
				if (service instanceof EVEModelServiceImpl) {
					InvBlueprintType blueprint;
					
					if (service.isBluePrint(entity)) {					
						blueprint = service.find(InvBlueprintType.class, entity.getTypeID());
					} else {
						blueprint = entity.getInvBlueprintType();
					}
					
					techTree = service.getTechTree(blueprint, "", -4.0);			
				}		
				
				if (ss.size() == 1) {
					
					TechTreeNode node = new TechTreeNode();
					node.setInvType(entity);
					node.setAmount(1.0);
					node.setChildren(techTree);
					
					int count = node.countAll();
					
					if (count > 100) {
						viewer.getGraphControl().setPreferredSize(count * 20, count * 20);
					} else {
						viewer.getGraphControl().setPreferredSize(-1,-1);
					}
					
					viewer.setInput(node);
				}
				
			}
		}
	};

	private GraphViewer viewer;

	class ViewContentProvider extends ArrayContentProvider implements
			IGraphEntityContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getConnectedTo(Object entity) {

			if (entity instanceof TechTreeNode) {

				Collection<TechTreeNode> collection = ((TechTreeNode) entity)
						.getChildren();

				if (collection instanceof Collection && collection.size() > 0) {
					return collection.toArray(new Object[collection.size()]);
				}
			}

			return null;
		}

		public Object[] getElements(Object parent) {

			if (parent instanceof TechTreeNode) {

				Collection<TechTreeNode> collection = getNodeChildren(((TechTreeNode) parent), 0);

				return collection.toArray(new Object[collection.size()]);
			}

			return new Object[0];
		}

		protected Collection<TechTreeNode> getNodeChildren(TechTreeNode node, int level) {

			Collection<TechTreeNode> collection = new ArrayList<TechTreeNode>();

			if (node.getType() == TechTreeNode.TYPES.MOON) {
				return collection;
			}
			
			collection.add(node);

			if (node.getChildren().size() > 0) {

				Collection<TechTreeNode> techTreeNodes = ((TechTreeNode) node)
						.getChildren();

				for (TechTreeNode techTreeNode : techTreeNodes) {
					collection.addAll(getNodeChildren(techTreeNode, level +1));
				}

			}

			return collection;
		}
	}

	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {

			if (obj instanceof TechTreeNode) {
				return ((TechTreeNode) obj).getInvType().getTypeName();
			}

			return null;
		}

		public Image getImage(Object object) {

			if (object instanceof TechTreeNode) {
				
				InvType entity = (InvType)((TechTreeNode)object).getInvType();
				
				EveIcon eveIcon = entity.getEveIcon();
				
				if (eveIcon instanceof EveIcon) {
					
					try {
						ImageDescriptor image = ImageDescriptor.createFromURL(new File("/home/gregor/evedata/tyr101-img/icons/32_32/icon" + eveIcon.getIconFile() + ".png").toURI().toURL());
						return image.createImage();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			return null;

		}
	}

	public TechTreeItemView() {

	}

	public void createPartControl(Composite parent) {

		getSite().getPage().addSelectionListener(this.listener);

		viewer = new GraphViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.applyLayout();
		viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		viewer.applyLayout();
		fillToolBar();
	}

	public void dispose() {
		getSite().getPage().removeSelectionListener(this.listener);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	private void fillToolBar() {
		ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(
				this);
		IActionBars bars = getViewSite().getActionBars();
		bars.getMenuManager().add(toolbarZoomContributionViewItem);

	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}
}
