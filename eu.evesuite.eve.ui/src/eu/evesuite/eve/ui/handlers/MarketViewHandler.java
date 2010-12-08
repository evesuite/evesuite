package eu.evesuite.eve.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;

import eu.evesuite.eve.ui.Activator;
import eu.evesuite.eve.ui.views.BluePrintView;

public class MarketViewHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {
			window.getActivePage().showView(BluePrintView.ID);
		} catch (Exception e) {
			IStatus status = new Status(Status.WARNING, Activator.PLUGIN_ID, e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.LOG | StatusManager.BLOCK);			
		}
		
		return null;
	}
	
}
