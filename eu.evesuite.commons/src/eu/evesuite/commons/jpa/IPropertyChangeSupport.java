package eu.evesuite.commons.jpa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface IPropertyChangeSupport {

	public void addPropertyChangeListener(PropertyChangeListener listener);

	public void removePropertyChangeListener(PropertyChangeListener listener);

	public PropertyChangeListener[] getPropertyChangeListeners();

	public boolean equals(Object object);

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener);

	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener);

	public PropertyChangeListener[] getPropertyChangeListeners(
			String propertyName);

	public void firePropertyChange(String propertyName, Object oldValue,
			Object newValue);

	public void firePropertyChange(String propertyName, int oldValue,
			int newValue);

	public void firePropertyChange(String propertyName, boolean oldValue,
			boolean newValue);

	public void firePropertyChange(PropertyChangeEvent event);

	public void fireIndexedPropertyChange(String propertyName, int index,
			Object oldValue, Object newValue);

	public void fireIndexedPropertyChange(String propertyName, int index,
			int oldValue, int newValue);

	public void fireIndexedPropertyChange(String propertyName, int index,
			boolean oldValue, boolean newValue);

	public boolean hasListeners(String propertyName);
	
}



