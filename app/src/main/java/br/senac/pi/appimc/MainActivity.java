package br.senac.pi.appimc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //mostrar botão de calcular o imc
        findViewById(R.id.btnImc).setOnClickListener(imc());
    }

    //método do imc
    private View.OnClickListener imc() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mostrando os edits text de peso e altura
                EditText edt_peso = (EditText) findViewById(R.id.edtPeso);
                EditText edt_altura = (EditText) findViewById(R.id.edtAltura);
                //variaveis pra receber os valores dos edittext
                double peso = Double.parseDouble(edt_peso.getText().toString());
                double altura = Double.parseDouble(edt_altura.getText().toString());
                //calculando o IMC
                double res_imc = (peso) / (altura * altura);
                //mostrando o imc no text view
                TextView textImc = (TextView) findViewById(R.id.txtImc);
                textImc.setText(getString(R.string.txt_resultado_imc) + res_imc);
                //classificação de imc
                TextView textClassificacao = (TextView) findViewById(R.id.txtClassificacao);
                if (res_imc < 18.5) {
                    textClassificacao.setText(getString(R.string.txt_abaixoPeso));
                }
                if ((res_imc > 18.6) && (res_imc < 24.9)) {
                    textClassificacao.setText(getString(R.string.txt_idealPeso));
                }
                if ((res_imc > 25.0) && (res_imc < 29.9)) {
                    textClassificacao.setText(getString(R.string.txt_acimaPeso));

                }
                if ((res_imc > 30.0) && (res_imc < 34.9)) {
                    textClassificacao.setText(getString(R.string.txt_obesidade1));
                }
                if ((res_imc > 35.0) && (res_imc < 39.9)) {
                    textClassificacao.setText(getString(R.string.txt_obesidade2));
                }

                if ((res_imc > 40.0)) {
                    textClassificacao.setText(getString(R.string.txt_obesidade3));
                }

            }
        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
