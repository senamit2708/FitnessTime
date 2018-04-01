package com.example.senamit.fitnesstime;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

/**
 * Created by senamit on 31/3/18.
 */

public class FitnessRepository {

    private static final String LOG_TAG = FitnessRepository.class.getSimpleName();

    private  FitnessExerciseDao fitnessExerciseDao;
//    private LiveData<List<FitnessExercise>> fitnessExerciseList;
       List<FitnessExercise> fitnessExerciseList;
        Application application;
    FitnessExerciseDatabase db;



    public FitnessRepository(Application application) {

        Log.i(LOG_TAG, "inside the fitness repository constructor");
        db = FitnessExerciseDatabase.getDatabase(application);
        Log.i(LOG_TAG, "inside the fitness repository constructor 2");
        fitnessExerciseDao = db.fitnessExerciseDao();
        Log.i(LOG_TAG, "inside the fitness repository constructor 3");
        fitnessExerciseList=  new showAsyncTask(fitnessExerciseDao).doInBackground();
        Log.i(LOG_TAG, "inside the fitness repository constructor 4");
    }

//    public LiveData<List<FitnessExercise>> getFitnessExerciseList() {
//        return fitnessExerciseList;
//    }

    public List<FitnessExercise> getFitnessExerciseList() {
        return fitnessExerciseList;
    }



//    private class showAsyncTask extends AsyncTaskLoader<List<FitnessExercise>> {
//
//
//        public showAsyncTask(Context context) {
//            super(context);
//        }
//
//        @Override
//        public List<FitnessExercise> loadInBackground() {
//            Log.e(LOG_TAG, "inside load in background for test");
//            return fitnessExerciseDao.getAllFitnessExerciseList();
//        }
//    }
    private static class showAsyncTask extends AsyncTask<Void, Void, List<FitnessExercise>>{

        private FitnessExerciseDao asyncDao;

    public showAsyncTask(FitnessExerciseDao dao) {
        asyncDao = dao;
    }

    @Override
    protected List<FitnessExercise> doInBackground(Void... voids) {
                    Log.e(LOG_TAG, "inside load in background for test");

            return asyncDao.getAllFitnessExerciseList();
    }
}

}
