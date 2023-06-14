package com.example.exoplanet.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.exoplanet.dto.Exoplanets;
import com.example.exoplanet.dto.HottestPlanet;
import com.example.exoplanet.dto.OrphanPlanet;
import com.example.exoplanet.dto.PlanetSize;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 320146640
 *
 */
@RestController
public class PlanetController {

	private static final String DATA_URL = "https://gist.githubusercontent.com/joelbirchler/66cf8045fcbb6515557347c05d789b4a/raw/9a196385b44d4288431eef74896c0512bad3defe/exoplanets";

	private final RestTemplate restTemplate;

	public PlanetController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/*
	 *  returns no of orphan
	 *  planet count
	 */
	@GetMapping(path = "/orphanplanet")
	public ResponseEntity<OrphanPlanet> OrphanPlanetCount() throws JsonMappingException, JsonProcessingException {
		int orphan_planet_count = 0;
		Exoplanets[] exoplanets = getExoplanet();

		for (Exoplanets exoplanet : exoplanets) {
			if (exoplanet != null && exoplanet.getTypeFlag() == 3) {
				orphan_planet_count++;
			}
		}
		OrphanPlanet orphanPlanet = new OrphanPlanet();
		orphanPlanet.setCount(orphan_planet_count);
		ResponseEntity<OrphanPlanet> responseEntity = new ResponseEntity<OrphanPlanet>(orphanPlanet, HttpStatus.OK);
		return responseEntity;
	}

	
	/*
	 *  returns hottest planet name
	 *  temperature
	 */
	@GetMapping(path = "/hottestplanet")
	public ResponseEntity<HottestPlanet> hottestPlanet() throws JsonMappingException, JsonProcessingException {
		String hottestPlanetName = null;
		double hottestStarTemperature = 0.0;
		Exoplanets[] exoplanets = getExoplanet();

		for (Exoplanets exoplanet : exoplanets) {
			if (exoplanet != null) {
				if (hottestStarTemperature < exoplanet.getHostStarTempK())
					hottestStarTemperature = exoplanet.getHostStarTempK();
				if (exoplanet.getHostStarTempK() == hottestStarTemperature) {
					hottestPlanetName = exoplanet.getPlanetIdentifier();
				}
			}
		}
		HottestPlanet hottestplanet = new HottestPlanet();
		hottestplanet.setName(hottestPlanetName);
		hottestplanet.setTemperature(hottestStarTemperature);
		ResponseEntity<HottestPlanet> responseEntity = new ResponseEntity<HottestPlanet>(hottestplanet, HttpStatus.OK);
		return responseEntity;
	}

	/*
	 *  returns planet sizes for each year
	 * 
	 */
	@GetMapping(path = "/planetssizebyyear", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> planetSizeByYear() throws JsonMappingException, JsonProcessingException {
		Map<Integer, PlanetSize> planetSizebyYear = new HashMap<>();
		int discoveryYear = 0;
		double radiusJpt = 0.0;
		Exoplanets[] exoplanets = getExoplanet();

		for (Exoplanets exoplanet : exoplanets) {
			if (exoplanet != null) {
				Object discyear = exoplanet.getDiscoveryYear();
				String year = discyear.toString();
				Object obj = exoplanet.getRadiusJpt();
				String radius = obj.toString();
				if (!year.equalsIgnoreCase("0") && !radius.equalsIgnoreCase("0.0")) {
					discoveryYear = Integer.parseInt(year);
					radiusJpt = Double.parseDouble(radius);
					if (planetSizebyYear.get(discoveryYear) == null) {
						planetSizebyYear.put(discoveryYear, new PlanetSize(0, 0, 0));
					}
					PlanetSize p = planetSizebyYear.get(discoveryYear);
					if (radiusJpt < 1) {
						int small = p.getSmall();
						small++;
						p.setSmall(small);
					} else if (radiusJpt >= 1 && radiusJpt < 2) {
						int medium = p.getMedium();
						medium++;
						p.setMedium(medium);

					} else {
						int large = p.getLarge();
						large++;
						p.setLarge(large);
					}
					planetSizebyYear.put(discoveryYear, p);
				}
			}
		}
		Gson gson = new GsonBuilder().create();
		return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(planetSizebyYear));

	}

	Exoplanets[] getExoplanet() throws JsonProcessingException, JsonMappingException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> request = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(DATA_URL, HttpMethod.GET, request, String.class);
		String exoplanetData = response.getBody();

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		Exoplanets[] exoplanets = mapper.readValue(exoplanetData, Exoplanets[].class);
		return exoplanets;
	}
}
