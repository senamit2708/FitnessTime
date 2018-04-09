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

    @Query("DELETE FROM exercise_type")
    void deleteAllExerciseType();

    @Query("DELETE FROM exercise_list")
    void  deleteAllExerciseList();

    @Query("SELECT * FROM exercise_list")
    LiveData<List<FitnessExercise>> getAllFitnessExerciseList();


    @Query("SELECT * FROM exercise_type")
    LiveData<List<FitnessExerciseType>> getExerciseTypeList();


    //JUST FOR LEARNING PURPOSE, WE CAN USE BOTH , BUT ITS GOOD IF WE WRITE CODE IN MINIMUM
//    @Query("SELECT * FROM exercise_list INNER JOIN exercise_type ON " +
//            "exercise_list.exercise_type_id =Exercise_type.id WHERE exercise_list.exercise_type_id=:id")
//    LiveData<List<FitnessExercise>> getFitnessExerciseListNew(int id);


    @Query("SELECT * FROM exercise_list WHERE exercise_type_id =:id")
    LiveData<List<FitnessExercise>> getFitnessExerciseListNew(int id);

}
