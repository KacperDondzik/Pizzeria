package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbMala, rbSrednia, rbDuza;
    private CheckBox cbGrubeCiasto;
    private EditText etSztuk;
    private Button btnDalej;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbMala = findViewById(R.id.rbMala);
        rbSrednia = findViewById(R.id.rbSrednia);
        rbDuza = findViewById(R.id.rbDuza);
        cbGrubeCiasto = findViewById(R.id.cbGrubeCiasto);
        etSztuk = findViewById(R.id.etSztuk);
        btnDalej = findViewById(R.id.btnDalej);

        btnDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przejdzDoPodsumowania();
            }
        });
    }

    private void przejdzDoPodsumowania() {
        String strSztuk = etSztuk.getText().toString().trim();

        if (strSztuk.isEmpty()) {
            Toast.makeText(this, "Podaj liczbę sztuk!", Toast.LENGTH_SHORT).show();
            return;
        }

        int sztuk;
        try {
            sztuk = Integer.parseInt(strSztuk);
            if (sztuk <= 0) {
                Toast.makeText(this, "Liczba sztuk musi być większa od 0!", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Niepoprawna liczba sztuk!", Toast.LENGTH_SHORT).show();
            return;
        }



        double cenaBazowa = 35.0;
        String nazwaRozmiaru = "Średnia";

        if (rbMala.isChecked()) {
            cenaBazowa = 25.0;
            nazwaRozmiaru = "Mała";
        } else if (rbDuza.isChecked()) {
            cenaBazowa = 45.0;
            nazwaRozmiaru = "Duża";
        }




        double dodatekCiasto = cbGrubeCiasto.isChecked() ? 5.0 : 0.0;
        String nazwaCiasta = cbGrubeCiasto.isChecked() ? "Grube" : "Cienkie";


        double cenaKoncowa = (cenaBazowa + dodatekCiasto) * sztuk;



        Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
        intent.putExtra("ROZMIAR", nazwaRozmiaru);
        intent.putExtra("CIASTO", nazwaCiasta);
        intent.putExtra("SZTUK", sztuk);
        intent.putExtra("CENA", cenaKoncowa);

        startActivity(intent);
    }
}