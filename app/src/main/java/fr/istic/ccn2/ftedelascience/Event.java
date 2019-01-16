package fr.istic.ccn2.ftedelascience;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Event implements Parcelable {

    private int id ;
   private String adresse;
   private String agenda_d_origine_titre;
   private String agenda_d_origine_uid;
    private String animateurs;
    private String apercu;
    private String  code_postal;
    private String cr;
    private String dates;
    private String departement;
    private String derniere_mise_a_jour;
    private String description_fr;
    private String description_longue_fr;
    private String description_longue_html_fr;
    private String evenements_lies;
    private ArrayList<Double> geolocalisation;
    private String horaires_detailles_fr;
    private String horaires_iso;
    private String  identifiant;
    private String identifiant_du_lieu;
    private String image;
    private String image_source;
    private String inscription_necessaire;
    private String lien;
    private String lien_canonique;
    private String lien_d_inscription;
    private Integer nb_evenements;
    private String nom_du_lieu;
    private String organisateur;
    private String partenaire;
    private String pays;
    private String public_specifique;
    private String publics_concernes;
    private String  reconduction;
    private String region;
    private String resume_dates_fr;
    private String resume_horaires_fr;
    private String   selection;
    private String statut;
    private String thematiques;
    private String titre_fr;
    private String type_d_animation;
    private String ville;

       // private String date_debut;
       // private String date_fin;
        //private String mots_cles_fr;
       // private String accessibilite_fr;
       // @DatabaseField(dataType=DataType.SERIALIZABLE)
       //   private ArrayList<Double> geolocalisation ;

        //private Boolean checked = false;

       // private Integer votersNumber = new Integer(0);

      //  private Float rating = new Float(0);

       // private Integer fillPlaces = new Integer(0);

      //  private Integer maxAvailablePlaces = new Integer(0);


    public Event(Parcel in ) {
        id= in.readInt();
        this.adresse = in.readString();
        this.agenda_d_origine_titre = in.readString();
        this.agenda_d_origine_uid = in.readString();
        this.animateurs = in.readString();
        this.apercu = in.readString();
        this.code_postal = in.readString();
        this.cr = in.readString();
        this.dates = in.readString();
        this.departement = in.readString();
        this.derniere_mise_a_jour = in.readString();
        this.description_fr = in.readString();
        this.description_longue_fr = in.readString();
        this.description_longue_html_fr = in.readString();
        this.evenements_lies = in.readString();
        ArrayList<Double> arr = new ArrayList<Double>();
        arr.add(in.readDouble());
        arr.add(in.readDouble());
        geolocalisation = arr;
        this.horaires_detailles_fr = in.readString();
        this.horaires_iso = in.readString();
        this.identifiant = in.readString();
        this.identifiant_du_lieu = in.readString();
        this.image = in.readString();
        this.image_source = in.readString();
        this.inscription_necessaire = in.readString();
        this.lien = in.readString();
        this.lien_canonique = in.readString();
        this.lien_d_inscription = in.readString();
        this.nb_evenements =  in.readInt();
        this.nom_du_lieu = in.readString();
        this.organisateur = in.readString();
        this.partenaire = in.readString();
        this.pays = in.readString();
        this.public_specifique = in.readString();
        this.publics_concernes = in.readString();
        this.reconduction = in.readString();
        this.region = in.readString();
        this.resume_dates_fr = in.readString();
        this.resume_horaires_fr = in.readString();
        this.selection = in.readString();
        this.statut = in.readString();
        this.thematiques = in.readString();
        this.titre_fr = in.readString();
        this.type_d_animation = in.readString();
        this.ville = in.readString();
    }

   /* protected Event(Parcel in) {
            id = in.readInt();
            apercu = in.readString();
            image = in.readString();
            ville = in.readString();
            identifiant = in.readString();
            description_fr = in.readString();
            titre_fr = in.readString();
            thematiques = in.readString();
            region = in.readString();
            description_longue_fr = in.readString();
            type_d_animation = in.readString();
            horaires_detailles_fr = in.readString();
            //date_debut = in.readString();
            //date_fin = in.readString();
            nom_du_lieu = in.readString();
            inscription_necessaire = in.readString();
            adresse = in.readString();
            organisateur = in.readString();
            publics_concernes = in.readString();
            statut = in.readString();
            lien = in.readString();
            dates = in.readString();
           // mots_cles_fr = in.readString();
            //accessibilite_fr = in.readString();
            nb_evenements = in.readInt();
            ArrayList<Double> arr = new ArrayList<Double>();
            arr.add(in.readDouble());
            arr.add(in.readDouble());
            geolocalisation = arr;
            //votersNumber = in.readInt();
            //rating = in.readFloat();
           // fillPlaces = in.readInt();
           // maxAvailablePlaces = in.readInt();
        }*/

        public static final Creator<Event> CREATOR = new Creator<Event>() {
            @Override
            public Event createFromParcel(Parcel in) {
                return new Event(in);
            }

            @Override
            public Event[] newArray(int size) {
                return new Event[size];
            }
        };

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAgenda_d_origine_titre() {
        return agenda_d_origine_titre;
    }

    public void setAgenda_d_origine_titre(String agenda_d_origine_titre) {
        this.agenda_d_origine_titre = agenda_d_origine_titre;
    }

    public String getAgenda_d_origine_uid() {
        return agenda_d_origine_uid;
    }

    public void setAgenda_d_origine_uid(String agenda_d_origine_uid) {
        this.agenda_d_origine_uid = agenda_d_origine_uid;
    }

    public String getAnimateurs() {
        return animateurs;
    }

    public void setAnimateurs(String animateurs) {
        this.animateurs = animateurs;
    }

    public String getApercu() {
        return apercu;
    }

    public void setApercu(String apercu) {
        this.apercu = apercu;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getDerniere_mise_a_jour() {
        return derniere_mise_a_jour;
    }

    public void setDerniere_mise_a_jour(String derniere_mise_a_jour) {
        this.derniere_mise_a_jour = derniere_mise_a_jour;
    }

    public String getDescription_fr() {
        return description_fr;
    }

    public void setDescription_fr(String description_fr) {
        this.description_fr = description_fr;
    }

    public String getDescription_longue_fr() {
        return description_longue_fr;
    }

    public void setDescription_longue_fr(String description_longue_fr) {
        this.description_longue_fr = description_longue_fr;
    }

    public String getDescription_longue_html_fr() {
        return description_longue_html_fr;
    }

    public void setDescription_longue_html_fr(String description_longue_html_fr) {
        this.description_longue_html_fr = description_longue_html_fr;
    }

    public String getEvenements_lies() {
        return evenements_lies;
    }

    public void setEvenements_lies(String evenements_lies) {
        this.evenements_lies = evenements_lies;
    }

    public ArrayList<Double> getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(ArrayList<Double> geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    public String getHoraires_detailles_fr() {
        return horaires_detailles_fr;
    }

    public void setHoraires_detailles_fr(String horaires_detailles_fr) {
        this.horaires_detailles_fr = horaires_detailles_fr;
    }

    public String getHoraires_iso() {
        return horaires_iso;
    }

    public void setHoraires_iso(String horaires_iso) {
        this.horaires_iso = horaires_iso;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiant_du_lieu() {
        return identifiant_du_lieu;
    }

    public void setIdentifiant_du_lieu(String identifiant_du_lieu) {
        this.identifiant_du_lieu = identifiant_du_lieu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getInscription_necessaire() {
        return inscription_necessaire;
    }

    public void setInscription_necessaire(String inscription_necessaire) {
        this.inscription_necessaire = inscription_necessaire;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getLien_canonique() {
        return lien_canonique;
    }

    public void setLien_canonique(String lien_canonique) {
        this.lien_canonique = lien_canonique;
    }

    public String getLien_d_inscription() {
        return lien_d_inscription;
    }

    public void setLien_d_inscription(String lien_d_inscription) {
        this.lien_d_inscription = lien_d_inscription;
    }

    public Integer getNb_evenements() {
        return nb_evenements;
    }

    public void setNb_evenements(Integer nb_evenements) {
        this.nb_evenements = nb_evenements;
    }

    public String getNom_du_lieu() {
        return nom_du_lieu;
    }

    public void setNom_du_lieu(String nom_du_lieu) {
        this.nom_du_lieu = nom_du_lieu;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public String getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(String partenaire) {
        this.partenaire = partenaire;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPublic_specifique() {
        return public_specifique;
    }

    public void setPublic_specifique(String public_specifique) {
        this.public_specifique = public_specifique;
    }

    public String getPublics_concernes() {
        return publics_concernes;
    }

    public void setPublics_concernes(String publics_concernes) {
        this.publics_concernes = publics_concernes;
    }

    public String getReconduction() {
        return reconduction;
    }

    public void setReconduction(String reconduction) {
        this.reconduction = reconduction;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getResume_dates_fr() {
        return resume_dates_fr;
    }

    public void setResume_dates_fr(String resume_dates_fr) {
        this.resume_dates_fr = resume_dates_fr;
    }

    public String getResume_horaires_fr() {
        return resume_horaires_fr;
    }

    public void setResume_horaires_fr(String resume_horaires_fr) {
        this.resume_horaires_fr = resume_horaires_fr;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getThematiques() {
        return thematiques;
    }

    public void setThematiques(String thematiques) {
        this.thematiques = thematiques;
    }

    public String getTitre_fr() {
        return titre_fr;
    }

    public void setTitre_fr(String titre_fr) {
        this.titre_fr = titre_fr;
    }

    public String getType_d_animation() {
        return type_d_animation;
    }

    public void setType_d_animation(String type_d_animation) {
        this.type_d_animation = type_d_animation;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public static Creator<Event> getCREATOR() {
        return CREATOR;
    }

  /*  public Map<String, Object> mapToFireBaseEvent(){
            Map<String, Object> fireBaseEvent = new HashMap<>();
            fireBaseEvent.put("id", this.id);
            fireBaseEvent.put("rating", this.rating);
            fireBaseEvent.put("fillingRate", this.maxAvailablePlaces != 0 ? (this.fillPlaces * 1.0 / this.maxAvailablePlaces) : 0);
            fireBaseEvent.put("votersNumber", this.votersNumber);
            fireBaseEvent.put("fillPlaces", this.fillPlaces);
            fireBaseEvent.put("maxAvailablePlaces", this.maxAvailablePlaces);

            return fireBaseEvent;
        }*/

        @Override
        public String toString() {
            return "Event{" +
                    "id=" + id +
                    ", titre=" + titre_fr +
                    ", thematiques=" + thematiques +
                    ", nom du lieu=" + nom_du_lieu +
                    ", description='" + description_fr + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

    @Override
        public void writeToParcel(Parcel dest, int flags) {

            dest.writeInt(id);

            if(apercu != null){
                dest.writeString(apercu);
            }
            else {
                dest.writeString("nothing");
            }

            if(image != null){
                dest.writeString(image);
            }
            else {
                dest.writeString("nothing");
            }

            if(ville != null){
                dest.writeString(ville);
            }
            else {
                dest.writeString("nothing");
            }

            if(identifiant != null){
                dest.writeString(identifiant);
            }
            else {
                dest.writeString("nothing");
            }

            if(description_fr != null){
                dest.writeString(description_fr);
            }
            else {
                dest.writeString("nothing");
            }

            if(titre_fr != null){
                dest.writeString(titre_fr);
            }
            else {
                dest.writeString("nothing");
            }

            if(thematiques != null){
                dest.writeString(thematiques);
            }
            else {
                dest.writeString("nothing");
            }

            if(region != null){
                dest.writeString(region);
            }
            else {
                dest.writeString("nothing");
            }

            if(description_longue_fr != null){
                dest.writeString(description_longue_fr);
            }
            else {
                dest.writeString("nothing");
            }

            if(type_d_animation != null){
                dest.writeString(type_d_animation);
            }
            else {
                dest.writeString("nothing");
            }

            if(horaires_detailles_fr != null){
                dest.writeString(horaires_detailles_fr);
            }
            else {
                dest.writeString("nothing");
            }

            if(nom_du_lieu != null){
                dest.writeString(nom_du_lieu);
            }
            else {
                dest.writeString("nothing");
            }

            if(inscription_necessaire != null){
                dest.writeString(inscription_necessaire);
            }
            else {
                dest.writeString("nothing");
            }

            if(adresse != null){
                dest.writeString(adresse);
            }
            else {
                dest.writeString("nothing");
            }

            if(organisateur != null){
                dest.writeString(organisateur);
            }
            else {
                dest.writeString("nothing");
            }

            if(publics_concernes != null){
                dest.writeString(publics_concernes);
            }
            else {
                dest.writeString("nothing");
            }

            if(statut != null){
                dest.writeString(statut);
            }
            else {
                dest.writeString("nothing");
            }

            if(lien != null){
                dest.writeString(lien);
            }
            else {
                dest.writeString("nothing");
            }

            if(dates != null){
                dest.writeString(dates);
            }
            else {
                dest.writeString("nothing");
            }

            if(nb_evenements != null){
                dest.writeInt(nb_evenements);
            }
            else {
                dest.writeInt(0);
            }

            if(geolocalisation != null){
                dest.writeDouble(geolocalisation.get(0));
                dest.writeDouble(geolocalisation.get(1));
            }
            else {
                dest.writeDouble(0);
                dest.writeDouble(0);
            }

        }


    }



