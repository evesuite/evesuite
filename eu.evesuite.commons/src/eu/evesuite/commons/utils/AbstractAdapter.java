package eu.evesuite.commons.utils;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

abstract public class AbstractAdapter implements IWorkbenchAdapter {

	@Override
	public Object[] getChildren(Object o) {
		return new Object[0];
	}

	@Override
	public ImageDescriptor getImageDescriptor(Object object) {
		return null;
	}

	@Override
	public String getLabel(Object o) {
		return "Override getLabel(Object o) in " + this.getClass().getName();
	}

	@Override
	public Object getParent(Object o) {
		return null;
	}

}
