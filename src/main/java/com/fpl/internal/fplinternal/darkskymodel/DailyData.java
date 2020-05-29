package com.fpl.internal.fplinternal.darkskymodel;

public class DailyData {

	private Double temperatureHigh;
	private Double temperatureLow;

	public DailyData() {
		super();
	}

	public Double getTemperatureHigh() {
		return temperatureHigh;
	}

	public void setTemperatureHigh(Double temperatureHigh) {
		this.temperatureHigh = temperatureHigh;
	}

	public Double getTemperatureLow() {
		return temperatureLow;
	}

	public void setTemperatureLow(Double temperatureLow) {
		this.temperatureLow = temperatureLow;
	}

	@Override
	public String toString() {
		return "DailyData [temperatureHigh=" + temperatureHigh + ", temperatureLow=" + temperatureLow + "]";
	}

}
