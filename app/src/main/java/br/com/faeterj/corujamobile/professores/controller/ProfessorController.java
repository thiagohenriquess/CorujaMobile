package br.com.faeterj.corujamobile.professores.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import br.com.faeterj.corujamobile.professores.model.Professor;

/**
 * Created by pc 2015 on 04/06/2016.
 */
public class ProfessorController {

    private SQLiteDatabase conn;
    private boolean aux;

    public ProfessorController(SQLiteDatabase conn){

        this.conn = conn;

    }

    public void inserir(Professor prof){

        ContentValues values = new ContentValues();

        values.put("NOME", prof.getNome());
        values.put("EMAIL", prof.getEmail());
        values.put("MATERIAS", prof.getMaterias());
        values.put("DIASMANHA", prof.getDiasManha());
        values.put("DIASNOITE", prof.getDiasNoite());

        conn.insertOrThrow("PROFESSOR", null, values);
    }

    public ArrayAdapter<Professor> buscaProfessor(Context context) {

        ArrayAdapter<Professor> adpProfessor = new ArrayAdapter<Professor>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("PROFESSOR", null, null, null, null, null, null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();
            do {
                Professor professor = new Professor();

                professor.setId(cursor.getLong(cursor.getColumnIndex(Professor.ID)));
                professor.setNome(cursor.getString(cursor.getColumnIndex(Professor.NOME)));
                professor.setEmail(cursor.getString(cursor.getColumnIndex(professor.EMAIL)));
                professor.setMaterias(cursor.getString(cursor.getColumnIndex(professor.MATERIAS)));
                professor.setDiasManha(cursor.getString(cursor.getColumnIndex(Professor.DIASMANHA)));
                professor.setDiasNoite(cursor.getString(cursor.getColumnIndex(Professor.DIASNOITE)));
                cursor.getString(1);
                adpProfessor.add(professor);

            }while(cursor.moveToNext());
        }
        return adpProfessor;
    }
}
