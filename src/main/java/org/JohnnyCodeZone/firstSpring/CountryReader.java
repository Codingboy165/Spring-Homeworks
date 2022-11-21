package org.JohnnyCodeZone.firstSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class CountryReader {
    //name|capital|population|area|continent|neighbour1~neighbour2
    public CountryReader() {
        System.out.println("Starting to build the country reader");
    }

    @Bean
    public List<Country> readCountry() throws IOException {
        List<Country> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("country.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            result.add(countryFromALine(line));
        }
        return result;
    }


    private static Country countryFromALine(String line) {
        String[] tokensBeforeNeighbour = line.split(Pattern.quote("|"), 6);
         String[] tokensForNeighbour = tokensBeforeNeighbour[5].split("~");

        return new Country(tokensBeforeNeighbour[0], tokensBeforeNeighbour[1], (int) Long.parseLong(tokensBeforeNeighbour[2]),
                Integer.parseInt(tokensBeforeNeighbour[3]), tokensBeforeNeighbour[4], tokensForNeighbour[0],tokensForNeighbour[1]);
    }
}
