package com.example.exoplanet.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.exoplanet.dto.Exoplanets;
import com.example.exoplanet.dto.HottestPlanet;
import com.example.exoplanet.dto.OrphanPlanet;

@RunWith(SpringRunner.class)
public class PlanetControllerTest {
	
	@Test
	public void orphanPlanetCount_test() throws Exception {

        Exoplanets[] exoplanets = new Exoplanets[2];
        exoplanets[0] = new Exoplanets();
        exoplanets[0].setTypeFlag(3);
        exoplanets[1] = new Exoplanets();
        exoplanets[1].setTypeFlag(1);
        PlanetController planetController = mock(PlanetController.class);
        when(planetController.getExoplanet()).thenReturn(exoplanets);

        ResponseEntity<OrphanPlanet> response = planetController.OrphanPlanetCount();

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getCount());
    }

	@Test
	public void hottestPlanet_test() throws Exception {
        Exoplanets[] exoplanets = new Exoplanets[3];
        exoplanets[0] = new Exoplanets();
        exoplanets[0].setHostStarTempK(29500);
        exoplanets[0].setPlanetIdentifier("hottest planet");
        exoplanets[1] = new Exoplanets();
        exoplanets[1].setHostStarTempK(2950);
        exoplanets[1].setPlanetIdentifier("planet2");
        exoplanets[2] = new Exoplanets();
        exoplanets[2].setHostStarTempK(2050);
        exoplanets[2].setPlanetIdentifier("planet3");
        PlanetController planetController = mock(PlanetController.class);
        when(planetController.getExoplanet()).thenReturn(exoplanets);

        ResponseEntity<HottestPlanet> response = planetController.hottestPlanet();

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getName());
        assertNotNull(response.getBody().getTemperature());
    }
	
	@Test
	public void planetSizeByYear_test() throws Exception {
        Exoplanets[] exoplanets = new Exoplanets[3];
        exoplanets[0] = new Exoplanets();
        exoplanets[0].setRadiusJpt(0.54);
        exoplanets[0].setDiscoveryYear(2021);
        exoplanets[1] = new Exoplanets();
        exoplanets[1].setDiscoveryYear(2021);
        exoplanets[1].setRadiusJpt(2.52);
        exoplanets[2] = new Exoplanets();
        exoplanets[2].setRadiusJpt(1.54);
        exoplanets[2].setDiscoveryYear(2024);
        PlanetController planetController = mock(PlanetController.class);
        when(planetController.getExoplanet()).thenReturn(exoplanets);

        ResponseEntity<Object> response = planetController.planetSizeByYear();

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}