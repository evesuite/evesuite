package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="eveIcons")
public class EveIcon implements Serializable {

	private static final long serialVersionUID = 8775670756580810964L;

	@Id
	private int iconID;

	private String iconFile;

	private String description;

	@OneToMany(mappedBy = "eveIcon", fetch = FetchType.LAZY)	
	private Collection<InvCategory> invCategories;
	
	@OneToMany(mappedBy = "eveIcon", fetch = FetchType.LAZY)	
	private Collection<InvGroup> invGroups;
	
	@OneToMany(mappedBy = "eveIcon", fetch = FetchType.LAZY)	
	private Collection<InvType> invTypes;
	
    public EveIcon() {
    }

	public int getIconID() {
		return iconID;
	}

	public void setIconID(int iconID) {
		this.iconID = iconID;
	}

	public String getIconFile() {
		return iconFile;
	}

	public void setIconFile(String iconFile) {
		this.iconFile = iconFile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInvCategories(Collection<InvCategory> invCategories) {
		this.invCategories = invCategories;
	}

	public Collection<InvCategory> getInvCategories() {
		return invCategories;
	}

	public void setInvGroups(Collection<InvGroup> invGroups) {
		this.invGroups = invGroups;
	}

	public Collection<InvGroup> getInvGroups() {
		return invGroups;
	}

	public void setInvTypes(Collection<InvType> invTypes) {
		this.invTypes = invTypes;
	}

	public Collection<InvType> getInvTypes() {
		return invTypes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iconID;
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
		if (!(obj instanceof EveIcon)) {
			return false;
		}
		EveIcon other = (EveIcon) obj;
		if (iconID != other.getIconID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EveIcon [iconID=" + iconID + ", "
				+ (iconFile != null ? "iconFile=" + iconFile + ", " : "")
				+ (description != null ? "description=" + description : "")
				+ "]";
	}

}