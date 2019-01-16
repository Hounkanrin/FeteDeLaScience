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

import butterknife.Bind;
import butterknife.ButterKnife;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> eventList;
    private Context context;


    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    public EventAdapter(EventFragment eventFragment, List<Event> eventList) {
    }

    public EventAdapter() {
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.event_list, parent, false);
        EventAdapter.ViewHolder viewHolder = new EventAdapter.ViewHolder(view);
        return viewHolder;
    }

   @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Event event = eventList.get(i);
        viewHolder.titleText.setText(event.getTitre_fr());
        viewHolder.themeText.setText(event.getThematiques());
        viewHolder.descriptionText.setText(event.getDescription_fr());
        Picasso.get().load(event.getApercu()).into(viewHolder.apercuImage);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        /*CardView cardView;
        TextView titleText;
        TextView descriptionText;
        TextView themeText;
        ImageView apercuImage;*/
       @Bind(R.id.event_container)CardView cardView;
        @Bind(R.id.title) TextView titleText;
        @Bind(R.id.description) TextView descriptionText;
        @Bind(R.id.thematiques) TextView themeText;
        @Bind(R.id.apercu) ImageView apercuImage;


        //@Bind(R.id.event_checkbox) CheckBox eventCheckBox;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
              /* cardView =  itemView.findViewById(R.id.event_container);
                titleText = itemView.findViewById(R.id.title);
                apercuImage =  itemView.findViewById(R.id.apercu);
                themeText = itemView.findViewById(R.id.thematiques);
                descriptionText = itemView.findViewById(R.id.description);*/
        }

    }
}




