package eu.evesuite.commons.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


/**
 * Entity implementation class for Entity: BaseEntity
 * 
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners({ BaseEntityId.BaseEntityListener.class })
public class BaseEntityId extends BaseEntity implements IBaseEntityId {

	public static class BaseEntityListener {

		@PrePersist
		public void onPrePersist(BaseEntityId entity) {
		}

		@PreUpdate
		public void onPreUpdate(BaseEntityId entity) {
		}
	}

	@Id
	@Column(name = "id", nullable = false)
	protected int id;

	public BaseEntityId() {
	}

	/**
	 * @param id
	 * @param createdAt
	 * @param updatedAt
	 */
	public BaseEntityId(int id, Date createdAt, Date updatedAt) {

		super(createdAt, updatedAt);

		setId(id);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		BaseEntityId other = (BaseEntityId) obj;

		if (id != other.getId()) {
			return false;
		}

		return true;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public void setId(int id) {
		propertyChangeSupport.firePropertyChange("id", this.id, this.id = id);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [id=" + id + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
