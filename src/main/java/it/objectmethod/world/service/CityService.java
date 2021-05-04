package it.objectmethod.world.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.objectmethod.world.model.City;
import it.objectmethod.world.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepo;

	public ResponseEntity<City> findByName(String cityName) {
		City city = null;
		ResponseEntity<City> response = null;
		if (cityName == null || cityName.trim().isEmpty()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			city = cityRepo.findByName(cityName);
			response = new ResponseEntity<>(city, HttpStatus.OK);
		}
		return response;
	}

	public ResponseEntity<List<City>> findAllByCountryCode(String countryCode) {
		List<City> cities = cityRepo.findAllByCountryCode(countryCode);
		ResponseEntity<List<City>> response = new ResponseEntity<>(cities, HttpStatus.OK);
		return response;
	}
}
