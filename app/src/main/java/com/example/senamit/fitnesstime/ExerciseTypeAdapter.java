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
    private List<FitnessExerciseType> fitnessExerciseList;
    private ClickListenerExerciseType onClickListener;


    public ExerciseTypeAdapter(Context context, ClickListenerExerciseType onClickListener) {
        this.context = context;
        this.onClickListener= onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_exercise_type_recycler_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (fitnessExerciseList!=null){
            FitnessExerciseType current = fitnessExerciseList.get(position);
            holder.txtExerciseName.setText(current.getExercise_type());
        }else {
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

    void setExercise(List<FitnessExerciseType> mFitnessExercise){
        fitnessExerciseList = mFitnessExercise;
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtExerciseName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtExerciseName = itemView.findViewById(R.id.txtExerciseName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.i(LOG_TAG, "inside the onclick listener");
            int clickedItemIndex = getAdapterPosition();
            int exerciseTypeId = fitnessExerciseList.get(clickedItemIndex).getExercise_type_id();
            onClickListener.onListItemClick(clickedItemIndex, exerciseTypeId);
        }
    }

    public interface ClickListenerExerciseType{
        void onListItemClick(int clickedItemIndex, int exerciseTypeId);

    }

}
