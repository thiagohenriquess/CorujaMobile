package br.com.faeterj.corujamobile.historico.Repository;

/**
 * Created by Felipe on 07/06/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.faeterj.corujamobile.historico.database.ScriptSQL;
import br.com.faeterj.corujamobile.historico.Model.Historico;

/**
 * Created by Felipe on 29/05/2016.
 */
public class HistRepository {

    private SQLiteDatabase conn;

    public HistRepository(SQLiteDatabase conn) {
        this.conn = conn;
    }

    public ArrayAdapter<Historico> ObterTodosHist(Context context) {
        ArrayAdapter<Historico> todosHist = new ArrayAdapter<Historico>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.rawQuery("SELECT * FROM HISTORICO", null);

        if(cursor.getCount()< 1){

            cursor.moveToFirst();

            do{

                todosHist.add(CreateHist(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));

            }while(cursor.moveToNext());

        }
        else{
            cursor.moveToFirst();

            do{

                todosHist.add(CreateHist(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));

            }while(cursor.moveToNext());
        }
        return todosHist;
    }

    private Historico CreateHist(String periodo, String disc, String media, String falta, String situacao) {
        Historico hist = new Historico();
        hist.setPeriodo(periodo);
        hist.setDisc(disc);
        hist.setMedia(media);
        hist.setFalta(falta);
        hist.setSituacao(situacao);

        return hist;
    }
}