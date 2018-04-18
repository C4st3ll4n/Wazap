package senac.cadaluno.castellan.wazap.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import senac.cadaluno.castellan.wazap.Fragmentos.ChatFrag;
import senac.cadaluno.castellan.wazap.Fragmentos.CttsFrag;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] tabs = {"CONVERSAS", "CONTATOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ChatFrag();
                break;

            case 1:
                fragment = new CttsFrag();
                break;
        }
        return fragment;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tabs.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
