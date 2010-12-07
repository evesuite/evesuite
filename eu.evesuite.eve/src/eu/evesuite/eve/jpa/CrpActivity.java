package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crpActivities database table.
 * 
 */
@Entity
@Table(name="crpActivities")
public class CrpActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte activityID;

	private String activityName;

	private String description;

    public CrpActivity() {
    }

	public byte getActivityID() {
		return this.activityID;
	}

	public void setActivityID(byte activityID) {
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

}