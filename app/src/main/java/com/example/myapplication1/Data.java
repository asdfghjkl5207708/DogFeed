package com.example.myapplication1;


public class Data {
    private String name;
    private String time;
    private String nameHolder, timeHolder;

    public Data(){}

    public Data(String name, String time){
        this.name = name;
        this.time = time;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setTime(String time){
        this.time = time;
    }

    public String getName(){return name;}
    public String getTime(){return time;}

}

/*Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase(url);
        myFirebaseRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
@Override
public void onDataChange(com.firebase.client.DataSnapshot snapshot) {
        for (com.firebase.client.DataSnapshot dataSnapshot : snapshot.getChildren()){
        Data data = dataSnapshot.getValue(Data.class);
        dogName = data.getName();
        dogTime = data.getTime();
        Log.d("InLook", " name = "+ dogName + ", time = " + dogTime);




        }
        }//onDataChange end;

@Override
public void onCancelled(FirebaseError firebaseError) {

        }
        });//addValueEventListener end;*/
