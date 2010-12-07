package eu.evesuite.eve.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;

import eu.evesuite.commons.utils.DefaultDeferredAdapter;

public class MarketContentProviderAdapterFactory implements IAdapterFactory {

	private IDeferredWorkbenchAdapter adapter = new DefaultDeferredAdapter();
	
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		return adapter;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return  new Class[] { IDeferredWorkbenchAdapter.class, IWorkbenchAdapter.class, DefaultDeferredAdapter.class };
	}

}
