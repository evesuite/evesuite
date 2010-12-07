package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crpNPCDivisions database table.
 * 
 */
@Entity
@Table(name="crpNPCDivisions")
public class CrpNPCDivision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte divisionID;

	private String description;

	private String divisionName;

	private String leaderType;

    public CrpNPCDivision() {
    }

	public byte getDivisionID() {
		return this.divisionID;
	}

	public void setDivisionID(byte divisionID) {
		this.divisionID = divisionID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDivisionName() {
		return this.divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getLeaderType() {
		return this.leaderType;
	}

	public void setLeaderType(String leaderType) {
		this.leaderType = leaderType;
	}

}