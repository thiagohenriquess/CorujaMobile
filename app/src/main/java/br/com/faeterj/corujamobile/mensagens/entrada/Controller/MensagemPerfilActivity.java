
package br.com.faeterj.corujamobile.mensagens.entrada.Controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.entrada.Repository.DataBase;
import br.com.faeterj.corujamobile.mensagens.entrada.Model.Perfil;
import br.com.faeterj.corujamobile.mensagens.entrada.Repository.MensagemRepository;
import br.com.faeterj.corujamobile.mensagens.entrada.Repository.PerfilRepository;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;
import br.com.faeterj.corujamobile.professores.ActProfessor;

public class MensagemPerfilActivity extends AppCompatActivity {

    EditText edtText;
    ListView listViewMensagensRemetente;

    ArrayAdapter<String> adpPerfil;
    private PerfilRepository repositoryPerfil;

    ArrayAdapter<String> adpMensagem;
    private MensagemRepository repositoryMensagem;

    private DataBase dataBase;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_perfil);

        //Atrelando os dados ao layout
        edtText = (EditText) findViewById(R.id.cxTextoActMensPerfil);

        listViewMensagensRemetente = (ListView) findViewById(R.id.listaMensagensRecebidasRemetente);

        //recuperando o objeto remetente
        Intent intent = getIntent();
        Perfil remetente = (Perfil) intent.getSerializableExtra("remetente");

        //teste só pra ver ser o remtnete realmente veio
        String nome = remetente.getNome();
        edtText.setText(nome);

        try{
            //referenciando a classe do banco criado
            dataBase = new DataBase(this);
            //criando conexao com o banco
            //metodo getReadableDatabase apenas para ver ser o banco
            conn = dataBase.getWritableDatabase();

            repositoryPerfil = new PerfilRepository(conn);
            adpPerfil = repositoryPerfil.buscaPerfil(this);

            repositoryMensagem = new MensagemRepository(conn);

            adpMensagem = repositoryMensagem.buscaMensagem(this,nome);


        }catch(Exception e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexao NÂO FOI feita !!" + e.getMessage());
            dlg.setNeutralButton("OK",null);
            dlg.show();
            edtText.setText(e.getMessage());

        }
        //Essa parte esta funcionando, se uso uma lista ficticia aparece tudo direitinho
        //final ListaAdapterMensagem mensagemAdapter = new ListaAdapterMensagem(this, remetente.getCxSaida());

        //passa pra lista o adapter
        listViewMensagensRemetente.setAdapter(adpMensagem);
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

