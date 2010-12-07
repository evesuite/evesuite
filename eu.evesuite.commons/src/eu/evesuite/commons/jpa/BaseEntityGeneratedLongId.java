package eu.evesuite.commons.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@EntityListeners({ BaseEntityGeneratedLongId.BaseEntityListener.class })
public class BaseEntityGeneratedLongId extends BaseEntity {

	public static class BaseEntityListener {

		@PrePersist
		public void onPrePersist(BaseEntityGeneratedLongId entity) {
		}

		@PreUpdate
		public void onPreUpdate(BaseEntityGeneratedLongId entity) {
		}
	}

	@Id
	@Column(name = "id", nullable = false)
	// @GeneratedValue(generator="system-uuid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;

	public BaseEntityGeneratedLongId() {
	}

	/**
	 * @param id
	 * @param createdAt
	 * @param updatedAt
	 */
	public BaseEntityGeneratedLongId(int id, Date createdAt, Date updatedAt) {

		super(createdAt, updatedAt);

		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		BaseEntityGeneratedLongId other = (BaseEntityGeneratedLongId) obj;

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
		this.id = id;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [id=" + id + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
