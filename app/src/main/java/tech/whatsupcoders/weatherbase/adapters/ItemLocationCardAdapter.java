package tech.whatsupcoders.weatherbase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tech.whatsupcoders.weatherbase.R;
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
    public void onBindViewHolder(@NonNull ItemLocationCardAdapter.CardViewHolder holder, int position) {
        holder.tv_location.setText(getListLocations().get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return getListLocations().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView tv_location;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_location=itemView.findViewById(R.id.location_name_card_textview);
        }
    }
}