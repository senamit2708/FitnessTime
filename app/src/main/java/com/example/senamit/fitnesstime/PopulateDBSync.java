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
        mFitnessExerciseDao.deleteAllExerciseList();
        FitnessExercise fitnessExercise = new FitnessExercise("priyanka");
        FitnessExercise fitnessExercise2 = new FitnessExercise("amit");
        mFitnessExerciseDao.insertExerciseList(fitnessExercise);
        mFitnessExerciseDao.insertExerciseList(fitnessExercise2);


        return null;
    }
}
