package br.com.faeterj.corujamobile.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import br.com.faeterj.corujamobile.InicioActivity;
import br.com.faeterj.corujamobile.login.convert.AlunoConverter;
import br.com.faeterj.corujamobile.login.modelo.Aluno;
import br.com.faeterj.corujamobile.login.modelo.AlunoDAO;

/**
 * Created by AndreLuiz on 13/06/2016.
 */
public class EnviaAlunoTask extends AsyncTask<Aluno,Object,String> {
    private final Context context;
    private ProgressDialog dialog;
    private Aluno aluno;

    public EnviaAlunoTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context,"Aguarde","Confirmando Login", true,true);
    }

    @Override
    protected String doInBackground(Aluno... params) {

        aluno=params[0];

        //CLASSE PARA CONVERTER INFORMAÇÕS PARA JSON
        AlunoConverter converter = new AlunoConverter();
        String jason = converter.converterParaJason(aluno);

        //CHAMA WEBCLIENT PARA IR AO WS COM AS INFORMAÇÕES DO ALUNO
        WebClient webClient = new WebClient();

        //RECEBE UMA RESPOSTA
        //SE O ALUNO EXISTE E A SENHA CONFERE , RESPOSTA = 1
        //SE NÃO RESPOSTA = 0
        String resposta = webClient.post(jason);

        //CONFERE SE O ALUNO EXISTE NO BANCO
        if (resposta.equals("1")) {
            AlunoDAO dao = new AlunoDAO(context);
            aluno.setLogado(1);
            dao.inserir(aluno);
            Intent intent = new Intent(context, InicioActivity.class);
        }else {
            Intent intent = new Intent(context, InicioActivity.class);
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        dialog.dismiss();
        if(aluno.getLogado()==1)
            Toast.makeText(context,"Aluno Logado",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context,"Falha no login",Toast.LENGTH_SHORT).show();
    }
}
