package senac.cadaluno.castellan.wazap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class LoginAct extends AppCompatActivity {
    AppCompatEditText num, nome, ddd, ddi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        num = findViewById(R.id.editNumber);


        SimpleMaskFormatter smf1 = new SimpleMaskFormatter("NNNNN - NNNN");
        MaskTextWatcher mtw1 = new MaskTextWatcher(num, smf1);
        num.addTextChangedListener(mtw1);

        SimpleMaskFormatter smf2 = new SimpleMaskFormatter("(NN)");
        MaskTextWatcher mtw2 = new MaskTextWatcher(num, smf2);
        ddd.addTextChangedListener(mtw2);

        SimpleMaskFormatter smf3 = new SimpleMaskFormatter("+NN");
        MaskTextWatcher mtw3 = new MaskTextWatcher(num, smf3);
        ddi.addTextChangedListener(mtw3);
    }
}
