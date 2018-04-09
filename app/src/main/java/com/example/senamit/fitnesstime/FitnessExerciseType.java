package com.example.senamit.fitnesstime;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by senamit on 1/4/18.
 */
@Entity(tableName = "exercise_type", indices = @Index("id"))
public class FitnessExerciseType {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer exercise_type_id;

    @ColumnInfo(name = "Exercise_type")
    private String exercise_type;

    public FitnessExerciseType(@NonNull Integer exercise_type_id, String exercise_type) {
        this.exercise_type_id = exercise_type_id;
        this.exercise_type = exercise_type;
    }

    @NonNull
    public Integer getExercise_type_id() {
        return exercise_type_id;
    }

    public void setExercise_type_id(@NonNull Integer exercise_type_id) {
        this.exercise_type_id = exercise_type_id;
    }

    public String getExercise_type() {
        return exercise_type;
    }

    public void setExercise_type(String exercise_type) {
        this.exercise_type = exercise_type;
    }
}
