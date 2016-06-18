
package br.com.faeterj.corujamobile.mensagens.entrada.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.faeterj.corujamobile.mensagens.entrada.Model.Perfil;


/**
 * Created by thiago on 06/06/16.
 */

public class PerfilRepository {
    private SQLiteDatabase conn;

    public PerfilRepository(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void inserirPerfil(Perfil perfil){

        ContentValues values= new ContentValues();

        values.put("nome", perfil.getNome());
        values.put("matricula", "11");
        values.put("img", perfil.getImg());


        conn.insertOrThrow("perfil", null, values);

    }
    public ArrayAdapter<String> buscaPerfil(Context context){

        ArrayAdapter<String> adapterPerfil = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1);
        Perfil perfil;
        Cursor cursor = conn.query("perfil", null, null, null, null, null, null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();


            do {
                String nome = cursor.getString(1);
                //String matricula = cursor.getString(2);
                //String imgS = cursor.getString(3);
                //int img = Integer.parseInt(imgS);

                //perfil = new Perfil(nome);

                adapterPerfil.add(nome);
            }while(cursor.moveToNext());
        }


        return adapterPerfil;
    }
}

