package com.example.uday.barcodereader.additem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.uday.barcodereader.MainActivity;
import com.example.uday.barcodereader.R;
import com.example.uday.barcodereader.ScanActivity;
import com.example.uday.barcodereader.barcodemodel.ProductResponse;
import com.example.uday.barcodereader.barcodemodel.Result;
import com.example.uday.barcodereader.retrofitapi.ApiClient;
import com.example.uday.barcodereader.retrofitapi.Apiinteface;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by uday on 15/1/18.
 */

public class AddItemActivity extends AppCompatActivity {
    ImageView imageViewProduct ;
    int SCAN_RESULT =100;
    private final static String API_KEY = "ws6i5tx5rbj8jcbdifyjxit610aocp";
    private static final String TAG = MainActivity.class.getSimpleName();
    EditText editTextProductName;
    EditText editTextProductBar;
    EditText editTextDesc;

    EditText editTextMenuf;
    EditText editTextModel;
    EditText editText_qty;
    EditText editText_rate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        imageViewProduct = findViewById(R.id.product_image);
        editTextProductBar = findViewById(R.id.barcode);
        editTextProductName = findViewById(R.id.pro_name);
        editTextDesc =findViewById(R.id.pro_long_des);
        editTextMenuf =findViewById(R.id.pro_manufacturer);
        editTextModel =findViewById(R.id.pro_model);
        editText_rate = findViewById(R.id.pro_rate);
        editText_qty = findViewById(R.id.quantity);

        Glide.with(AddItemActivity.this).load(R.drawable.default_profile_image)
                .into(imageViewProduct);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar =getSupportActionBar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater;
        menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_additem_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.done:
            {
                String barcode = editTextProductBar.getText().toString();
                String ptitle = editTextProductName.getText().toString();
                String pdesc = editTextDesc.getText().toString();
                int pqty = Integer.parseInt(editText_qty.getText().toString());
                int prate = Integer.parseInt(editText_rate.getText().toString());
                APIServiceAddItem apiServiceAddItem;
                apiServiceAddItem = APIUtilsAddItem.getAPIService();
                apiServiceAddItem.savePost(barcode,ptitle,pdesc,null,pqty,prate,null).enqueue(new Callback<ProductModel>() {
                    @Override
                    public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                        Toast.makeText(AddItemActivity.this,"Product Added Sucessfull",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ProductModel> call, Throwable t) {

                    }
                });


            }
                return true;
            case R.id.home:
                startActivity(new Intent(AddItemActivity.this,MainActivity.class));
                return true;
            case  R.id.scan_code:
                startActivityForResult(new Intent(AddItemActivity.this,ScanActivity.class),SCAN_RESULT);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SCAN_RESULT)
        {
            Toasty.success(AddItemActivity.this,"Sucess", Toast.LENGTH_LONG,true).show();
            String scanData  = data.getStringExtra("scan_data");
            editTextProductBar.setText(scanData);
            Apiinteface apiService =
                    ApiClient.getClient().create(Apiinteface.class);

            Call<ProductResponse> call = apiService.getProductDetails(API_KEY,editTextProductBar.getText().toString());
            call.enqueue(new Callback<ProductResponse>() {
                @Override
                public void onResponse(Call<ProductResponse>call, Response<ProductResponse> response) {
                    List<Result> results = response.body().getResult();
                    Log.d(TAG, "Number of products received: " + results.size());
                    for (Result  i:results
                            ) {
                        editTextModel.setText(i.getProductDetails().getModel());
                        editTextProductName.setText(i.getProductDetails().getProductName());
                        editTextDesc.setText(i.getProductDetails().getLongDiscription());
                        //TODO chnage it as this is not weith according to API
                        editText_qty.setText(i.getProductDetails().getProductWeight());
                        Glide.with(AddItemActivity.this).load(i.getProductImage().getImageUrl()).into(imageViewProduct);
                    }
                }

                @Override
                public void onFailure(Call<ProductResponse>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
        }

    }
}
