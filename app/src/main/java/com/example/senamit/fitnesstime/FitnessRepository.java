package com.example.senamit.fitnesstime;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senamit on 31/3/18.
 */

public class FitnessRepository {

    private static final String LOG_TAG = FitnessRepository.class.getSimpleName();
    FitnessExerciseDao fitnessExerciseDao;

     LiveData<List<FitnessExerciseType>> fitnessExerciseList;
     LiveData<List<FitnessExercise>> fitnessExerciseTypeSelected;
    FitnessExerciseDatabase db;



    public FitnessRepository(Application application) {
        Log.i(LOG_TAG, "inside the fitness repository constructor");
        db = FitnessExerciseDatabase.getDatabase(application);
        fitnessExerciseDao=db.fitnessExerciseDao();
        fitnessExerciseList=fitnessExerciseDao.getExerciseTypeList();

    }


    public LiveData<List<FitnessExerciseType>> getFitnessExerciseList() {
        return fitnessExerciseList;
    }

    public LiveData<List<FitnessExercise>> getFitnessExerciseListNew(int id){
        fitnessExerciseTypeSelected= fitnessExerciseDao.getFitnessExerciseListNew(id);
        return fitnessExerciseTypeSelected;
    }


}
