package fr.istic.ccn2.ftedelascience;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class EventRecyclerAdapater extends RecyclerView.Adapter<EventRecyclerAdapater.MyViewHolder> {

    private List<Event> eventList;
    private Context context;

    public EventRecyclerAdapater (Context context , List<Event> eventList){
    this.context= context;
    this.eventList = eventList;
    }


    @NonNull
    @Override
    public EventRecyclerAdapater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.eventcardview_,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventRecyclerAdapater.MyViewHolder myViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called,");
        Event event = eventList.get(i);
        myViewHolder.titre.setText(event.getTitre());
        myViewHolder.thematiques.setText(event.getThematiques());
        myViewHolder.description.setText(event.getDescription());
        myViewHolder.nbPlaces.setText(event.getNbPlaces());
        myViewHolder.placeMax.setText(event.getPlaceMax());
        myViewHolder.periode.setText(event.getPeriode());
        Picasso.get().load(event.getImage()).into(myViewHolder.image);


    }

    @Override
    public int getItemCount() {
        return this.eventList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

       TextView nbPlaces;
       ImageView image;
       TextView  placeMax;
       TextView  periode;
       TextView description;
       TextView titre;
       TextView thematiques;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nbPlaces = itemView.findViewById(R.id.places);
            image =  itemView.findViewById(R.id.event_image);
            placeMax = itemView.findViewById(R.id.placeMax);
            periode = itemView.findViewById(R.id.period);
            description = itemView.findViewById(R.id.description);
            thematiques = itemView.findViewById(R.id.thematique);
            titre = itemView.findViewById(R.id.title);

        }
    }
}

