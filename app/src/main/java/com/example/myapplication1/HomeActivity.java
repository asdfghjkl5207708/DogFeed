package com.example.myapplication1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity{
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private String userUID;
    public static final int REQUEST_LOGIN = 1;
    private ImageButton im_checkData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null){
                    startActivityForResult(new Intent(HomeActivity.this, Login.class), REQUEST_LOGIN);
                }
                else{
                    userUID = user.getUid();
                }
            }
        };
    }
    public void check_Data_btOnClick(View v){
        im_checkData = (ImageButton)findViewById(R.id.im_checkData);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_LOGIN:
                if (resultCode != RESULT_OK){
                    finish();
                }
                break;
        }
    }
    @Override
    protected void onStart (){
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }
    @Override
    protected void onStop (){
        super.onStop();
        auth.removeAuthStateListener(authStateListener);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            new AlertDialog.Builder(HomeActivity.this)
                    .setMessage("離開程式?")
                    .setPositiveButton("確定",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    finish();
                                }
                            })
                    .setNegativeButton("取消",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                }
                            }).show();
        }
        return true;
    } //如果使用者在這個Activity按返回鍵，會確認他是否離開應用程式


}
