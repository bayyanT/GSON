package com.example.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSave(View view) {
        Book[]books=new Book[2];
        books[0]=new Book("Java core","Johan");
        books[1]=new Book("C#","Mark");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Gson gson=new Gson();
        String stringGson=gson.toJson(books);
        editor.putString("123",stringGson);
        Toast.makeText(this, "Data Saved"+stringGson, Toast.LENGTH_SHORT).show();

    }

    public void onLoad(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson =new Gson();
        String x=sharedPreferences.getString("123","");
        Book []books=gson.fromJson(x,Book[].class);
        Toast.makeText(this, "number of books"+books.length, Toast.LENGTH_SHORT).show();


    }
}