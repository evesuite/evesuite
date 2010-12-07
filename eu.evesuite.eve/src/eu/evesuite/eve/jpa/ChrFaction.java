package eu.evesuite.eve.jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the chrFactions database table.
 */
@Entity
@Table(name = "chrFactions")
public class ChrFaction extends EntityAbstract {

	private static final long serialVersionUID = 1124778085754646915L;

	@Id
	private int factionID;

	private int corporationID;

	private String description;

	private String factionName;

	private int militiaCorporationID;

	// @Converter(name="races", converterClass=ChrRacesConvertor.class)
	// @Convert("races")
	private int raceIDs;

	private double sizeFactor;

	private int solarSystemID;

	private int stationCount;

	private int stationSystemCount;

	@OneToMany(mappedBy = "chrFaction", fetch = FetchType.LAZY)
	private Collection<MapRegion> mapRegions;

	@OneToMany(mappedBy = "chrFaction", fetch = FetchType.LAZY)
	private Collection<MapConstellation> mapConstellations;

	@OneToMany(mappedBy = "chrFaction", fetch = FetchType.LAZY)
	private Collection<MapSolarSystem> mapSolarSystems;

	@ManyToOne
	@JoinColumn(name = "corporationID", insertable=false, updatable=false)
	private CrpNPCCorporation crpNPCCorporation;

	@ManyToOne
	@JoinColumn(name = "militiaCorporationID", insertable=false, updatable=false)
	private CrpNPCCorporation militiaCrpNPCCorporation;

	@OneToMany(mappedBy = "chrFaction", fetch = FetchType.LAZY)
	private Collection<CrpNPCCorporation> crpNPCCorporations;

	public ChrFaction() {
	}

	public Collection<MapRegion> getMapRegions() {
		return mapRegions;
	}

	public void setMapRegions(Collection<MapRegion> mapRegions) {
		this.mapRegions = mapRegions;
	}

	public Collection<MapConstellation> getMapConstellations() {
		return mapConstellations;
	}

	public void setMapConstellations(
			Collection<MapConstellation> mapConstellations) {
		this.mapConstellations = mapConstellations;
	}

	public Collection<MapSolarSystem> getMapSolarSystems() {
		return mapSolarSystems;
	}

	public void setMapSolarSystems(Collection<MapSolarSystem> mapSolarSystems) {
		this.mapSolarSystems = mapSolarSystems;
	}

	public CrpNPCCorporation getCrpNPCCorporation() {
		return crpNPCCorporation;
	}

	public void setCrpNPCCorporation(CrpNPCCorporation crpNPCCorporation) {
		this.crpNPCCorporation = crpNPCCorporation;
	}

	public CrpNPCCorporation getMilitiaCrpNPCCorporation() {
		return militiaCrpNPCCorporation;
	}

	public void setMilitiaCrpNPCCorporation(
			CrpNPCCorporation militiaCrpNPCCorporation) {
		this.militiaCrpNPCCorporation = militiaCrpNPCCorporation;
	}

	public Collection<CrpNPCCorporation> getCrpNPCCorporations() {
		return crpNPCCorporations;
	}

	public void setCrpNPCCorporations(
			Collection<CrpNPCCorporation> crpNPCCorporations) {
		this.crpNPCCorporations = crpNPCCorporations;
	}

	public int getFactionID() {
		return this.factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}

	public int getCorporationID() {
		return this.corporationID;
	}

	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFactionName() {
		return this.factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public int getMilitiaCorporationID() {
		return this.militiaCorporationID;
	}

	public void setMilitiaCorporationID(int militiaCorporationID) {
		this.militiaCorporationID = militiaCorporationID;
	}

	public int getRaceIDs() {
		return this.raceIDs;
	}

	public void setRaceIDs(int raceIDs) {
		this.raceIDs = raceIDs;
	}

	public double getSizeFactor() {
		return this.sizeFactor;
	}

	public void setSizeFactor(double sizeFactor) {
		this.sizeFactor = sizeFactor;
	}

	public int getSolarSystemID() {
		return this.solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public int getStationCount() {
		return this.stationCount;
	}

	public void setStationCount(int stationCount) {
		this.stationCount = stationCount;
	}

	public int getStationSystemCount() {
		return this.stationSystemCount;
	}

	public void setStationSystemCount(int stationSystemCount) {
		this.stationSystemCount = stationSystemCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + factionID;
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
		if (!(obj instanceof ChrFaction)) {
			return false;
		}
		ChrFaction other = (ChrFaction) obj;
		if (factionID != other.factionID) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ChrFaction [factionID=" + factionID + ", corporationID="
				+ corporationID + ", description=" + description
				+ ", factionName=" + factionName + ", militiaCorporationID="
				+ militiaCorporationID + ", raceIDs=" + raceIDs
				+ ", sizeFactor=" + sizeFactor + ", solarSystemID="
				+ solarSystemID + ", stationCount=" + stationCount
				+ ", stationSystemCount=" + stationSystemCount
				+ ", mapRegions=" + mapRegions + ", mapConstellations="
				+ mapConstellations + ", mapSolarSystems=" + mapSolarSystems
				+ ", crpNPCCorporation=" + crpNPCCorporation
				+ ", militiaCrpNPCCorporation=" + militiaCrpNPCCorporation
				+ ", crpNPCCorporations=" + crpNPCCorporations + "]";
	}

}