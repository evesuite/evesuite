package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staStations database table.
 * 
 */
@Entity
@Table(name="staStations")
public class StaStation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int stationID;

	private int constellationID;

	private int corporationID;

	private double dockingCostPerVolume;

	private double maxShipVolumeDockable;

	private int officeRentalCost;

	private byte operationID;

	private int regionID;

	private double reprocessingEfficiency;

	private byte reprocessingHangarFlag;

	private double reprocessingStationsTake;

	private short security;

	private int solarSystemID;

	private String stationName;

	private short stationTypeID;

	private double x;

	private double y;

	private double z;

    public StaStation() {
    }

	public int getStationID() {
		return this.stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public int getConstellationID() {
		return this.constellationID;
	}

	public void setConstellationID(int constellationID) {
		this.constellationID = constellationID;
	}

	public int getCorporationID() {
		return this.corporationID;
	}

	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	public double getDockingCostPerVolume() {
		return this.dockingCostPerVolume;
	}

	public void setDockingCostPerVolume(double dockingCostPerVolume) {
		this.dockingCostPerVolume = dockingCostPerVolume;
	}

	public double getMaxShipVolumeDockable() {
		return this.maxShipVolumeDockable;
	}

	public void setMaxShipVolumeDockable(double maxShipVolumeDockable) {
		this.maxShipVolumeDockable = maxShipVolumeDockable;
	}

	public int getOfficeRentalCost() {
		return this.officeRentalCost;
	}

	public void setOfficeRentalCost(int officeRentalCost) {
		this.officeRentalCost = officeRentalCost;
	}

	public byte getOperationID() {
		return this.operationID;
	}

	public void setOperationID(byte operationID) {
		this.operationID = operationID;
	}

	public int getRegionID() {
		return this.regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public double getReprocessingEfficiency() {
		return this.reprocessingEfficiency;
	}

	public void setReprocessingEfficiency(double reprocessingEfficiency) {
		this.reprocessingEfficiency = reprocessingEfficiency;
	}

	public byte getReprocessingHangarFlag() {
		return this.reprocessingHangarFlag;
	}

	public void setReprocessingHangarFlag(byte reprocessingHangarFlag) {
		this.reprocessingHangarFlag = reprocessingHangarFlag;
	}

	public double getReprocessingStationsTake() {
		return this.reprocessingStationsTake;
	}

	public void setReprocessingStationsTake(double reprocessingStationsTake) {
		this.reprocessingStationsTake = reprocessingStationsTake;
	}

	public short getSecurity() {
		return this.security;
	}

	public void setSecurity(short security) {
		this.security = security;
	}

	public int getSolarSystemID() {
		return this.solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public String getStationName() {
		return this.stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public short getStationTypeID() {
		return this.stationTypeID;
	}

	public void setStationTypeID(short stationTypeID) {
		this.stationTypeID = stationTypeID;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}