package com.example.weslley.mytemp;

import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Contador extends AppCompatActivity {
    double r = 0;
    CountDownTimer start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        //Setar variável de tempo como variável global
        this.r = getIntent().getDoubleExtra("tempo", 0);
        //iniciar o contador
        iniciarContador(this.r);
    }

    public TextView findTextViewById(int id){
       return (TextView) findViewById(id);
    }

    public void iniciarContador(double time){
        //Recuperar campos de texto
        final TextView t = findTextViewById(R.id.t1);
        final TextView t2 = findTextViewById(R.id.t2);
        //Recuperar botão de restart
        final Button btnRestart = (Button) findViewById(R.id.btnRestart);
        //Tornar botão de Restart invisível
        btnRestart.setVisibility(View.INVISIBLE);
        //Limpar campo de resultado
        t2.setText(" ");
        start = new CountDownTimer((int)time * 1000, 100) {
            public void onTick(long millisUntilFinished) {
                // Centesimo string to String
                String cent = String.valueOf(millisUntilFinished / 100);

                // Segundos e milissegundos
                t.setText(millisUntilFinished / 1000 +

                        // Pega o primeiro dígito da casa dos centesimos
                        "," + cent.substring(cent.length() - 1));
            }

            public void onFinish() {
                t.setText("0,0");
                t2.setText("Fim!");
                btnRestart.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void back(View view){
        start.cancel();
        //Finaliza a activity atual
        finish();
    }

    public void restart(View view){
        iniciarContador(this.r);
    }
    //Não está sendo usado
    public void setResultDialog(String op, double r) {
        //DIÁLOGO
        new AlertDialog.Builder(this)
                .setMessage(op + ": " + r)
                .setPositiveButton("OK", null).show();
    }

    //Não está sendo usado
    public void setResultTost(String op, double r) {
        //TOAST
        Toast.makeText(getApplicationContext(), op +
                ": " + r, Toast.LENGTH_LONG).show();
    }
}
