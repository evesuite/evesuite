package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eveGraphics database table.
 * 
 */
@Entity
@Table(name="eveGraphics")
public class EveGraphic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short graphicID;

	private String description;

	private short explosionID;

	private String icon;

	private byte obsolete;

	private byte published;

	private String url3D;

	private String urlSound;

	private String urlWeb;

    public EveGraphic() {
    }

	public short getGraphicID() {
		return this.graphicID;
	}

	public void setGraphicID(short graphicID) {
		this.graphicID = graphicID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getExplosionID() {
		return this.explosionID;
	}

	public void setExplosionID(short explosionID) {
		this.explosionID = explosionID;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public byte getObsolete() {
		return this.obsolete;
	}

	public void setObsolete(byte obsolete) {
		this.obsolete = obsolete;
	}

	public byte getPublished() {
		return this.published;
	}

	public void setPublished(byte published) {
		this.published = published;
	}

	public String getUrl3D() {
		return this.url3D;
	}

	public void setUrl3D(String url3D) {
		this.url3D = url3D;
	}

	public String getUrlSound() {
		return this.urlSound;
	}

	public void setUrlSound(String urlSound) {
		this.urlSound = urlSound;
	}

	public String getUrlWeb() {
		return this.urlWeb;
	}

	public void setUrlWeb(String urlWeb) {
		this.urlWeb = urlWeb;
	}

}