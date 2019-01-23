package fr.istic.ccn2.ftedelascience;

public class Event {

    private int id;
    private String apercu;
    private String nbPlaces;
    private String placeMax;
    private String periode;
    private String description;
    private String titre_fr;
    private String thematiques;
    private String ville;
    private String description_longue_fr;

    public Event(String apercu, String description, String titre_fr, String thematiques, String ville) {
        this.apercu = apercu;
        this.description = description;
        this.titre_fr = titre_fr;
        this.thematiques = thematiques;
        this.ville = ville;

    }

    public Event(String titre1, String s, String titre, String ville, String description, String thematiques) {
        this.description = description;
        this.titre_fr = titre;
        this.thematiques = thematiques;
        this.ville = ville;
        this.apercu = s;
    }

    public String getApercu() {
        return apercu;
    }

    public void setApercu(String apercu) {
        this.apercu = apercu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(String nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getPlaceMax() {
        return placeMax;
    }

    public void setPlaceMax(String placeMax) {
        this.placeMax = placeMax;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getDescription_longue_fr() {
        return description_longue_fr;
    }

    public void setDescription_longue_fr(String description_longue_fr) {
        this.description_longue_fr = description_longue_fr;
    }
    /*
    private String region;
    private String description_longue_fr;
    private String type_d_animation;
    private String horaires_detailles_fr;
    private String date_debut;
    private String date_fin;
    private String nom_du_lieu;
    private String inscription_necessaire;
    private String adresse;
    private String organisateur;
    private String publics_concernes;
    private String statut;
    private String lien;
    private String dates;
    private String mots_cles_fr;
    private String accessibilite_fr;
    private ArrayList<Double> geolocalisation ;
    private Integer nb_evenements;
    private Boolean checked = false;
    private Integer votersNumber = new Integer(0);
    private Float rating = new Float(0);
    private Integer fillPlaces = new Integer(0);
    private Integer maxAvailablePlaces = new Integer(0);*/

}
