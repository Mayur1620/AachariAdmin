package admin.aachari.aachariadmin;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayur on 12/22/2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Merchant merchant;
    List<MerchantPojo> list = new ArrayList<>();

    public MyAdapter(Merchant merchant, List<MerchantPojo> list) {
        this.merchant = merchant;
        this.list = list;
    }


    @Override
    public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(merchant);
        View v = inflater.inflate(R.layout.activity_merchant_card,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.address.setText(list.get(position).getAddress());
        holder.contact.setText(list.get(position).getContact());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(merchant,CardActivity.class);
                i.putExtra("name",list.get(position).getName());
                merchant.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setFilter(List<MerchantPojo> new_list){
        list = new ArrayList<>();
        list.addAll(new_list);
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView name,address,contact;
        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.m_name);
            address = itemView.findViewById(R.id.m_address);
            contact = itemView.findViewById(R.id.m_contact);
        }
    }
}
