package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ramAssemblyLines database table.
 * 
 */
@Entity
@Table(name="ramAssemblyLines")
public class RamAssemblyLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int assemblyLineID;

	private byte activityID;

	private byte assemblyLineTypeID;

	private int containerID;

	private double costInstall;

	private double costPerHour;

	private double discountPerGoodStandingPoint;

	private double maximumCharSecurity;

	private double maximumCorpSecurity;

	private double minimumCharSecurity;

	private double minimumCorpSecurity;

	private double minimumStanding;

    @Temporal( TemporalType.TIMESTAMP)
	private Date nextFreeTime;

	private int ownerID;

	private byte restrictionMask;

	private double surchargePerBadStandingPoint;

	private byte UIGroupingID;

    public RamAssemblyLine() {
    }

	public int getAssemblyLineID() {
		return this.assemblyLineID;
	}

	public void setAssemblyLineID(int assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}

	public byte getActivityID() {
		return this.activityID;
	}

	public void setActivityID(byte activityID) {
		this.activityID = activityID;
	}

	public byte getAssemblyLineTypeID() {
		return this.assemblyLineTypeID;
	}

	public void setAssemblyLineTypeID(byte assemblyLineTypeID) {
		this.assemblyLineTypeID = assemblyLineTypeID;
	}

	public int getContainerID() {
		return this.containerID;
	}

	public void setContainerID(int containerID) {
		this.containerID = containerID;
	}

	public double getCostInstall() {
		return this.costInstall;
	}

	public void setCostInstall(double costInstall) {
		this.costInstall = costInstall;
	}

	public double getCostPerHour() {
		return this.costPerHour;
	}

	public void setCostPerHour(double costPerHour) {
		this.costPerHour = costPerHour;
	}

	public double getDiscountPerGoodStandingPoint() {
		return this.discountPerGoodStandingPoint;
	}

	public void setDiscountPerGoodStandingPoint(double discountPerGoodStandingPoint) {
		this.discountPerGoodStandingPoint = discountPerGoodStandingPoint;
	}

	public double getMaximumCharSecurity() {
		return this.maximumCharSecurity;
	}

	public void setMaximumCharSecurity(double maximumCharSecurity) {
		this.maximumCharSecurity = maximumCharSecurity;
	}

	public double getMaximumCorpSecurity() {
		return this.maximumCorpSecurity;
	}

	public void setMaximumCorpSecurity(double maximumCorpSecurity) {
		this.maximumCorpSecurity = maximumCorpSecurity;
	}

	public double getMinimumCharSecurity() {
		return this.minimumCharSecurity;
	}

	public void setMinimumCharSecurity(double minimumCharSecurity) {
		this.minimumCharSecurity = minimumCharSecurity;
	}

	public double getMinimumCorpSecurity() {
		return this.minimumCorpSecurity;
	}

	public void setMinimumCorpSecurity(double minimumCorpSecurity) {
		this.minimumCorpSecurity = minimumCorpSecurity;
	}

	public double getMinimumStanding() {
		return this.minimumStanding;
	}

	public void setMinimumStanding(double minimumStanding) {
		this.minimumStanding = minimumStanding;
	}

	public Date getNextFreeTime() {
		return this.nextFreeTime;
	}

	public void setNextFreeTime(Date nextFreeTime) {
		this.nextFreeTime = nextFreeTime;
	}

	public int getOwnerID() {
		return this.ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public byte getRestrictionMask() {
		return this.restrictionMask;
	}

	public void setRestrictionMask(byte restrictionMask) {
		this.restrictionMask = restrictionMask;
	}

	public double getSurchargePerBadStandingPoint() {
		return this.surchargePerBadStandingPoint;
	}

	public void setSurchargePerBadStandingPoint(double surchargePerBadStandingPoint) {
		this.surchargePerBadStandingPoint = surchargePerBadStandingPoint;
	}

	public byte getUIGroupingID() {
		return this.UIGroupingID;
	}

	public void setUIGroupingID(byte UIGroupingID) {
		this.UIGroupingID = UIGroupingID;
	}

}