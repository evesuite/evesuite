package eu.evesuite.eve.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class EveIconAdapterFactory implements IAdapterFactory {

	private IWorkbenchAdapter adapter = new EveIconAdapter();
	
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		return adapter;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return  new Class[] { IWorkbenchAdapter.class, EveIconAdapter.class };
	}

}
