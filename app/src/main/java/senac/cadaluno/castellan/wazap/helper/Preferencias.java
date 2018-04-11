package senac.cadaluno.castellan.wazap.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Criado por Henrique em 11/04/2018.
 */
public class Preferencias {
    private Context contexto;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String GAVETA = "wazap.token";
    private int MODO = Context.MODE_PRIVATE;

    private String PARAM_NOME = "NOME";
    private String PARAM_TEL = "TELEFONE";
    private String PARAM_TOKEN = "TOKEN";

    public Preferencias(Context c) {
        this.contexto = c;
        this.preferences = contexto.getSharedPreferences(GAVETA, MODO);
    }

    public void salvar(String nomeUser, String telefone, String token) {
        try {
            editor = preferences.edit();
            editor.putString(PARAM_NOME, nomeUser);
            editor.putString(PARAM_TEL, telefone);
            editor.putString(PARAM_TOKEN, token);
            editor.apply();
            Toast.makeText(contexto, "Deu tudo certo meu patrão ", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(contexto, "Deu ruim na hora de salvar\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public HashMap<String, String> dadosUser() {
        HashMap<String, String> userData = new HashMap<>();
        userData.put(PARAM_NOME, preferences.getString(PARAM_NOME, null));
        userData.put(PARAM_TEL, preferences.getString(PARAM_TEL, null));
        userData.put(PARAM_TOKEN, preferences.getString(PARAM_TOKEN, null));
        return userData;
    }

}
