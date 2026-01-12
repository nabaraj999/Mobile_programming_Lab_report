package com.example.mobileprograminglabreport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentApiDemoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_api_demo);

        recyclerView = findViewById(R.id.studentRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadStudents();
    }

    private void loadStudents() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yourdomain.com/") // replace with your URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StudentAPI api = retrofit.create(StudentAPI.class);

        Call<List<StudentModel>> call = api.getStudents();

        call.enqueue(new Callback<List<StudentModel>>() {
            @Override
            public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(StudentApiDemoActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<StudentModel> studentList = response.body();
                studentAdapter = new StudentAdapter(studentList);
                recyclerView.setAdapter(studentAdapter);
            }

            @Override
            public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                Toast.makeText(StudentApiDemoActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
