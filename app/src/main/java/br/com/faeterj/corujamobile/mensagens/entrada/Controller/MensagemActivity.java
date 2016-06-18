package br.com.faeterj.corujamobile.mensagens.entrada.Controller;
//Usando git pela ide

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.entrada.Repository.DataBase;
import br.com.faeterj.corujamobile.mensagens.entrada.Repository.ListaAdapterMensagem;
import br.com.faeterj.corujamobile.mensagens.entrada.Model.Mensagem;
import br.com.faeterj.corujamobile.mensagens.entrada.Repository.MensagemRepository;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;
import br.com.faeterj.corujamobile.professores.ActProfessor;


public class MensagemActivity extends AppCompatActivity {

    //Cria DataBase (interaçao com o sql
    private DataBase dataBase;
    //Cria conexao com banco
    private SQLiteDatabase conn;
    //Cria a listView das mensagens e pega a referencia dela
    ListView listViewMensagens;
    // Lista de mensagem
    List<Mensagem> cxMensagem;
    //Mensagem Repository
    MensagemRepository repositoryMensagem = new MensagemRepository(conn);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        //Testando conexao com o Banco
        try{
            //referenciando a classe do banco criado
            dataBase = new DataBase(this);
            //criando conexao com o banco
            //metodo getReadableDatabase apenas para ver ser o banco
            conn = dataBase.getWritableDatabase();

        }catch(SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexao NÂO FOI feita !!" + ex.getMessage());
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }

        //Referencia dela do layout.xml
        listViewMensagens   = (ListView) findViewById(R.id.listaMensagensRecebidas);

        //criar a list que usaremos para ser a caixa de mensagem
        cxMensagem = dataBase.buscaLista();

        //Criar a ponte dos dados entre o ListView e o List
        //Passa o content que estamos: this
        //Os dados cxMensagem
        //o layout foi criado nessa classe
        final ListaAdapterMensagem mensagemAdapter = new ListaAdapterMensagem(this, cxMensagem);

        //passa pra lista o adapter
        listViewMensagens.setAdapter(mensagemAdapter);

        listViewMensagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position,long id) {
            Mensagem mensagem = mensagemAdapter.getItem(position);

            //Cria o intent para passar o outro activity
            Intent intent;
            intent = new Intent(getApplicationContext() ,MensagemPerfilActivity.class);
            intent.putExtra("remetente", mensagem.getRemetente());

            startActivity(intent);

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
