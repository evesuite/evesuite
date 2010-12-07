package eu.evesuite.commons.jpa;

import java.util.Collection;

import eu.evesuite.commons.jpa.api.IApiKey;
import eu.evesuite.commons.jpa.api.ICharacter;
import eu.evesuite.commons.jpa.api.ICharacterPK;

public interface EVEAPIModelService extends IModelService {

	public IApiKey createIApiKey();

	public ICharacter createICharacter();

	public ICharacterPK createICharacterPK();
	
	public Collection<IApiKey> getIApiKeys();
	
	public Collection<ICharacter> getICharacters();
}
