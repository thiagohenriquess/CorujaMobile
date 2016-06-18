package br.com.faeterj.corujamobile.mensagens.entrada.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.faeterj.corujamobile.mensagens.entrada.Model.Mensagem;
import br.com.faeterj.corujamobile.mensagens.entrada.Model.Perfil;
import br.com.faeterj.corujamobile.mensagens.entrada.Model.ScriptSQL;
import br.com.faeterj.corujamobile.R;

/**
 * Created by thiago on 04/06/16.
 */
public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context)
    {
        super(context, "FaeterjAPP", null, 1);
    }

    private SQLiteDatabase conn;
    PerfilRepository perfilRepository = new PerfilRepository(conn);
    MensagemRepository mensagemRepository = new MensagemRepository(conn);

    Perfil professor = new Perfil();
    Perfil professor1 = new Perfil("Professora", R.drawable.professora);
    Perfil professor2 = new Perfil("Professor Raimundo", R.drawable.professor_raimundo);
    Perfil professor3 = new Perfil("Bill Gates", R.drawable.billgates);
    Perfil professor4 = new Perfil("Ada Lovelace", R.drawable.ada_lovelace);
    Perfil equipe = new Perfil("Equipe FaterjApp", R.drawable.equipe);

    String mensagem2 = "O sucesso é um péssimo professor. Seduz pessoas inteligentes a pensarem quem não podem perder.";
    String mensagem3= "A luz acabou! Não teremos aula hoje";

    Mensagem ms1 = criarMensagem("Reposição","marcada para segunda de 17:00 ás 18:20. Obrigada!",professor1);
    Mensagem ms2 = criarMensagem("Reposição","marcada para segunda de 17:00 ás 18:20. Obrigada!",professor1);
    Mensagem ms3 = criarMensagem("Prova de Algoritmos","Prova sem consulta valendo 8 pontos",professor4);
    Mensagem ms4 = criarMensagem("Atenção",mensagem3,equipe);
    Mensagem ms5 = criarMensagem("Reposição","marcada para segunda de 17:00 ás 18:20. Obrigada!",professor);
    Mensagem ms6 = criarMensagem("Reposição","marcada para segunda de 17:00 ás 18:20. Obrigada!",professor);
    Mensagem ms7 = criarMensagem("Notas Lançadas","Prezados alunos, as notas foram lançadas!! Todos com um 0 bem redondo!",professor2);
    Mensagem ms8 = criarMensagem("Sobre o Sucesso",mensagem2,professor3);
    Mensagem ms9 = criarMensagem("Proxíma Sexta","Não haverá aula",professor1);
    Mensagem ms10 = criarMensagem("Bem vindo","Seja bem vindo ao nosso aplicativo, faça bom uso!Caso note algum problema contate o estagiário",equipe);

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptSQL.getCreatePerfil());
        db.execSQL(ScriptSQL.getCreateMensagem());
        adicionaContatoMensagem();



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void adicionaContatoMensagem() {

        try {
            perfilRepository.inserirPerfil(professor);
            perfilRepository.inserirPerfil(professor1);
            ;
            perfilRepository.inserirPerfil(professor2);
            perfilRepository.inserirPerfil(professor3);
            perfilRepository.inserirPerfil(professor4);
            mensagemRepository.inserirMensagem(ms1);
            mensagemRepository.inserirMensagem(ms2);
            mensagemRepository.inserirMensagem(ms3);
            mensagemRepository.inserirMensagem(ms4);
            mensagemRepository.inserirMensagem(ms5);
            mensagemRepository.inserirMensagem(ms6);
            mensagemRepository.inserirMensagem(ms7);
            mensagemRepository.inserirMensagem(ms8);
            mensagemRepository.inserirMensagem(ms9);
            mensagemRepository.inserirMensagem(ms10);

        } catch (Exception e) {

        }



    }
    public List<Mensagem> buscaLista(){
        List<Mensagem> listMensagens = new ArrayList<Mensagem>();
        listMensagens.add(ms1);
        listMensagens.add(ms2);
        listMensagens.add(ms3);
        listMensagens.add(ms4);
        listMensagens.add(ms5);
        listMensagens.add(ms6);
        listMensagens.add(ms7);
        listMensagens.add(ms8);
        listMensagens.add(ms9);
        listMensagens.add(ms10);

        return listMensagens;
    }

    private Mensagem criarMensagem(String titulo, String conteudo, Perfil remetente){
        Mensagem mensagem = new Mensagem(titulo,conteudo,remetente);
        return mensagem;
    }


}

