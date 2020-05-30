package com.fpl.internal.fplinternal.locationmodel;

import java.util.List;

public class GoogleMaps {

	private List<Results> results;
	private String status;

	public GoogleMaps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
