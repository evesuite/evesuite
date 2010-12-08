package eu.evesuite.eve.ui.providers;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Query;

import eu.evesuite.commons.jpa.EVEModelService;
import eu.evesuite.commons.utils.IModelContentProvider;
import eu.evesuite.eve.jpa.InvMarketGroup;
import eu.evesuite.eve.ui.Activator;

public class TechTreeContentProvider implements IModelContentProvider {

	@Override
	public String getName() {
		return "TechTree";
	}

	@Override
	public Object[] getElements() {
		
		EVEModelService service = Activator.getDefault().getModelService();
		
		if (service instanceof EVEModelService) {
			
			try {
				Query query = service.createNamedQuery("InvMarketGroup.TechTree");
				
				@SuppressWarnings("unchecked")
				Collection<InvMarketGroup> collection = query.getResultList();
				
				if (collection instanceof Collection) {
					
					Collections.sort((List<InvMarketGroup>)collection, new Comparator<InvMarketGroup>() {

						@Override
						public int compare(InvMarketGroup o1, InvMarketGroup o2) {
							return o1.getMarketGroupName().compareTo(o2.getMarketGroupName());
						}
						
					});
					
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
