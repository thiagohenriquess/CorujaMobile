package br.com.faeterj.corujamobile.grade.Data;

/**
 * Created by Willian on 02/06/2016.
 */
public class ScriptSQL {
    public static String getCreateMensagemSaida()
    {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS MENSAGEM_SAIDA ( ");
        sqlBuilder.append("_id                INTEGER       NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("TITULO          VARCHAR (255), ");
        sqlBuilder.append("MENSAGEM          VARCHAR (255), ");
        sqlBuilder.append("REMETENTE       VARCHAR (255) ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }

    public static String getCreateGrade()
    {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS GRADE ( ");
        sqlBuilder.append("_id                INTEGER       NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("SIGLA          VARCHAR (10), ");
        sqlBuilder.append("NOME          VARCHAR (255), ");
        sqlBuilder.append("HORA_INICIAL       VARCHAR (20), ");
        sqlBuilder.append("HORA_FINAL       VARCHAR (20), ");
        sqlBuilder.append("DIA_SEMANA       VARCHAR (30) ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }
}
