package com.example.senamit.fitnesstime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by senamit on 30/3/18.
 */

public class ExerciseTypeAdapter extends RecyclerView.Adapter<ExerciseTypeAdapter.ViewHolder> {

    private static final String LOG_TAG = ExerciseTypeAdapter.class.getSimpleName();
    private Context context;
    private List<FitnessExercise> fitnessExerciseList;

    public ExerciseTypeAdapter(Context context) {
        this.context = context;
        Log.i(LOG_TAG, "inside the constructor of reycler adapter");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_exercise_type_recycler_view, parent, false);
        Log.i(LOG_TAG, "inside the oncreate view holder of reycler adapter");
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (fitnessExerciseList!=null){
            Log.i(LOG_TAG, "inside the onBindViewholder if statement of reycler adapter");
            FitnessExercise current = fitnessExerciseList.get(position);
            holder.txtExerciseName.setText(current.getExerciseName());
        }else {
            Log.i(LOG_TAG, "inside the onBindViewholder else statement of reycler adapter");

            holder.txtExerciseName.setText("No exercise Listed");
        }

    }

    @Override
    public int getItemCount() {
        if (fitnessExerciseList!=null){
           // Log.i(LOG_TAG, "the count of item inside recycler is "+fitnessExerciseList.size());
            return fitnessExerciseList.size();
        } else {
            Log.i(LOG_TAG, "the count is 0 ");
            return 0;
        }
    }

    void setExercise(List<FitnessExercise> mFitnessExercise){
        fitnessExerciseList = mFitnessExercise;
//        Log.i(LOG_TAG, "the count of item inside recycler is "+fitnessExerciseList.size());

        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtExerciseName;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.i(LOG_TAG, "inside the constructor of view holder");

            txtExerciseName = itemView.findViewById(R.id.txtExerciseName);
        }
    }
}
