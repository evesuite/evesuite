package eu.evesuite.commons.jpa;

import java.beans.PropertyChangeListener;
import java.util.Map;

import javax.persistence.Query;

public interface IModelService {

	public final static String PROPERTY_CHANGE_STATUS = "status";
	
	public final static String PROPERTY_CHANGE_CONNECT = "connect";
	
	public final static String PROPERTY_CHANGE_DISCONNECT = "disconnect";
	
	public void addPropertyChangeListener(PropertyChangeListener listener);

	public void removePropertyChangeListener(PropertyChangeListener listener);
	
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener);

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener);

	public void setPersistenceUnit(String persistenceUnit) throws RuntimeException;
	
	public <T> T find(Class<T> arg0, Object arg1);

	public void persist(Object arg0) throws Exception;
	
	public void remove(Object arg0) throws Exception;	
	
	public Query createQuery(String arg0) throws Exception;
	
	public Query createNamedQuery(String arg0) throws Exception;
	
	public Query createNativeQuery(String arg0) throws Exception;
	
	public void open() throws Exception;

	@SuppressWarnings("rawtypes")
	public void open(Map map) throws Exception;

	public void close() throws Exception;
	
	public boolean isOpened();

}
