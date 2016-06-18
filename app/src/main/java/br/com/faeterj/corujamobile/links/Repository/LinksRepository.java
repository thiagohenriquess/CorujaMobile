package br.com.faeterj.corujamobile.links.Repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.faeterj.corujamobile.links.Model.Link;

/**
 * Created by Felipe on 29/05/2016.
 */
public class LinksRepository {

    private SQLiteDatabase conn;

    public LinksRepository(SQLiteDatabase conn) {
        this.conn = conn;
    }

    public ArrayAdapter<Link> ObterTodosLinks(Context context) {
        ArrayAdapter<Link> todosLinks = new ArrayAdapter<Link>(context, android.R.layout.simple_list_item_1);

        //Cursor cursor = conn.query("LINK", null, null, null, null, null, null);
        Cursor cursor = conn.rawQuery("SELECT * FROM LINK", null);

        if(cursor.getCount()>0){

            cursor.moveToFirst();

            do{

                todosLinks.add(CreateLink(cursor.getString(1), cursor.getString(2)));

            }while(cursor.moveToNext());

        }

        return todosLinks;
    }

    private Link CreateLink(String desc, String url) {
        Link link = new Link();
        link.setDesc(desc);
        link.setUrl(url);

        return link;
    }
}
