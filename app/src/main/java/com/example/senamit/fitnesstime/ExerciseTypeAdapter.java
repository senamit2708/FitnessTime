package com.example.senamit.fitnesstime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by senamit on 30/3/18.
 */

public class ExerciseTypeAdapter extends RecyclerView.Adapter<ExerciseTypeAdapter.ViewHolder> {

    private Context context;
    private List<FitnessExercise> fitnessExerciseList;

    public ExerciseTypeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_exercise_type_recycler_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (fitnessExerciseList!=null){
            FitnessExercise current = fitnessExerciseList.get(position);
            holder.txtExerciseName.setText(current.getExerciseName());
        }else {
            holder.txtExerciseName.setText("No exercise Listed");
        }

    }

    @Override
    public int getItemCount() {
        if (fitnessExerciseList!=null){
            return fitnessExerciseList.size();
        } else  return 0;
    }

    void setExercise(List<FitnessExercise> mFitnessExercise){
        fitnessExerciseList = mFitnessExercise;
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
