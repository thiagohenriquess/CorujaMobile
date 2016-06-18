
package br.com.faeterj.corujamobile.mensagens.entrada.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.faeterj.corujamobile.mensagens.entrada.Model.Mensagem;


/**
 * Created by thiago on 04/06/16.
 */

public class MensagemRepository {

    private SQLiteDatabase conn;

    public MensagemRepository(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void inserirMensagem(Mensagem mensagem){

        ContentValues values= new ContentValues();


        values.put("titulo", mensagem.getTitulo());
        //values.put("id_remetente", R.drawable.professora);
        values.put("conteudo", mensagem.getConteudo());
        values.put("id_remetente", mensagem.getRemetente().getNome());

        conn.insertOrThrow("mensagem", null, values);

    }


    public ArrayAdapter<String> buscaMensagem(Context context){

        ArrayAdapter<String> adapterMensagem = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1);
        Mensagem mensagem;

        Cursor cursor = conn.query("mensagem", null, null, null, null, null, null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                String titulo = cursor.getString(1);
                String conteudo = cursor.getString(2);
                String remetente = cursor.getString(3);

                mensagem = new Mensagem(titulo,conteudo);

                adapterMensagem.add(remetente);
            }while(cursor.moveToNext());
        }


        return adapterMensagem;
    }

    public List<Mensagem> buscaMensagemTodas(){

        List<Mensagem> mensagemArrayList = new ArrayList<>();
        Mensagem mensagem;

        mensagem = new Mensagem();


        mensagemArrayList.add(mensagem);


        Cursor cursor = conn.query("mensagem", null, null, null, null, null, null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                String conteudo = cursor.getString(1);
                String titulo = cursor.getString(2);
                String remetente = cursor.getString(3);

                mensagem = new Mensagem(titulo,conteudo);

                mensagemArrayList.add(mensagem);
            }while(cursor.moveToNext());
        }


        return mensagemArrayList;
    }

    //So como teste estou passando a String mas futuro é adaptar o arrayadapter aqui
    //Passa o remetene e pega o conteudo da mensagem
    public ArrayAdapter<String> buscaMensagem(Context context,String rem){

        ArrayAdapter<String> adapterMensagem = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1);
        Mensagem mensagem;
        //campos a serem visto, nao funcionou
        String[] campos = {"titulo"};
        //where seleionado
        String where = "id_remetente = '" + rem + "'";

        Cursor cursor = conn.query("mensagem", null, where, null, null, null, null);

        if(cursor!=null && cursor.getCount() > 0){


            cursor.moveToFirst();

            do {
                String titulo = cursor.getString(1);
                String conteudo = cursor.getString(2);
                String remetente = cursor.getString(3);

                //mensagem = new Mensagem(titulo,conteudo);

                adapterMensagem.add(conteudo);
            }while(cursor.moveToNext());
        }


        return adapterMensagem;
    }

}

