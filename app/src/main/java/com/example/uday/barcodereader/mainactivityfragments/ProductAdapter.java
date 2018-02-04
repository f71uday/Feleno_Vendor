package com.example.uday.barcodereader.mainactivityfragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uday.barcodereader.R;
import com.example.uday.barcodereader.barcodemodel.ProductResponse;

import java.util.List;

/**
 * Created by uday on 4/2/18.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<Product> products;
    private int rowLayout;
    private Context context;

    public static class ProductViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout productLayout;
        TextView productname;
        TextView productId;
        TextView Description;
        TextView rate;
        TextView qty;

        public ProductViewHolder(View v) {
            super(v);
            productLayout =  v.findViewById(R.id.vendor_product_layout);
            productname =  v.findViewById(R.id.list_product_name);
            productId = v.findViewById(R.id.list_product_bar);
            Description =v.findViewById(R.id.list_product_desc);
            rate = v.findViewById(R.id.list_product_rate);
            qty = v.findViewById(R.id.list_product_qty);

        }
    }

    public ProductAdapter(List<Product> products, int rowLayout, Context context) {
        this.products = products;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_adapter, parent, false);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ProductAdapter.ProductViewHolder holder, int position) {
        holder.productname.setText(products.get(position).getPtitle());
        holder.productId.setText(products.get(position).getId());
        holder.rate.setText(products.get(position).getPrate());
        holder.qty.setText(products.get(position).getPqty());
        holder.Description.setText(products.get(position).getPdesc());
    }



    @Override
    public int getItemCount() {
        return 0;
    }
}
