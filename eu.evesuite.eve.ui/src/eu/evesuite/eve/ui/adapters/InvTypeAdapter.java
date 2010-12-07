package eu.evesuite.eve.ui.adapters;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Collection;

import javax.persistence.Query;

import org.eclipse.jface.resource.ImageDescriptor;

import eu.evesuite.commons.jpa.EVEMetricsModelService;
import eu.evesuite.commons.jpa.evemetrics.IMarket;
import eu.evesuite.commons.utils.AbstractDeferredAdapter;
import eu.evesuite.eve.jpa.EveIcon;
import eu.evesuite.eve.jpa.InvType;
import eu.evesuite.eve.ui.Activator;

public class InvTypeAdapter extends AbstractDeferredAdapter {

	@Override
	public Object[] getChildren(Object o) {
		
		InvType entity = (InvType)o;
		
		EVEMetricsModelService service = Activator.getDefault().getMetricsModelService();

		if (service instanceof EVEMetricsModelService) {
			
			try {
				
				Query query = service.createNamedQuery("Market.findByTypeID");				
				query.setParameter("typeID", entity.getTypeID());
				
				@SuppressWarnings("unchecked")
				Collection<IMarket> collection = query.getResultList();
				
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
	
	@Override
	public ImageDescriptor getImageDescriptor(Object object) {
		
		InvType entity = (InvType)object;
		
		EveIcon eveIcon = entity.getEveIcon();
		
		if (eveIcon instanceof EveIcon) {
			
			try {
				return ImageDescriptor.createFromURL(new File("/home/gregor/evedata/tyr101-img/icons/32_32/icon" + eveIcon.getIconFile() + ".png").toURI().toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}	

	@Override
	public String getLabel(Object o) {

		InvType entity = (InvType) o;

		return entity.getTypeName() + " " + Integer.toString(entity.getTypeID());
	}

}
