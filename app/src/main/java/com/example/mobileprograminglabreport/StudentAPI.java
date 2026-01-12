package com.example.mobileprograminglabreport;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentAPI {
    @GET("students.php")   // your endpoint URL
    Call<List<StudentModel>> getStudents();
}
