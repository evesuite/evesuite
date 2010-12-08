package eu.evesuite.eve.ui.adapters;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;

import eu.evesuite.commons.utils.AbstractDeferredAdapter;
import eu.evesuite.eve.jpa.EveIcon;
import eu.evesuite.eve.jpa.InvMarketGroup;
import eu.evesuite.eve.jpa.InvType;

public class InvMarketGroupAdapter extends AbstractDeferredAdapter {

	@Override
	public Object[] getChildren(Object o) {

		InvMarketGroup entity = (InvMarketGroup) o;
		
		Collection<InvMarketGroup> collection = entity.getInvMarketGroups();
		
		Collections.sort((List<InvMarketGroup>)collection, new Comparator<InvMarketGroup>() {

			@Override
			public int compare(InvMarketGroup o1, InvMarketGroup o2) {
				return o1.getMarketGroupName().compareTo(o2.getMarketGroupName());
			}
			
		});
		
		Collection<InvType> types = entity.getInvTypes();

		Collections.sort((List<InvType>)types, new Comparator<InvType>() {

			@Override
			public int compare(InvType o1, InvType o2) {
				return o1.getTypeName().compareTo(o2.getTypeName());
			}
			
		});
		
		Collection<Object> list = new ArrayList<Object>();
		list.addAll(collection);
		list.addAll(types);
		
		if (list instanceof Collection) {
								
			return list.toArray(new Object[list.size()]);
		}		

		return new Object[0];
	}
	
	@Override
	public ImageDescriptor getImageDescriptor(Object object) {
		
		InvMarketGroup entity = (InvMarketGroup) object;
		
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

		InvMarketGroup entity = (InvMarketGroup) o;

		return entity.getMarketGroupName();
	}

}
