package com.example.senamit.fitnesstime;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by senamit on 31/3/18.
 */

public class PopulateDBSync extends AsyncTask<Void, Void, Void>{

    private static final String LOG_TAG = PopulateDBSync.class.getSimpleName();
    private FitnessExerciseDao mFitnessExerciseDao;

    public PopulateDBSync(FitnessExerciseDatabase db) {

        mFitnessExerciseDao = db.fitnessExerciseDao();
    }


    @Override
    protected Void doInBackground(Void... params) {
        Log.i(LOG_TAG, "inside do in background of populate db sync");
        mFitnessExerciseDao.deleteAllExerciseList();
        Log.i(LOG_TAG, "inside do in background of populate db sync 2");

        FitnessExercise fitnessExercise = new FitnessExercise("priyanka");
        FitnessExercise fitnessExercise2 = new FitnessExercise("amit");
        Log.i(LOG_TAG, "inside do in background of populate db sync 3");

        mFitnessExerciseDao.insertExerciseList(fitnessExercise);
        mFitnessExerciseDao.insertExerciseList(fitnessExercise2);
        Log.i(LOG_TAG, "inside do in background of populate db sync 4");


        return null;
    }
}
