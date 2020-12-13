package dev.smartpanda.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    //criar variaveis para linkar aos intens da interface grafica
    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // linka as variaveis com os itens da interface grafica
        editPrecoAlcool     = findViewById(R.id.campoAlcool);
        editPrecoGasolina   = findViewById(R.id.campoGasolina);
        textResultado       = findViewById((R.id.textViewResultado));

    }

    //metodo para calcular preço acionado ao clinar no botao calcular

    public void calcularPreco (View view) {

        //recuperar valores digitados pelo usuario na GUI
        String precoAlcool      = editPrecoAlcool.getText().toString();
        String precoGasolina    = editPrecoGasolina.getText().toString();

        // uso do metodo pata validar os campos digitados - não podem estar em branco
        Boolean resValida = validarCampos(precoAlcool, precoGasolina);
        if (resValida) {

            //convertendo string para Double
            Double valorAlcool      = Double.parseDouble( precoAlcool );
            Double valorGasolina    = Double.parseDouble( precoGasolina );

            //calculo do combustivel mais vantajoso

            System.out.println(valorAlcool/valorGasolina);

            if ( valorAlcool/valorGasolina <= 0.7 ){
                textResultado.setText("Melhor abastecer com ALCOOL ;)");
            }
            else{
                textResultado.setText("Melhor abastecer com GASOLINA ;)");
            }
        }

        else {
            textResultado.setText("Primeiro preencha os campos corretamente");
        }
    }


    //metodo pata validar se os campos foram digitados

    public  Boolean validarCampos (String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ) {
            camposValidados = false;
        } else if ( pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
        }

        return camposValidados;
    }

}
