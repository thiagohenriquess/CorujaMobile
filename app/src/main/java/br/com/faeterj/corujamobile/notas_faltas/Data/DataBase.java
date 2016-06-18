package br.com.faeterj.corujamobile.notas_faltas.Data;

/**
 * Created by Danilo on 10/06/2016.
 */

import android.content.Context;
import android.database.sqlite.*;


public class DataBase extends SQLiteOpenHelper{





    public DataBase(Context context){
        super(context, "AppFaeterj", null,1 );

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL(AlunoRepository.CreateTableAluno());
        db.execSQL(ScriptSQL.createTableAlunoTurma());
        //db.execSQL(DisciplinaRepository.CreateTableDisciplina());
        //db.execSQL(TurmaRepository.CreateTableTurma());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
