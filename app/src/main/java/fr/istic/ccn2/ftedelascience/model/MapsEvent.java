package fr.istic.ccn2.ftedelascience.model;


import java.util.ArrayList;

public class MapsEvent {

    private ArrayList<Double> geolocalisation ;
    private double latitude;
    private double longitude ;
    private String titre_fr;

    public MapsEvent(double latitude, double longitude, String titre) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.titre_fr = titre;
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

    public String getTitre_fr() {
        return titre_fr;
    }

    public void setTitre_fr(String titre_fr) {
        this.titre_fr = titre_fr;
    }
}

