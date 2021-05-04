package it.objectmethod.world.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.world.model.City;
import it.objectmethod.world.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/find")
	public ResponseEntity<City> findByName(@RequestParam(name = "cityName", required = false) String cityName) {
		ResponseEntity<City> city = cityService.findByName(cityName);
		return city;
	}

	@GetMapping("/{countryCode}/cities")
	public ResponseEntity<List<City>> findAllByCountryCode(@PathVariable("countryCode") String countryCode) {
		ResponseEntity<List<City>> cities = cityService.findAllByCountryCode(countryCode);
		return cities;
	}

	@GetMapping("/continent/cities")
	public ResponseEntity<List<City>> findByCountry_Continent(@RequestParam("continentName") String continentName) {
		ResponseEntity<List<City>> cities = cityService.findByCountry_Continent(continentName);
		return cities;
	}
}
