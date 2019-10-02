package tech.whatsupcoders.weatherbase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import tech.whatsupcoders.weatherbase.R;
import tech.whatsupcoders.weatherbase.adapters.ItemLocationCardAdapter;
import tech.whatsupcoders.weatherbase.models.Location;
import tech.whatsupcoders.weatherbase.models.LocationData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Location> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.location_recyclerview);
        recyclerView.setHasFixedSize(true);


        list=new ArrayList<>();
        list.addAll(LocationData.getListData());
        showRecyclerViewList();

        FloatingActionButton myFab = findViewById(R.id.location_map_button);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), LocationMapActivity.class);
                startActivity(activity2Intent);
            }
        });
    }

    private void showRecyclerViewList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemLocationCardAdapter cardAdapter=new ItemLocationCardAdapter(this);
        cardAdapter.setListLocations(list);
        recyclerView.setAdapter(cardAdapter);

    }
}
