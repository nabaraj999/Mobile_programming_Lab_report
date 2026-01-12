package com.example.mobileprograminglabreport;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentDialogActivity extends AppCompatActivity {

    Button btnOpenDialog;
    TextView txtDisplayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dialog);

        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        txtDisplayInfo = findViewById(R.id.txtDisplayInfo);

        btnOpenDialog.setOnClickListener(v -> showStudentDialog());
    }

    private void showStudentDialog() {
        Dialog dialog = new Dialog(StudentDialogActivity.this);
        dialog.setContentView(R.layout.dialog_student_input);

        EditText edtName = dialog.findViewById(R.id.edtName);
        EditText edtRoll = dialog.findViewById(R.id.edtRoll);
        EditText edtResult = dialog.findViewById(R.id.edtResult);
        EditText edtGrade = dialog.findViewById(R.id.edtGrade);
        Button btnSave = dialog.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {

            String name = edtName.getText().toString();
            String roll = edtRoll.getText().toString();
            String result = edtResult.getText().toString();
            String grade = edtGrade.getText().toString();

            if (name.isEmpty() || roll.isEmpty() || result.isEmpty() || grade.isEmpty()) {
                edtName.setError("Required");
                edtRoll.setError("Required");
                edtResult.setError("Required");
                edtGrade.setError("Required");
                return;
            }

            String displayData =
                    "Name: " + name + "\n"
                            + "Roll: " + roll + "\n"
                            + "Result: " + result + "%\n"
                            + "Grade: " + grade;

            txtDisplayInfo.setText(displayData);

            dialog.dismiss();
        });

        dialog.show();
    }
}
