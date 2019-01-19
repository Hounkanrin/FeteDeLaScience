package fr.istic.ccn2.ftedelascience;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class EventRecyclerView extends RecyclerView.Adapter<EventRecyclerView.MyHolder> {

    List<Event> eventList;
    Context context;

    public EventRecyclerView(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    public EventRecyclerView() {
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_list,parent, false);
       MyHolder myHoder = new MyHolder(view);
        return myHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Event event = eventList.get(i);
        Picasso.get().load(event.getApercu()).into(myHolder.apercu);
        myHolder.titre.setText(event.getTitre_fr());
        myHolder.thematiques.setText(event.getThematiques());
        myHolder.ville.setText(event.getVille());

    }

    @Override
    public int getItemCount() {
        int arr = 0;
        try{
            if (eventList.size()==0){
                arr=0;
            }else {
                arr = eventList.size();
            }
        }catch (Exception e){
        }
        return arr;
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView titre ;
        TextView ville;
        TextView thematiques;
        ImageView apercu;
        CardView cardView;

        public MyHolder( View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            titre = itemView.findViewById(R.id.title);
            ville = itemView.findViewById(R.id.ville);
            thematiques = itemView.findViewById(R.id.thematiques);
            apercu = itemView.findViewById(R.id.apercu);
        }
    }
}
