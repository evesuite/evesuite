package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the planetSchematicsPinMap database table.
 * 
 */
@Entity
@Table(name="planetSchematicsPinMap")
public class PlanetSchematicsPinMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlanetSchematicsPinMapPK id;

    public PlanetSchematicsPinMap() {
    }

	public PlanetSchematicsPinMapPK getId() {
		return this.id;
	}

	public void setId(PlanetSchematicsPinMapPK id) {
		this.id = id;
	}
	
}