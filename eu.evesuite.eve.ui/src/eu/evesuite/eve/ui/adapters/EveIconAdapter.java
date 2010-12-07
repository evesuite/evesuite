package eu.evesuite.eve.ui.adapters;


import org.eclipse.jface.resource.ImageDescriptor;

import eu.evesuite.commons.utils.AbstractAdapter;
import eu.evesuite.eve.jpa.EveIcon;

public class EveIconAdapter extends AbstractAdapter {

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

		EveIcon entity = (EveIcon) o;

		return entity.getIconFile();
	}

}
