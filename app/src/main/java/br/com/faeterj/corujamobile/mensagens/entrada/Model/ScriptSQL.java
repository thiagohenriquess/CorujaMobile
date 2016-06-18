    package br.com.faeterj.corujamobile.mensagens.entrada.Model;

/**
 * Created by thiago on 04/06/16.
 */

public class ScriptSQL {

    public static String getCreatePerfil(){

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE perfil ( ");
        sqlBuilder.append("_id       INTEGER        NOT NULL ");
        sqlBuilder.append("                         PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("nome      VARCHAR(30)    NOT NULL, ");
        sqlBuilder.append("matricula int            NOT NULL, ");
        sqlBuilder.append("img       int); ");

        return sqlBuilder.toString();
    }

    public static String getCreateMensagem(){

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS mensagem( ");
        sqlBuilder.append("_id          INTEGER         NOT NULL ");
        sqlBuilder.append("                             PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("titulo       VARCHAR(20)     NOT NULL, ");
        sqlBuilder.append("conteudo     VARCHAR(120)    NOT NULL, ");
        sqlBuilder.append("id_remetente INTEGER         ); ");

        //sqlBuilder.append("FOREIGN KEY(id_remetente) REFERENCES perfil(_id)); ");

        return sqlBuilder.toString();
    }


}

