package com.example.senamit.fitnesstime;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senamit on 31/3/18.
 */

public class FitnessRepository {

    private static final String LOG_TAG = FitnessRepository.class.getSimpleName();

    private  FitnessExerciseDao fitnessExerciseDao;
//    private LiveData<List<FitnessExercise>> fitnessExerciseList;
       List<FitnessExercise> fitnessExerciseList= new ArrayList<FitnessExercise>();
        Application application;
    FitnessExerciseDatabase db;



    public FitnessRepository(Application application) {
        Log.i(LOG_TAG, "inside the fitness repository constructor");
        db = FitnessExerciseDatabase.getDatabase(application);
    }

    private void getDatbase(FitnessExerciseDatabase db) {

    }

    private void loadData(final FitnessExerciseDatabase db) {
        new AsyncTask<Void, Void, List<FitnessExercise>>(){
            FitnessExerciseDao fitnessExerciseDao=db.fitnessExerciseDao();

            @Override
            protected List<FitnessExercise> doInBackground(Void... voids) {
                return fitnessExerciseDao.getAllFitnessExerciseList();
            }

            @Override
            protected void onPostExecute(List<FitnessExercise> fitnessExercises) {
                super.onPostExecute(fitnessExercises);
                fitnessExerciseList.addAll(fitnessExercises);
            }
        }.execute();
    }

//    public LiveData<List<FitnessExercise>> getFitnessExerciseList() {
//        return fitnessExerciseList;
//    }


    List<FitnessExercise> getFitnessExerciseList() {
        loadData(db);
        return fitnessExerciseList;
    }


}
