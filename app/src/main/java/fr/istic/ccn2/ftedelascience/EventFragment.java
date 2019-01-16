package fr.istic.ccn2.ftedelascience;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.widget.Toast.LENGTH_SHORT;

public class EventFragment extends Fragment {

   private static final String TAG = EventFragment.class.getSimpleName();
    DatabaseReference db;
    private List<Event> eventList;
    @Bind(R.id.event_recycler_view) RecyclerView recyclerView;
    @Bind(R.id.progressBar_cyclic) ProgressBar progressBar;

    private OnEventListFragmentInteractionListener mListener;
    private EventAdapter eventAdapter;
    /*@BindView(R.id.search_bar) SearchView searchView;
    @BindView(R.id.key_words_filter) Spinner filterSpinner;
    @BindView(R.id.options_path_layout_btn) LinearLayout optionsPathLineaLayoutBtn;
    @BindView(R.id.edit_path_btn) IconTextView editPathBtn;
    private Unbinder unbinder;*/


   public EventFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseDatabase.getInstance().getReference("fields");

    /*   db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Event event = dataSnapshot1.getValue(Event.class);
                    eventList.add(event);
                }
                eventAdapter = new EventAdapter(EventFragment.this, eventList);
                recyclerView.setAdapter(eventAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
               // Toast.makeText(EventFragment.this, "error de demarrage", LENGTH_SHORT).show();

            }
        });*/

    }



 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_fragment,container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventAdapter = new EventAdapter(getActivity().getApplication().getApplicationContext(), eventList);
        recyclerView.setAdapter(eventAdapter);
         return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public interface OnEventListFragmentInteractionListener {
        void onItemSelected(Event item);
    }
}
