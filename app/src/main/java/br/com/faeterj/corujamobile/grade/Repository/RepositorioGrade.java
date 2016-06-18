package br.com.faeterj.corujamobile.grade.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.faeterj.corujamobile.grade.Model.Grade;


/**
 * Created by Willian on 02/06/2016.
 */
public class RepositorioGrade {

    private SQLiteDatabase conn;
    public RepositorioGrade(SQLiteDatabase conn)
    {
        this.conn = conn;
    }

    /*public void Inserir (MensagemSaida mensagemSaida)
    {
        ContentValues values = new ContentValues();
        values.put("TITULO",mensagemSaida.getTitulo());
        values.put("MENSAGEM",mensagemSaida.getMensagem());
        values.put("REMETENTE", mensagemSaida.getRemetente());

        conn.insertOrThrow("MENSAGEM_SAIDA", null, values);
    }*/
    public  void testeInserirMensagens()
    {
        for (int i =0 ; i<2 ; i++)
        {
            ContentValues values = new ContentValues();
            values.put("SIGLA","OO2");
            values.put("NOME","Orientação a objjeto 2");
            values.put("HORA_INICIAL", "18:00");
            values.put("HORA_FINAL", "22:10");
            values.put("DIA_SEMANA", "Segunda - Feira");
            conn.insertOrThrow("GRADE", null, values);
        }

        for (int i =0 ; i<2 ; i++)
        {
            ContentValues values = new ContentValues();
            values.put("SIGLA","ME2");
            values.put("NOME","Metodologia de pesquisa 2");
            values.put("HORA_INICIAL", "19:20");
            values.put("HORA_FINAL", "20:40");
            values.put("DIA_SEMANA", "Quinta - Feira");
            conn.insertOrThrow("GRADE", null, values);
        }

        for (int i =0 ; i<2 ; i++)
        {
            ContentValues values = new ContentValues();
            values.put("SIGLA","PSW");
            values.put("NOME","Não sei o nome");
            values.put("HORA_INICIAL", "19:20");
            values.put("HORA_FINAL", "21:30");
            values.put("DIA_SEMANA", "Sexta - Feira");
            conn.insertOrThrow("GRADE", null, values);
        }
    }

    public ArrayAdapter<Grade> buscaGrade(Context context)
    {
        ArrayAdapter<Grade>  adpGrade = new ArrayAdapter<Grade>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("GRADE", null,null,null,null,null,null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                Grade grade = new Grade();
                grade.setSigla(cursor.getString(1));
                grade.setNome(cursor.getString(2));
                grade.setHoraInicial(cursor.getString(3));
                grade.setHoraFinal(cursor.getString(4));
                grade.setDiaSemana(cursor.getString(5));

                adpGrade.add(grade);
            }while (cursor.moveToNext());

        }
        adpGrade.notifyDataSetChanged();
        return adpGrade;
    }
}
