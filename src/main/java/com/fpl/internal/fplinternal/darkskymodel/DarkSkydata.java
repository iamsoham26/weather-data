package com.fpl.internal.fplinternal.darkskymodel;

public class DarkSkydata {

	private Double latitude;
	private Double longitude;
	private Hourly hourly;
	private Daily daily;

	public DarkSkydata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Hourly getHourly() {
		return hourly;
	}

	public void setHourly(Hourly hourly) {
		this.hourly = hourly;
	}

	public Daily getDaily() {
		return daily;
	}

	public void setDaily(Daily daily) {
		this.daily = daily;
	}

	@Override
	public String toString() {
		return "DarkSkydata [latitude=" + latitude + ", longitude=" + longitude + ", hourly=" + hourly + ", daily="
				+ daily + "]";
	}

}
