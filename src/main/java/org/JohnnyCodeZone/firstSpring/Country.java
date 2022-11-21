package org.JohnnyCodeZone.firstSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Random;


public class Country {
    private final String name;
    private final String capital;
    private final int population;
    private final int area;
    private final String continent;
    private final String neighbour1;
    private final String neighbour2;
    private final int ID;
    private static int a = 0;
    public Country(String name, String capital, int population, int area, String continent, String neighbour1, String neighbour2) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbour1 = neighbour1;
        this.neighbour2 = neighbour2;
        ID = a++;
    }

    public String name() {
        return name;
    }

    public String capital() {
        return capital;
    }

    public int population() {
        return population;
    }

    public int area() {
        return area;
    }

    public String continent() {
        return continent;
    }

    public String neighbour1() {
        return neighbour1;
    }

    public String neighbour2() {
        return neighbour2;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Country) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.capital, that.capital) &&
                this.population == that.population &&
                this.area == that.area &&
                Objects.equals(this.continent, that.continent) &&
                Objects.equals(this.neighbour1, that.neighbour1) &&
                Objects.equals(this.neighbour2, that.neighbour2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, population, area, continent, neighbour1, neighbour2);
    }

    @Override
    public String toString() {
        return "Country[" +
                "name=" + name + ", " +
                "capital=" + capital + ", " +
                "population=" + population + ", " +
                "area=" + area + ", " +
                "continent=" + continent + ", " +
                "neighbour1=" + neighbour1 + ", " +
                "neighbour2=" + neighbour2 +
                " ID= " + ID + ']';
    }

}
