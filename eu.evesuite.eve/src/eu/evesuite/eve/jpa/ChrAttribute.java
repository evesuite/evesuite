package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chrAttributes database table.
 * 
 */
@Entity
@Table(name="chrAttributes")
public class ChrAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte attributeID;

	private String attributeName;

	private String description;

	private short graphicID;

	private String notes;

	private String shortDescription;

    public ChrAttribute() {
    }

	public byte getAttributeID() {
		return this.attributeID;
	}

	public void setAttributeID(byte attributeID) {
		this.attributeID = attributeID;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
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

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}