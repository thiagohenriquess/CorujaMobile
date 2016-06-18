package br.com.faeterj.corujamobile.notas_faltas.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.faeterj.corujamobile.notas_faltas.Data.DataBase;
import br.com.faeterj.corujamobile.notas_faltas.Model.Turma;

/**
 * Created by Danilo on 10/06/2016.
 */
public class TurmaRepository {

    private SQLiteDatabase db;

    public TurmaRepository (Context context){

        this.db = new DataBase(context).getWritableDatabase();

    }




    public void insertTurmaRepository (Turma turma){

        ContentValues valores = new ContentValues();

        valores.put("horario", turma.getHorario());
        valores.put("turno", turma.getTurno());
        valores.put("ano", turma.getAno());
        valores.put("semestre", turma.getSemestre());

        db.insert("turma",null,valores);

    }


}
