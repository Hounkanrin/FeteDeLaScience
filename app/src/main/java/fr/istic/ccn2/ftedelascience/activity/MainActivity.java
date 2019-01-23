package fr.istic.ccn2.ftedelascience.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.istic.ccn2.ftedelascience.R;


public class MainActivity extends AppCompatActivity {


    TextView titre;
    TextView description_longue;
    ImageView image;
   // TextView nbPlaces;
    //TextView placeMax;
    TextView thematiques;
    TextView organisateur;
    TextView animation;
    TextView horaire;
    TextView lieu;
    TextView inscription;
    TextView adresse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titre = findViewById(R.id.title);
        description_longue = findViewById(R.id.description_longue);
        image = findViewById(R.id.image);
       // nbPlaces = findViewById(R.id.nbplaces);
       // placeMax = findViewById(R.id.placeMax);
        thematiques = findViewById(R.id.thematiques);
        organisateur = findViewById(R.id.organisateur);
        animation = findViewById(R.id.animation);
        thematiques = findViewById(R.id.thematiques);
        organisateur = findViewById(R.id.organisateur);
        animation = findViewById(R.id.animation);
       horaire = findViewById(R.id.horaire);
        lieu = findViewById(R.id.lieu);
        inscription = findViewById(R.id.inscription);
        adresse = findViewById(R.id.adresse);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            animation.setText(bundle.getString("animation"));
            Picasso.get().load(bundle.getString("image")).into(image);
            titre.setText(bundle.getString("titre"));
            thematiques.setText(bundle.getString("thematiques"));
            organisateur.setText(bundle.getString("organisateur"));
            description_longue.setText(bundle.getString("description_longue"));
            horaire.setText(bundle.getString("horaire"));
            lieu.setText(bundle.getString("lieu"));
            inscription.setText(bundle.getString("inscription"));
            adresse.setText(bundle.getString("adresse"));


        }


    }



}
