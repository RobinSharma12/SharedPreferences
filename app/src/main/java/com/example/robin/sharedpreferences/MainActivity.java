package com.example.robin.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    EditText userName;
    EditText password;
    TextView savedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText3);
        savedData = (TextView)findViewById(R.id.mainactivity_textView3);
    }
    public void onSaveButton(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("User Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserName", userName.getText().toString());
        editor.putString("Password",password.getText().toString());
        editor.apply();
        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();
    }

    public void onDisplayButton(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("User Data", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("UserName", "");
        String password = sharedPreferences.getString("Password", "");
        savedData.setText(username + "  " + password);
    }

}
