package com.example.senamit.fitnesstime;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senamit on 31/3/18.
 */

public class PopulateDBSync extends AsyncTask<Void, Void, Void>{

    private static final String LOG_TAG = PopulateDBSync.class.getSimpleName();
    private FitnessExerciseDao mFitnessExerciseDao;
    private List<FitnessExercise> fitnessExerciseList;

    public PopulateDBSync(FitnessExerciseDatabase db) {

        mFitnessExerciseDao = db.fitnessExerciseDao();
    }


    @Override
    protected Void doInBackground(Void... params) {
        mFitnessExerciseDao.deleteAllExerciseList();

        fitnessExerciseList = new ArrayList<FitnessExercise>();
        fitnessExerciseList.add(new FitnessExercise("priyanka1", "patro1"));
        fitnessExerciseList.add(new FitnessExercise("priyanka2", "patro2"));
        fitnessExerciseList.add(new FitnessExercise("priyanka3", "patro3"));
        fitnessExerciseList.add(new FitnessExercise("priyanka4", "patro4"));
        mFitnessExerciseDao.insertAllExercisesList(fitnessExerciseList);



        return null;
    }
}
