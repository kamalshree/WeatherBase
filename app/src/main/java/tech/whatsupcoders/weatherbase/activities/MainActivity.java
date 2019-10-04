package tech.whatsupcoders.weatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import tech.whatsupcoders.weatherbase.R;
import tech.whatsupcoders.weatherbase.adapters.ItemLocationCardAdapter;
import tech.whatsupcoders.weatherbase.models.Location;
import tech.whatsupcoders.weatherbase.models.LocationData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Location> list;
    private ItemLocationCardAdapter cardAdapter;
    private String myFavLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.location_recyclerview);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(LocationData.getListData());
        showRecyclerViewList();

        FloatingActionButton myFab = findViewById(R.id.location_map_button);
        FloatingActionButton myHelp = findViewById(R.id.location_help_button);

        //Help Button
        myHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpIntent = new Intent(getApplicationContext(), ScrollingActivity.class);
                helpIntent.putExtra("url", "https://openweathermap.org/");
                startActivity(helpIntent);
            }
        });

        //Map Button
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent locationIntent = new Intent(getApplicationContext(), LocationMapActivity.class);
                startActivityForResult(locationIntent, 1);
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Location location = new Location();
                myFavLoc = data.getStringExtra("addressVal");
                location.setPlace(myFavLoc);
                list.add(location);
                cardAdapter.notifyDataSetChanged();
            }
        }
    }


    private void showRecyclerViewList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new ItemLocationCardAdapter(this);
        cardAdapter.setListLocations(list);
        recyclerView.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
    }
}
