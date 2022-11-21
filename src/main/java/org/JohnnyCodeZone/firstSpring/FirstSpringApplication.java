package org.JohnnyCodeZone.firstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FirstSpringApplication.class, args);
		CountryService countryService=new CountryService(new CountryReader());
		System.out.println(countryService.listAllCountries());
		System.out.println(countryService.listAllCountryNames());
		System.out.println(countryService.getCapitalCountry("Romania"));
		System.out.println(countryService.getPopulationOfACountry("Romania"));
		System.out.println(countryService.getCountriesInContinent("Europe"));
		System.out.println(countryService.getCountryNeighbours("Italy"));
		System.out.println(countryService.getCountriesInContinentWithPopulationLargerThanPopulation("Europe",50000L));
		System.out.println(countryService.getCountriesThatNeighbourXButNotY("Moldova","Ucraine"));
	}

}
