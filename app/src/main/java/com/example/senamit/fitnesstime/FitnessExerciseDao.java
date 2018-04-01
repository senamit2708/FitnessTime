package com.example.senamit.fitnesstime;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by senamit on 29/3/18.
 */
@Dao
public interface FitnessExerciseDao {

    @Insert
     void insertExerciseList(FitnessExercise fitnessExercise);

    @Query("DELETE FROM exercise_list")
    void  deleteAllExerciseList();

    @Query("SELECT * FROM exercise_list")
    LiveData<List<FitnessExercise>> getAllFitnessExerciseList();



}
