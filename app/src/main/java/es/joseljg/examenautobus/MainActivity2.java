package es.joseljg.examenautobus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    private int num_pasajeros = 0;
    private double precio_billete = 0.0;
    private double ingresos = 0.0;
    private double gastos = 0.0;
    private double total = 0.0;
    //---------------------------------------------------------------
    private TextView txt_valor_numpasajeros2 = null;
    private TextView txt_precio_viaje2 = null;
    private TextView txt_precio_ingresos2 = null;
    private TextView txt_precio_gastos2 = null;
    private TextView txt_precio_total2 = null;
    private EditText edt_precio_autobus2 = null;
    //----------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // recupero los datos que me han mandado
        txt_valor_numpasajeros2 = (TextView) findViewById(R.id.txt_valor_numpasajeros2);
        txt_precio_viaje2 = (TextView) findViewById(R.id.txt_precio_viaje2);
        txt_precio_ingresos2 = (TextView) findViewById(R.id.txt_precio_ingresos2);
        txt_precio_gastos2 = (TextView) findViewById(R.id.txt_precio_gastos2) ;
        txt_precio_total2 = (TextView) findViewById(R.id.txt_precio_total2);
        edt_precio_autobus2 = (EditText) findViewById(R.id.edt_precio_autobus);
        //--------------------------------------------------------------------------------------------------------
        Intent intent = getIntent();
        if(intent != null)
        {
            num_pasajeros = intent.getIntExtra(MainActivity.EXTRA_NUM_PASAJEROS,0);
            txt_valor_numpasajeros2.setText(String.valueOf(num_pasajeros));
            //-------------------------------------------------------------------
            precio_billete = intent.getDoubleExtra(MainActivity.EXTRA_PRECIO_BILLETE,0.0);
            txt_precio_viaje2.setText(String.valueOf(precio_billete)+"€");
            //--------------------------------------------------------------------
            ingresos = intent.getDoubleExtra(MainActivity.EXTRA_INGRESOS, 0.0);
            txt_precio_ingresos2.setText(String.valueOf(ingresos)+"€");
            //---------------------------------------------------------------------
            total = ingresos - gastos;
            txt_precio_gastos2.setText(String.valueOf(gastos)+"€");
            txt_precio_total2.setText(String.valueOf(total)+"€");
            //---------------------------------------------------------------------
            Toast.makeText(this,"numero de pasajeros -> " + String.valueOf(num_pasajeros),Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"precio billete -> " + String.valueOf(precio_billete),Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"ingresos -> " + String.valueOf(ingresos),Toast.LENGTH_SHORT).show();
            //----------------------------------------------------------------------------------------------

        }
    }

    public void aplicar(View view) {
        String texto_precio_autobus = String.valueOf(edt_precio_autobus2.getText());
        if(!texto_precio_autobus.isEmpty()) {
            gastos = Double.valueOf(texto_precio_autobus);
            total = ingresos - gastos;
            txt_precio_gastos2.setText(String.valueOf(gastos) + "€");
            txt_precio_total2.setText(String.valueOf(total) + "€");
        }
        else{
            edt_precio_autobus2.setError("introduce el precio del autobus");
        }
    }
}