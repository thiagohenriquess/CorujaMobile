package br.com.faeterj.corujamobile.mensagens.saida;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.mensagens.saida.Data.DataBase;
import br.com.faeterj.corujamobile.mensagens.saida.Model.MensagemSaida;
import br.com.faeterj.corujamobile.mensagens.saida.Repository.RepositorioMensagemSaida;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;
import br.com.faeterj.corujamobile.professores.ActProfessor;

public class ConteudoMensagemSaida extends AppCompatActivity {
    private MensagemSaida mensagemSaida;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioMensagemSaida repositorioMensagemSaida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo_mensagem_saida);

        try
        {
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioMensagemSaida = new RepositorioMensagemSaida(conn);
            Intent intent = getIntent();

            Bundle params = intent.getExtras();
           // int position ;
            if(params!=null)
            {
                mensagemSaida = new MensagemSaida();
                //position = params.getInt("position");
                mensagemSaida.setTitulo(params.getString("SaidaTitulo"));// = repositorioMensagemSaida.getItemIdByPosition(position);
                mensagemSaida.setMensagem(params.getString("SaidaMensagem"));
            }
            //repositorioMensagemSaida.testeInserirMensagens();

            //lstMensagemSaida.setAdapter(adpMensagemSaida);

            /*AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso!");
            dlg.setNeutralButton("Ok", null);
            dlg.show();*/
        }
        catch (SQLException ex)
        {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Error!" + ex.getMessage());
            dlg.setNeutralButton("Ok", null);
            dlg.show();
        }

        LinearLayout li = new LinearLayout(this);
        li.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        li.setLayoutParams(lp);

        LinearLayout lh = new LinearLayout(this);
        lh.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams lph = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
        //lh.setLayoutParams(lph);
        //lph.width = 2;

        li.addView(lh);

        LinearLayout lv = new LinearLayout(this);
        lv.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lpv = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
       // lpv.width = 1;
        //lv.setLayoutParams(lpv);
        li.addView(lv);

        TextView t = new TextView(this);
        t.setText(mensagemSaida.getTitulo());
        LinearLayout.LayoutParams tbox = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        t.setLayoutParams(tbox);
        lh.addView(t);

        TextView tv = new TextView(this);
        tv.setText(mensagemSaida.getMensagem());
        LinearLayout.LayoutParams tbox1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        tv.setLayoutParams(tbox1);
        lv.addView(tv);

        setContentView(li);
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
