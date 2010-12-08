package eu.evesuite.eve.ui.editor.page;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;

import eu.evesuite.eve.bean.TechTreeNode;
import eu.evesuite.eve.jpa.EVEModelServiceImpl;
import eu.evesuite.eve.jpa.InvBlueprintType;
import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.ui.Activator;
import eu.evesuite.eve.ui.editor.InvTypeEditorInput;

public class InvTypeEditorPageTechTree extends FormPage implements IZoomableWorkbenchPart {

	private GraphViewer viewer;
	
	class ViewContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}
		
		public Object[] getConnectedTo(Object entity) {
			
			if (entity instanceof TechTreeNode) {
				
				Collection<TechTreeNode> collection = ((TechTreeNode)entity).getChildren();
				
				if (collection instanceof Collection && collection.size() > 0) {
					return collection.toArray(new Object[collection.size()]);
				}
			}
			
			return null;
		}
		

		public Object[] getElements(Object parent) {
			
			if (parent instanceof TechTreeNode) {
				
				Collection<TechTreeNode> collection = getNodeChildren(((TechTreeNode)parent));
				
				return collection.toArray(new Object[collection.size()]);
			}
			
			return new Object[0];
		}
		
		
		protected Collection<TechTreeNode> getNodeChildren(TechTreeNode node) {
			
			Collection<TechTreeNode> collection = new ArrayList<TechTreeNode>();
			
			collection.add(node);

			if (node.getChildren().size() > 0) {
				
				Collection<TechTreeNode> techTreeNodes = ((TechTreeNode)node).getChildren();
				
				for (TechTreeNode techTreeNode : techTreeNodes) {
					collection.addAll(getNodeChildren(techTreeNode));
				}
				
			}
			
			return collection;
		}
	}

	class ViewLabelProvider extends LabelProvider {
		
		public String getText(Object obj) {
			
			if (obj instanceof TechTreeNode) {
				return ((TechTreeNode)obj).getInvType().getTypeName();
			} 
			
			return null;
		}

		public Image getImage(Object obj) {

			return null;
		}
	}

	public InvTypeEditorPageTechTree(FormEditor editor) {
		super(editor, "techtree", "TechTree");
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {

		ScrolledForm form = managedForm.getForm();
		FillLayout fillLayout = new FillLayout();
		form.getBody().setLayout(fillLayout);

		InvType entity = ((InvTypeEditorInput) getEditorInput()).getEntity();
		
		EVEModelServiceImpl service = (EVEModelServiceImpl) Activator.getDefault().getModelService();
		
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
		
		TechTreeNode node = new TechTreeNode();
		node.setInvType(entity);
		node.setAmount(1.0);
		node.setChildren(techTree);
		
		viewer = new GraphViewer(form.getBody(), SWT.BORDER);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.getGraphControl().setPreferredSize(7000, 7000);
		viewer.applyLayout();
		viewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);

		viewer.setInput(node);		
		
		//ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(this);
		//IActionBars bars = managedForm.getgetViewSite().getActionBars();
		//bars.getMenuManager().add(toolbarZoomContributionViewItem);
	}
	
	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}
}
