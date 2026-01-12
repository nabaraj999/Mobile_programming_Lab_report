package com.example.mobileprograminglabreport;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LabContextMenuActivity extends AppCompatActivity {

    TextView txtContextDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_popup_menu);

        txtContextDemo = findViewById(R.id.txtContextDemo);

        // Register for context menu
        registerForContextMenu(txtContextDemo);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose Action");
        menu.add(0, 1, 0, "Edit");
        menu.add(0, 2, 0, "Delete");
        menu.add(0, 3, 0, "Share");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "Edit Selected", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "Delete Selected", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "Share Selected", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
