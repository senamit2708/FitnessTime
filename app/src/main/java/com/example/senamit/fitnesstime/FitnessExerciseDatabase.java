package com.example.senamit.fitnesstime;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by senamit on 29/3/18.
 */

@Database(entities = {FitnessExercise.class, FitnessExerciseType.class}, version = 1)
public abstract class FitnessExerciseDatabase extends RoomDatabase {

    private static final String LOG_TAG = FitnessExerciseDatabase.class.getSimpleName();


    public abstract FitnessExerciseDao fitnessExerciseDao();

    private static FitnessExerciseDatabase INSTANCE;

    static FitnessExerciseDatabase getDatabase(final Context context){
        Log.i(LOG_TAG, "inside the get Database method of fitnessexercise database");
        if (INSTANCE==null){
            synchronized (FitnessExerciseDatabase.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FitnessExerciseDatabase.class, "fitness_database").addCallback(sRoomDatabase).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabase = new FitnessExerciseDatabase.Callback(){


        //optionally try to use onopen for dev coding purpose
//        @Override
//        public void onOpen(@NonNull SupportSQLiteDatabase db) {
//            super.onOpen(db);
//            new PopulateDBSync(INSTANCE).execute();
//        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.i(LOG_TAG, "inside the callback method of fitnessexercise database");
            new PopulateDBSync(INSTANCE).execute();
        }

    };



}
