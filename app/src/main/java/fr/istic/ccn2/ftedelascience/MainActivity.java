package fr.istic.ccn2.ftedelascience;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Write a message to the database
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef;
    List<Event> eventList;
    RecyclerView recyclerView;
    Button view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (Button) findViewById(R.id.view);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("filds");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eventList = new ArrayList<Event>();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Event eventValue = dataSnapshot1.getValue(Event.class);
                    Event event = new Event();
                    String titre = eventValue.getTitre_fr();
                    String thematiques = eventValue.getThematiques();
                    String ville = eventValue.getVille();
                    String apercu = eventValue.getApercu();
                    event.setTitre_fr(titre);
                    event.setThematiques(thematiques);
                    event.setVille(ville);
                    event.setApercu(apercu);
                    eventList.add(event);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Hello", "Failed to read value.", databaseError.toException());
            }

        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventRecyclerView eventRecyclerView = new EventRecyclerView(eventList, MainActivity.this);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,2);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(eventRecyclerView);
            }
        });
    }
}
