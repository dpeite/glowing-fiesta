package desbancandowilliamhill.betfail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> spinnerArray =  new ArrayList<String>();

        leerNombresJugadores(spinnerArray);

        Button button = (Button) findViewById(R.id.button);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.spinner_jugador1)).setAdapter(adapter);
        ((Spinner) findViewById(R.id.spinner_jugador2)).setAdapter(adapter);
    } // Cierre onCreate

    public void obtenerGanador(View v) {
        Toast.makeText(MainActivity.this, "Nunca apuestes a Nadal",
                Toast.LENGTH_LONG).show();
    }

    private ArrayList<String> leerNombresJugadores(ArrayList<String> list) {

        try {
            InputStream is = getAssets().open("nombreJugador");

            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            String text = new String(buffer);

            String[] nombres = text.split("\\n");

            for (int i = 0; i < nombres.length; i++ ) {
                list.add(nombres[i]);
            }

            return list;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // Cierre leerNobmresJugadores
}
