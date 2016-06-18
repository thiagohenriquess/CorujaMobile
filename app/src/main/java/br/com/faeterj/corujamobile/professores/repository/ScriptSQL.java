package br.com.faeterj.corujamobile.professores.repository;

/**
 * Created by pc 2015 on 04/06/2016.
 */
public class ScriptSQL {
    public static String getCreateProfessor(){

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS PROFESSOR ( ");
        sqlBuilder.append(" _id       INTEGER      NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOME             VARCHAR (50), ");
        sqlBuilder.append("EMAIL            VARCHAR (50), ");
        sqlBuilder.append("MATERIAS         VARCHAR (50), ");
        sqlBuilder.append("DIASMANHA        VARCHAR (50), ");
        sqlBuilder.append("DIASNOITE        VARCHAR (50)); ");
        sqlBuilder.append("); ");

        return sqlBuilder.toString();
    }
}
