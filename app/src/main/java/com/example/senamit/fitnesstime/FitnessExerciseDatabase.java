package com.example.senamit.fitnesstime;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by senamit on 29/3/18.
 */

@Database(entities = {FitnessExercise.class}, version = 1)
public abstract class FitnessExerciseDatabase extends RoomDatabase {

    public abstract FitnessExerciseDao fitnessExerciseDao();

    private static FitnessExerciseDatabase INSTANCE;

    static FitnessExerciseDatabase getDatabase(final Context context){
        if (INSTANCE==null){
            synchronized (FitnessExerciseDatabase.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FitnessExerciseDatabase.class, "fitness_database").build();
                }
            }
        }
        return INSTANCE;
    }



}
