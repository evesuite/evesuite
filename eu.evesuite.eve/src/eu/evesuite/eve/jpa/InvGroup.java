package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name="invGroups")
public class InvGroup implements Serializable {

	private static final long serialVersionUID = 6838679511147104735L;

	@Id
	private int groupID;

	private boolean allowManufacture;

	private boolean allowRecycler;

	private boolean anchorable;

	private boolean anchored;

	private boolean categoryID;

	private String description;

	private boolean fittableNonSingleton;

	private int iconID;

	private String groupName;

	private boolean published;

	private boolean useBasePrice;

	@ManyToOne
	@JoinColumn(name = "iconID", insertable=false, updatable=false)	
	private EveIcon eveIcon;	

	@ManyToOne
	@JoinColumn(name="categoryID", insertable=false, updatable=false)
	private InvCategory invCategory;
	
	@OneToMany(mappedBy = "invGroup", fetch = FetchType.LAZY)
	private Collection<InvType> invTypes;
	
    public InvGroup() {
    }

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public boolean getAllowManufacture() {
		return this.allowManufacture;
	}

	public void setAllowManufacture(boolean allowManufacture) {
		this.allowManufacture = allowManufacture;
	}

	public boolean getAllowRecycler() {
		return this.allowRecycler;
	}

	public void setAllowRecycler(boolean allowRecycler) {
		this.allowRecycler = allowRecycler;
	}

	public boolean getAnchorable() {
		return this.anchorable;
	}

	public void setAnchorable(boolean anchorable) {
		this.anchorable = anchorable;
	}

	public boolean getAnchored() {
		return this.anchored;
	}

	public void setAnchored(boolean anchored) {
		this.anchored = anchored;
	}

	public boolean getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(boolean categoryID) {
		this.categoryID = categoryID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getFittableNonSingleton() {
		return this.fittableNonSingleton;
	}

	public void setFittableNonSingleton(boolean fittableNonSingleton) {
		this.fittableNonSingleton = fittableNonSingleton;
	}

	public int getIconID() {
		return this.iconID;
	}

	public void setIconID(int iconID) {
		this.iconID = iconID;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean getPublished() {
		return this.published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean getUseBasePrice() {
		return this.useBasePrice;
	}

	public void setUseBasePrice(boolean useBasePrice) {
		this.useBasePrice = useBasePrice;
	}

	public void setEveIcon(EveIcon eveIcon) {
		this.eveIcon = eveIcon;
	}

	public EveIcon getEveIcon() {
		return eveIcon;
	}

	public void setInvCategory(InvCategory invCategory) {
		this.invCategory = invCategory;
	}

	public InvCategory getInvCategory() {
		return invCategory;
	}

	public void setInvTypes(Collection<InvType> invTypes) {
		this.invTypes = invTypes;
	}

	public Collection<InvType> getInvTypes() {
		return invTypes;
	}

}