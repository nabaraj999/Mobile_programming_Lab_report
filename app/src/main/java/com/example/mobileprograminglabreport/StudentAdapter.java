package com.example.mobileprograminglabreport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    List<StudentModel> studentList;

    public StudentAdapter(List<StudentModel> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_student_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentModel student = studentList.get(position);

        holder.txtId.setText("ID: " + student.getId());
        holder.txtName.setText("Name: " + student.getName());
        holder.txtAge.setText("Age: " + student.getAge());
        holder.txtFaculty.setText("Faculty: " + student.getFaculty());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtAge, txtFaculty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtStudId);
            txtName = itemView.findViewById(R.id.txtStudName);
            txtAge = itemView.findViewById(R.id.txtStudAge);
            txtFaculty = itemView.findViewById(R.id.txtStudFaculty);
        }
    }
}
