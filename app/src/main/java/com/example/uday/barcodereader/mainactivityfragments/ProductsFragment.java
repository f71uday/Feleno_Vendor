package com.example.uday.barcodereader.mainactivityfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.uday.barcodereader.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


/**
 * Created by uday on 4/2/18.
 */

public class ProductsFragment extends Fragment {
    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
       // Toast.makeText(getActivity().getApplicationContext(),"FRagment loaded",Toast.LENGTH_LONG).show();
        recyclerView = view.findViewById(R.id.product_list);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ProoductResponse> call = apiInterface.getAllproducts("f71");
        call.enqueue(new Callback<ProoductResponse>() {
            @Override
            public void onResponse(Call<ProoductResponse> call, Response<ProoductResponse> response) {
                List<Product> products = response.body().getList();
                Log.d("Products", "Number of databases received: " + products.size());
                LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(new ProductAdapter(products,R.layout.product_list_adapter,getActivity().getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ProoductResponse> call, Throwable t) {
            Log.e("Retrofit",t.toString());
            }
        });


        return view;
    }

}
