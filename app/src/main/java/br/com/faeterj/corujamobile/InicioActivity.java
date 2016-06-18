package br.com.faeterj.corujamobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

  /*      Aluno aluno = new Aluno();

        AlunoDAO dao = new AlunoDAO(this);

        aluno=dao.pegaAluno();

        if(aluno.getLogado()==0){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{*/
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        //}
    }

}
