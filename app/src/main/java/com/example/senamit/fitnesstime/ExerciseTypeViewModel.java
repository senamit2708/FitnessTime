package com.example.senamit.fitnesstime;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by senamit on 29/3/18.
 */

public class ExerciseTypeViewModel extends AndroidViewModel {

    private FitnessRepository mRepository;
    private LiveData<List<FitnessExercise>> mFitnessExerciseList;

    public ExerciseTypeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new FitnessRepository(application);
        mFitnessExerciseList = mRepository.getFitnessExerciseList();
    }

    public LiveData<List<FitnessExercise>> getmFitnessExerciseList() {
        return mFitnessExerciseList;
    }
}
