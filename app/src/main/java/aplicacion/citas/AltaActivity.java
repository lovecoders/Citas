package aplicacion.citas;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javabeans.Usuario;
import modelo.GestionComunicacion;


public class AltaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
    }
    public void guardar(View v) {
        EditText edtTel = ((EditText) this.findViewById(R.id.edtTel));
        EditText edtNick = ((EditText) this.findViewById(R.id.edtNick));
        EditText edtSexo = ((EditText) this.findViewById(R.id.edtSexo));
        EditText edtEdad = ((EditText) this.findViewById(R.id.edtEdad));

        Usuario us=new Usuario (Integer.parseInt(edtTel.getText().toString()),edtNick.getText().toString(),
                                Boolean.parseBoolean(edtSexo.getText().toString()), Integer.parseInt(edtEdad.getText().toString()));

        edtTel.getText().clear();
        edtNick.getText().clear();
        edtSexo.getText().clear();
        edtEdad.getText().clear();

        Toast.makeText(this,"Registro completo", Toast.LENGTH_SHORT).show();


        class TareaCom extends AsyncTask<String, Void, Void> {

            @Override
            protected Void doInBackground(String... params) {
                GestionComunicacion gcom = new GestionComunicacion();
                gcom.altaUsuario(Integer.parseInt(params[0]), params[1], Boolean.parseBoolean(params[2]), Integer.parseInt(params[3]));
                return null;

            }

            public void salir(View v) {
                this.finish();
            }


        }
    }
}
