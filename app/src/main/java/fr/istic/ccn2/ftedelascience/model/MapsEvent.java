package fr.istic.ccn2.ftedelascience.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MapsEvent {

    private ArrayList<Double> geolocalisation ;
    private double latitude;
    private double longitude ;

    public MapsEvent(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public MapsEvent(ArrayList<Double> geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    public MapsEvent() {
    }

    public ArrayList<Double> getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(ArrayList<Double> geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

