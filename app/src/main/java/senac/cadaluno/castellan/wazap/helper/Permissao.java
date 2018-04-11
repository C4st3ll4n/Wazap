package senac.cadaluno.castellan.wazap.helper;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Criado por Henrique em 11/04/2018.
 */
public class Permissao {

    public static boolean valida(int CodigoRequisicao, Activity activity, String[] permissoes) {

        if (Build.VERSION.SDK_INT >= 23) {

            List<String> listaPermissao = new ArrayList<>();

            for (String perm : permissoes) {

                boolean isPermitido = ContextCompat.checkSelfPermission(activity.getApplicationContext(), perm) == PackageManager.PERMISSION_GRANTED;

                if (!isPermitido)   listaPermissao.add(perm);

            }

            if (listaPermissao.isEmpty()) return true;

            String[] permissoesFuturas = new String[listaPermissao.size()];
            listaPermissao.toArray(permissoesFuturas);
            ActivityCompat.requestPermissions(activity,permissoesFuturas,CodigoRequisicao);
        }
        return true;
    }
}
