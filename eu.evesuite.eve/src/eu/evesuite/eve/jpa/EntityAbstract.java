package eu.evesuite.eve.jpa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the agtAgents database table.
 * 
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners({ EntityAbstract.EntityAbstractListener.class })
abstract public class EntityAbstract implements Serializable,
		PropertyChangeListener {

	public static class EntityAbstractListener {

		@PrePersist
		public void onPrePersist(EntityAbstract entity) {
			throw new RuntimeException("not implemented");
		}

		@PreUpdate
		public void onPreUpdate(EntityAbstract entity) {
			throw new RuntimeException("not implemented");
		}
	}

	@Transient
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}

}
