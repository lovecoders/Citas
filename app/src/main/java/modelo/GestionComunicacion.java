package modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javabeans.Usuario;


public class GestionComunicacion {
    public void enviarAlta(int telefono, String nick, boolean sexo, int edad) {
        try {
            Socket sc = new Socket("192.168.0.187", 8000); //VERIFICAR IP de la máquina que ejecuta el cliente!!!
            PrintStream salida = new PrintStream(sc.getOutputStream());
            salida.println("0"); //indica al servidor que el JSON que va a recibir es "tipo 0" (JSON de alta)
            JSONObject job = new JSONObject();
            job.put("telefono", telefono);
            job.put("nick", nick);
            job.put("sexo", sexo);
            job.put("edad", edad);
            salida.println(job.toString());
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void enviarAlta(Usuario usuario) {
        try {
            Socket sc = new Socket("192.168.0.187", 8000); //VERIFICAR IP de la máquina que ejecuta el cliente!!!
            PrintStream salida = new PrintStream(sc.getOutputStream());
            salida.println("0"); //indica al servidor que el JSON que va a recibir es "tipo 0" (JSON de alta)
            JSONObject job = new JSONObject();
            job.put("telefono", usuario.getTelefono());
            job.put("nick", usuario.getNick());
            job.put("sexo", usuario.isSexo());
            job.put("edad", usuario.getEdad());
            salida.println(job.toString());
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void enviarPreferencias(int prefsexo, int edadmin, int edadmax, int prefrelacion) {
        try {
            Socket sc = new Socket("192.168.0.187", 8000); //VERIFICAR IP de la máquina que ejecuta el cliente!!!
            PrintStream salida = new PrintStream(sc.getOutputStream());
            salida.println("1"); //indica al servidor que el JSON que va a recibir es "tipo 1" (JSON de preferencias)
            JSONObject job = new JSONObject();
            job.put("prefsexo", prefsexo);
            job.put("edadmin", edadmin);
            job.put("edadmax", edadmax);
            job.put("prefrelacion", prefrelacion);
            salida.println(job.toString());
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /*public void enviarLocalizacion(int prefsexo, int edadmin, int edadmax, int prefrelacion){
        try{
            Socket sc=new Socket("192.168.0.187",8000); //VERIFICAR IP de la máquina que ejecuta el cliente!!!
            PrintStream salida=new PrintStream(sc.getOutputStream());
            //salida.println("2"); //indica al servidor que el JSON que va a recibir es "tipo 2" (JSON de ubicación)

        }
        catch(IOException ex){
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }*/
}