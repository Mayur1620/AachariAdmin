package admin.aachari.aachariadmin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Mayur on 12/22/2017.
 */

public class CardActivity extends AppCompatActivity {
    TextView name;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_card_layout);

        String mname = getIntent().getExtras().getString("name");

        navView = findViewById(R.id.navView);
        getSupportActionBar().setTitle(mname);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View headerView = navView.getHeaderView(0);
        name = headerView.findViewById(R.id.m_name);
        name.setText(mname);

        drawer = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(
                this, drawer , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
