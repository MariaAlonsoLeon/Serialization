package org.model;

public class Session {

    private org.model.Movie movie;
    private org.model.Theater theater;
    private String time;

    public Session(Movie movie, Theater theater, String time) {
        this.movie = movie;
        this.theater = theater;
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public String getTime() {
        return time;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setTime(String time) {
        this.time = time;
    }
}