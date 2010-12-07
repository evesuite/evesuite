package eu.evesuite.eve.ui.providers;

import java.util.Collection;

import javax.persistence.Query;

import eu.evesuite.commons.jpa.EVEModelService;
import eu.evesuite.commons.utils.IModelContentProvider;
import eu.evesuite.eve.jpa.InvMarketGroup;
import eu.evesuite.eve.ui.Activator;

public class BluePrintContentProvider implements IModelContentProvider {

	@Override
	public String getName() {
		return "BluePrint";
	}

	@Override
	public Object[] getElements() {
		
		EVEModelService service = Activator.getDefault().getModelService();
		
		if (service instanceof EVEModelService) {
			
			try {
				Query query = service.createNamedQuery("InvMarketGroup.BluePrint");
				
				@SuppressWarnings("unchecked")
				Collection<InvMarketGroup> collection = query.getResultList();
				
				if (collection instanceof Collection) {
					return collection.toArray(new Object[collection.size()]);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return new Object[0];
	}

}
