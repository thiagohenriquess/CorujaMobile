package br.com.faeterj.corujamobile.grade.Data;

/**
 * Created by Willian on 02/06/2016.
 */
import android.content.Context;
import android.database.sqlite.*;

public class DataBase extends SQLiteOpenHelper{
    public DataBase(Context context)
    {
        super(context,"APPFAETERJ",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptSQL.getCreateMensagemSaida());
        db.execSQL(ScriptSQL.getCreateGrade());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}