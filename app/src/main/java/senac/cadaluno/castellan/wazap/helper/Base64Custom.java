package senac.cadaluno.castellan.wazap.helper;

import android.util.Base64;

public class Base64Custom {

    public static String encoder64(String texto){
        return Base64.encodeToString(texto.getBytes(),Base64.DEFAULT).replaceAll("(\\n | \\r)","");
    }

    public static String decoder64(String textoCodificado){
        return Base64.decode(textoCodificado,Base64.DEFAULT).toString();
    }

}
