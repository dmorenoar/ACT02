package com.example.act02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recuperamos la lista
        lista = findViewById(R.id.listaNombes);

        Intent intent = getIntent();

        TextView txtMensaje = (TextView) findViewById(R.id.textViewMensaje);

        //Recogemos el valor directamente asociandolo al mensaje
        txtMensaje.setText(intent.getStringExtra("Mensaje"));

        //Recogemos el valor en una variable
        final ArrayList<String> listaNombres = (ArrayList<String>) intent.getSerializableExtra("array");

        Log.d("Msg", "El primer nombre de la lista que recibo es: " + listaNombres.get(0));
        Log.d("Msg","Recibo de la primera activity:" + intent.getStringExtra("Mensaje"));

        //Rellenamos la lista con el array que recibimos

        //Creamos el adaptador para la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaNombres);

        lista.setAdapter(adapter);

        /*lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Han clicado la lista",Toast.LENGTH_LONG);
            }
        });*/

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Msg", "Has clicado " + listaNombres.get(i));
                Toast.makeText(MainActivity2.this, "Has clicado: " + listaNombres.get(i), Toast.LENGTH_SHORT).show();
            }
        });


    }
}