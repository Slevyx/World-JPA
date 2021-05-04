package it.objectmethod.world.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.objectmethod.world.model.Country;
import it.objectmethod.world.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepo;

	public ResponseEntity<List<Country>> findCountryByNameAndOrContinent(String countryName, String continentName) {
		ResponseEntity<List<Country>> response;
		if (countryName == null || continentName == null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			List<Country> countriesList = countryRepo.findCountryByNameAndOrContinent(countryName, continentName);
			response = new ResponseEntity<>(countriesList, HttpStatus.OK);
		}
		return response;
	}

	public ResponseEntity<List<String>> findDistinctContinent() {
		List<String> continentsList = countryRepo.findDistinctContinent();
		ResponseEntity<List<String>> response = new ResponseEntity<>(continentsList, HttpStatus.OK);
		return response;
	}

	public ResponseEntity<List<Country>> findByContinent(String continentName) {
		ResponseEntity<List<Country>> response;
		if (continentName == null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			List<Country> countries = countryRepo.findByContinent(continentName);
			response = new ResponseEntity<>(countries, HttpStatus.OK);
		}
		return response;
	}
}
