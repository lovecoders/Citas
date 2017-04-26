package aplicacion.citas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void alta(View v) {
        Intent intent=new Intent(this,AltaActivity.class);
        this.startActivity(intent);



    }
    public void preferencias(View v) {

    }
    public void coincidentes(View V){

    }
}
