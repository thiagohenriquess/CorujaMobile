package br.com.faeterj.corujamobile.links.database;

import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by Felipe on 01/06/2016.
 */
public class DB extends SQLiteOpenHelper{

    //METODO DE CRIAÇÃO DO BANCO
    public DB(Context context) {

        super(context, "BDLinks", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //EXECUTA O SQL QUE CRIA A TABELA LINK
        db.execSQL(ScriptSQL.getCreateLink());

        //EXECUTA O SQL QUE POPULA A TABELA LINK
        db.execSQL(ScriptSQL.getSQL());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
