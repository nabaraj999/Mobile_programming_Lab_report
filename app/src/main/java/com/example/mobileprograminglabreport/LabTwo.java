package com.example.mobileprograminglabreport;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] names = {"Android", "Java", "Kotlin", "XML"};
    int[] images = {R.drawable.android, R.drawable.java, R.drawable.kotlin, R.drawable.xml};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_two);

        ListView listView = findViewById(R.id.listView);
        GridView gridView = findViewById(R.id.gridView);

        CustomAdapter adapter = new CustomAdapter(this, names, images);
        listView.setAdapter(adapter);
        gridView.setAdapter(adapter);
    }
}
