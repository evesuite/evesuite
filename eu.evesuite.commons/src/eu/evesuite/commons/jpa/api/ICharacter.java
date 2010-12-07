package eu.evesuite.commons.jpa.api;

import eu.evesuite.commons.jpa.IBaseEntity;

/**
 * Entity implementation class for Entity: Character
 * 
 */
public interface ICharacter extends IBaseEntity {

	public IApiKey getApiKey();

	public ICharacterPK getId();

	public void setApiKey(IApiKey apiKey);

	public void setId(ICharacterPK id);
	
	public String getName();

	public void setName(String name);
}
