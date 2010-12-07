package eu.evesuite.eve.ui.editor.page;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import eu.evesuite.eve.jpa.EVEModelServiceImpl;
import eu.evesuite.eve.jpa.InvBlueprintType;
import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.jpa.InvTypeMaterial;
import eu.evesuite.eve.ui.Activator;
import eu.evesuite.eve.ui.editor.InvTypeEditorInput;

public class InvTypeEditorPageMaterial extends FormPage {

	private TableViewer viewer;

	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {

			InvType entity = ((InvTypeEditorInput) parent).getEntity();

			/*
			Collection<RamTypeRequirement> ramTypeRequirements = entity
					.getRamTypeRequirements();
					*/

			EVEModelServiceImpl service = (EVEModelServiceImpl) Activator
					.getDefault().getModelService();

			
			if (service instanceof EVEModelServiceImpl) {
				InvBlueprintType blueprint;
				
				if (service.isBluePrint(entity)) {					
					blueprint = service.find(InvBlueprintType.class, entity.getTypeID());
				} else {
					blueprint = entity.getInvBlueprintType();
				}
				
			}
			
			return new Object[0];
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public String getColumnText(Object obj, int index) {

			InvTypeMaterial entity = (InvTypeMaterial) obj;

			switch (index) {
			case 1:
				return entity.getMaterialInvType().getTypeName();
			case 2:
				return Integer.toString(entity.getQuantity());

			default:
				break;
			}

			return null;
		}

		public Image getColumnImage(Object obj, int index) {

			switch (index) {
			case 0:
				return getImage(obj);
			}

			return null;
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	public InvTypeEditorPageMaterial(FormEditor editor) {
		super(editor, "material", "Materials");
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {

		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		GridLayout layout = new GridLayout();
		GridData gd1 = new GridData(GridData.FILL_BOTH);
		gd1.grabExcessHorizontalSpace = true;
		gd1.horizontalAlignment = SWT.FILL;
		layout.numColumns = 1;
		form.getBody().setLayout(layout);
		form.getBody().setLayoutData(gd1);

		InvType entity = ((InvTypeEditorInput) getEditorInput()).getEntity();

		// Creating the Screen
		Section section = toolkit.createSection(form.getBody(),
				Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText("Materials for " + entity.getTypeName());
		section.setDescription("Materials needed to produce one unit of "
				+ entity.getTypeName());
		// Composite for storing the data
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);
		Table t = toolkit.createTable(client, SWT.NULL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		t.setLayoutData(gd);
		toolkit.paintBordersFor(client);
		section.setClient(client);
		viewer = new TableViewer(t);
		String[] titles = { "", "Name", "Quantity" };
		int[] bounds = { 100, 100, 100 };

		for (int i = 0; i < titles.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(titles[i]);
			column.getColumn().setWidth(bounds[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
		}
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(getEditorInput());
	}

}
