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

public class ExerciseNamesActivity extends AppCompatActivity {

    ExerciseTypeViewModel mViewModel;
    List<FitnessExercise> fitnessExerciseList;
    private static final String LOG_TAG = ExerciseNamesActivity.class.getSimpleName();
    public static final String EXERCISE_TYPE_ID="exerciseTypeId";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ExerciseNameAdapter exerciseNameAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_names);
        Intent intent = getIntent();
        int id = intent.getIntExtra(EXERCISE_TYPE_ID, 0);

        mViewModel = ViewModelProviders.of(this).get(ExerciseTypeViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        exerciseNameAdapter = new ExerciseNameAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exerciseNameAdapter);





        mViewModel.getFitnessExerciseListNew(id).observe(this, new Observer<List<FitnessExercise>>() {
            @Override
            public void onChanged(@Nullable List<FitnessExercise> fitnessExercises) {
                exerciseNameAdapter.setExercise(fitnessExercises);
//                fitnessExerciseList=fitnessExercises;
//                FitnessExercise fitnessExercise1 = fitnessExercises.get(0);
//                String test_body = fitnessExercise1.getExerciseName();

            }
        });

    }
}
