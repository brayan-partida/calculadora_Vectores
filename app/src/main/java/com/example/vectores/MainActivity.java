package com.example.vectores;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText A1, A2, A3, B1, B2, B3, escalar_a, escalar_b;
    Button suma, resta, escalar, unitarios, angulo, magnitud, prod_cruz;
    TextView resultado, textoEscalarA, textoEscalarB;

    Spinner seleccion;
    double[] a = new double[3];
    double[] b = new double[3];

    double[] c = new double[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] vectores = {"Sumar", "Restar", "Multiplicacion", "Angulo entre Vectores", "Producto Cruz", "Escalar de A", "Escalar", "Unitario", "MagnitudA", "MagnitudB", "Proyeccion", "Sistemas De Fuerza"};


        //todo ==Aqui esta las Referencias de las Variables///////========
        escalar_a = findViewById(R.id.escalar_a);
        escalar_b = findViewById(R.id.escalar_b);
        A1 = findViewById(R.id.A1);
        A2 = findViewById(R.id.A2);
        A3 = findViewById(R.id.A3);
        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);
        B3 = findViewById(R.id.B3);

        textoEscalarA = findViewById(R.id.textoEscalarA);
        textoEscalarB = findViewById(R.id.textoEscalarB);

        suma = findViewById(R.id.prod_cruz);

        seleccion = findViewById(R.id.seleccion);


        ocultarEscalar();

//todo = aqui empieza el adaptador =========================================
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, vectores);

        seleccion.setAdapter(adapter);
        seleccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opereaciones = seleccion.getSelectedItem().toString();

                if (opereaciones.equals("Escalar")) {
                    aparecerEscalar();
                }//if del escalar

                if (opereaciones.equals("Sumar")) {
                    ocultarEscalar();
                }//if del sumar
            }//todo termina la seleccion de click listener

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }//todo aqui termina el on create


    public void Onclick(View view) {
        switch (view.getId()) {
            case R.id.prod_cruz:
                suma_vectores();
                break;
        }
    }

    public void suma_vectores() {


        int escalar;
        double cruz;
        double mag;
        double mag2;
        double angulo;
        double ang;
        double ang2;

        int suma;

        a[0] = Double.parseDouble(A1.getText().toString());
        a[1] = Double.parseDouble(A2.getText().toString());
        a[2] = Double.parseDouble(A3.getText().toString());

        b[0] = Double.parseDouble(B1.getText().toString());
        b[1] = Double.parseDouble(B2.getText().toString());
        b[2] = Double.parseDouble(B3.getText().toString());


        double MagnitudA = 0;
        double[] magnitudB = new double[3];


        if (seleccion.getSelectedItem().equals("Sumar")) {
            String cad = "los valores son ";

            for (int i = 0; i < 3; i++) {
                c[i] = a[i] + b[i];
                cad = cad + "el valor: " + i + ": " + c[i] + "\n";

            }
            Toast.makeText(this, cad, Toast.LENGTH_LONG).show();
        }


        if (seleccion.getSelectedItem().equals("Restar")) {

            for (int i = 0; i < 3; i++) {
                c[i] = a[i] - b[i];


            }
            for (int i = 0; i < 3; i++) {
                //resultado.setText("<" + (c[i]) + ">");
                Toast.makeText(this, "el valor del vector " + i + " es:" + c[i], Toast.LENGTH_LONG).show();
            }//termina el vector
        }//todo termina el de restar


        if (seleccion.getSelectedItem().equals("Multiplicacion")) {

            for (int i = 0; i < 3; i++) {
                c[i] = a[i] * b[i];


            }
            for (int i = 0; i < 3; i++) {
                //resultado.setText("<" + (c[i]) + ">");
                Toast.makeText(this, "el valor del vector " + i + " es:" + c[i], Toast.LENGTH_LONG).show();
            }//termina el vector
        }//todo termina el de multiplicacion


        if (seleccion.getSelectedItem().equals("Producto Cruz")) {
            double cruzi = ((a[1] * b[2]) - (a[2] * b[1]));
            double cruzj = -((a[0] * b[2]) - (b[0] * a[2]));
            double cruzk = ((a[0] * b[1]) - (b[0] * a[1]));
            Toast.makeText(this, "El valor cruz es: <" + cruzi + ", " + cruzj + " , " + cruzk + ">", Toast.LENGTH_LONG).show();

        }//todo aqui termina el producto cruz-------------

        //PROD. CRUZ


        if (seleccion.getSelectedItem().equals("MagnitudA")) {


            double Magnitud = Math.sqrt((Math.pow(a[0], 2)) + (Math.pow(a[1], 2)) + (Math.pow(a[1], 2)));

            Toast.makeText(this, "El valor de la magnitud del vector A  :" + Magnitud, Toast.LENGTH_LONG).show();


        }//todo aqui termina la magnitud del vector A-------------


        if (seleccion.getSelectedItem().equals("MagnitudB")) {


            double Magnitud = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2) + Math.pow(b[1], 2));

            Toast.makeText(this, "El valor de la magnitud del vector B  :" + Magnitud, Toast.LENGTH_LONG).show();


        }//todo aqui termina la magnitud del vector A-------------

        // double[] Ec = new double[3];
        if (seleccion.getSelectedItem().equals("Escalar de A")) {


            //  escalar_a.setVisibility(View.VISIBLE);
            double esA = Double.parseDouble(escalar_a.getText().toString());


            for (int i = 0; i < 3; i++) {
                c[i] = (esA) * (a[i]);
            }

            for (int i = 0; i < 3; i++) {


                Toast.makeText(this, "el valor es =" + c[i], Toast.LENGTH_LONG).show();
            }

        }//todo aqui termina la magnitud del vector Escalar A


        if (seleccion.getSelectedItem().equals("Angulo entre Vectores")) {

            anguloVectores();
        }


    }//todo == Termina el Onclick------------------------------------------------------------------


    public void ocultarEscalar() {

        escalar_a.setVisibility(View.INVISIBLE);
        escalar_b.setVisibility(View.INVISIBLE);
        textoEscalarA.setVisibility(View.INVISIBLE);
        textoEscalarB.setVisibility(View.INVISIBLE);
    }

    public void aparecerEscalar() {
        escalar_a.setVisibility(View.VISIBLE);
        escalar_b.setVisibility(View.VISIBLE);
        textoEscalarA.setVisibility(View.VISIBLE);
        textoEscalarB.setVisibility(View.VISIBLE);
    }

    public void anguloVectores() {

        double MagnitudA = Math.sqrt((Math.pow(a[0], 2)) + (Math.pow(a[1], 2)) + (Math.pow(a[1], 2)));
        double MagnitudB = Math.sqrt((Math.pow(b[0], 2)) + (Math.pow(b[1], 2)) + (Math.pow(b[1], 2)));


        for (int i = 0; i < 3; i++) {
            c[i] = a[i] * b[i];


        }
       double multiplicarMagnitud=MagnitudA * MagnitudB;
        double productoPunto = Math.cos((c[0] + c[1] + c[2]) / (multiplicarMagnitud));


        Toast.makeText(getApplicationContext(), "el angulo entre vectores es" + productoPunto, Toast.LENGTH_LONG).show();


    }//todo == termina el metodo vector


}

