package senac.cadaluno.castellan.wazap.helper.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Criado por Henrique em 11/04/2018.
 */
public final class FirebaseConfigs {
    private static DatabaseReference databaseReference;

    public DatabaseReference getFirebase(){
        if (databaseReference == null) databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference;
    }
}
