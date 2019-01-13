package fr.istic.ccn2.ftedelascience;

public class Event {

    private int id;
    //private String apercu;
    //private String identifiant;
    private String nbPlaces;
    private String image;
    private String placeMax;
    private String periode;
    private String description;
    private String titre;
    private String thematiques;
    private boolean permission;

    public Event(String nbPlaces, String image, String placeMax, String periode, String description, String titre, String thematiques, boolean permission) {
        this.nbPlaces = nbPlaces;
        this.image = image;
        this.placeMax = placeMax;
        this.periode = periode;
        this.description = description;
        this.titre = titre;
        this.thematiques = thematiques;
        this.permission = permission;
    }

    public Event() {
    }

    public String getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(String nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getThematiques() {
        return thematiques;
    }

    public void setThematiques(String thematiques) {
        this.thematiques = thematiques;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
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
