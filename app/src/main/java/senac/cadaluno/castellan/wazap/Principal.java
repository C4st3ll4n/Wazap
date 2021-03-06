package senac.cadaluno.castellan.wazap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import senac.cadaluno.castellan.wazap.adapter.TabAdapter;
import senac.cadaluno.castellan.wazap.helper.SlidingTabLayout;
import senac.cadaluno.castellan.wazap.helper.config.FirebaseConfigs;

public class Principal extends AppCompatActivity {
    private android.support.v7.widget.Toolbar tools;
    private FirebaseAuth fireAuth;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tools = findViewById(R.id.toolbar);
        tools.setTitle("ZaptZopt");
        setSupportActionBar(tools);

        fireAuth = FirebaseConfigs.getFireAuth();

        viewPager = findViewById(R.id.viewPage);

        slidingTabLayout = findViewById(R.id.slideTabLayout);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:

                break;
            case R.id.menu_config:

                break;
            case R.id.menu_pesquisa:

                break;
            case R.id.menu_sair:
                fireAuth.signOut();
                startActivity(new Intent(this, LoginAct.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
