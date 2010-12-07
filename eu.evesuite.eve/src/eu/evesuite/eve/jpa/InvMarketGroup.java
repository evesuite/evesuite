package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="invMarketGroups")
@NamedQuery(name="InvMarketGroup.Parent", query = "SELECT a FROM InvMarketGroup a WHERE a.parentGroupID IS NULL")
public class InvMarketGroup implements Serializable {

	private static final long serialVersionUID = 4938578595565203344L;

	@Id
	private int marketGroupID;

	private String description;

	private int iconID;

	private boolean hasTypes;

	private String marketGroupName;

	private int parentGroupID;

	@ManyToOne
	@JoinColumn(name = "parentGroupID", insertable=false, updatable=false)
	private InvMarketGroup parentInvMarketGroup;

	@OneToMany(mappedBy = "parentInvMarketGroup", fetch = FetchType.LAZY)	
	private Collection<InvMarketGroup> invMarketGroups;
	
	@OneToMany(mappedBy = "invMarketGroup", fetch = FetchType.LAZY)	
	private Collection<InvType> invTypes;
	
	@ManyToOne
	@JoinColumn(name = "iconID", insertable=false, updatable=false)
	private EveIcon eveIcon;
	
    public InvMarketGroup() {
    }
    
	public Collection<InvType> getInvTypes() {
		return invTypes;
	}

	public void setInvTypes(Collection<InvType> invTypes) {
		this.invTypes = invTypes;
	}

	public InvMarketGroup getParentInvMarketGroup() {
		return parentInvMarketGroup;
	}

	public void setParentInvMarketGroup(InvMarketGroup parentInvMarketGroup) {
		this.parentInvMarketGroup = parentInvMarketGroup;
	}

	public Collection<InvMarketGroup> getInvMarketGroups() {
		return invMarketGroups;
	}

	public void setInvMarketGroups(Collection<InvMarketGroup> invMarketGroups) {
		this.invMarketGroups = invMarketGroups;
	}

	public int getMarketGroupID() {
		return this.marketGroupID;
	}

	public void setMarketGroupID(int marketGroupID) {
		this.marketGroupID = marketGroupID;
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

	public boolean getHasTypes() {
		return this.hasTypes;
	}

	public boolean hasTypes() {
		return getHasTypes();
	}

	public void setHasTypes(boolean hasTypes) {
		this.hasTypes = hasTypes;
	}

	public String getMarketGroupName() {
		return this.marketGroupName;
	}

	public void setMarketGroupName(String marketGroupName) {
		this.marketGroupName = marketGroupName;
	}

	public int getParentGroupID() {
		return this.parentGroupID;
	}

	public void setParentGroupID(int parentGroupID) {
		this.parentGroupID = parentGroupID;
	}

	public void setEveIcon(EveIcon eveIcon) {
		this.eveIcon = eveIcon;
	}

	public EveIcon getEveIcon() {
		return eveIcon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marketGroupID;
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
		if (!(obj instanceof InvMarketGroup)) {
			return false;
		}
		InvMarketGroup other = (InvMarketGroup) obj;
		if (marketGroupID != other.getMarketGroupID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InvMarketGroup [marketGroupID="
				+ marketGroupID
				+ ", "
				+ (description != null ? "description=" + description + ", "
						: "")
				+ "iconID="
				+ iconID
				+ ", hasTypes="
				+ hasTypes
				+ ", "
				+ (marketGroupName != null ? "marketGroupName="
						+ marketGroupName + ", " : "")
				+ "parentGroupID="
				+ parentGroupID
				+ ", "
				+ (parentInvMarketGroup != null ? "parentInvMarketGroup="
						+ parentInvMarketGroup + ", " : "")
				+ (invMarketGroups != null ? "invMarketGroups="
						+ invMarketGroups + ", " : "")
				+ (invTypes != null ? "invTypes=" + invTypes + ", " : "")
				+ (eveIcon != null ? "eveIcon=" + eveIcon : "") + "]";
	}

	
}