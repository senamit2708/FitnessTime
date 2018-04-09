package com.example.senamit.fitnesstime;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class ExerciseTypeActivity extends AppCompatActivity implements ExerciseTypeAdapter.ClickListenerExerciseType{

    private static final String LOG_TAG = ExerciseTypeActivity.class.getSimpleName();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ExerciseTypeAdapter exerciseTypeAdapter;
     ExerciseTypeViewModel mViewModel;
     public static final String EXERCISE_TYPE_ID="exerciseTypeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_type);

        mViewModel = ViewModelProviders.of(this).get(ExerciseTypeViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        exerciseTypeAdapter = new ExerciseTypeAdapter(this, ExerciseTypeActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exerciseTypeAdapter);



        mViewModel.getmFitnessExerciseList().observe(this, new Observer<List<FitnessExerciseType>>() {
            @Override
            public void onChanged(@Nullable List<FitnessExerciseType> fitnessExercises) {
                exerciseTypeAdapter.setExercise(fitnessExercises);
            }
        });


    }

    @Override
    public void onListItemClick(int clickedItemIndex, int exerciseTypeId) {
        Log.i(LOG_TAG, "inside the onlistitem click method");
        Intent intent = new Intent(this, ExerciseNamesActivity.class );
        intent.putExtra(EXERCISE_TYPE_ID, exerciseTypeId);
        startActivity(intent);

    }
}
