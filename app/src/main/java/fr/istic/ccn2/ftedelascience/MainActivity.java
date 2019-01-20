package fr.istic.ccn2.ftedelascience;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Write a message to the database
    //FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef;
    ArrayList<Event> eventList;
    RecyclerView recyclerView;
    EventRecyclerView adapter;
    //Button view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.event_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<Event>();
        int i =1;
        while (i<6366){
            dbRef = FirebaseDatabase.getInstance().getReference().child(Integer.toString(i));
            i++;
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String titre = dataSnapshot.child("fields").child("titre_fr").getValue(String.class);
                    Event event = new Event(titre);
                    eventList.add(event);
                    adapter = new EventRecyclerView(MainActivity.this, eventList);
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();

                }
            });
        }


    }

}
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.event_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<Event>();
        int i = 1;
        while (i < 6366){
            dbRef = FirebaseDatabase.getInstance().getReference().child(Integer.toString(i));
            i++;
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String titre = dataSnapshot.child("fields").child("titre_fr").getValue(String.class);
                    Event event = new Event(titre);
                    eventList.add(event);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();

                }
            });
        }


   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.event_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<Event>();

            dbRef = FirebaseDatabase.getInstance().getReference().child("fields");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                        Event eventValue = dataSnapshot1.getValue(Event.class);
                        String titre = eventValue.getTitre_fr();
                        Event event = new Event(titre);
                        eventList.add(event);
                        adapter = new EventRecyclerView(MainActivity.this, eventList);
                        recyclerView.setAdapter(adapter);

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();

                }
            });



    /*   db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("fields");
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
        });*/
