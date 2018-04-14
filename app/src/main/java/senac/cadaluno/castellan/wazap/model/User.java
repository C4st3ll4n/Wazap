package senac.cadaluno.castellan.wazap.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import senac.cadaluno.castellan.wazap.helper.config.FirebaseConfigs;

/**
 * Criado por Henrique em 12/04/2018.
 */

public class User {
    private String Id;
    private String Nome;
    private String email;
    private String Senha;

    public User() {
    }

    public void salvar() {
        DatabaseReference ref = FirebaseConfigs.getFirebase();
        ref.child("USERS").child(getId()).setValue(this);
    }

    @Exclude
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
