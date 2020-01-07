package mx.edu.isc.tesoem.karm.datosgson7s11;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    EditText txtnombre,txtedad,txtcorreo,txtcurp;
    TextView lbljson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);
        txtcurp = findViewById(R.id.txtcurp);
        lbljson = findViewById(R.id.lbljson);
    }
    @SuppressLint("LongLogTag")
    public void convertirjson(View v){
        Datos datosbj = new Datos(txtnombre.getText().toString(),Integer.parseInt(txtedad.getText().toString()),txtcorreo.getText().toString(),txtcurp.getText().toString());
        Gson gson = new Gson();
        String cjson = gson.toJson(datosbj);
        lbljson.setText(cjson);
        Datos datosobj1 = gson.fromJson(cjson,Datos.class);
        Log.i("Informacion del json -->","Nombre "+ datosobj1.getNombre()+" , Edad"+ datosobj1.getEdad()+", Correo" + datosobj1.getCorreo()+", Curp"+ datosobj1.getCurp());
    }
}
