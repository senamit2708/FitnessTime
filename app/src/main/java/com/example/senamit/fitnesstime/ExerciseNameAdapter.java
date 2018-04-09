package com.example.senamit.fitnesstime;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
/**
 * Created by senamit on 9/4/18.
 */

public class ExerciseNameAdapter extends RecyclerView.Adapter<ExerciseNameAdapter.ViewHolder> {

    Context context;
    private List<FitnessExercise> fitnessExerciseList;

    public ExerciseNameAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_exercise_name_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (fitnessExerciseList!=null){
            FitnessExercise current = fitnessExerciseList.get(position);
            holder.txtExerciseName.setText(current.getExerciseName());
        }else {
            holder.txtExerciseName.setText("No exercise found");
        }

    }

    @Override
    public int getItemCount() {
        if (fitnessExerciseList!=null){
            return fitnessExerciseList.size();
        }else {
            return 0;
        }
    }

    void setExercise(List<FitnessExercise> fitnessExercises){
        fitnessExerciseList=fitnessExercises;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtExerciseName;
        public ViewHolder(View itemView) {
            super(itemView);
            txtExerciseName = itemView.findViewById(R.id.txtExerciseName);
        }
    }
}
