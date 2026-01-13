package com.example.mobileprograminglabreport;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentCrudActivity extends AppCompatActivity {

    EditText edtID, edtName, edtAge;
    Button btnInsert, btnView, btnUpdate, btnDelete;
    TextView txtResult;

    StudentDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_crud);

        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        txtResult = findViewById(R.id.txtResult);

        dbHelper = new StudentDatabaseHelper(this);

        // Insert Operation
        btnInsert.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            int age = Integer.parseInt(edtAge.getText().toString());

            if (dbHelper.insertStudent(name, age)) {
                Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Insert Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Read Operation
        btnView.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getStudents();
            if (cursor.getCount() == 0) {
                txtResult.setText("No Records Found!");
                return;
            }

            StringBuilder sb = new StringBuilder();
            while (cursor.moveToNext()) {
                sb.append("ID: ").append(cursor.getInt(0)).append("\n");
                sb.append("Name: ").append(cursor.getString(1)).append("\n");
                sb.append("Age: ").append(cursor.getInt(2)).append("\n\n");
            }
            txtResult.setText(sb.toString());
        });

        // Update Operation
        btnUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(edtID.getText().toString());
            String name = edtName.getText().toString();
            int age = Integer.parseInt(edtAge.getText().toString());

            if (dbHelper.updateStudent(id, name, age)) {
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Update Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Delete Operation
        btnDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(edtID.getText().toString());

            if (dbHelper.deleteStudent(id)) {
                Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Delete Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
