package eu.evesuite.eve.ui.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.*;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.action.*;
import org.eclipse.swt.SWT;

import eu.evesuite.commons.jpa.EVEModelService;
import eu.evesuite.commons.utils.DeferredTreeContentProvider;
import eu.evesuite.commons.utils.IModelContentProvider;
import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.ui.Activator;
import eu.evesuite.eve.ui.editor.InvTypeEditor;
import eu.evesuite.eve.ui.editor.InvTypeEditorInput;
import eu.evesuite.eve.ui.providers.TechTreeContentProvider;

public class TechTreeView extends ViewPart implements PropertyChangeListener {

	public static final String ID = "eu.evesuite.eve.ui.views.TechTreeView";

	private TreeViewer viewer;

	private Action action;
	
	public TechTreeView() {
		
		EVEModelService service = eu.evesuite.eve.ui.Activator.getDefault().getModelService();

		if (service instanceof EVEModelService) {
			service.addPropertyChangeListener(this);
		}
	}

	@Override
	public void dispose() {
		
		EVEModelService service = eu.evesuite.eve.ui.Activator.getDefault().getModelService();

		if (service instanceof EVEModelService) {
			service.removePropertyChangeListener(this);
		}
	}
	
	public void createPartControl(Composite parent) {
		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new DeferredTreeContentProvider());
        viewer.setLabelProvider(new WorkbenchLabelProvider());
        getSite().setSelectionProvider(viewer);
		
        IModelContentProvider contentProvider = new TechTreeContentProvider();
        
		viewer.setInput(contentProvider);
		
		viewer.getTree().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				ITreeSelection selections = (ITreeSelection)viewer.getSelection();
				
				if (selections instanceof ITreeSelection) {
					
					for (@SuppressWarnings("rawtypes")
					Iterator iterator = selections.iterator(); iterator
							.hasNext();) {
						
						Object selection = iterator.next();
						
						if (selection instanceof InvType) {
							
							InvType entity = (InvType)selection;
							
							try {
								getSite().getPage().openEditor(new InvTypeEditorInput(entity), InvTypeEditor.ID);
							} catch (PartInitException e1) {
								IStatus status = new Status(Status.WARNING, Activator.PLUGIN_ID, e1.getMessage(), e1);
								StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);								
							}
							
						}
					}
				}
				
			}
		});
		
		makeActions();
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				
				if (action instanceof Action) {
					action.run();
				}
			}
		});
	}	
	
	private void makeActions() {
		
		action = new Action() {
			
			public void run() {
				
				if (viewer != null) {
					viewer.refresh();
				}
			}
		};
		
		action.setText("Refresh");
		action.setToolTipText("Refresh TechTree");
	}
}