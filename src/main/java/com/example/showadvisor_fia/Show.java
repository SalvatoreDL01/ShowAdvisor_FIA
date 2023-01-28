package com.example.showadvisor_fia;

import java.io.Serializable;

public class Show implements Serializable {
    private String id;
    private String title;
    private String type;
    private String description;
    private double release_year;
    private String age_certification;
    private double runtime;
    private String genres;
    private String production_countries;
    private String seasons;
    private String imdb_id;
    private double tmdb_popularity;

    public Show(String id, String title, String type, String description, double release_year, String age_certification, double runtime, String genres, String production_countries, String seasons, String imdb_id, double tmdb_popularity) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.release_year = release_year;
        this.age_certification = age_certification;
        this.runtime = runtime;
        this.genres = genres;
        this.production_countries = production_countries;
        this.seasons = seasons;
        this.imdb_id = imdb_id;
        this.tmdb_popularity = tmdb_popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRelease_year() {
        return release_year;
    }

    public void setRelease_year(double release_year) {
        this.release_year = release_year;
    }

    public String getAge_certification() {
        return age_certification;
    }

    public void setAge_certification(String age_certification) {
        this.age_certification = age_certification;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(String production_countries) {
        this.production_countries = production_countries;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public double getTmdb_popularity() {
        return tmdb_popularity;
    }

    public void setTmdb_popularity(double tmdb_popularity) {
        this.tmdb_popularity = tmdb_popularity;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", release_year=" + release_year +
                ", age_certification='" + age_certification + '\'' +
                ", runtime=" + runtime +
                ", genres='" + genres + '\'' +
                ", production_countries='" + production_countries + '\'' +
                ", seasons='" + seasons + '\'' +
                ", imdb_id='" + imdb_id + '\'' +
                ", tmdb_popularity=" + tmdb_popularity +
                '}';
    }
}