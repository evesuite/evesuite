package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staStationTypes database table.
 * 
 */
@Entity
@Table(name="staStationTypes")
public class StaStationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short stationTypeID;

	private byte conquerable;

	private double dockEntryX;

	private double dockEntryY;

	private double dockEntryZ;

	private short dockingBayGraphicID;

	private double dockOrientationX;

	private double dockOrientationY;

	private double dockOrientationZ;

	private short hangarGraphicID;

	private byte officeSlots;

	private byte operationID;

	private double reprocessingEfficiency;

    public StaStationType() {
    }

	public short getStationTypeID() {
		return this.stationTypeID;
	}

	public void setStationTypeID(short stationTypeID) {
		this.stationTypeID = stationTypeID;
	}

	public byte getConquerable() {
		return this.conquerable;
	}

	public void setConquerable(byte conquerable) {
		this.conquerable = conquerable;
	}

	public double getDockEntryX() {
		return this.dockEntryX;
	}

	public void setDockEntryX(double dockEntryX) {
		this.dockEntryX = dockEntryX;
	}

	public double getDockEntryY() {
		return this.dockEntryY;
	}

	public void setDockEntryY(double dockEntryY) {
		this.dockEntryY = dockEntryY;
	}

	public double getDockEntryZ() {
		return this.dockEntryZ;
	}

	public void setDockEntryZ(double dockEntryZ) {
		this.dockEntryZ = dockEntryZ;
	}

	public short getDockingBayGraphicID() {
		return this.dockingBayGraphicID;
	}

	public void setDockingBayGraphicID(short dockingBayGraphicID) {
		this.dockingBayGraphicID = dockingBayGraphicID;
	}

	public double getDockOrientationX() {
		return this.dockOrientationX;
	}

	public void setDockOrientationX(double dockOrientationX) {
		this.dockOrientationX = dockOrientationX;
	}

	public double getDockOrientationY() {
		return this.dockOrientationY;
	}

	public void setDockOrientationY(double dockOrientationY) {
		this.dockOrientationY = dockOrientationY;
	}

	public double getDockOrientationZ() {
		return this.dockOrientationZ;
	}

	public void setDockOrientationZ(double dockOrientationZ) {
		this.dockOrientationZ = dockOrientationZ;
	}

	public short getHangarGraphicID() {
		return this.hangarGraphicID;
	}

	public void setHangarGraphicID(short hangarGraphicID) {
		this.hangarGraphicID = hangarGraphicID;
	}

	public byte getOfficeSlots() {
		return this.officeSlots;
	}

	public void setOfficeSlots(byte officeSlots) {
		this.officeSlots = officeSlots;
	}

	public byte getOperationID() {
		return this.operationID;
	}

	public void setOperationID(byte operationID) {
		this.operationID = operationID;
	}

	public double getReprocessingEfficiency() {
		return this.reprocessingEfficiency;
	}

	public void setReprocessingEfficiency(double reprocessingEfficiency) {
		this.reprocessingEfficiency = reprocessingEfficiency;
	}

}