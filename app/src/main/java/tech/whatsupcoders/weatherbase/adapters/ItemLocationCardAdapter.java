package tech.whatsupcoders.weatherbase.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tech.whatsupcoders.weatherbase.R;
import tech.whatsupcoders.weatherbase.activities.LocationDetailsActivity;
import tech.whatsupcoders.weatherbase.models.Location;

public class ItemLocationCardAdapter extends RecyclerView.Adapter<ItemLocationCardAdapter.CardViewHolder>{
    private Context context;
    private ArrayList<Location> listLocations;

    public ItemLocationCardAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Location> getListLocations() {
        return listLocations;
    }

    public void setListLocations(ArrayList<Location> listLocations) {
        this.listLocations = listLocations;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemList= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,parent,false);
        return new CardViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLocationCardAdapter.CardViewHolder holder, final int position) {
        holder.tv_location.setText(getListLocations().get(position).getPlace());
        holder.cardview_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LocationDetailsActivity.class);
                intent.putExtra("placeDetails", getListLocations().get(position).getPlace());
                intent.putExtra("latitude", getListLocations().get(position).getLatitude());
                intent.putExtra("longitude", getListLocations().get(position).getLongitude());
                context.startActivity(intent);
            }
        });
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeLocationItems(position);
            }
        });
    }

    private void removeLocationItems(int position) {
        listLocations.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getListLocations().size());
    }

    @Override
    public int getItemCount() {
        return getListLocations().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView tv_location;
        ImageButton button_delete;
        CardView cardview_location;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_location=itemView.findViewById(R.id.location_name_card_textview);
            button_delete=itemView.findViewById(R.id.delete_button);
            cardview_location=itemView.findViewById(R.id.location_cardview);
        }
    }
}