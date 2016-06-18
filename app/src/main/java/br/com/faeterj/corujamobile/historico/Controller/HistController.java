package br.com.faeterj.corujamobile.historico.Controller;

/**
 * Created by Felipe on 07/06/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.faeterj.corujamobile.historico.Model.Historico;
import br.com.faeterj.corujamobile.historico.Repository.HistRepository;

public class HistController {

    public ArrayAdapter<Historico> ObterTodosHist(Context context, SQLiteDatabase conn) {
        ArrayAdapter<Historico> todosHist = new HistRepository(conn).ObterTodosHist(context);

        return todosHist;
    }
}
