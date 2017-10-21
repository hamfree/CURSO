package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Cliente para probar servicios RESTful
 */
public class MiMainCli_Persona {

    public static void main(String[] args) throws Exception {

          addPersona(1, "pepe", "fdez");
//        buscarPersona(1);
//        buscarTodasPersona();
//        borrarPersona(1);
//        modificarPersona(1, "pepenew", "fdeznew");
//        buscarTodasPersona();
    }

    //    Para incluir un usuario. El Id lo pone el servidor */
    private static void addPersona(int id, String nombre, String apellido) throws Exception {
        System.out.println("metodo add usuario " + id + " " + nombre + " " + apellido);
        URL url = new URL("http://localhost:8080/Ejercicio_Persona_REST/webresources/persona");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setAllowUserInteraction(true);
        con.setDoOutput(true);
        con.setDoInput(true);

        con.connect();
        DataOutputStream writer = new DataOutputStream(con.getOutputStream());
        String cuerpoPost = "id=" + id + "&nombre=" + URLEncoder.encode(nombre, "UTF-8")
                + "&apellido=" + URLEncoder.encode(apellido, "UTF-8");
        System.out.println(cuerpoPost);
        writer.writeBytes(cuerpoPost);

        writer.close();

//        BufferedReader resultado = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String linea = null;
//        while ((linea = resultado.readLine()) != null) {
//            System.out.println(linea);
//        }
//        resultado.close();
        System.out.println("Codigo de respuesta: " + con.getResponseCode());
        System.out.println("Mensaje de respuesta: " + con.getResponseMessage());
        con.disconnect();
    }

    private static void modificarPersona(int id, String nombre, String apellido)
            throws Exception {

        System.out.println("metodo  modificarPersona " + id
                + " " + nombre + " " + apellido);
        URL url = new URL("http://localhost:8080/Ejercicio_Persona_REST/webresources/persona/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty(
                "Content-Type", "application/x-www-form-urlencoded");
        con.setAllowUserInteraction(true);
        con.setDoOutput(true);
        con.setDoInput(true);

        con.connect();

        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());

        String cuerpoPost = "nombre=" + URLEncoder.encode(nombre, "UTF-8")
                + "&" + "apellido=" + URLEncoder.encode(apellido, "UTF-8");
        System.out.println("PUT: " + cuerpoPost);
        writer.write(cuerpoPost);

        writer.close();

        BufferedReader resultado = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String linea = null;
        while ((linea = resultado.readLine()) != null) {
            System.out.println(linea);
        }
        resultado.close();

        con.disconnect();
    }

    private static void borrarPersona(int id)
            throws Exception {

        System.out.println("metodo  borrarPersona " + id);
        URL url = new URL("http://localhost:8080/Ejercicio_Persona_REST/webresources/persona/" + id);
        System.out.println(url.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");

        con.setAllowUserInteraction(true);
        con.setDoOutput(false);
        con.setDoInput(true);

        con.connect();

        System.out.println(con.getResponseCode());

        con.disconnect();
    }

    private static void buscarPersona(int id) throws Exception {
        System.out.println("metodo buscarPersona");
        URL url = new URL("http://localhost:8080/Ejercicio_Persona_REST/webresources/persona/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setAllowUserInteraction(true);
        con.setDoOutput(false);
        con.setDoInput(true);
        con.connect();

        BufferedReader resultado = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String linea = null;
        while ((linea = resultado.readLine()) != null) {
            System.out.println(linea);
        }
        resultado.close();
        con.disconnect();
    }

    private static void buscarTodasPersona() throws Exception {
        System.out.println("metodo buscarPersona");
        URL url = new URL("http://localhost:8080/Ejercicio_Persona_REST/webresources/persona/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setAllowUserInteraction(true);
        con.setDoOutput(false);
        con.setDoInput(true);
        con.connect();

        BufferedReader resultado = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String linea = null;
        while ((linea = resultado.readLine()) != null) {
            System.out.println(linea);
        }
        resultado.close();
        con.disconnect();
    }

}
