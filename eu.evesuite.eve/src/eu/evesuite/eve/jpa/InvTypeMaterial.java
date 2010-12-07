package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invTypeMaterials database table.
 * 
 */
@Entity
@Table(name="invTypeMaterials")
@IdClass(InvTypeMaterialPK.class)
public class InvTypeMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int typeID;
	
	@Id
	private int materialTypeID;

	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "materialTypeID", insertable=false, updatable=false)
	private InvType invType;
	
	@ManyToOne
	@JoinColumn(name = "typeID", insertable=false, updatable=false)
	private InvType materialInvType;

    public InvType getInvType() {
		return invType;
	}

	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public InvType getMaterialInvType() {
		return materialInvType;
	}

	public void setMaterialInvType(InvType materialInvType) {
		this.materialInvType = materialInvType;
	}

	public InvTypeMaterial() {
    }

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getMaterialTypeID() {
		return materialTypeID;
	}

	public void setMaterialTypeID(int materialTypeID) {
		this.materialTypeID = materialTypeID;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}