package senac.cadaluno.castellan.wazap.helper.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Criado por Henrique em 11/04/2018.
 */
public final class FirebaseConfigs {
    private static DatabaseReference databaseReference;
    private static FirebaseAuth fireAuth;

    public static DatabaseReference getFirebase() {
        if (databaseReference == null) databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference;
    }

    public static FirebaseAuth getFireAuth() {
        if (fireAuth == null) fireAuth = FirebaseAuth.getInstance();
        return fireAuth;
    }
}
