package br.com.faeterj.corujamobile.login.convert;

import br.com.faeterj.corujamobile.login.modelo.Aluno;

import org.json.JSONException;
import org.json.JSONStringer;

/**
 * Created by AndreLuiz on 12/06/2016.
 */
public class AlunoConverter {

    public String converterParaJason(Aluno aluno) {

        //MONTAR O JASON PARA IR PARA WS

        JSONStringer js = new JSONStringer();

        //object() = {
        //key() = o nome da chave
        //array() = [


        //cabeçalho
        try {
            js.object().key("list").array().object().key("aluno").array();
            js.object();
            js.key("matricula").value(aluno.getMatricula());
            js.key("senha").value(aluno.getSenha());

            js.endObject();

            js.endArray().endObject().endArray().endObject();

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
