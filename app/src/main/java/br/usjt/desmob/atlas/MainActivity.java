package br.usjt.desmob.atlas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * @author Lucas Vasconcelos Molessani - 201508392
 * DESMOBI
 * CCP3AN-MCA
 */
public class MainActivity extends Activity {
    Spinner spinnerContinente;
    public static final String CHAVE = "br.usjt.desmob.atlas.txtContinente";
    String continente = "Todos";

    /**
     * @author Lucas Vasconcelos Molessani - 201508392
     * apresentar detalhes do pais selecionado
     * @param savedInstanceState dados recebidos de outra activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = (Spinner)findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new ContinenteSelecionado());
    }

    /**
     * @author Lucas Vasconcelos Molessani - 201508392
     * Método resposavel por chamar a
     * activity de listar paises pelo continente
     */
    public void listarPaises(View view){
        Intent intent = new Intent(this, ListaPaisesActivity.class);

        intent.putExtra(CHAVE, continente);
        startActivity(intent);
    }

    /**
     * @author Lucas Vasconcelos Molessani - 201508392
     * DEVMOBI
     * CCP3AN-MCA
     */
    private class ContinenteSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continente = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
