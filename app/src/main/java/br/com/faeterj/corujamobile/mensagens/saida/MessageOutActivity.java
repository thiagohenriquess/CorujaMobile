package br.com.faeterj.corujamobile.mensagens.saida;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
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


public class MessageOutActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnAdicionar;
    private EditText edtPesquisaMensagem;
    private ListView lstMensagemSaida;
    private ArrayAdapter<MensagemSaida> adpMensagemSaida;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioMensagemSaida repositorioMensagemSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_out);

        btnAdicionar = (ImageButton) findViewById(R.id.btnAdicionar);
        edtPesquisaMensagem = (EditText) findViewById(R.id.edtPesquisaMensagem);
        lstMensagemSaida = (ListView) findViewById(R.id.lstMensagemSaida);

        lstMensagemSaida.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Bundle params = new Bundle();
                Intent appInfo = new Intent(MessageOutActivity.this, ConteudoMensagemSaida.class);
                MensagemSaida mensagemSaida = (MensagemSaida) adapter.getItemAtPosition(position);
                //ArrayList<MensagemSaida> mensagem = new ArrayList<MensagemSaida>();
               // mensagem.
                //long _id = ((ListView) view.findViewById(R.id.polstMensagemSaida.getSelectedItemId();
                params.putString("SaidaTitulo", mensagemSaida.getTitulo());
                params.putString("SaidaMensagem", mensagemSaida.getMensagem());
                appInfo.putExtras(params);
                startActivity(appInfo);

            }
        });

        try
        {
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioMensagemSaida = new RepositorioMensagemSaida(conn);
            repositorioMensagemSaida.testeInserirMensagens();
            adpMensagemSaida = repositorioMensagemSaida.buscaMensagensSaida(this);
            lstMensagemSaida.setAdapter(adpMensagemSaida);

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

        edtPesquisaMensagem.addTextChangedListener(new TextWatcher() {


        public void afterTextChanged(Editable s) {

        }

        public void beforeTextChanged(CharSequence s,

              int start, int count,

              int after) {

        }

        public void onTextChanged(CharSequence s,

          int start,

          int before, int count) {

          // Aplica o filtro no Adapter
            adpMensagemSaida.getFilter().filter(s.toString());
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

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mensagem = new Intent(this, GradeExtra.class);
        startActivity(mensagem);

        finish();

        return super.onOptionsItemSelected(item);
    }*/
    @Override
    public void onClick(View v) {

        //startActivityForResult(it, 0);
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adpMensagemSaida = repositorioMensagemSaida.buscaMensagensSaida(this);
        lstMensagemSaida.setAdapter(adpMensagemSaida);
    }*/
}
