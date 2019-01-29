package fr.istic.ccn2.ftedelascience.adapater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.istic.ccn2.ftedelascience.R;
import fr.istic.ccn2.ftedelascience.activity.MainActivity;
import fr.istic.ccn2.ftedelascience.model.Event;

import static android.support.constraint.Constraints.TAG;

public class EventRecyclerAdapater extends RecyclerView.Adapter<EventRecyclerAdapater.MyViewHolder>{

    private List<Event> eventList;
    private Context context;
    private List<Event> events;

    private static OnItemClickListener listener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
       this.listener = listener;
    }

    public EventRecyclerAdapater (Context context , List<Event> eventList){
    this.context= context;
    this.eventList = eventList;
    events = new ArrayList<>(eventList);
    }


    @Override
    public EventRecyclerAdapater.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventcardview_, parent, false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(final EventRecyclerAdapater.MyViewHolder myViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called,");
        Event event = eventList.get(i);
        myViewHolder.titre.setText(event.getTitre_fr());
        myViewHolder.thematiques.setText(event.getThematiques());
        Picasso.get().load(event.getApercu()).fit().centerInside().into(myViewHolder.apercu);
        myViewHolder.description.setText(event.getDescription());
        Picasso.get().load(event.getApercu()).into(myViewHolder.apercu);

       myViewHolder.MoncardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               /*if (listener != null) {
                   int position = myViewHolder.getAdapterPosition();
                   if (position != RecyclerView.NO_POSITION) {
                       listener.OnItemClick(position);*/

                       Intent intent = new Intent(context, MainActivity.class);
                       intent.putExtra("titre", eventList.get(myViewHolder.getAdapterPosition()).getTitre_fr());
                       intent.putExtra("thematiques", eventList.get(myViewHolder.getAdapterPosition()).getThematiques());
                       intent.putExtra("description_longue", eventList.get(myViewHolder.getAdapterPosition()).getDescription_longue_fr());
                       //intent.putExtra("nPlaces", eventList.get(myViewHolder.getAdapterPosition()).getNbPlaces());
                       //  intent.putExtra("placeMax",eventList.get(myViewHolder.getAdapterPosition()).getPlaceMax());
                       intent.putExtra("image", eventList.get(myViewHolder.getAdapterPosition()).getImage());
                       intent.putExtra("organisateur", eventList.get(myViewHolder.getAdapterPosition()).getOrganisateur());
                       intent.putExtra("animation", eventList.get(myViewHolder.getAdapterPosition()).getAnimation());
                       intent.putExtra("inscription", eventList.get(myViewHolder.getAdapterPosition()).getInscription());
                       intent.putExtra("horaire", eventList.get(myViewHolder.getAdapterPosition()).getHoraire());
                       intent.putExtra("lieu", eventList.get(myViewHolder.getAdapterPosition()).getLieu());
                       intent.putExtra("adresse", eventList.get(myViewHolder.getAdapterPosition()).getAdresse());
                       intent.putExtra("telephone", eventList.get(myViewHolder.getAdapterPosition()).getTelephone());

                       context.startActivity(intent);
                   }

           

       });

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return this.eventList.size();
    }


    public void updateEventList(List<Event> newEventList){
        eventList = new ArrayList<Event>();
        eventList.addAll(newEventList);
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView MoncardView;
        TextView ville;
       //TextView nbPlaces;
       //TextView  placeMax;
        ImageView apercu;
        TextView description;
        TextView titre;
        TextView thematiques;
        TextView description_longue;
        ImageView image;
        TextView organisateur;
        TextView animation;
        TextView horaire;
        TextView lieu;
        TextView adresse;
        TextView inscription;
        TextView telephone;

        public MyViewHolder(View itemView) {
            super(itemView);
            apercu = itemView.findViewById(R.id.imageEvent);
            MoncardView = itemView.findViewById(R.id.cardview);
            ville = itemView.findViewById(R.id.ville);
            description = itemView.findViewById(R.id.description);
            thematiques = itemView.findViewById(R.id.thematiques);
            titre = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
           // nbPlaces = itemView.findViewById(R.id.nbplaces);
          //  placeMax = itemView.findViewById(R.id.placeMax);
            description_longue = itemView.findViewById(R.id.description_longue);
            organisateur = itemView.findViewById(R.id.organisateur);
            animation = itemView.findViewById(R.id.animation);
            horaire = itemView.findViewById(R.id.horaire);
            lieu = itemView.findViewById(R.id.lieu);
            adresse = itemView.findViewById(R.id.adresse);
            inscription = itemView.findViewById(R.id.inscription);
            telephone = itemView.findViewById(R.id.telephone);

        }
    }


}

