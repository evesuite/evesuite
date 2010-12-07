package eu.evesuite.eve.ui.editor.page;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.tree.TreeNode;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import eu.evesuite.eve.bean.TechTreeNode;
import eu.evesuite.eve.jpa.EVEModelServiceImpl;
import eu.evesuite.eve.jpa.InvBlueprintType;
import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.jpa.InvTypeMaterial;
import eu.evesuite.eve.ui.Activator;
import eu.evesuite.eve.ui.editor.InvTypeEditorInput;

public class InvTypeEditorPageTechTree extends FormPage {

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
		
		for (TechTreeNode techTreeNode : techTree) {
			techTreeNode.setParent(node);
		}
		
		viewer = new GraphViewer(form.getBody(), SWT.BORDER);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setLayoutAlgorithm(new TreeLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		viewer.setInput(node);
		
		/*
		// Graph will hold all other objects
		Graph graph = new Graph(form.getBody(), SWT.NONE);
		// Now a few nodes
		GraphNode node1 = new GraphNode(graph, SWT.NONE, "Jim");
		GraphNode node2 = new GraphNode(graph, SWT.NONE, "Jack");
		GraphNode node3 = new GraphNode(graph, SWT.NONE, "Joe");
		GraphNode node4 = new GraphNode(graph, SWT.NONE, "Bill");
		// Lets have a directed connection
		new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1,
				node2);
		// Lets have a dotted graph connection
		new GraphConnection(graph, ZestStyles.CONNECTIONS_DOT, node2, node3);
		// Standard connection
		new GraphConnection(graph, SWT.NONE, node3, node1);
		// Change line color and line width
		GraphConnection graphConnection = new GraphConnection(graph, SWT.NONE,
				node1, node4);
		graphConnection.changeLineColor(form.getBody().getDisplay().getSystemColor(
				SWT.COLOR_GREEN));
		// Also set a text
		graphConnection.setText("This is a text");
		graphConnection.setHighlightColor(form.getBody().getDisplay().getSystemColor(
				SWT.COLOR_RED));
		graphConnection.setLineWidth(3);
		graphConnection.addListener(SWT.SELECTED, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				System.out.println("Selected");
			}

		});
		
		graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
				*/
	}

}
