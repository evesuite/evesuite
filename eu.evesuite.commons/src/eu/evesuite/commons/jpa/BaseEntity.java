package eu.evesuite.commons.jpa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners({ BaseEntity.BaseEntityListener.class })
public class BaseEntity implements IBaseEntity {

	public static class BaseEntityListener {

		@PrePersist
		public void onPrePersist(BaseEntity entity) {

			entity.setCreatedAt(new Date());
			entity.setUpdatedAt(entity.getCreatedAt());
		}

		@PreUpdate
		public void onPreUpdate(BaseEntity entity) {
			entity.setUpdatedAt(new Date());
		}
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
	protected Date createdAt;

	@Transient
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt", nullable = false)
	protected Date updatedAt;

	public BaseEntity() {
	}

	public BaseEntity(Date createdAt, Date updatedAt) {

		super();

		setCreatedAt(createdAt);
		setUpdatedAt(updatedAt);
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void setCreatedAt(Date createdAt) {
		propertyChangeSupport.firePropertyChange("createdAt", this.createdAt,
				this.createdAt = createdAt);
	}

	public void setUpdatedAt(Date updatedAt) {
		propertyChangeSupport.firePropertyChange("updatedAt", this.updatedAt,
				this.updatedAt = updatedAt);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	@Override
	public PropertyChangeListener[] getPropertyChangeListeners() {
		return propertyChangeSupport.getPropertyChangeListeners();
	}

	@Override
	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);		
	}

	@Override
	public PropertyChangeListener[] getPropertyChangeListeners(
			String propertyName) {
		return propertyChangeSupport.getPropertyChangeListeners(propertyName);
	}

	@Override
	public void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	@Override
	public void firePropertyChange(String propertyName, int oldValue,
			int newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
		
	}

	@Override
	public void firePropertyChange(String propertyName, boolean oldValue,
			boolean newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);		
	}

	@Override
	public void firePropertyChange(PropertyChangeEvent event) {
		propertyChangeSupport.firePropertyChange(event);		
	}

	@Override
	public void fireIndexedPropertyChange(String propertyName, int index,
			Object oldValue, Object newValue) {
		propertyChangeSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);	
	}

	@Override
	public void fireIndexedPropertyChange(String propertyName, int index,
			int oldValue, int newValue) {
		propertyChangeSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);		
	}

	@Override
	public void fireIndexedPropertyChange(String propertyName, int index,
			boolean oldValue, boolean newValue) {
		propertyChangeSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
	}

	@Override
	public boolean hasListeners(String propertyName) {
		// TODO Auto-generated method stub
		return false;
	}

}
