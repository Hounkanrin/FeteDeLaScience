package fr.istic.ccn2.ftedelascience.model;


import java.io.Serializable;

public class Event implements Serializable {


    private String apercu;
    private String nbPlaces;
    private String placeMax;
    private String periode;
    private String description;
    private String titre_fr;
    private String thematiques;
    private String ville;
    private String description_longue_fr;
    private String image ;
    private String organisateur;
    private  String animation;
    private  String adresse;
    private  String lieu;
    private  String horaire;
    private  String inscription;
    private String telephone;
    private String mots_cles;
    private String date;


    public Event(String apercu, String description, String titre_fr, String thematiques) {
        this.apercu = apercu;
        this.description = description;
        this.titre_fr = titre_fr;
        this.thematiques = thematiques;


    }

    public Event(String titre, String ville, String description, String thematiques, String description_longue, String image, String organisateur, String animation, String adresse, String lieu, String inscription, String horaire, String apercu, String telephone, String mots_cles, String date) {
        this.description = description;
        this.titre_fr = titre;
        this.thematiques = thematiques;
        this.ville = ville;
        this.description_longue_fr = description_longue;
        this.image = image;
        this.organisateur =organisateur;
        this.animation = animation;
        this.adresse = adresse;
        this.lieu = lieu;
        this.inscription = inscription;
        this.horaire = horaire;
        this.apercu = apercu;
        this.telephone = telephone;
        this.mots_cles = mots_cles;
        this.date = date;
    }

    public Event(String titre, String lieu, String thematiques) {
        this.titre_fr = titre;
        this.thematiques = thematiques;
        this.lieu = lieu;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getInscription() {
        return inscription;
    }

    public void setInscription(String inscription) {
        this.inscription = inscription;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMots_cles() {
        return mots_cles;
    }

    public void setMots_cles(String mot_cle) {
        this.mots_cles = mot_cle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
