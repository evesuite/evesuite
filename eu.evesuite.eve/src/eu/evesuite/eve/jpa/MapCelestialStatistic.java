package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapCelestialStatistics database table.
 * 
 */
@Entity
@Table(name="mapCelestialStatistics")
public class MapCelestialStatistic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int celestialID;

	private double age;

	private double density;

	private double eccentricity;

	private double escapeVelocity;

	private byte fragmented;

	private double life;

	private byte locked;

	private double luminosity;

	private double mass;

	private double massDust;

	private double massGas;

	private double orbitPeriod;

	private double orbitRadius;

	private double pressure;

	private double radius;

	private double rotationRate;

	private String spectralClass;

	private double surfaceGravity;

	private double temperature;

    public MapCelestialStatistic() {
    }

	public int getCelestialID() {
		return this.celestialID;
	}

	public void setCelestialID(int celestialID) {
		this.celestialID = celestialID;
	}

	public double getAge() {
		return this.age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getDensity() {
		return this.density;
	}

	public void setDensity(double density) {
		this.density = density;
	}

	public double getEccentricity() {
		return this.eccentricity;
	}

	public void setEccentricity(double eccentricity) {
		this.eccentricity = eccentricity;
	}

	public double getEscapeVelocity() {
		return this.escapeVelocity;
	}

	public void setEscapeVelocity(double escapeVelocity) {
		this.escapeVelocity = escapeVelocity;
	}

	public byte getFragmented() {
		return this.fragmented;
	}

	public void setFragmented(byte fragmented) {
		this.fragmented = fragmented;
	}

	public double getLife() {
		return this.life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public byte getLocked() {
		return this.locked;
	}

	public void setLocked(byte locked) {
		this.locked = locked;
	}

	public double getLuminosity() {
		return this.luminosity;
	}

	public void setLuminosity(double luminosity) {
		this.luminosity = luminosity;
	}

	public double getMass() {
		return this.mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getMassDust() {
		return this.massDust;
	}

	public void setMassDust(double massDust) {
		this.massDust = massDust;
	}

	public double getMassGas() {
		return this.massGas;
	}

	public void setMassGas(double massGas) {
		this.massGas = massGas;
	}

	public double getOrbitPeriod() {
		return this.orbitPeriod;
	}

	public void setOrbitPeriod(double orbitPeriod) {
		this.orbitPeriod = orbitPeriod;
	}

	public double getOrbitRadius() {
		return this.orbitRadius;
	}

	public void setOrbitRadius(double orbitRadius) {
		this.orbitRadius = orbitRadius;
	}

	public double getPressure() {
		return this.pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRotationRate() {
		return this.rotationRate;
	}

	public void setRotationRate(double rotationRate) {
		this.rotationRate = rotationRate;
	}

	public String getSpectralClass() {
		return this.spectralClass;
	}

	public void setSpectralClass(String spectralClass) {
		this.spectralClass = spectralClass;
	}

	public double getSurfaceGravity() {
		return this.surfaceGravity;
	}

	public void setSurfaceGravity(double surfaceGravity) {
		this.surfaceGravity = surfaceGravity;
	}

	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

}