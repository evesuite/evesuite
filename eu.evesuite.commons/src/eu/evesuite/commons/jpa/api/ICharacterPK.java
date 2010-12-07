package eu.evesuite.commons.jpa.api;

import java.io.Serializable;

/**
 * The primary key class for the character database table.
 * 
 */
public interface ICharacterPK extends Serializable {

	public int getId();

	public int getUserId();

	public void setId(int id);

	public void setUserId(int userId);

}