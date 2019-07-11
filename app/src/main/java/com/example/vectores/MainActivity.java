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

        String[] vectores = {"Sumar",
                "Restar",
                "Producto Punto",
                "Multiplicacion",
                "Angulo entre Vectores",
                "Producto Cruz",
                "Escalar de A",
                "Escalar de B",
                "Escalar",
                "Unitario de A",
                "Unitario de B",
                "MagnitudA",
                "MagnitudB",
                "Proyeccion de A sobre B",
                "Proyeccion de B sobre A",
                "Sistemas De Fuerza"
        };


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

                if (opereaciones.equals("Escalar de A")) {
                    aparecerEscalar();
                }//if del escalar


                if (opereaciones.equals("Escalar de B")) {
                    aparecerEscalar();
                }//if del escalar


                if (opereaciones.equals("Sumar")) {
                    ocultarEscalar();
                }//if del sumar


                if (opereaciones.equals("Resta")) {
                    ocultarEscalar();
                }//if del sumar
                if (opereaciones.equals("Producto Punto")){
                    ocultarEscalar();
                }

                if (opereaciones.equals("Multiplicacion")){
                    ocultarEscalar();
                }

                if (opereaciones.equals("Angulo entre Vectores")){
                    ocultarEscalar();
                }

                if (opereaciones.equals("Producto Cruz")){
                    ocultarEscalar();
                }
                if (opereaciones.equals("MagnitudA")){
                    ocultarEscalar();
                }

                if (opereaciones.equals("MagnitudB")){
                    ocultarEscalar();
                }
                if (opereaciones.equals("Proyeccion de A sobre B")){
                    ocultarEscalar();
                }

                if (opereaciones.equals("Proyeccion de B sobre A")){
                    ocultarEscalar();
                }
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
            String cad = "los valores de la operacion Suma : \n";

            for (int i = 0; i < 3; i++) {
                c[i] = a[i] + b[i];
                cad = cad + "posicion :" + i + " = " + c[i] + "\n";

            }
            Toast.makeText(this, cad, Toast.LENGTH_LONG).show();
        }


        if (seleccion.getSelectedItem().equals("Restar")) {
            String cad = "los valores de la operacion Resta : \n";
            for (int i = 0; i < 3; i++) {
                c[i] = a[i] - b[i];
                cad = cad + "posicion :" + i + " = " + c[i] + "\n";

            }

            Toast.makeText(this, cad, Toast.LENGTH_LONG).show();

        }//todo termina el de restar

        if (seleccion.getSelectedItem().equals("Producto Punto")) {
            productoPunto();
        }//todo termina P * Q


        if (seleccion.getSelectedItem().equals("Multiplicacion")) {
            String cad = "los valores de la operacion Producto Punto : \n";

            for (int i = 0; i < 3; i++) {
                c[i] = a[i] * b[i];

                cad = cad + "posicion :" + i + " = " + c[i] + "\n";


            }

            Toast.makeText(this, cad, Toast.LENGTH_LONG).show();

        }//todo termina el de Producto Punto


        if (seleccion.getSelectedItem().equals("Producto Cruz")) {
            double cruzi = ((a[1] * b[2]) - (a[2] * b[1]));
            double cruzj = -((a[0] * b[2]) - (b[0] * a[2]));
            double cruzk = ((a[0] * b[1]) - (b[0] * a[1]));
            Toast.makeText(this, "El valor cruz es: < " + cruzi + " i , " + cruzj + " j , " + cruzk + "k >", Toast.LENGTH_LONG).show();

        }//todo aqui termina el producto cruz-------------

        //PROD. CRUZ


        if (seleccion.getSelectedItem().equals("MagnitudA")) {


            double Magnitud = Math.sqrt((Math.pow(a[0], 2)) + (Math.pow(a[1], 2)) + (Math.pow(a[2], 2)));

            Toast.makeText(this, "El valor de la magnitud del vector A  :" + Magnitud, Toast.LENGTH_LONG).show();


        }//todo aqui termina la magnitud del vector A-------------


        if (seleccion.getSelectedItem().equals("MagnitudB")) {


            double Magnitud = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2) + Math.pow(b[2], 2));

            Toast.makeText(this, "El valor de la magnitud del vector B  :" + Magnitud, Toast.LENGTH_LONG).show();


        }//todo aqui termina la magnitud del vector A-------------

        // double[] Ec = new double[3];
        if (seleccion.getSelectedItem().equals("Escalar de A")) {


            String cad = "los valores de la operacion Escalar A : \n";
            double esA = Double.parseDouble(escalar_a.getText().toString());


            for (int i = 0; i < 3; i++) {
                c[i] = (esA) * (a[i]);

                cad = cad + "posicion :" + i + " = " + c[i] + "\n";
            }


            Toast.makeText(this, cad, Toast.LENGTH_LONG).show();


        }//todo aqui termina la magnitud del vector Escalar A

        if (seleccion.getSelectedItem().equals("Unitario de A")) {

            vectorUnitarioA();
        }//todo aqui termina vector unitario A

        if (seleccion.getSelectedItem().equals("Unitario de B")) {

            vectorUnitarioB();
        }//todo aqui termina el Vector unitario DE B


        if (seleccion.getSelectedItem().equals("Angulo entre Vectores")) {

            anguloVectores();
        }//todo aqui termina el Angulo Entre vectores


        if (seleccion.getSelectedItem().equals("Escalar de B")) {

            EscalarB();
        }//todo aqui termina el escalar de B

        if (seleccion.getSelectedItem().equals("Proyeccion de A sobre B")) {

            ProyeccionAB();
        }//todo aqui termina el escalar de B


        if (seleccion.getSelectedItem().equals("Proyeccion de B sobre A")) {

            ProyeccionBA();
        }//todo aqui termina el escalar de B


    }//todo == Termina el Onclick------------------------------------------------------------------


    //todo empiezan los metodo//////////////////////////////////////////////////////////////////////
    //todo///////////////////////////////////////////////////////////////////////////////////////////
    //todo empiezan los metodo//////////////////////////////////////////////////////////////////////
    //todo///////////////////////////////////////////////////////////////////////////////////////////

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
        double Magnituda = (Math.pow(a[0], 2)) + (Math.pow(a[1], 2)) + (Math.pow(a[2], 2));
        double Magnitudb = (Math.pow(b[0], 2)) + (Math.pow(b[1], 2)) + (Math.pow(b[2], 2));
        double MagnitudA = Math.sqrt(Magnituda);
        double MagnitudB = Math.sqrt(Magnitudb);


        for (int i = 0; i < 3; i++) {
            c[i] = a[i] * b[i];


        }
        double productoPunto = c[0] + c[1] + c[2];
        double magnitudXmagnitud = MagnitudA * MagnitudB;
        double calcularValores = (productoPunto) / (magnitudXmagnitud);
        double calculoAngulo = Math.acos(calcularValores);
        double angulo = calculoAngulo * (180 / Math.PI);


        Toast.makeText(getApplicationContext(), "el angulo entre vectores es de :" + angulo + " Grados", Toast.LENGTH_LONG).show();


    }//todo == termina el Angulo Entre Vectores


    public void EscalarB() {

        String cad = "los valores de la operacion Escalar B : \n";
        double esB = Double.parseDouble(escalar_b.getText().toString());


        for (int i = 0; i < 3; i++) {
            c[i] = (esB) * (b[i]);

            cad = cad + "posicion :" + i + " = " + c[i] + "\n";
        }


        Toast.makeText(this, cad, Toast.LENGTH_LONG).show();

    }//todo == ESCALAR DE B=======================================


    public void ProyeccionAB() {

        String cad = " la proyeccion de A sobre B es :\n";

        double Magnituda = (Math.pow(a[0], 2)) + (Math.pow(a[1], 2)) + (Math.pow(a[2], 2));


        double Punto = (
                (a[0] * b[0]) +
                        (a[1] * b[1]) +
                        (a[2] * b[2])
        );


        double MagnitudA1 = (Math.sqrt(Magnituda));
        double MagnitudA2 = Math.pow(MagnitudA1, 2);
        for (int i = 0; i < 3; i++) {


            c[i] = ((Punto) / (MagnitudA2)) * (a[i]);


            cad = cad + "posicion :" + i + " = " + c[i] + "\n";

        }


        Toast.makeText(this, cad, Toast.LENGTH_LONG).show();


    }


    public void ProyeccionBA() {

        String cad = " la proyeccion de A sobre B es :\n";

        double Magnituda = (Math.pow(b[0], 2)) + (Math.pow(b[1], 2)) + (Math.pow(b[2], 2));


        double Punto = (
                (a[0] * b[0]) +
                        (a[1] * b[1]) +
                        (a[2] * b[2])
        );


        double MagnitudA1 = (Math.sqrt(Magnituda));
        double MagnitudA2 = Math.pow(MagnitudA1, 2);
        for (int i = 0; i < 3; i++) {


            c[i] = ((Punto) / (MagnitudA2)) * (b[i]);


            cad = cad + "posicion :" + i + " = " + c[i] + "\n";

        }


        Toast.makeText(this, cad, Toast.LENGTH_LONG).show();


    }//todo proyeccion de B SOBRE A

    public void productoPunto() {

        double Punto = (
                (a[0] * b[0]) +
                        (a[1] * b[1]) +
                        (a[2] * b[2])
        );


        Toast.makeText(this, "el producto punto es :\n" + Punto, Toast.LENGTH_LONG).show();
    }//todo operacion producto Punto

    public void vectorUnitarioA() {
        double Magnituda = (Math.pow(a[0], 2)) + (Math.pow(a[1], 2)) + (Math.pow(a[2], 2));
        double MagnitudR= (Math.sqrt(Magnituda));
        String cad = "el vector Unitario de A: \n";
        for (int i = 0; i < 3; i++) {
            c[i] = (a[i]) / (MagnitudR);
            cad = cad + "posicion :" + i + " = " + c[i] + "\n";
        }
        Toast.makeText(this, cad, Toast.LENGTH_LONG).show();
    }//todo Vector unitario A------------------


    public void vectorUnitarioB() {
        double Magnituda = (Math.pow(b[0], 2)) + (Math.pow(b[1], 2)) + (Math.pow(b[2], 2));
        String cad = "el vector Unitario de B: \n";
        double MagnitudR= (Math.sqrt(Magnituda));
        for (int i = 0; i < 3; i++) {
            c[i] = (b[i]) / (MagnitudR);

            cad = cad + "posicion :" + i + " = " + c[i] + "\n";

        }
        Toast.makeText(this, cad, Toast.LENGTH_LONG).show();

    }//todo Vector unitario B------------------

}

