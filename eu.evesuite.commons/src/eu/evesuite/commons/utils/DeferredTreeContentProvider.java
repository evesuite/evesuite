package eu.evesuite.commons.utils;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.progress.DeferredTreeContentManager;

public class DeferredTreeContentProvider extends BaseWorkbenchContentProvider {
	
	private DeferredTreeContentManager manager;

    @Override
    public Object[] getChildren(Object element) {
            return manager.getChildren(element);
    }

    @Override
    public boolean hasChildren(Object element) {
            return manager.mayHaveChildren(element);
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            manager = new DeferredTreeContentManager((AbstractTreeViewer) viewer);
    }

}
