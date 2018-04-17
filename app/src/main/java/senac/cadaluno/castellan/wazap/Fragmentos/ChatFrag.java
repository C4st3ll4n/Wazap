package senac.cadaluno.castellan.wazap.Fragmentos;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import senac.cadaluno.castellan.wazap.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFrag extends Fragment {


    public ChatFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

}
