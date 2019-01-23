package fr.istic.ccn2.ftedelascience;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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
    public EventRecyclerAdapater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventcardview_, parent, false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull final EventRecyclerAdapater.MyViewHolder myViewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called,");
        Event event = eventList.get(i);
        myViewHolder.titre.setText(event.getTitre_fr());
        myViewHolder.thematiques.setText(event.getThematiques());
        myViewHolder.description.setText(event.getDescription());
       //Picasso.get().load(event.getApercu()).into(myViewHolder.apercu);

       myViewHolder.MoncardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, MainActivity.class);
               intent.putExtra("Titre", eventList.get(myViewHolder.getAdapterPosition()).getTitre_fr());
               intent.putExtra("Ville", eventList.get(myViewHolder.getAdapterPosition()).getVille());
               intent.putExtra("description", eventList.get(myViewHolder.getAdapterPosition()).getDescription());
               intent.putExtra("apercu", eventList.get(myViewHolder.getAdapterPosition()).getApercu());
               intent.putExtra("thematiques", eventList.get(myViewHolder.getAdapterPosition()).getThematiques());
               intent.putExtra("description_longue", eventList.get(myViewHolder.getAdapterPosition()).getDescription_longue_fr());
               //intent.putExtra("nPlaces", eventList.get(myViewHolder.getAdapterPosition()).getNbPlaces());
             //  intent.putExtra("placeMax",eventList.get(myViewHolder.getAdapterPosition()).getPlaceMax());
              // intent.putExtra("apercu", eventList.get(myViewHolder.getAdapterPosition()).getApercu());

               context.startActivity(intent);
           }
       });


    }

    @Override
    public int getItemCount() {
        return this.eventList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

       CardView MoncardView;
       TextView ville;
       ImageView apercu;
       //TextView nbPlaces;
       //TextView  placeMax;
       TextView description;
       TextView titre;
       TextView thematiques;
       TextView description_longue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MoncardView = itemView.findViewById(R.id.cardview);
            ville = itemView.findViewById(R.id.ville);
            apercu =  itemView.findViewById(R.id.apercu);
            description = itemView.findViewById(R.id.description);
            thematiques = itemView.findViewById(R.id.thematiques);
            titre = itemView.findViewById(R.id.title);
           // nbPlaces = itemView.findViewById(R.id.nbplaces);
          //  placeMax = itemView.findViewById(R.id.placeMax);
            description_longue = itemView.findViewById(R.id.description_longue);


        }
    }
}

