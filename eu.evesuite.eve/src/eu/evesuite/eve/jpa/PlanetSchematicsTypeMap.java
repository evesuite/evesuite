package eu.evesuite.eve.jpa;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="planetSchematicsTypeMap")
@IdClass(PlanetSchematicsTypeMapPK.class)
@NamedQuery(
		name = "findPlanetSchematicsByInvType",
		query = "SELECT a FROM PlanetSchematicsTypeMap a WHERE a.typeID=:typeID AND a.isInput=0"		
)
public class PlanetSchematicsTypeMap implements Serializable {

	private static final long serialVersionUID = -1149836552386019393L;

	@Id
	private int schematicID;

	@Id
	private int typeID;

	private boolean isInput;

	private short quantity;

	@ManyToOne
	@JoinColumn(name = "schematicID", insertable=false, updatable=false)	
	private PlanetSchematic planetSchematic;	
			
	@ManyToOne
	@JoinColumn(name = "typeID", insertable=false, updatable=false)	
	private InvType invType;	
			
    public PlanetSchematicsTypeMap() {
    }

	public int getSchematicID() {
		return this.schematicID;
	}
	
	public void setSchematicID(int schematicID) {
		this.schematicID = schematicID;
	}
	
	public int getTypeID() {
		return this.typeID;
	}
	
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
    
	public boolean getIsInput() {
		return this.isInput;
	}

	public void setIsInput(boolean isInput) {
		this.isInput = isInput;
	}

	public short getQuantity() {
		return this.quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public void setPlanetSchematic(PlanetSchematic planetSchematic) {
		this.planetSchematic = planetSchematic;
	}

	public PlanetSchematic getPlanetSchematic() {
		return planetSchematic;
	}

	public void setInvType(InvType invType) {
		this.invType = invType;
	}

	public InvType getInvType() {
		return invType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + schematicID;
		result = prime * result + typeID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PlanetSchematicsTypeMap)) {
			return false;
		}
		PlanetSchematicsTypeMap other = (PlanetSchematicsTypeMap) obj;
		if (schematicID != other.getSchematicID()) {
			return false;
		}
		if (typeID != other.getTypeID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PlanetSchematicsTypeMap [schematicID=" + schematicID
				+ ", typeID=" + typeID + ", quantity=" + quantity
				+ ", isInput=" + isInput + "]";
	}

}