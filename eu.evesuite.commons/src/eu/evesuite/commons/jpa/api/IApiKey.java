package eu.evesuite.commons.jpa.api;

import java.util.List;

import eu.evesuite.commons.jpa.IBaseEntityId;

public interface IApiKey extends IBaseEntityId {

	public List<ICharacter> getCharacters();

	public String getKeyLimited();

	public String getKeyFull();

	public void setCharacters(List<ICharacter> characters);

	public void setKeyLimited(String keyLimited);
	
	public void setKeyFull(String keyFull);
}
