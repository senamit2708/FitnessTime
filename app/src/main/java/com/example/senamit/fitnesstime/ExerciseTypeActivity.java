package com.example.senamit.fitnesstime;

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
    List<FitnessExercise> fitnessExerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_type);

        fitnessExerciseList = new ArrayList<FitnessExercise>();
        fitnessExerciseList.add(new FitnessExercise("exercise 1"));
        fitnessExerciseList.add(new FitnessExercise("exercise 2"));

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        exerciseTypeAdapter = new ExerciseTypeAdapter(this);
        exerciseTypeAdapter.setExercise(fitnessExerciseList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exerciseTypeAdapter);


    }
}
