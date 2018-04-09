package com.example.senamit.fitnesstime;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;


/**
 * Created by senamit on 27/3/18.
 */

@Entity(tableName = "exercise_list", foreignKeys = @ForeignKey(entity = FitnessExerciseType.class,
        parentColumns = "id", childColumns = "exercise_type_id", onDelete = CASCADE),
        indices = @Index(value ="exercise_type_id" ))
public class FitnessExercise {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int exercise_id;

    @ColumnInfo(name = "exercise_type")
    private String exerciseType;

    @NonNull
    @ColumnInfo(name = "exercise_type_id")
    private  Integer exerciseTypeId;

    @ColumnInfo(name = "exercise_name")
    private String exerciseName;

    public FitnessExercise(@NonNull Integer exerciseTypeId, String exerciseType, String exerciseName) {
        this.exerciseType = exerciseType;
        this.exerciseTypeId = exerciseTypeId;
        this.exerciseName = exerciseName;
    }

    @ColumnInfo(name = "body_part")
    private String exerciseBodyPart;


    @ColumnInfo(name = "work_out")
    private String exerciseWorkOut;

    @ColumnInfo(name = "description")
    private String exerciseDescription;

    @ColumnInfo(name = "bookmarked")
    private String exerciseBookmarked;


    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    @NonNull
    public Integer getExerciseTypeId() {
        return exerciseTypeId;
    }

    public void setExerciseTypeId(@NonNull Integer exerciseTypeId) {
        this.exerciseTypeId = exerciseTypeId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseBodyPart() {
        return exerciseBodyPart;
    }

    public void setExerciseBodyPart(String exerciseBodyPart) {
        this.exerciseBodyPart = exerciseBodyPart;
    }

    public String getExerciseWorkOut() {
        return exerciseWorkOut;
    }

    public void setExerciseWorkOut(String exerciseWorkOut) {
        this.exerciseWorkOut = exerciseWorkOut;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getExerciseBookmarked() {
        return exerciseBookmarked;
    }

    public void setExerciseBookmarked(String exerciseBookmarked) {
        this.exerciseBookmarked = exerciseBookmarked;
    }
}
