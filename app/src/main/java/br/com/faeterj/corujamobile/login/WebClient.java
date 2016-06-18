package br.com.faeterj.corujamobile.login;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by AndreLuiz on 12/06/2016.
 */
public class WebClient {

    public String post(String json){

        try {
            URL url = new URL("127.0.0.1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //Dizer que vai enviar JSON e quer a devoloção em JSON

            connection.setRequestProperty("Content-type","application/json");
            connection.setRequestProperty("Accept","application/json");

            // porque é post
            connection.setDoOutput(true);

            //escrendo a saida

            PrintStream output =  new PrintStream(connection.getOutputStream());

            output.println(json);

            connection.connect();

            Scanner scanner = new Scanner(connection.getInputStream());

            String resposta = scanner.next();

            return resposta;
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
