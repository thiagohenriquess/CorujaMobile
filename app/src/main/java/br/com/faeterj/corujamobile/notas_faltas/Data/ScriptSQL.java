package br.com.faeterj.corujamobile.notas_faltas.Data;

/**
 * Created by Danilo on 14/06/2016.
 */
public class ScriptSQL {

    public static String createTableAlunoTurma(){

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS alunoTurma( ");
        sqlBuilder.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("av1 DOUBLE, ");
        sqlBuilder.append("av2 DOUBLE, ");
        sqlBuilder.append("avs DOUBLE, ");
        sqlBuilder.append("avf DOUBLE, ");
        sqlBuilder.append("faltas INTEGER, ");
        sqlBuilder.append("status VARCHAR(10), ");
        sqlBuilder.append ("nomeAluno VARCHAR(25), ");//verificar como pegar o nome pela chave estrangeira
        sqlBuilder.append ("nomeDisciplina VARCHAR(15) ");//verificar como pegar o nome pela chave estrangeira

        sqlBuilder.append("); ");

        return sqlBuilder.toString();
    }

    public static String CreateTableAluno(){

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS aluno( ");
        sqlBuilder.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("nome VARCHAR(20), ");
        sqlBuilder.append("matricula INTEGER ");
        sqlBuilder.append("); ");

        return sqlBuilder.toString();
    }

    public static String CreateTableDisciplina(){

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS disicplina( ");
        sqlBuilder.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("nome VARCHAR(20) ");
        sqlBuilder.append("); ");

        return sqlBuilder.toString();
    }

    public static String CreateTableTurma(){



        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS turma( ");
        sqlBuilder.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("horario VARCHAR(10), "); //resolver como colocar como DATE
        sqlBuilder.append("turno VARCHAR(10), ");
        sqlBuilder.append("ano INTEGER, ");
        sqlBuilder.append("semestre INTEGER ");

        sqlBuilder.append("); ");

        return sqlBuilder.toString();
    }
}
