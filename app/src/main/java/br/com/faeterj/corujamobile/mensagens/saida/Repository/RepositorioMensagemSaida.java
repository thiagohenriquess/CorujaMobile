package br.com.faeterj.corujamobile.mensagens.saida.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.faeterj.corujamobile.mensagens.saida.Model.MensagemSaida;


/**
 * Created by Willian on 02/06/2016.
 */
public class RepositorioMensagemSaida {
    private SQLiteDatabase conn;
    public RepositorioMensagemSaida(SQLiteDatabase conn)
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
            values.put("TITULO","Entrega do trabalho de AV2");
            values.put("MENSAGEM","Olá alunos, segue em anexo as orientações para realização do trabalho");
            values.put("REMETENTE", "teste@gmail.com");
            conn.insertOrThrow("MENSAGEM_SAIDA", null, values);
        }

        for (int i =0 ; i<2 ; i++)
        {
            ContentValues values = new ContentValues();
            values.put("TITULO","Ausência");
            values.put("MENSAGEM","Olá alunos, informamos que o professor x não comparecerá a FATERJ hoje pela noite");
            values.put("REMETENTE", "teste@gmail.com");
            conn.insertOrThrow("MENSAGEM_SAIDA", null, values);
        }

        for (int i =0 ; i<2 ; i++)
        {
            ContentValues values = new ContentValues();
            values.put("TITULO","Semana Tecnológica");
            values.put("MENSAGEM","Olá alunos, lembramos que no dia 03/06 daremos início a mais uma semana tecnológica");
            values.put("REMETENTE", "teste@gmail.com");
            conn.insertOrThrow("MENSAGEM_SAIDA", null, values);
        }
    }

    public ArrayAdapter<MensagemSaida> buscaMensagensSaida(Context context)
    {
        ArrayAdapter<MensagemSaida>  adpMensagemSaida = new ArrayAdapter<MensagemSaida>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("MENSAGEM_SAIDA", null,null,null,null,null,null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
                MensagemSaida mensagemSaida = new MensagemSaida();
                mensagemSaida.setTitulo(cursor.getString(1));
                mensagemSaida.setMensagem(cursor.getString(2));
                mensagemSaida.setRemetente(cursor.getString(3));

                adpMensagemSaida.add(mensagemSaida);
            }while (cursor.moveToNext());

        }
        return adpMensagemSaida;
    }

    public MensagemSaida getItemIdByPosition(int position) {

        MensagemSaida mensagemSaida = new MensagemSaida();
        int _id = getItemId(position);
        Cursor localCursor = conn.rawQuery("select * from " + "MENSAGEM_SAIDA " + "WHERE _id = " + _id,
                null);
        //int i = localCursor.getColumnIndex("ID");
        if (localCursor.moveToFirst()) {

         //   do {

                mensagemSaida.setTitulo(localCursor.getString(1));
                mensagemSaida.setMensagem(localCursor.getString(2));
                mensagemSaida.setRemetente(localCursor.getString(3));
                //itemID = Integer.parseInt(localCursor.getString(i));
            //} while (localCursor.moveToPosition(position));
        }
        localCursor.close();
        return mensagemSaida;
    }

    private int getItemId(int position) {

        int itemID = 0;
        Cursor localCursor = conn.rawQuery("select * from " + "MENSAGEM_SAIDA",
                null);
        int i = localCursor.getColumnIndex("_id");
        if (localCursor.moveToFirst()) {

            localCursor.moveToPosition(position);
            itemID = Integer.parseInt(localCursor.getString(i));
           // } while (localCursor.moveToPosition(position));
        }
        localCursor.close();
        return itemID;
    }
}
