package com.example.pizzeria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvSzczegoly = findViewById(R.id.tvSzczegoly);
        TextView tvCenaRazem = findViewById(R.id.tvCenaRazem);
        Button btnPowrot = findViewById(R.id.btnPowrot);

        String rozmiar = getIntent().getStringExtra("ROZMIAR");
        String ciasto = getIntent().getStringExtra("CIASTO");
        int sztuk = getIntent().getIntExtra("SZTUK", 1);
        double cenaKoncowa = getIntent().getDoubleExtra("CENA", 0.0);




        String szczegolyTekst = "• Rozmiar: " + rozmiar + "\n" +
                "• Ciasto: " + ciasto + "\n" +
                "• Sztuk: " + sztuk;
        tvSzczegoly.setText(szczegolyTekst);




        tvCenaRazem.setText(String.format("Razem: %.2f PLN", cenaKoncowa));




        btnPowrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
