package com.example.d2a.boxofiice;

import java.io.Serializable;

public class Movie implements Serializable {

    public String title;
    public double rating;
    public int status;

    public Movie(String title, double rating, int status){
        this.title = title;
        this.rating = rating;
        this.status = status;
    }

    public String getStatus(){
        if (status == 1)
            return "Playing";
        else if(status == 2)
            return "Coming Soon";
        else
            return "Archive";
    }
}
