package it.objectmethod.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.world.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	@Query(value = "SELECT x FROM Country x WHERE ('' = ?1 OR UPPER(x.name) = ?1) AND ('' = ?2 OR UPPER(x.continent) = ?2)")
	public List<Country> findCountryByNameAndOrContinent(String countryName, String continentName);

	@Query(value = "SELECT DISTINCT x.continent FROM Country x")
	public List<String> findDistinctContinent();

	public List<Country> findByContinent(String continentName);
}
