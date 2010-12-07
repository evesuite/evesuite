package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapRegionJumps database table.
 * 
 */
@Entity
@Table(name="mapRegionJumps")
public class MapRegionJump implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MapRegionJumpPK id;

    public MapRegionJump() {
    }

	public MapRegionJumpPK getId() {
		return this.id;
	}

	public void setId(MapRegionJumpPK id) {
		this.id = id;
	}
	
}