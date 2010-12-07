package eu.evesuite.eve.ui.adapters;

import eu.evesuite.commons.jpa.evemetrics.IMarket;
import eu.evesuite.commons.utils.AbstractDeferredAdapter;

public class IMarketAdapter extends AbstractDeferredAdapter {

	@Override
	public Object[] getChildren(Object o) {
				
		return new Object[0];
	}

	@Override
	public String getLabel(Object o) {

		IMarket entity = (IMarket) o;

		return Long.toString(entity.getId());
	}

}
