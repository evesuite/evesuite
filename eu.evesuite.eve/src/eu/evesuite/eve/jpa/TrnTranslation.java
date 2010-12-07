package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trnTranslations database table.
 * 
 */
@Entity
@Table(name="trnTranslations")
public class TrnTranslation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrnTranslationPK id;

	private String text;

    public TrnTranslation() {
    }

	public TrnTranslationPK getId() {
		return this.id;
	}

	public void setId(TrnTranslationPK id) {
		this.id = id;
	}
	
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}