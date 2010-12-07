package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="invMetaTypes")
public class InvMetaType implements Serializable {

	private static final long serialVersionUID = 1321011839086141112L;

	@Id
	private int typeID;

	private int metaGroupID;

	private int parentTypeID;

	@ManyToOne
	@JoinColumn(name = "typeID", insertable=false, updatable=false)	
	private InvType invType;
	
	@ManyToOne
	@JoinColumn(name = "parentTypeID", insertable=false, updatable=false)	
	private InvType parentInvType;
	
	@ManyToOne
	@JoinColumn(name = "metaGroupID", insertable=false, updatable=false)	
	private InvMetaGroup invMetaGroup;
	
    public InvType getInvType() {
		return invType;
	}

	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public InvType getParentInvType() {
		return parentInvType;
	}

	public void setParentInvType(InvType parentInvType) {
		this.parentInvType = parentInvType;
	}

	public InvMetaGroup getInvMetaGroup() {
		return invMetaGroup;
	}

	public void setInvMetaGroup(InvMetaGroup invMetaGroup) {
		this.invMetaGroup = invMetaGroup;
	}

	public InvMetaType() {
    }

	public int getTypeID() {
		return this.typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getMetaGroupID() {
		return this.metaGroupID;
	}

	public void setMetaGroupID(int metaGroupID) {
		this.metaGroupID = metaGroupID;
	}

	public int getParentTypeID() {
		return this.parentTypeID;
	}

	public void setParentTypeID(int parentTypeID) {
		this.parentTypeID = parentTypeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof InvMetaType)) {
			return false;
		}
		InvMetaType other = (InvMetaType) obj;
		if (typeID != other.getTypeID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InvMetaType [typeID="
				+ typeID
				+ ", metaGroupID="
				+ metaGroupID
				+ ", parentTypeID="
				+ parentTypeID
				+ ", "
				+ (invType != null ? "invType=" + invType + ", " : "")
				+ (parentInvType != null ? "parentInvType=" + parentInvType
						+ ", " : "")
				+ (invMetaGroup != null ? "invMetaGroup=" + invMetaGroup : "")
				+ "]";
	}

}