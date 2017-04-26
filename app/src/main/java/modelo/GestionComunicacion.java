package modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by USUARIO on 25/04/2017.
 */

public class GestionComunicacion {
           public void altaUsuario(int telefono,String nick, String sexo, int edad){

            try{
                Socket sc=new Socket("192.168.0.187",8000);
                PrintStream salida=new PrintStream(sc.getOutputStream());
                JSONObject job=new JSONObject();
                job.put("telefono",telefono);
                job.put("nick",nick);
                job.put("sexo",sexo);
                job.put("edad",edad);
                salida.println(job.toString());
                sc.close();
            }
            catch(IOException ex){
                ex.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

           }
}
