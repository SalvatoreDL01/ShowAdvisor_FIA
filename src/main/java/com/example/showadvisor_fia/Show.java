package com.example.showadvisor_fia;

import java.io.Serializable;
import java.util.Objects;

public class Show implements Serializable{
    private String id;
    private String title;
    private String type;
    private String description;
    private double release_year;
    private double runtime;
    private String genres;
    private String seasons;
    private double score;
    private double individualFitness;

    public Show(String id, String title, String type, String description, double release_year, double runtime,
                String genres, String seasons, double score) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.release_year = release_year;
        this.runtime = runtime;
        this.genres = genres;
        this.seasons = seasons;
        this.score = score;
        this.individualFitness=0;
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

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getIndividualFitness() {
        return individualFitness;
    }

    public void setIndividualFitness(double individualFitness) {
        this.individualFitness = individualFitness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show)) return false;
        Show show = (Show) o;
        return getId().equals(show.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Show{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", release_year=" + release_year + '\'' +
                ", runtime=" + runtime + '\'' +
                ", genres='" + genres + '\'' +
                ", seasons='" + seasons + '\'' +
                ", score='" + score +
                '}';
    }
}