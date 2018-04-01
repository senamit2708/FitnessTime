package com.example.senamit.fitnesstime;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by senamit on 1/4/18.
 */
@Entity(tableName = "exericse_type")
public class FitnessExerciseType {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int exercise_type_id;

    @ColumnInfo(name = "Exercise_type")
    private String exercise_type;

    public FitnessExerciseType(@NonNull int exercise_type_id, String exercise_type) {
        this.exercise_type_id = exercise_type_id;
        this.exercise_type = exercise_type;
    }

    @NonNull
    public int getExercise_type_id() {
        return exercise_type_id;
    }

    public String getExercise_type() {
        return exercise_type;
    }
}
