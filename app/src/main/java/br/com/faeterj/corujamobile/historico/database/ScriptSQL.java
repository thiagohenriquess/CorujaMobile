package br.com.faeterj.corujamobile.historico.database;

/**
 * Created by Felipe on 07/06/2016.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.net.ContentHandler;

public class ScriptSQL {

    public static String SQL = "INSERT INTO  HISTORICO(PERIODO, DISC, MEDIA, FALTA, SITUACAO) VALUES " +
            "('1°', 'AL1', '4.0', '0', 'RM')," +
            "('1°', 'AC1', '8.0', '3', 'AP')," +
            "('1°', 'ADM', '9.0', '6', 'AP')," +
            "('1°', 'ME1', '7.5', '8', 'AP')," +
            "('1°', 'MAT', '7.0', '0', 'AP')," +
            "('2°', 'AL1', '7.0', '0', 'AP')," +
            "('2°', 'RD1', '8.0', '0', 'AP')," +
            "('2°', 'SOP', '7.7', '0', 'AP')," +
            "('2°', 'AC2', '8.4', '0', 'AP')," +
            "('3°', 'AL2', '7.9', '0', 'AP')," +
            "('3°', 'RD2', '6.0', '0', 'AP')," +
            "('3°', 'OO1', '6.7', '0', 'AP')," +
            "('3°', 'INT', '9.0', '0', 'AP');";

    public static String getSQL(){return SQL; }

    public static String getCreateHist(){

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS HISTORICO( ");
        sqlBuilder.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("PERIODO VARCHAR(2), ");
        sqlBuilder.append("DISC VARCHAR(3), ");
        sqlBuilder.append("MEDIA VARCHAR(4), ");
        sqlBuilder.append("FALTA VARCHAR(2), ");
        sqlBuilder.append("SITUACAO VARCHAR(2) ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();


    }
}
