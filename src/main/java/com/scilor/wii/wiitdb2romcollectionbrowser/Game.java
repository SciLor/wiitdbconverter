package com.scilor.wii.wiitdb2romcollectionbrowser;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SciLor on 30.01.2017.
 */
public class Game {
    private String id; //R2TE41
    private String name; //Teenage Mutant Ninja Turtles: Smash-Up (USA) (EN,ES)
    private String type; //
    private String region; //NTSC-U
    private List<String> languages; //EN,DE,ES
    private Map<String, GameLocale> locales;
    private String developer; //Game Arts
    private String publisher; //Ubi Soft Entertainment
    private LocalDateTime releaseDate;

    private GameRating rating;
    private List<String> genres;
    private GameWiFi wifi;
    private GameInput input;

    public Game() {
        this.locales = new HashMap<String, GameLocale>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Map<String, GameLocale> getLocales() {
        return locales;
    }

    public void setLocales(Map<String, GameLocale> locales) {
        this.locales = locales;
    }

    public String getDeveloper() {
        return developer;
    }

    public GameRating getRating() {
        return rating;
    }

    public void setRating(GameRating rating) {
        this.rating = rating;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public GameWiFi getWifi() {
        return wifi;
    }

    public void setWifi(GameWiFi wifi) {
        this.wifi = wifi;
    }

    public GameInput getInput() {
        return input;
    }

    public void setInput(GameInput input) {
        this.input = input;
    }
}
