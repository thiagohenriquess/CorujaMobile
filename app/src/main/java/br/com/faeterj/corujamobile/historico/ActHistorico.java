package br.com.faeterj.corujamobile.historico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.view.*;
import android.widget.*;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.Controller.HistController;
import br.com.faeterj.corujamobile.historico.Model.Historico;
import br.com.faeterj.corujamobile.historico.database.DB;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;
import br.com.faeterj.corujamobile.professores.ActProfessor;

import android.database.*;

public class ActHistorico extends AppCompatActivity {

    private GridView gvHist;
    private ArrayAdapter<Historico> adpHist;
    private HistController histController;

    private DB banco;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_historico);

        histController = new HistController();

        //CRIAÇÃO DO BANCO
        try {
            banco = new DB(this);
            conn = banco.getWritableDatabase();

            adpHist = histController.ObterTodosHist(this, conn);

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro na criação do banco: " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

        //RECUPERA O GRIDVIEW
        gvHist = (GridView)findViewById(R.id.gvHist);

        //VINCULA O LISTVIEW AO ADAPTER CORRESPONDENTE
        gvHist.setAdapter(adpHist);

        //SETA O CLIQUE NO ITEM PARA REALIZAR ALGUMA AÇÃO
        gvHist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    default:
                        Toast.makeText(getApplicationContext(),"Clicável", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_navegacao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it;
        switch (item.getItemId())
        {
            case R.id.mni_acao1:
                it = new Intent(this, ActNotaFalta.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao2:
                it = new Intent(this, GradeExtra.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao3:
                it = new Intent(this, mensagens.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao4:
                it = new Intent(this, ActHistorico.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao5:
                it = new Intent(this, ActProfessor.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao6:
                it = new Intent(this, ActLink.class);
                startActivity(it);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
