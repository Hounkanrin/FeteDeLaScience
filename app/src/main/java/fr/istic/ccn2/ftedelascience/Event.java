package fr.istic.ccn2.ftedelascience;

public class Event {
    private String titre_fr;
    //private String thematiques;
    //private String apercu;
    // private String ville;


    public Event(String titre_fr) {
        this.titre_fr = titre_fr;
    }

    public String getTitre_fr() {
        return titre_fr;
    }

    public void setTitre_fr(String titre_fr) {
        this.titre_fr = titre_fr;
    }
}