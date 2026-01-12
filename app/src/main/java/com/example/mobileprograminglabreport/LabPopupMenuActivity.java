import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class LabPopupMenuActivity extends AppCompatActivity {

    Button btnShowPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_popup_menu);

        btnShowPopup = findViewById(R.id.btnShowPopup);

        btnShowPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(LabPopupMenuActivity.this, btnShowPopup);
            popupMenu.getMenuInflater().inflate(R.menu.popup_lab_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.lab_popup_edit:
                        Toast.makeText(this, "Edit clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.lab_popup_delete:
                        Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.lab_popup_share:
                        Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            });

            popupMenu.show();
        });
    }
}
