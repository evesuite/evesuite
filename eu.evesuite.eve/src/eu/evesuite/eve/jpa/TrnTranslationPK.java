package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the trnTranslations database table.
 * 
 */
@Embeddable
public class TrnTranslationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private short tcID;

	private int keyID;

	private String languageID;

    public TrnTranslationPK() {
    }
	public short getTcID() {
		return this.tcID;
	}
	public void setTcID(short tcID) {
		this.tcID = tcID;
	}
	public int getKeyID() {
		return this.keyID;
	}
	public void setKeyID(int keyID) {
		this.keyID = keyID;
	}
	public String getLanguageID() {
		return this.languageID;
	}
	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrnTranslationPK)) {
			return false;
		}
		TrnTranslationPK castOther = (TrnTranslationPK)other;
		return 
			(this.tcID == castOther.tcID)
			&& (this.keyID == castOther.keyID)
			&& this.languageID.equals(castOther.languageID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.tcID);
		hash = hash * prime + this.keyID;
		hash = hash * prime + this.languageID.hashCode();
		
		return hash;
    }
}