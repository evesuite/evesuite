package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crtRecommendations database table.
 * 
 */
@Entity
@Table(name="crtRecommendations")
public class CrtRecommendation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int recommendationID;

	private int certificateID;

	private byte recommendationLevel;

	private short shipTypeID;

    public CrtRecommendation() {
    }

	public int getRecommendationID() {
		return this.recommendationID;
	}

	public void setRecommendationID(int recommendationID) {
		this.recommendationID = recommendationID;
	}

	public int getCertificateID() {
		return this.certificateID;
	}

	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}

	public byte getRecommendationLevel() {
		return this.recommendationLevel;
	}

	public void setRecommendationLevel(byte recommendationLevel) {
		this.recommendationLevel = recommendationLevel;
	}

	public short getShipTypeID() {
		return this.shipTypeID;
	}

	public void setShipTypeID(short shipTypeID) {
		this.shipTypeID = shipTypeID;
	}

}