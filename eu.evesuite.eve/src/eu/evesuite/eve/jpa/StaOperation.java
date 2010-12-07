package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staOperations database table.
 * 
 */
@Entity
@Table(name="staOperations")
public class StaOperation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte operationID;

	private byte activityID;

	private short amarrStationTypeID;

	private byte border;

	private short caldariStationTypeID;

	private byte corridor;

	private String description;

	private byte fringe;

	private short gallenteStationTypeID;

	private byte hub;

	private short joveStationTypeID;

	private short minmatarStationTypeID;

	private String operationName;

	private byte ratio;

    public StaOperation() {
    }

	public byte getOperationID() {
		return this.operationID;
	}

	public void setOperationID(byte operationID) {
		this.operationID = operationID;
	}

	public byte getActivityID() {
		return this.activityID;
	}

	public void setActivityID(byte activityID) {
		this.activityID = activityID;
	}

	public short getAmarrStationTypeID() {
		return this.amarrStationTypeID;
	}

	public void setAmarrStationTypeID(short amarrStationTypeID) {
		this.amarrStationTypeID = amarrStationTypeID;
	}

	public byte getBorder() {
		return this.border;
	}

	public void setBorder(byte border) {
		this.border = border;
	}

	public short getCaldariStationTypeID() {
		return this.caldariStationTypeID;
	}

	public void setCaldariStationTypeID(short caldariStationTypeID) {
		this.caldariStationTypeID = caldariStationTypeID;
	}

	public byte getCorridor() {
		return this.corridor;
	}

	public void setCorridor(byte corridor) {
		this.corridor = corridor;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getFringe() {
		return this.fringe;
	}

	public void setFringe(byte fringe) {
		this.fringe = fringe;
	}

	public short getGallenteStationTypeID() {
		return this.gallenteStationTypeID;
	}

	public void setGallenteStationTypeID(short gallenteStationTypeID) {
		this.gallenteStationTypeID = gallenteStationTypeID;
	}

	public byte getHub() {
		return this.hub;
	}

	public void setHub(byte hub) {
		this.hub = hub;
	}

	public short getJoveStationTypeID() {
		return this.joveStationTypeID;
	}

	public void setJoveStationTypeID(short joveStationTypeID) {
		this.joveStationTypeID = joveStationTypeID;
	}

	public short getMinmatarStationTypeID() {
		return this.minmatarStationTypeID;
	}

	public void setMinmatarStationTypeID(short minmatarStationTypeID) {
		this.minmatarStationTypeID = minmatarStationTypeID;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public byte getRatio() {
		return this.ratio;
	}

	public void setRatio(byte ratio) {
		this.ratio = ratio;
	}

}