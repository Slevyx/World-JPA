package it.objectmethod.world.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.world.model.Country;
import it.objectmethod.world.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/find")
	public ResponseEntity<List<Country>> findCountryByNameAndOrContinent(
			@RequestParam(name = "countryName", required = false) String countryName,
			@RequestParam(name = "continentName", required = false) String continentName) {
		ResponseEntity<List<Country>> countriesList = countryService.findCountryByNameAndOrContinent(countryName,
				continentName);
		return countriesList;
	}

	@GetMapping("/continents")
	public ResponseEntity<List<String>> findDistinctContinent() {
		ResponseEntity<List<String>> continentsList = countryService.findDistinctContinent();
		return continentsList;
	}

	@GetMapping("/continent/countries")
	public ResponseEntity<List<Country>> findByContinent(
			@RequestParam(name = "continentName", required = false) String continentName) {
		ResponseEntity<List<Country>> countries = countryService.findByContinent(continentName);
		return countries;
	}
}