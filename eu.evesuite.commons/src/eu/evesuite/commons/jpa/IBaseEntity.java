package eu.evesuite.commons.jpa;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;



public interface IBaseEntity extends Serializable, PropertyChangeListener, IPropertyChangeSupport {

	public Date getCreatedAt();

	public Date getUpdatedAt();

	public void setCreatedAt(Date createdAt);

	public void setUpdatedAt(Date updatedAt);

}
