package eu.evesuite.eve.ui.editor.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;

import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.jpa.InvTypeMaterial;
import eu.evesuite.eve.ui.editor.InvTypeEditorInput;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.Realm;

public class InvTypeEditorPageInvention extends FormPage {
	
	private Table table;
	private TableViewer tableViewer;

	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public InvTypeEditorPageInvention(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * 
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public InvTypeEditorPageInvention(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Empty FormPage");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody()
				.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(managedForm.getForm().getBody(),
				SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		composite.setLayout(new GridLayout(1, false));

		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		managedForm.getToolkit().paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		new TableViewerColumnSorter(tableViewerColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				// TODO Remove this method, if your getValue(Object) returns Comparable.
				// Typical Comparable are String, Integer, Double, etc.
				return super.doCompare(viewer, e1, e2);
			}
			@Override
			protected Object getValue(Object o) {
				// TODO remove this method, if your EditingSupport returns value
				return super.getValue(o);
			}
		};
		tableViewerColumn.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				
				Object entity = cell.getElement();
				
				if (entity instanceof InvTypeMaterial) {
					cell.setImage(new Image(getSite().getShell().getDisplay(), "/home/gregor/evedata/tyr101-img/icons/32_32/icon" + ((InvTypeMaterial)entity).getMaterialInvType().getEveIcon().getIconFile() + ".png"));
				} else {
					cell.setText(entity.toString());
				}
				
			}
		});
		TableColumn tableColumn = tableViewerColumn.getColumn();
		tableColumn.setWidth(100);
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		new TableViewerColumnSorter(tableViewerColumn_1) {
			@Override
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				// TODO Remove this method, if your getValue(Object) returns Comparable.
				// Typical Comparable are String, Integer, Double, etc.
				return super.doCompare(viewer, e1, e2);
			}
			@Override
			protected Object getValue(Object o) {
				// TODO remove this method, if your EditingSupport returns value
				return super.getValue(o);
			}
		};		tableViewerColumn_1.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				
				Object entity = cell.getElement();

				if (entity instanceof InvTypeMaterial) {
					cell.setText(((InvTypeMaterial)entity).getMaterialInvType().getTypeName());
				} else {
					cell.setText(entity.toString());
				}
				
			}
		});		
		TableColumn tableColumn_1 = tableViewerColumn_1.getColumn();
		tableColumn_1.setWidth(100);
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_2.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				
				Object entity = cell.getElement();
				
				cell.setText(Integer.toString(((InvTypeMaterial)entity).getQuantity()));
			}
		});		
		TableColumn tableColumn_2 = tableViewerColumn_2.getColumn();
		tableColumn_2.setWidth(100);

		initDataBindings();
	}
	
	public InvType getEntity() {
		return ((InvTypeEditorInput) getEditorInput()).getEntity();
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		//IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), InvTypeMaterial.class, new String[]{"materialInvType.eveIcon", "materialInvType", "quantity"});
		//tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		//
		IObservableList getEntityInvTypeMaterialsObserveList = PojoObservables.observeList(Realm.getDefault(), getEntity(), "invTypeMaterials");
		tableViewer.setInput(getEntityInvTypeMaterialsObserveList);
		//
		return bindingContext;
	}
}
