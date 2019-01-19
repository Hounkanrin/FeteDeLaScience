package fr.istic.ccn2.ftedelascience;

public class Event {
    private String titre_fr;
    private String thematiques;
    private String apercu;
    private String ville;

    public Event(String titre_fr, String thematiques, String apercu, String ville) {
        this.titre_fr = titre_fr;
        this.thematiques = thematiques;
        this.apercu = apercu;
        this.ville = ville;
    }

    public Event() {
    }

    public String getTitre_fr() {
        return titre_fr;
    }

    public void setTitre_fr(String titre_fr) {
        this.titre_fr = titre_fr;
    }

    public String getThematiques() {
        return thematiques;
    }

    public void setThematiques(String thematiques) {
        this.thematiques = thematiques;
    }

    public String getApercu() {
        return apercu;
    }

    public void setApercu(String apercu) {
        this.apercu = apercu;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
