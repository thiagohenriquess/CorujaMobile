package br.com.faeterj.corujamobile.links.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.faeterj.corujamobile.links.Model.Link;
import br.com.faeterj.corujamobile.links.Repository.LinksRepository;

/**
 * Created by Felipe on 29/05/2016.
 */
public class LinksController {

    public ArrayAdapter<Link> ObterTodosLinks(Context context, SQLiteDatabase conn) {
        ArrayAdapter<Link> todosLinks = new LinksRepository(conn).ObterTodosLinks(context);

        return todosLinks;
    }
}