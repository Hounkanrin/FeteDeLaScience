package fr.istic.ccn2.ftedelascience.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fr.istic.ccn2.ftedelascience.R;
import fr.istic.ccn2.ftedelascience.adapater.EventRecyclerAdapater;
import fr.istic.ccn2.ftedelascience.model.Event;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    private Event event;
    RecyclerView recyclerView;
    private EventRecyclerAdapater eventRecyclerAdapater;
    List<Event> eventList;

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
    TextView telephone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.event_recyclerView);
        eventList = new ArrayList<>();

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
        telephone = findViewById(R.id.telephone);
        ImageView image_call = findViewById(R.id.image_call);

        Intent intent = getIntent();
        event = (Event) intent.getSerializableExtra("eventClass");
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
                    telephone.setText(bundle.getString("telephone"));
            image_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callPhone();
                }

            });
        }
    }

    public void callPhone(){
        Bundle bundle = getIntent().getExtras();
        telephone.setText(bundle.getString("telephone"));
        if(telephone.length()>0){
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            } else {
                String dial = "tel:" + telephone;
                startActivity(new Intent (Intent.ACTION_CALL, Uri.parse(dial)));
            }

            }else {
            Toast.makeText(MainActivity.this, "Numéro de téléphone vide ", Toast.LENGTH_LONG);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                callPhone();
            }else{
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_LONG).show();
            }
        }
    }
}
