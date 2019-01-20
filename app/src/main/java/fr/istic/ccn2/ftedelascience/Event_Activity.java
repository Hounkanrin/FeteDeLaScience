package fr.istic.ccn2.ftedelascience;

import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Event_Activity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    List<Event> eventList;
    EventRecyclerAdapater eventRecyclerAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_);

        recyclerView = (RecyclerView) findViewById(R.id.event_recyclerView);
       // GridLayoutManager myGridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<Event>();
        int i =1;
        while (i < 6366){
            reference = FirebaseDatabase.getInstance().getReference().child("eventsScience").child(Integer.toString(i));
            i++;
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String titre = dataSnapshot.child("fields").child("titre_fr").getValue(String.class);
                    String ville = dataSnapshot.child("fields").child("ville").getValue(String.class);
                    String thematiques = dataSnapshot.child("fields").child("thematiques").getValue(String.class);
                    String description = dataSnapshot.child("fields").child("description_fr").getValue(String.class);
                    Event event = new Event(titre, ville, description, thematiques);
                    eventList.add(event);
                    eventRecyclerAdapater = new EventRecyclerAdapater(Event_Activity.this,eventList);
                    recyclerView.setAdapter(eventRecyclerAdapater);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Event_Activity.this, " wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

}
