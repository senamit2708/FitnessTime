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
    private LiveData<List<FitnessExerciseType>> mFitnessExerciseList;
    private LiveData<List<FitnessExercise>> fitnessExerciseTypeSelected;

    public ExerciseTypeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new FitnessRepository(application);
        mFitnessExerciseList = mRepository.getFitnessExerciseList();


    }

    public LiveData<List<FitnessExerciseType>> getmFitnessExerciseList() {
        return mFitnessExerciseList;
    }

    public LiveData<List<FitnessExercise>> getFitnessExerciseListNew(int id){
        fitnessExerciseTypeSelected= mRepository.getFitnessExerciseListNew(id);
        return fitnessExerciseTypeSelected;
    }

}
