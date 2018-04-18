package senac.cadaluno.castellan.wazap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import senac.cadaluno.castellan.wazap.helper.Base64Custom;
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

    public void fazerCadastro(View v) {
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
                            String emailCodificado = Base64Custom.encoder64(user.getEmail());
                            user.setId(emailCodificado);
                            user.salvar();
                            startActivity(new Intent(CadastroAct.this,LoginAct.class));
                            finish();
                        } else {
                            String m;
                            try {
                                throw task.getException();

                            } catch (FirebaseAuthWeakPasswordException f) {
                                m = "Senha fraca demais";
                            } catch (FirebaseAuthUserCollisionException f) {
                                m = "User já existe";
                            } catch (FirebaseAuthInvalidCredentialsException f) {
                                m = "Email inválido";
                            } catch (Exception e) {
                                m = "Algo de errado não está certo";
                            }
                            Toast.makeText(CadastroAct.this, m, Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
}
