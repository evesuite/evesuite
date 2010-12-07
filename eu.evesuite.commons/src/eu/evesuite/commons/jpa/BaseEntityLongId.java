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
@EntityListeners({ BaseEntityLongId.BaseEntityListener.class })
public class BaseEntityLongId extends BaseEntity implements IBaseEntityLongId {

	public static class BaseEntityListener {

		@PrePersist
		public void onPrePersist(BaseEntityLongId entity) {
		}

		@PreUpdate
		public void onPreUpdate(BaseEntityLongId entity) {
		}
	}

	@Id
	@Column(name = "id", nullable = false)
	protected long id;

	public BaseEntityLongId() {
	}

	/**
	 * @param id
	 * @param createdAt
	 * @param updatedAt
	 */
	public BaseEntityLongId(int id, Date createdAt, Date updatedAt) {

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

		BaseEntityLongId other = (BaseEntityLongId) obj;

		if (id != other.getId()) {
			return false;
		}

		return true;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return (int)id;
	}

	public void setId(long id) {
		propertyChangeSupport.firePropertyChange("id", this.id, this.id = id);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [id=" + id + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
