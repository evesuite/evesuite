package eu.evesuite.commons.jpa;

import java.util.Collection;

import eu.evesuite.commons.jpa.evemetrics.IMarket;

public interface EVEMetricsModelService extends IModelService {

	public IMarket createIMarket();

	public Collection<IMarket> getIMarkets();
	
}
