package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chrBloodlines database table.
 * 
 */
@Entity
@Table(name="chrBloodlines")
public class ChrBloodline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte bloodlineID;

	private String bloodlineName;

	private byte charisma;

	private int corporationID;

	private String description;

	private String femaleDescription;

	private short graphicID;

	private byte intelligence;

	private String maleDescription;

	private byte memory;

	private byte perception;

	private byte raceID;

	private short shipTypeID;

	private String shortDescription;

	private String shortFemaleDescription;

	private String shortMaleDescription;

	private byte willpower;

    public ChrBloodline() {
    }

	public byte getBloodlineID() {
		return this.bloodlineID;
	}

	public void setBloodlineID(byte bloodlineID) {
		this.bloodlineID = bloodlineID;
	}

	public String getBloodlineName() {
		return this.bloodlineName;
	}

	public void setBloodlineName(String bloodlineName) {
		this.bloodlineName = bloodlineName;
	}

	public byte getCharisma() {
		return this.charisma;
	}

	public void setCharisma(byte charisma) {
		this.charisma = charisma;
	}

	public int getCorporationID() {
		return this.corporationID;
	}

	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFemaleDescription() {
		return this.femaleDescription;
	}

	public void setFemaleDescription(String femaleDescription) {
		this.femaleDescription = femaleDescription;
	}

	public short getGraphicID() {
		return this.graphicID;
	}

	public void setGraphicID(short graphicID) {
		this.graphicID = graphicID;
	}

	public byte getIntelligence() {
		return this.intelligence;
	}

	public void setIntelligence(byte intelligence) {
		this.intelligence = intelligence;
	}

	public String getMaleDescription() {
		return this.maleDescription;
	}

	public void setMaleDescription(String maleDescription) {
		this.maleDescription = maleDescription;
	}

	public byte getMemory() {
		return this.memory;
	}

	public void setMemory(byte memory) {
		this.memory = memory;
	}

	public byte getPerception() {
		return this.perception;
	}

	public void setPerception(byte perception) {
		this.perception = perception;
	}

	public byte getRaceID() {
		return this.raceID;
	}

	public void setRaceID(byte raceID) {
		this.raceID = raceID;
	}

	public short getShipTypeID() {
		return this.shipTypeID;
	}

	public void setShipTypeID(short shipTypeID) {
		this.shipTypeID = shipTypeID;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getShortFemaleDescription() {
		return this.shortFemaleDescription;
	}

	public void setShortFemaleDescription(String shortFemaleDescription) {
		this.shortFemaleDescription = shortFemaleDescription;
	}

	public String getShortMaleDescription() {
		return this.shortMaleDescription;
	}

	public void setShortMaleDescription(String shortMaleDescription) {
		this.shortMaleDescription = shortMaleDescription;
	}

	public byte getWillpower() {
		return this.willpower;
	}

	public void setWillpower(byte willpower) {
		this.willpower = willpower;
	}

}