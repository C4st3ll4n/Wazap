package senac.cadaluno.castellan.wazap;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import senac.cadaluno.castellan.wazap.helper.Preferencias;

public class ValidaAct extends AppCompatActivity {
    TextInputEditText validator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valida);
        validator = findViewById(R.id.editCod);

    }

    public void Validar(View v){
        Preferencias preferencias = new Preferencias(ValidaAct.this);
        HashMap<String,String> dataUser = preferencias.dadosUser();
        if (validator.getText().toString().equals(dataUser.get("TOKEN"))) {
            Toast.makeText(this, "Tudo funfando por aqui !", Toast.LENGTH_SHORT).show();
        }
    }
}
//0800 024 4318 - 8803 - Fernanda - ITAU / BMG