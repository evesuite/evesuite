package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crtClasses database table.
 * 
 */
@Entity
@Table(name="crtClasses")
public class CrtClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int classID;

	private String className;

	private String description;

    public CrtClass() {
    }

	public int getClassID() {
		return this.classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}