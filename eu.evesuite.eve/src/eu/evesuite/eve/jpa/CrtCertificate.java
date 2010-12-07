package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crtCertificates database table.
 * 
 */
@Entity
@Table(name="crtCertificates")
public class CrtCertificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int certificateID;

	private byte categoryID;

	private int classID;

	private int corpID;

	private String description;

	private byte grade;

	private int iconID;

    public CrtCertificate() {
    }

	public int getCertificateID() {
		return this.certificateID;
	}

	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}

	public byte getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(byte categoryID) {
		this.categoryID = categoryID;
	}

	public int getClassID() {
		return this.classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getCorpID() {
		return this.corpID;
	}

	public void setCorpID(int corpID) {
		this.corpID = corpID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getGrade() {
		return this.grade;
	}

	public void setGrade(byte grade) {
		this.grade = grade;
	}

	public int getIconID() {
		return this.iconID;
	}

	public void setIconID(int iconID) {
		this.iconID = iconID;
	}

}