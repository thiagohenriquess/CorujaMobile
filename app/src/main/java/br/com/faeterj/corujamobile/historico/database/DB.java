package br.com.faeterj.corujamobile.historico.database;

/**
 * Created by Felipe on 07/06/2016.
 */
import android.content.Context;
import android.database.sqlite.*;

public class DB extends SQLiteOpenHelper{

    //METODO DE CRIAÇÃO DO BANCO
    public DB(Context context) {

        super(context, "BDHistorico", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //EXECUTA O SQL QUE CRIA A TABELA HISTORICO
        db.execSQL(ScriptSQL.getCreateHist());

        //EXECUTA O SQL QUE POPULA A TABELA HISTORICO
        db.execSQL(ScriptSQL.getSQL());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
