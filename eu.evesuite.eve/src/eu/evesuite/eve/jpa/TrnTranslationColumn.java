package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trnTranslationColumns database table.
 * 
 */
@Entity
@Table(name="trnTranslationColumns")
public class TrnTranslationColumn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short tcID;

	private String columnName;

	private String masterID;

	private String tableName;

	private short tcGroupID;

    public TrnTranslationColumn() {
    }

	public short getTcID() {
		return this.tcID;
	}

	public void setTcID(short tcID) {
		this.tcID = tcID;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getMasterID() {
		return this.masterID;
	}

	public void setMasterID(String masterID) {
		this.masterID = masterID;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public short getTcGroupID() {
		return this.tcGroupID;
	}

	public void setTcGroupID(short tcGroupID) {
		this.tcGroupID = tcGroupID;
	}

}