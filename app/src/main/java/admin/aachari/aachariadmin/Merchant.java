package admin.aachari.aachariadmin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Merchant extends AppCompatActivity implements SearchView.OnQueryTextListener{
    Toolbar toolbar;
    RecyclerView rv;
    List<MerchantPojo> list = new ArrayList<>();
    MyAdapter adapter;

    String[] name = {"Mayur","Mangesh","Sahil","Akshay","Aakash","Shubham","Sanket"};
    String[] address = {"Nagpur","Wardha","Nagpur","Mumbai","Delhi","Wardha","Nagpur"};
    String[] contact = {"+91 9678904568","+91 8890567342","+91 9032456723","+91 9298076789","+91 8888094242","+91 7767894019","+91 9970896756"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);

        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Merchants");
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setHasFixedSize(true);

        int i = 0;
        for(String mname : name){
            list.add(new MerchantPojo(mname,address[i],contact[i]));
            i++;
        }

        adapter = new MyAdapter(this,list);
        rv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        List<MerchantPojo> new_list = new ArrayList<>();
        for(MerchantPojo merchantPojo : list){
            String name = merchantPojo.getName().toLowerCase();
            if (name.contains(newText)){
                new_list.add(merchantPojo);
            }
        }
        adapter.setFilter(new_list);
        return true;
    }
}
