package senac.cadaluno.castellan.wazap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class CadastroAct extends AppCompatActivity {
    FirebaseAuth autentic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void fazerCadastro(View v){
        autentic.signInAnonymously();
    }
}
