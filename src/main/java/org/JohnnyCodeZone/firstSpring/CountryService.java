package org.JohnnyCodeZone.firstSpring;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CountryService {

    private final CountryReader countryReader;
    private final List<Country> countryList;

    public CountryService(CountryReader countryReader) throws IOException {
        this.countryReader = countryReader;
        this.countryList = countryReader.readCountry();
    }

    public List<Country> listAllCountries() throws IOException {
        return countryReader.readCountry();
    }

    public List<String> listAllCountryNames() {
        return countryList.stream().map(Country::name).toList();
    }

    public String getCapitalCountry(String getCountry) {
        return (countryList.stream().filter(country -> Objects.equals(country.name(), getCountry)).map(Country::capital).distinct().collect(Collectors.joining()));
    }

    public Long getPopulationOfACountry(String countryWichYouWantToGetThePopulation) {
        return (countryList.stream().filter(country -> Objects.equals(country.name(), countryWichYouWantToGetThePopulation)).mapToLong(Country::population).distinct().sum());
    }

    public List<Country> getCountriesInContinent(String continent) {
        return countryList.stream().filter(country -> Objects.equals(country.continent(), continent)).toList();
    }

    public List<String> getCountryNeighbours(String getCountry){

        List<String> result = new ArrayList<>();

        String firstNeighbour = countryList.stream().filter(country -> Objects.equals(country.name(), getCountry)).map(Country::neighbour1).collect(Collectors.joining());
        String secondNeighbour = countryList.stream().filter(country -> Objects.equals(country.name(), getCountry)).map(Country::neighbour2).collect(Collectors.joining());

        result.add(firstNeighbour);
        result.add(secondNeighbour);

        return result;

    }

    public List<Country> getCountriesInContinentWithPopulationLargerThanPopulation(String continent , Long population){
        return countryList.stream().filter(country -> Objects.equals(country.continent(), continent)).filter(country -> country.population()>population).toList();
    }

    public List<Country> getCountriesThatNeighbourXButNotY(String neighbour1 , String neighbour2){
        return countryList.stream().filter(country -> Objects.equals(country.neighbour1(), neighbour1)).filter(country -> !Objects.equals(country.neighbour2(), neighbour2)).toList();
    }

}
