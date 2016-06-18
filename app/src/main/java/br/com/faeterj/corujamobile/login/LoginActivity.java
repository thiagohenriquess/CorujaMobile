package br.com.faeterj.corujamobile.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.login.modelo.Aluno;
import br.com.faeterj.corujamobile.login.modelo.LoginHelper;

public class LoginActivity extends AppCompatActivity {

    private LoginHelper helper;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //CLASSE PARA TRANSFORMAR AS INFORMAÇÕES DO CONTEXT EM OBJETO ALUNO
        helper = new LoginHelper(LoginActivity.this);
        aluno = helper.pegaAluno();

       new EnviaAlunoTask(this).execute(aluno);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
