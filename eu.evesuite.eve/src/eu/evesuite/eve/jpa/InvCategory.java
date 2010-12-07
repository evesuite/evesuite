package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name="invCategories")
public class InvCategory implements Serializable {

	private static final long serialVersionUID = -1868277078559016835L;

	@Id
	private int categoryID;

	private String categoryName;

	private String description;

	private int iconID;

	private boolean published;

	@ManyToOne
	@JoinColumn(name = "iconID", insertable=false, updatable=false)	
	private EveIcon eveIcon;

	@OneToMany(mappedBy = "invCategory", fetch = FetchType.LAZY)
	private Collection<InvGroup> invGroups;
	
    public InvCategory() {
    }

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public boolean getPublished() {
		return this.published;
	}

	public boolean isPublished() {
		return getPublished();
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public void setEveIcon(EveIcon eveIcon) {
		this.eveIcon = eveIcon;
	}

	public EveIcon getEveIcon() {
		return eveIcon;
	}

	public void setInvGroups(Collection<InvGroup> invGroups) {
		this.invGroups = invGroups;
	}

	public Collection<InvGroup> getInvGroups() {
		return invGroups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryID;
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
		if (!(obj instanceof InvCategory)) {
			return false;
		}
		InvCategory other = (InvCategory) obj;
		if (categoryID != other.getCategoryID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InvCategory [categoryID="
				+ categoryID
				+ ", "
				+ (categoryName != null ? "categoryName=" + categoryName + ", "
						: "")
				+ (description != null ? "description=" + description + ", "
						: "") + "iconID=" + iconID + ", published=" + published
				+ ", " + (eveIcon != null ? "eveIcon=" + eveIcon + ", " : "")
				+ (invGroups != null ? "invGroups=" + invGroups : "") + "]";
	}
	
}