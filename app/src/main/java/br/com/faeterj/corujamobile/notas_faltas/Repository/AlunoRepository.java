package br.com.faeterj.corujamobile.notas_faltas.Repository;

/**
 * Created by Danilo on 10/06/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;


import br.com.faeterj.corujamobile.notas_faltas.Model.Aluno;

public class AlunoRepository {

    private SQLiteDatabase conn;

    public AlunoRepository (SQLiteDatabase conn){

        this.conn = conn;

    }

   public ArrayAdapter<String> buscaDados(Context context){

        ArrayAdapter<String> adpAlunos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

       //Aemazena os registros da consulta

       return adpAlunos;

   }







    public void insertAlunoRepository (Aluno aluno){

        ContentValues valores = new ContentValues();
        valores.put("nome", aluno.getNome());
        valores.put("matricula", aluno.getMatricula());

        this.conn.insert("aluno",null,valores);
    }

}
