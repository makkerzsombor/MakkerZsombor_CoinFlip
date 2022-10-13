package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView kep;
    private Button btnFej;
    private Button btnIras;
    private TextView dobasok;
    private TextView gyozelmek;
    private TextView veresegek;
    private int index;
    private int gyoz;
    private int ver;
    private Random rnd = new Random();
    private AlertDialog.Builder jatekVegeAlertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnFej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index >= 5){
                    jatekVege();
                }else{
                    dobasok.setText("Dobások: " + index);
                    if (rnd.nextInt(2) + 1 == 1){
                        gyoz++;
                        gyozelmek.setText("Győzelem: " + gyoz);
                        Toast.makeText(MainActivity.this, "A dobás értéke: Fej", Toast.LENGTH_SHORT).show();
                        kep.setImageResource(R.drawable.heads);
                    }else{
                        ver++;
                        veresegek.setText("Vereség: " + ver);
                        Toast.makeText(MainActivity.this, "A dobás értéke: Írás", Toast.LENGTH_SHORT).show();
                        kep.setImageResource(R.drawable.tails);
                    }
                }
            }
        });

        btnIras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index >= 5){
                    jatekVege();
                }else {
                    dobasok.setText("Dobások: " + index);
                    if (rnd.nextInt(2) + 1 == 2){
                        gyoz++;
                        gyozelmek.setText("Győzelem: " + gyoz);
                        Toast.makeText(MainActivity.this, "A dobás értéke: Írás", Toast.LENGTH_SHORT).show();
                        kep.setImageResource(R.drawable.tails);
                    }else{
                        ver++;
                        veresegek.setText("Vereség: " + ver);
                        Toast.makeText(MainActivity.this, "A dobás értéke: Fej", Toast.LENGTH_SHORT).show();
                        kep.setImageResource(R.drawable.heads);
                    }
                }
            }
        });
    }
    private void init(){
        kep = findViewById(R.id.kep);
        btnFej = findViewById(R.id.btnFej);
        btnIras = findViewById(R.id.btnIras);
        dobasok = findViewById(R.id.dobasok);
        gyozelmek = findViewById(R.id.gyozelmek);
        veresegek = findViewById(R.id.veresegek);
        index = 0;
    }

    private void ujJatek(){
        index = 0;
        gyoz = 0;
        ver = 0;
        dobasok.setText("Dobások: 0");
        gyozelmek.setText("Győzelem: 0");
        veresegek.setText("Vereség: 0");
    }

    private void jatekVege(){
        jatekVegeAlertDialog = new AlertDialog.Builder(this);
        if (gyoz > ver){
            jatekVegeAlertDialog.setTitle("Győzelem!");
            jatekVegeAlertDialog.setMessage("Szeretne új játékot játszani?");
            jatekVegeAlertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            jatekVegeAlertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ujJatek();
                }
            });
            jatekVegeAlertDialog.create().show();
        }else{
            jatekVegeAlertDialog.setTitle("Vereség!");
            jatekVegeAlertDialog.setMessage("Szeretne új játékot játszani?");
            jatekVegeAlertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            jatekVegeAlertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ujJatek();
                }
            });
            jatekVegeAlertDialog.create().show();
        }
    }
}