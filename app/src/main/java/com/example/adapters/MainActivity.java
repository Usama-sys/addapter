package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Listview;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    SearchView searchview;
    ArrayList<String>list;
    ArrayAdapter<Adapter>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.lv);
        searchview = (SearchView)findViewById(R.id.searchView);

        list = new ArrayList<>();
        list.add("DSA");
        list.add("OS");
        list.add("MAD");
        list.add("TOA");
        list.add("DAA");

        Build.VERSION_CODES andriod;
        adapter=new ArrayAdapter<Adapter>(this, andriod.R.layout.simple_List_item_1,list );
                listview.setAdapter(adapter);
                searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        if (list.contains(query)){
                            adapter.getFilter().filter(query);
                        }else{
                            Toast.makeText(MainActivity.this, "Match Not Found",
                                    Toast.LENGTH_SHORT).show();
                        }
                        return false;

                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
    }
}