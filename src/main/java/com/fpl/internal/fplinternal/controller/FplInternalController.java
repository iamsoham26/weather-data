package com.fpl.internal.fplinternal.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fpl.internal.fplinternal.darkskymodel.DarkSkydata;
import com.fpl.internal.fplinternal.darkskymodel.Temperature;
import com.fpl.internal.fplinternal.darkskymodel.ZipLatLng;
import com.fpl.internal.fplinternal.locationmodel.GoogleMaps;

@RestController
@RequestMapping("/weather")
public class FplInternalController {

	private static final String GOOGLE_KEY = "AIzaSyACfeooPuBSvXvTp2zJUdzicPKvjjSH19Q";
	private static final String DARKSKY_API_KEY = "4bfa92bdad3663bbd903597cb5c83ddd";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/{zipcode}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Temperature> getWeatherByZipcode(DarkSkydata data, @PathVariable int zipcode)
			throws IOException {

		GoogleMaps latlng = new GoogleMaps();

		latlng = restTemplate.getForObject(
				"https://maps.googleapis.com/maps/api/geocode/json?address={zipcode}&key={key}", GoogleMaps.class, zipcode,
				GOOGLE_KEY);
		
		String lat = latlng.getResults().get(0).getGeometry().getLocation().getLat();
		String lng = latlng.getResults().get(0).getGeometry().getLocation().getLng();

		Temperature tmp = new Temperature();

		data = restTemplate.getForObject("https://api.darksky.net/forecast/{key}/{lat},{lng}", DarkSkydata.class,
				DARKSKY_API_KEY, lat, lng);

		tmp.setZipcode(zipcode);

		tmp.setMaxTemp(data.getDaily().getData().get(0).getTemperatureHigh());
		tmp.setMinTemp(data.getDaily().getData().get(0).getTemperatureLow());
		tmp.setAvgTemp(data.getDaily().getData().get(0).getTemperatureLow(),
				data.getDaily().getData().get(0).getTemperatureHigh());

		tmp.setHour1(data.getHourly().getData().get(0).getTemperature());
		tmp.setHumidity1(data.getHourly().getData().get(0).getHumidity());
		tmp.setHour2(data.getHourly().getData().get(1).getTemperature());
		tmp.setHumidity2(data.getHourly().getData().get(1).getHumidity());
		tmp.setHour3(data.getHourly().getData().get(2).getTemperature());
		tmp.setHumidity3(data.getHourly().getData().get(2).getHumidity());
		tmp.setHour4(data.getHourly().getData().get(3).getTemperature());
		tmp.setHumidity4(data.getHourly().getData().get(3).getHumidity());
		tmp.setHour5(data.getHourly().getData().get(4).getTemperature());
		tmp.setHumidity5(data.getHourly().getData().get(4).getHumidity());
		tmp.setHour6(data.getHourly().getData().get(5).getTemperature());
		tmp.setHumidity6(data.getHourly().getData().get(5).getHumidity());
		tmp.setHour7(data.getHourly().getData().get(6).getTemperature());
		tmp.setHumidity7(data.getHourly().getData().get(6).getHumidity());
		tmp.setHour8(data.getHourly().getData().get(7).getTemperature());
		tmp.setHumidity8(data.getHourly().getData().get(7).getHumidity());
		tmp.setHour9(data.getHourly().getData().get(8).getTemperature());
		tmp.setHumidity9(data.getHourly().getData().get(8).getHumidity());
		tmp.setHour10(data.getHourly().getData().get(9).getTemperature());
		tmp.setHumidity10(data.getHourly().getData().get(9).getHumidity());
		tmp.setHour11(data.getHourly().getData().get(10).getTemperature());
		tmp.setHumidity11(data.getHourly().getData().get(10).getHumidity());
		tmp.setHour12(data.getHourly().getData().get(11).getTemperature());
		tmp.setHumidity12(data.getHourly().getData().get(11).getHumidity());
		tmp.setHour13(data.getHourly().getData().get(12).getTemperature());
		tmp.setHumidity13(data.getHourly().getData().get(12).getHumidity());
		tmp.setHour14(data.getHourly().getData().get(13).getTemperature());
		tmp.setHumidity14(data.getHourly().getData().get(13).getHumidity());
		tmp.setHour15(data.getHourly().getData().get(14).getTemperature());
		tmp.setHumidity15(data.getHourly().getData().get(14).getHumidity());
		tmp.setHour16(data.getHourly().getData().get(15).getTemperature());
		tmp.setHumidity16(data.getHourly().getData().get(15).getHumidity());
		tmp.setHour17(data.getHourly().getData().get(16).getTemperature());
		tmp.setHumidity17(data.getHourly().getData().get(16).getHumidity());
		tmp.setHour18(data.getHourly().getData().get(17).getTemperature());
		tmp.setHumidity18(data.getHourly().getData().get(17).getHumidity());
		tmp.setHour19(data.getHourly().getData().get(18).getTemperature());
		tmp.setHumidity19(data.getHourly().getData().get(18).getHumidity());
		tmp.setHour20(data.getHourly().getData().get(19).getTemperature());
		tmp.setHumidity20(data.getHourly().getData().get(19).getHumidity());
		tmp.setHour21(data.getHourly().getData().get(20).getTemperature());
		tmp.setHumidity21(data.getHourly().getData().get(20).getHumidity());
		tmp.setHour22(data.getHourly().getData().get(21).getTemperature());
		tmp.setHumidity22(data.getHourly().getData().get(21).getHumidity());
		tmp.setHour23(data.getHourly().getData().get(22).getTemperature());
		tmp.setHumidity23(data.getHourly().getData().get(22).getHumidity());
		tmp.setHour24(data.getHourly().getData().get(23).getTemperature());
		tmp.setHumidity24(data.getHourly().getData().get(23).getHumidity());

		return new ResponseEntity<Temperature>(tmp, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getlatlng/{zipcode}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ZipLatLng> getZipLatLng(GoogleMaps data, @PathVariable Integer zipcode){
		
		data = restTemplate.getForObject(
				"https://maps.googleapis.com/maps/api/geocode/json?address={zipcode}&key={key}", GoogleMaps.class, zipcode,
				GOOGLE_KEY);
		
		ZipLatLng ziplatlng = new ZipLatLng();
		ziplatlng.setZipcode(zipcode);
		ziplatlng.setLat(data.getResults().get(0).getGeometry().getLocation().getLat());
		ziplatlng.setLng(data.getResults().get(0).getGeometry().getLocation().getLng());
	
		return new ResponseEntity<ZipLatLng>(ziplatlng, HttpStatus.OK);
	}

}
