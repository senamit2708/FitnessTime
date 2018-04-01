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
        fitnessExerciseList.add(new FitnessExercise(1,"ABS", "Chrunches 1"));
        fitnessExerciseList.add(new FitnessExercise(1,"ABS", "Chrunches 2"));
        fitnessExerciseList.add(new FitnessExercise(1,"ABS", "Chrunches 3"));
        fitnessExerciseList.add(new FitnessExercise(1,"ABS", "Chrunches 4"));
        fitnessExerciseList.add(new FitnessExercise(1,"BACK", "DeadLift 1"));
        fitnessExerciseList.add(new FitnessExercise(2,"BACK", "DeadLift 2"));
        fitnessExerciseList.add(new FitnessExercise(2,"BACK", "DeadLift 3"));
        fitnessExerciseList.add(new FitnessExercise(2,"BACK", "DeadLift 4"));
        fitnessExerciseList.add(new FitnessExercise(2,"BACK", "DeadLift 5"));
        fitnessExerciseList.add(new FitnessExercise(3,"BICEPS", "Dummbbell 1"));
        fitnessExerciseList.add(new FitnessExercise(3,"BICEPS", "Dummbbell 2"));
        fitnessExerciseList.add(new FitnessExercise(3,"BICEPS", "Dummbbell 3"));

        List<FitnessExerciseType> fitnessExerciseTypeList = new ArrayList<>();
        fitnessExerciseTypeList.add(new FitnessExerciseType(1, "ABS"));
        fitnessExerciseTypeList.add(new FitnessExerciseType(2, "BACK"));
        fitnessExerciseTypeList.add(new FitnessExerciseType(3, "BICEPS"));
        fitnessExerciseTypeList.add(new FitnessExerciseType(4, "TRICEPS"));

        mFitnessExerciseDao.insertAllExercisesList(fitnessExerciseList);
        mFitnessExerciseDao.insertAllExerciseType(fitnessExerciseTypeList);



        return null;
    }
}
