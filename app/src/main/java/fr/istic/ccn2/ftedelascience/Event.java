package fr.istic.ccn2.ftedelascience;

public class Event {

    private int id;
    //private String apercu;
    //private String identifiant;
    //private String nbPlaces;
    //private String image;
    //private String placeMax;
    private String periode;
    private String description;
    private String titre_fr;
    private String thematiques;


    public Event (String description,  String thematiques,String titre) {
        //this.nbPlaces = nbPlaces;
        //this.image = image;
        //  this.placeMax = placeMax;
        //  this.periode = periode;
        this.description = description;
        this.titre_fr = titre;
        this.thematiques = thematiques;
    }

    public Event() {
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
        return titre_fr;
    }

    public void setTitre(String titre) {
        this.titre_fr = titre;
    }

    public String getThematiques() {
        return thematiques;
    }

    public void setThematiques(String thematiques) {
        this.thematiques = thematiques;
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
