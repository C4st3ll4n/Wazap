package senac.cadaluno.castellan.wazap.adapter;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import senac.cadaluno.castellan.wazap.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabAdapter extends Fragment {


    public TabAdapter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
