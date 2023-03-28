package com.example.superasterioddetector.model;

import android.annotation.SuppressLint;

import java.io.Serializable;

public class Asteroids implements Serializable {

    String id;
    String name;
    String distance;
    Double magnitude;
    String orbitalPeriod;

    public Asteroids(String id, String name, String distance, Double magnitude) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.magnitude = magnitude;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SuppressLint("DefaultLocale")
    public String getMagnitude() {
        return String.format("%.1f", magnitude);
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public String getName() {
        return name;
    }

    @SuppressLint("DefaultLocale")
    public String getDistance() {
        return String.format("%.1f", Double.valueOf(distance));
    }

}
