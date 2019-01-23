package fr.istic.ccn2.ftedelascience;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    TextView ville;
    TextView titre;
    TextView description_longue;
    ImageView apercu;
   // TextView nbPlaces;
    //TextView placeMax;
    TextView thematiques;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ville = findViewById(R.id.ville);
        titre = findViewById(R.id.title);
        description_longue = findViewById(R.id.description_longue);
        apercu = findViewById(R.id.apercu);
       // nbPlaces = findViewById(R.id.nbplaces);
       // placeMax = findViewById(R.id.placeMax);
        thematiques = findViewById(R.id.thematiques);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            Picasso.get().load(bundle.getString("apercu")).into(apercu);
            titre.setText(bundle.getString("Titre"));
            thematiques.setText(bundle.getString("thematiques"));
           // ville.setText(bundle.getString("ville"));
           // nbPlaces.setText(bundle.getString("nbPlaces"));
           // ville.setText(bundle.getString("ville"));
            description_longue.setText(bundle.getString("description_longue"));

        }


    }



}
