package eu.evesuite.eve.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;

public class IMarketAdapterFactory implements IAdapterFactory {

	private IWorkbenchAdapter adapter = new IMarketAdapter();
	
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		return adapter;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return  new Class[] { IDeferredWorkbenchAdapter.class, IWorkbenchAdapter.class, IMarketAdapter.class };
	}

}
