package eu.evesuite.eve.ui.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.ui.editor.page.InvTypeEditorPageTechTree;

public class InvTypeEditor extends SharedHeaderFormEditor implements PropertyChangeListener {

	public static final String ID = "eu.evesuite.eve.ui.editor.InvTypeEditor";
	
	public InvTypeEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		setSite(site);
		setInput(input);
		
		InvType entity = (InvType) ((InvTypeEditorInput)getEditorInput()).getEntity();
		
		setPartName(entity.getTypeName());
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
	}

	@Override
	protected void addPages() {
		
		try {
			addPage(new InvTypeEditorPageTechTree(this));
			//addPage(new InvTypeEditorPageMaterial(this));
			//addPage(new InvTypeEditorPageOverview(this));
			//addPage(new InvTypeEditorPageInvention(this, "invention", "Invention"));
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void createHeaderContents(IManagedForm managedForm) {
		
		FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        toolkit.decorateFormHeading(form.getForm());
        
        InvType entity = ((InvTypeEditorInput)getEditorInput()).getEntity();
        
        form.setText(entity.getTypeName());
	}
}
