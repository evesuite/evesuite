package eu.evesuite.eve.jpa;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name="planetSchematics")
public class PlanetSchematic implements Serializable {
	
	private static final long serialVersionUID = -3761500559198251457L;

	@Id
	private int schematicID;

	private int cycleTime;

	private String schematicName;

	@OneToMany(mappedBy = "planetSchematic", fetch = FetchType.LAZY)	
	private Collection<PlanetSchematicsTypeMap> planetSchematicsTypeMaps;
		
    public PlanetSchematic() {
    }

	public int getSchematicID() {
		return this.schematicID;
	}

	public void setSchematicID(int schematicID) {
		this.schematicID = schematicID;
	}

	public int getCycleTime() {
		return this.cycleTime;
	}

	public void setCycleTime(int cycleTime) {
		this.cycleTime = cycleTime;
	}

	public String getSchematicName() {
		return this.schematicName;
	}

	public void setSchematicName(String schematicName) {
		this.schematicName = schematicName;
	}

	public void setPlanetSchematicsTypeMaps(Collection<PlanetSchematicsTypeMap> planetSchematicsTypeMaps) {
		this.planetSchematicsTypeMaps = planetSchematicsTypeMaps;
	}

	public Collection<PlanetSchematicsTypeMap> getPlanetSchematicsTypeMaps() {
		return planetSchematicsTypeMaps;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + schematicID;
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
		if (!(obj instanceof PlanetSchematic)) {
			return false;
		}
		PlanetSchematic other = (PlanetSchematic) obj;
		if (schematicID != other.getSchematicID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PlanetSchematic [schematicID="
				+ schematicID
				+ ", "
				+ (schematicName != null ? "schematicName=" + schematicName
						+ ", " : "") + "cycleTime=" + cycleTime + "]";
	}
	
}