package fr.istic.ccn2.ftedelascience.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import fr.istic.ccn2.ftedelascience.adapater.EventRecyclerAdapater;
import fr.istic.ccn2.ftedelascience.R;
import fr.istic.ccn2.ftedelascience.model.Event;



public class Event_Activity extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemSelectedListener {

    DatabaseReference reference;
    RecyclerView recyclerView;
    List<Event> eventList;
    EventRecyclerAdapater eventRecyclerAdapater;
    SearchView searchView;
    private int selectedFilter = 0 ;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_);
        //  searchView = findViewById(R.id.search);
        spinner = findViewById(R.id.spinner_filter);
        //spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.filter_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        recyclerView = this.<RecyclerView>findViewById(R.id.event_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<Event>();
        int i = 1;
        while (i < 6366) {
            reference = FirebaseDatabase.getInstance().getReference().child("eventsScience").child(Integer.toString(i));
            i++;
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String titre = dataSnapshot.child("fields").child("titre_fr").getValue(String.class);
                    String ville = dataSnapshot.child("fields").child("ville").getValue(String.class);
                    String thematiques = dataSnapshot.child("fields").child("thematiques").getValue(String.class);
                    String description = dataSnapshot.child("fields").child("description_fr").getValue(String.class);
                    String description_longue = dataSnapshot.child("fields").child("description_longue_fr").getValue(String.class);
                    String image = dataSnapshot.child("fields").child("image").getValue(String.class);
                    String organisateur = dataSnapshot.child("fields").child("organisateur").getValue(String.class);
                    String animation = dataSnapshot.child("fields").child("type_d_animation").getValue(String.class);
                    String horaire = dataSnapshot.child("fields").child("horaires_detailles_fr").getValue(String.class);
                    String lieu = dataSnapshot.child("fields").child("nom_du_lieu").getValue(String.class);
                    String adresse = dataSnapshot.child("fields").child("adresse").getValue(String.class);
                    String inscription = dataSnapshot.child("fields").child("inscription_necessaire").getValue(String.class);
                    String apercu = dataSnapshot.child("fields").child("apercu").getValue(String.class);
                    String telephone = dataSnapshot.child("fields").child("telephone_du_lieu").getValue(String.class);

                    Event event = new Event(titre, ville, description, thematiques, description_longue, image, organisateur, animation, adresse, lieu, inscription, horaire, apercu, telephone);
                    eventList.add(event);
                    eventRecyclerAdapater = new EventRecyclerAdapater(Event_Activity.this, eventList);
                    recyclerView.setAdapter(eventRecyclerAdapater);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Event_Activity.this, " wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search_bar);
        searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput = newText.toLowerCase();
        List<Event> newList = new ArrayList<>();
        switch (selectedFilter){
            case 0:
                for (Event event : (eventList)) {
                    if (event.getTitre_fr() != null) {
                        if (event.getTitre_fr().toLowerCase().contains(userInput))
                            newList.add(event);
                    }
                }
            case 1:
                for (Event event : (eventList)) {
                    if (event.getThematiques() != null) {
                        if (event.getThematiques().toLowerCase().contains(userInput))
                            newList.add(event);
                    }
                }
            case 2:
                for (Event event : (eventList)) {
                    if (event.getLieu() != null) {
                        if (event.getLieu().toLowerCase().contains(userInput))
                            newList.add(event);
                    }
                }
            case 3:
                for (Event event : (eventList)) {
                    if (event.getOrganisateur() != null) {
                        if (event.getOrganisateur().toLowerCase().contains(userInput))
                            newList.add(event);
                    }
                }
        }

        eventRecyclerAdapater.updateEventList(newList);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.carte:
                startActivity( new Intent(this, MapsActivity.class));
               return true;
            case R.id.parcours:
                }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
       // this.onQueryTextChange(eventList.toString());
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

}




