package eu.evesuite.commons.utils;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;
import org.eclipse.ui.progress.IElementCollector;
import org.eclipse.ui.statushandlers.StatusManager;

import eu.evesuite.commons.Activator;

public abstract class AbstractDeferredAdapter extends AbstractAdapter implements
		IDeferredWorkbenchAdapter {

	@Override 
	public void fetchDeferredChildren(Object object,
            IElementCollector collector, IProgressMonitor monitor) {

        try {

                Object[] children = getChildren(object);

                monitor.beginTask("Loading", children.length);

                for (int loop = 0; loop < children.length; loop++) {

                        if (monitor.isCanceled()) {
                                break;
                        }

                        collector.add(children[loop], monitor);
                        monitor.worked(1);
                }

        } catch (Exception e) {
                IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                                "Error in model", e);
                StatusManager.getManager().handle(status,
                                StatusManager.SHOW | StatusManager.LOG);
        } finally {
                monitor.done();
                collector.done();
        }
}

	

	@Override
	public boolean isContainer() {
		return true;
	}

	@Override
	public ISchedulingRule getRule(Object object) {
		return null;
	}

}
