package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dgmTypeAttributes database table.
 * 
 */
@Entity
@Table(name="dgmTypeAttributes")
@IdClass(DgmTypeAttributePK.class)
public class DgmTypeAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int typeID;

	@Id
	private int attributeID;

	private double valueFloat;

	private int valueInt;
	
	@ManyToOne
	@JoinColumn(name = "typeID", insertable=false, updatable=false)
	private InvType invType;
	
	@ManyToOne
	@JoinColumn(name = "attributeID", insertable=false, updatable=false)
	private DgmAttributeType dgmAttributeType;
	
    public DgmTypeAttribute() {
    }

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getAttributeID() {
		return attributeID;
	}

	public void setAttributeID(int attributeID) {
		this.attributeID = attributeID;
	}

	public double getValueFloat() {
		return this.valueFloat;
	}

	public void setValueFloat(double valueFloat) {
		this.valueFloat = valueFloat;
	}

	public int getValueInt() {
		return this.valueInt;
	}

	public void setValueInt(int valueInt) {
		this.valueInt = valueInt;
	}

	public InvType getInvType() {
		return invType;
	}

	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public DgmAttributeType getDgmAttributeType() {
		return dgmAttributeType;
	}

	public void setDgmAttributeType(DgmAttributeType dgmAttributeType) {
		this.dgmAttributeType = dgmAttributeType;
	}

}