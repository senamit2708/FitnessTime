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

    @Insert
    void insertAllExercisesList(List<FitnessExercise> fitnessExercises);

    @Insert
    void insertAllExerciseType(List<FitnessExerciseType> fitnessExerciseType );

    @Query("DELETE FROM exericse_type")
    void deleteAllExerciseType();

    @Query("DELETE FROM exercise_list")
    void  deleteAllExerciseList();

    @Query("SELECT * FROM exercise_list")
    LiveData<List<FitnessExercise>> getAllFitnessExerciseList();


    @Query("SELECT * FROM exericse_type")
    LiveData<List<FitnessExerciseType>> getExerciseTypeList();

}
