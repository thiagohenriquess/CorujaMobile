package br.com.faeterj.corujamobile.notas_faltas.Repository;


/**
 * Created by Danilo on 10/06/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;


public class AlunoTurmaRepository {

    private SQLiteDatabase conn;

    public AlunoTurmaRepository (SQLiteDatabase conn){

        this.conn = conn;

    }



    public  void testeInserirAlunoTurma() {
        for (int i =0 ; i<2 ; i++) {
            // if (i == 1){
            ContentValues values = new ContentValues();
            values.put("av1", 8);
            values.put("av2", 10);
            values.put("avs", 0);
            values.put("avf", 0);
            ;
            values.put("faltas", 6);
            values.put("status", "Aprovado");
            values.put("nomeAluno", "Maria");
            values.put("nomeDisciplina", "PSW");
            conn.insertOrThrow("alunoTurma", null, values);
        }
        for (int i = 0; i<2; i++){

          //  }else{
            ContentValues values = new ContentValues();
            values.put("av1", 5);
            values.put("av2", 5);
            values.put("avs", 0);
            values.put("avf", 4);;
            values.put("faltas", 1);
            values.put("status", "Reprovado");
            values.put("nomeAluno", "Maria");
            values.put("nomeDisciplina", "OO2");
            conn.insertOrThrow("alunoTurma", null, values);
        }

    }





    public ArrayAdapter<String> buscaDadosAlunoTurma(Context context){

        ArrayAdapter<String> adpAlunoTurma = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("alunoTurma", null, null, null, null, null, null);

        if (cursor.getColumnCount() > 0){

            cursor.moveToFirst();
            do{
                String nomeDisciplina = cursor.getString(8);
                String notaAv1 = cursor.getString(1);
                String notaAv2 = cursor.getString(2);
                String faltas = cursor.getString(5);
                String status = cursor.getString(6);
                adpAlunoTurma.add(nomeDisciplina + "\nAV1: " + notaAv1 + " / AV2:  " + notaAv2 +
                        "\nTotal de faltas: " + faltas + "\nSituação: " + status);
            }while (cursor.moveToNext());

        }
        return adpAlunoTurma;
    }

    public String getNomeAlunoTurma(){


        Cursor cursor = conn.query("alunoTurma", null, null, null, null, null, null);
        cursor.moveToFirst();
        String nomeAluno = cursor.getString(7);

        return nomeAluno;
    }





//inserindo na tabela com passagem do Objeto por parâmetro
//    public void insertAlunoTurmaRepository (AlunoTurma alunoTurma){
//
//        ContentValues valores = new ContentValues();
//
//        valores.put("av1", alunoTurma.getAv1());
//        valores.put("av2", alunoTurma.getAv2());
//        valores.put("avs", alunoTurma.getAvS());
//        valores.put("avf", alunoTurma.getAvF());
//        valores.put("faltas", alunoTurma.getFaltas());
//        valores.put("status", alunoTurma.getStatus());
//
//
//        this.conn.insert("alunoTurma",null,valores);
//    }


}
