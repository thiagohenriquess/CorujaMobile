package br.com.faeterj.corujamobile.login.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AndreLuiz on 12/06/2016.
 */
public class AlunoDAO extends SQLiteOpenHelper{

    public AlunoDAO(Context context) {
        super(context,"Aluno",null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Aluno(id INTEGER PRIMARY KEY, " +
                        "matricula REAL, "+
                        "senha TEXT," +
                        "logado REAL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Aluno pegaAluno() {

        Aluno aluno= new Aluno();

        String sql = ("SELECT * FROM Aluno WHERE id=0");

        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(sql, null);

        aluno.setLogado(c.getInt(c.getColumnIndex("logado")));
        aluno.setMatricula(c.getLong(c.getColumnIndex("matricula")));
        aluno.setSenha(c.getString(c.getColumnIndex("senha")));

        c.close();
        return aluno;
    }

    public void inserir(Aluno aluno) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaAluno(aluno);

        db.insert("Aluno",null,dados);

    }

    private ContentValues pegaAluno(Aluno aluno) {

        ContentValues dados = new ContentValues();
        dados.put("matricula",aluno.getMatricula());
        dados.put("senha",aluno.getSenha());
        dados.put("logado", 1);
        return dados;
    }
}
