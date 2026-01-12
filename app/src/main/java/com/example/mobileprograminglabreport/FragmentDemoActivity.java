package com.example.mobileprograminglabreport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class FragmentDemoActivity extends AppCompatActivity {

    Button btnAddFirst, btnAddSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        btnAddFirst = findViewById(R.id.btnAddFirst);
        btnAddSecond = findViewById(R.id.btnAddSecond);

        // Add first fragment dynamically
        btnAddFirst.setOnClickListener(v -> {
            addFragment(new FirstFragment());
        });

        // Replace fragment dynamically
        btnAddSecond.setOnClickListener(v -> {
            replaceFragment(new SecondFragment());
        });
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.dynamicContainer, fragment);
        transaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.dynamicContainer, fragment);
        transaction.commit();
    }
}
