package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crtRelationships database table.
 * 
 */
@Entity
@Table(name="crtRelationships")
public class CrtRelationship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int relationshipID;

	private int childID;

	private int parentID;

	private byte parentLevel;

	private short parentTypeID;

    public CrtRelationship() {
    }

	public int getRelationshipID() {
		return this.relationshipID;
	}

	public void setRelationshipID(int relationshipID) {
		this.relationshipID = relationshipID;
	}

	public int getChildID() {
		return this.childID;
	}

	public void setChildID(int childID) {
		this.childID = childID;
	}

	public int getParentID() {
		return this.parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public byte getParentLevel() {
		return this.parentLevel;
	}

	public void setParentLevel(byte parentLevel) {
		this.parentLevel = parentLevel;
	}

	public short getParentTypeID() {
		return this.parentTypeID;
	}

	public void setParentTypeID(short parentTypeID) {
		this.parentTypeID = parentTypeID;
	}

}