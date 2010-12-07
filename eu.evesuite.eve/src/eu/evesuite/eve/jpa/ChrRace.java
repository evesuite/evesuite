package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chrRaces database table.
 * 
 */
@Entity
@Table(name="chrRaces")
public class ChrRace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte raceID;

	private String description;

	private short graphicID;

	private String raceName;

	private String shortDescription;

    public ChrRace() {
    }

	public byte getRaceID() {
		return this.raceID;
	}

	public void setRaceID(byte raceID) {
		this.raceID = raceID;
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

	public String getRaceName() {
		return this.raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}