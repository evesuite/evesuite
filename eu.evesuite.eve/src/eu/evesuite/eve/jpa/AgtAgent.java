package eu.evesuite.eve.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * The persistent class for the agtAgents database table.
 * 
 */
@Entity
@Table(name = "agtAgents")
@NamedNativeQuery(name="AgtAgent.IDs", query = "SELECT agentID FROM agtAgents")
public class AgtAgent implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private int agentID;

	private int agentTypeID;

	private int corporationID;

	private int divisionID;

	private int level;

	private int locationID;

	private int quality;

	@ManyToOne
	@JoinColumn(name = "agentID", insertable=false, updatable=false)
	private EveName eveName;

	@ManyToOne
	@JoinColumn(name = "corporationID", insertable=false, updatable=false)
	private CrpNPCCorporation crpNPCCorporation;

	public EveName getEveName() {
		return eveName;
	}

	public void setEveName(EveName eveName) {
		this.eveName = eveName;
	}

	public CrpNPCCorporation getCrpNPCCorporation() {
		return crpNPCCorporation;
	}

	public void setCrpNPCCorporation(CrpNPCCorporation crpNPCCorporation) {
		this.crpNPCCorporation = crpNPCCorporation;
	}

	public AgtAgent() {
	}

	public int getAgentID() {
		return this.agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public int getAgentTypeID() {
		return this.agentTypeID;
	}

	public void setAgentTypeID(int agentTypeID) {
		this.agentTypeID = agentTypeID;
	}

	public int getCorporationID() {
		return this.corporationID;
	}

	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	public int getDivisionID() {
		return this.divisionID;
	}

	public void setDivisionID(int divisionID) {
		this.divisionID = divisionID;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLocationID() {
		return this.locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public int getQuality() {
		return this.quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "AgtAgent [agentID=" + agentID + ", agentTypeID=" + agentTypeID
				+ ", corporationID=" + corporationID + ", divisionID="
				+ divisionID + ", level=" + level + ", locationID="
				+ locationID + ", quality=" + quality + ", eveName=" + eveName
				+ ", crpNPCCorporation=" + crpNPCCorporation + "]";
	}

	
}