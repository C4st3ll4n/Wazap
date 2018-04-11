package senac.cadaluno.castellan.wazap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAct extends AppCompatActivity {
   private FirebaseAuth firebaseAuth;
    AppCompatEditText email, senha;
    /*private String[] permissoes = new String[]{
            Manifest.permission.SEND_SMS,
            Manifest.permission.INTERNET
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editEmail);
        senha = findViewById(R.id.editSenha);


        //Permissao.valida(1, this, permissoes);
/*
        SimpleMaskFormatter mascara_numero = new SimpleMaskFormatter("NNNNN - NNNN");
        SimpleMaskFormatter mascara_ddd = new SimpleMaskFormatter("NN");
        SimpleMaskFormatter mascara_ddi = new SimpleMaskFormatter("+NN");

        MaskTextWatcher textWatcher_numero = new MaskTextWatcher(email, mascara_numero);
        MaskTextWatcher textWatcher_ddd = new MaskTextWatcher(ddd, mascara_ddd);
        MaskTextWatcher textWatcher_ddi = new MaskTextWatcher(ddi, mascara_ddi);

        email.addTextChangedListener(textWatcher_numero);
        ddd.addTextChangedListener(textWatcher_ddd);
        ddi.addTextChangedListener(textWatcher_ddi);*/
    }
/*
    public void cadastrar(View v) {
        String nomeUser = senha.getText().toString();
        String telefone_formatado = ddi.getText().toString() + ddd.getText().toString() + email.getText().toString();

        String numero = telefone_formatado.replace("+", "");
        numero = numero.replace(" - ", "");

        //Toast.makeText(this, nomeUser + "\n" + numero, Toast.LENGTH_SHORT).show();

        Random geraToken = new Random();
        int tokenNumerico = geraToken.nextInt(9999 - 1000) + 100;
        String token = String.valueOf(tokenNumerico);

        //Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        Preferencias pref = new Preferencias(LoginAct.this);
        pref.salvar(nomeUser, numero, token);

        HashMap<String, String> user = pref.dadosUser();

        //Toast.makeText(this, user.get("NOME"), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, user.get("TELEFONE"), Toast.LENGTH_SHORT).show();

        Toast.makeText(this, user.get("TOKEN"), Toast.LENGTH_SHORT).show();

        String mensagem = nomeUser + " aqui está o seu código de confirmação do ZaptZopt: " + token;
        boolean enviadoSMS = enviarSMS("+" + numero, mensagem);

        if (enviadoSMS){
            startActivity(new Intent( this,ValidaAct.class));
            finish();
        }else{
            Toast.makeText(this, "Algo deu errado, tente novamente !", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean enviarSMS(String telefone, String mensagem) {
        try {
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(telefone, null, mensagem, null, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int resultado : grantResults) {
            if (resultado == PackageManager.PERMISSION_DENIED) alerta();
        }
    }

    private void alerta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("PERMISSÕES");
        builder.setMessage("É necessário que você aceite as permissões para que o app funcione normalmente");

        builder.setNeutralButton("COMPREENDO", new DialogInterface.OnClickListener() {
                @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }*/

    public void logar(View v){

    }

    public void goToCadastro(View v){
        startActivity(new Intent(this,CadastroAct.class));
        finish();
    }
}
