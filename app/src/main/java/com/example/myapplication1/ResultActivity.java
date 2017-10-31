package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Adapter;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultActivity extends AppCompatActivity {

    private String dogName, dogTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent = getIntent();
        String user_Click_Result = intent.getStringExtra("USER_CLICK_EXTRA");
        String url = "https://nhucsie-60df0.firebaseio.com/"+ user_Click_Result;
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();

        TextView title= (TextView)findViewById(R.id.title);
        title.setText("日期:"+user_Click_Result);

        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase(url);
        myFirebaseRef.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
            TextView tv_name = (TextView)findViewById(R.id.tv_name);
            TextView tv_time = (TextView)findViewById(R.id.tv_time);
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot snapshot) {
                for (com.firebase.client.DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Data data = dataSnapshot.getValue(Data.class);
                    Log.d("InOnDataChange", "name = "+ data.getName() + "time = "+ data.getTime());
                    if (data.getName() != null)
                        tv_name.setText("" + data.getName());
                    if (data.getTime() != null)
                        tv_time.setText("" + data.getTime());

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }//onCreate end;
}//ResultActivity end;
