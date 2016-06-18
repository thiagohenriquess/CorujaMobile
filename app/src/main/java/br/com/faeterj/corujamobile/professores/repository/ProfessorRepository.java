package br.com.faeterj.corujamobile.professores.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc 2015 on 04/06/2016.
 */
public class ProfessorRepository extends SQLiteOpenHelper {
    public ProfessorRepository(Context context) {

      super(context,"BDProfessor",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptSQL.getCreateProfessor());
        //db.execSQL(PopulaBanco.getPopulaBanco());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
