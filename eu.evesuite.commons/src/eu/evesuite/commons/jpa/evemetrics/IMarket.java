package eu.evesuite.commons.jpa.evemetrics;

import java.util.Date;

import eu.evesuite.commons.jpa.IBaseEntityLongId;

public interface IMarket extends IBaseEntityLongId {
		
	public boolean isSellOrder();

	public boolean getSell();

	public void setSell(boolean sell);

	public long getAvailableVolume();

	public void setAvailableVolume(long availableVolume);

	public Date getDateIssued();

	public void setDateIssued(Date dateIssued);

	public int getDuration();

	public void setDuration(int duration);

	public long getInitialVolume();

	public void setInitialVolume(long initialVolume);

	public double getPrice();

	public void setPrice(double price);

	public int getRegionID();

	public void setRegionID(int regionID);

	public long getSaleVolume();

	public void setSaleVolume(long saleVolume);

	public int getSolarSystemID();

	public void setSolarSystemID(int solarSystemID);

	public int getStationID();

	public void setStationID(int stationID);

	public int getTypeID();

	public void setTypeID(int typeID);		
}