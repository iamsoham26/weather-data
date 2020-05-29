/*package com.fpl.internal.fplinternal.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fpl.internal.fplinternal.model.Quote;
import com.fpl.internal.fplinternal.model.ZipLatLng;
import com.fpl.internal.fplinternal.model.ZipcodeData;

@Configuration
public class FplInternalController {

	private static final String KEY = "AIzaSyACfeooPuBSvXvTp2zJUdzicPKvjjSH19Q";

	@Autowired
	RestTemplate restTemplate;

	//@GetMapping(value = "/latlng", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ZipLatLng> getLatLong(Quote quote) throws IOException {

		FileWriter fileWriter = new FileWriter("./latlng.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
		List<ZipLatLng> list = new ArrayList<>();
		ZipcodeData zip;
		zip = restTemplate.getForObject("https://www.fpl.com/api/public/zip", ZipcodeData.class);
		ZipLatLng zipLatLng = new ZipLatLng();
		for(int i=0; i < zip.getData().size(); i++){
		
			quote = restTemplate.getForObject(
					"https://maps.googleapis.com/maps/api/geocode/json?address={zipcode}&key={key}", Quote.class,
					zip.getData().indexOf(i),KEY);

			double lat = quote.getResults().get(0).getGeometry().getLocation().getLat();
			double lng = quote.getResults().get(0).getGeometry().getLocation().getLng();
			zipLatLng.setZipcode(i);
			zipLatLng.setLatitude(lat);
			zipLatLng.setLongitude(lng);
			
			list.add(zipLatLng);
			printWriter.print(zipLatLng.toString());
			
		}
		
		printWriter.close();
		//return new ResponseEntity<List<ZipLatLng>>(list, HttpStatus.OK);
		return list;
	}

	@GetMapping(value = "/zip", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ZipcodeData> getZipcode(ZipcodeData zip) {
		zip = restTemplate.getForObject("https://www.fpl.com/api/public/zip", ZipcodeData.class);

		return new ResponseEntity<ZipcodeData>(zip, HttpStatus.OK);
	}

	public List<Integer> getListOfZipcode() {

		ZipcodeData zip;
		zip = restTemplate.getForObject("https://www.fpl.com/api/public/zip", ZipcodeData.class);

		return zip.getData();
	}

}
*/