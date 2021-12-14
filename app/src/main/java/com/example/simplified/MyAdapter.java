package com.example.simplified;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // here in array list we are passing the name of the list_item class as parameter.
   private ArrayList<list_item> listItems ;
   private Context context;

    public MyAdapter(Context context, ArrayList<list_item> listItems) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        list_item listitemm = listItems.get(position);
       holder.txthead.setText(listitemm.getHead());
       holder.txtdesc.setText(listitemm.getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txthead, txtdesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txthead= itemView.findViewById(R.id.textview);
            this.txtdesc=itemView.findViewById(R.id.description);
        }
    }
}
