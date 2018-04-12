package senac.cadaluno.castellan.wazap;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import senac.cadaluno.castellan.wazap.helper.config.FirebaseConfigs;
import senac.cadaluno.castellan.wazap.model.User;

public class CadastroAct extends AppCompatActivity {
    private FirebaseAuth autentic;
    private AppCompatEditText editNome, editEmail, editSenha;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        editEmail = findViewById(R.id.editEmail);
        editNome = findViewById(R.id.editNome);
        editSenha = findViewById(R.id.editSenha);
    }

    public void fazerCadastro(View v){
        user = new User();
        user.setEmail(editEmail.getText().toString());
        user.setNome(editNome.getText().toString());
        user.setSenha(editSenha.getText().toString());
        cadastrarUser();
    }

    public void cadastrarUser() {
        autentic = FirebaseConfigs.getFireAuth();
        autentic.createUserWithEmailAndPassword(user.getEmail(), user.getSenha()).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CadastroAct.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                            FirebaseUser fireUser = task.getResult().getUser();
                            user.setId(fireUser.getUid());
                            user.salvar();
                        } else
                            Toast.makeText(CadastroAct.this, "Errror ao cadastrar o usuário", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
