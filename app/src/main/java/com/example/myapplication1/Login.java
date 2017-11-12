package com.example.myapplication1;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private TextInputLayout mEmail, mPSW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (TextInputLayout)findViewById(R.id.mEmail);
        mPSW = (TextInputLayout)findViewById(R.id.mPSW);
    }
    public void login(View v){
        mEmail = (TextInputLayout)findViewById(R.id.mEmail);
        mPSW = (TextInputLayout)findViewById(R.id.mPSW);
        final Button bt_login = (Button) findViewById(R.id.bt_login);
        final FirebaseAuth auth = FirebaseAuth.getInstance();

        String logEmail = mEmail.getEditText().getText().toString().trim();
        String logPSW = mPSW.getEditText().getText().toString().trim();

        auth.signInWithEmailAndPassword(logEmail, logPSW)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        setResult(RESULT_OK);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        bt_login.setError("登入失敗，請檢查email/password");
                    }
                });
    }

    public void Register_bt_onclick (View v){
        new AlertDialog.Builder(this)
                .setMessage("尚未開放使用，敬請期待!")
                .setPositiveButton("確定", null)
                .show();
    } //讓使用者註冊的按鈕
}


