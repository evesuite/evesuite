package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name="ramActivities")
public class RamActivity implements Serializable {

	private static final long serialVersionUID = -3656614335983137402L;

	@Id
	private int activityID;

	private String activityName;

	private String description;

	private String iconNo;

	private boolean published;

	@OneToMany(mappedBy = "ramActivity", fetch = FetchType.LAZY)
	private Collection<RamTypeRequirement> ramTypeRequirements;
	
    public RamActivity() {
    }

	public int getActivityID() {
		return this.activityID;
	}

	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIconNo() {
		return this.iconNo;
	}

	public void setIconNo(String iconNo) {
		this.iconNo = iconNo;
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

	public void setRamTypeRequirements(Collection<RamTypeRequirement> ramTypeRequirements) {
		this.ramTypeRequirements = ramTypeRequirements;
	}

	public Collection<RamTypeRequirement> getRamTypeRequirements() {
		return ramTypeRequirements;
	}

	
}