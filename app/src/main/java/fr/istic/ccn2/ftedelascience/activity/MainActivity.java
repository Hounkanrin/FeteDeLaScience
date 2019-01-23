package fr.istic.ccn2.ftedelascience.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.istic.ccn2.ftedelascience.R;


public class MainActivity extends AppCompatActivity {

    TextView ville;
    TextView titre;
    TextView description_longue;
    ImageView image;
   // TextView nbPlaces;
    //TextView placeMax;
    TextView thematiques;



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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            Picasso.get().load(bundle.getString("image")).into(image);
            titre.setText(bundle.getString("titre"));
           // nbPlaces.setText(bundle.getString("nbPlaces"));
            description_longue.setText(bundle.getString("description_longue"));

        }


    }



}
