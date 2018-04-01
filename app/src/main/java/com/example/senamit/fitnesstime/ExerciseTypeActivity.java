package com.example.senamit.fitnesstime;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTypeActivity extends AppCompatActivity {

    private static final String LOG_TAG = ExerciseTypeActivity.class.getSimpleName();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ExerciseTypeAdapter exerciseTypeAdapter;
     ExerciseTypeViewModel mViewModel;

    List<FitnessExercise> fitnessExerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_type);

//        mViewModel = ViewModelProviders.of(this).get(ExerciseTypeViewModel.class);
        mViewModel = ViewModelProviders.of(this).get(ExerciseTypeViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        exerciseTypeAdapter = new ExerciseTypeAdapter(this);
//        exerciseTypeAdapter.setExercise(fitnessExerciseList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exerciseTypeAdapter);


//        mViewModel.getmFitnessExerciseList().observe(this, new Observer<List<FitnessExercise>>() {
//            @Override
//            public void onChanged(@Nullable List<FitnessExercise> fitnessExercises) {
//                exerciseTypeAdapter.setExercise(fitnessExercises);
//            }
//        });

      fitnessExerciseList =  mViewModel.getmFitnessExerciseList();
        exerciseTypeAdapter.setExercise(fitnessExerciseList);
//

    }
}
