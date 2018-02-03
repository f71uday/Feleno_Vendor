package com.example.uday.barcodereader.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uday.barcodereader.additem.AddItemActivity;
import com.example.uday.barcodereader.R;
import com.google.gson.Gson;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by uday on 25/1/18.
 */

public class SignUp extends AppCompatActivity {
    EditText editText_id;
    TextInputEditText editText_name;
    EditText editText_mobile;
    EditText editText_email;
    Button button_submit;
    ProgressDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editText_email = findViewById(R.id.signup_email);
        editText_id = findViewById(R.id.signup_id);
        editText_mobile = findViewById(R.id.signup_mobile);
        editText_name = findViewById(R.id.signup_fullname);
        button_submit = findViewById(R.id.signup_submit);
        dialog = new ProgressDialog(SignUp.this);
        
        final APIService mAPIService;




        mAPIService = APIUtils.getAPIService();
        button_submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String id = editText_id.getText().toString();
                String name = editText_name.getText().toString();
                String mobile = editText_mobile.getText().toString();


                String email = editText_email.getText().toString();
                mAPIService.savePost(id,name,mobile,email).enqueue(new Callback<PostModel>() {

                    @Override
                    public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                        if (response.isSuccessful())
                        {
                            Log.d("SIGNUP Retro Client ","creation sucessfull"+ new Gson().toJson(response.body()));

                            Toasty.success(SignUp.this,"Sign Up sucessfull", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(SignUp.this, AddItemActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<PostModel> call, Throwable t) {
                          Log.e("SIGNUP Retro Client ",t.toString());
                    }
                });
                dialog.dismiss();
            }
        }
        );

    }

}

