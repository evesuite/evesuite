package eu.evesuite.eve.jpa.convertor;

import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

public class ChrRacesConvertor implements Converter {

	private static final long serialVersionUID = 2747851821893506624L;

	@Override
	public Object convertDataValueToObjectValue(Object arg0, Session arg1) {
		
		Integer value = (Integer)arg0;
		
		System.out.println("value:" + value);
		
		return null;
	}

	@Override
	public Object convertObjectValueToDataValue(Object arg0, Session arg1) {
		System.out.println("test2");
		return null;
	}

	@Override
	public void initialize(DatabaseMapping arg0, Session arg1) {
		System.out.println("test0");
		
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	

}
