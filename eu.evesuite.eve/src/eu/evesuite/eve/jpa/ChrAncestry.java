package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chrAncestries database table.
 * 
 */
@Entity
@Table(name="chrAncestries")
public class ChrAncestry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte ancestryID;

	private String ancestryName;

	private byte bloodlineID;

	private byte charisma;

	private String description;

	private short graphicID;

	private byte intelligence;

	private byte memory;

	private byte perception;

	private String shortDescription;

	private byte willpower;

    public ChrAncestry() {
    }

	public byte getAncestryID() {
		return this.ancestryID;
	}

	public void setAncestryID(byte ancestryID) {
		this.ancestryID = ancestryID;
	}

	public String getAncestryName() {
		return this.ancestryName;
	}

	public void setAncestryName(String ancestryName) {
		this.ancestryName = ancestryName;
	}

	public byte getBloodlineID() {
		return this.bloodlineID;
	}

	public void setBloodlineID(byte bloodlineID) {
		this.bloodlineID = bloodlineID;
	}

	public byte getCharisma() {
		return this.charisma;
	}

	public void setCharisma(byte charisma) {
		this.charisma = charisma;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public byte getWillpower() {
		return this.willpower;
	}

	public void setWillpower(byte willpower) {
		this.willpower = willpower;
	}

}