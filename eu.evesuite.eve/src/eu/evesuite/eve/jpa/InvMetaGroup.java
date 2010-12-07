package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="invMetaGroups")
public class InvMetaGroup implements Serializable {

	private static final long serialVersionUID = -7196288630010399839L;

	@Id
	private int metaGroupID;

	private String description;

	private int iconID;

	private String metaGroupName;
	
	@OneToMany(mappedBy = "invMetaGroup", fetch = FetchType.LAZY)
	private Collection<InvMetaType> invMetaTypes;

    public InvMetaGroup() {
    }

	public int getMetaGroupID() {
		return this.metaGroupID;
	}

	public void setMetaGroupID(int metaGroupID) {
		this.metaGroupID = metaGroupID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIconID() {
		return this.iconID;
	}

	public void setIconID(int iconID) {
		this.iconID = iconID;
	}

	public String getMetaGroupName() {
		return this.metaGroupName;
	}

	public void setMetaGroupName(String metaGroupName) {
		this.metaGroupName = metaGroupName;
	}
	
	public void setInvMetaTypes(Collection<InvMetaType> invMetaTypes) {
		this.invMetaTypes = invMetaTypes;
	}

	public Collection<InvMetaType> getInvMetaTypes() {
		return invMetaTypes;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + metaGroupID;
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
		if (!(obj instanceof InvMetaGroup)) {
			return false;
		}
		InvMetaGroup other = (InvMetaGroup) obj;
		if (metaGroupID != other.getMetaGroupID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InvMetaGroup [metaGroupID="
				+ metaGroupID
				+ ", "
				+ (metaGroupName != null ? "metaGroupName=" + metaGroupName
						+ ", " : "")
				+ (description != null ? "description=" + description + ", "
						: "") + "iconID=" + iconID + ", "
				+ (invMetaTypes != null ? "invMetaTypes=" + invMetaTypes : "")
				+ "]";
	}

	
}