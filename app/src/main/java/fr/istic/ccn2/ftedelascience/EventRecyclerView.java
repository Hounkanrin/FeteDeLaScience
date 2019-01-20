package fr.istic.ccn2.ftedelascience;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EventRecyclerView extends RecyclerView.Adapter<EventRecyclerView.MyHolder> {

    Context context;
    ArrayList<Event> eventArrayList;

    public EventRecyclerView(Context context, ArrayList<Event> eventArrayList) {
        this.context = context;
        this.eventArrayList = eventArrayList;
    }

    @NonNull
    @Override
    public EventRecyclerView.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_list, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventRecyclerView.MyHolder myHolder, int i) {
        myHolder.titre.setText(eventArrayList.get(i).getTitre_fr());


    }

    @Override
    public int getItemCount() {
        return eventArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView titre;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            titre = itemView.findViewById(R.id.title);
            cardView = itemView.findViewById(R.id.mycardview);

        }
    }
}
