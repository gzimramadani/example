package com.example.zadaca2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.zadaca2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void prevedi(View view){
      EditText word =(EditText) findViewById(R.id.word);
      String theword = word.getText().toString();
      String prevod1 = najdiprevod(theword);
      TextView word2 = findViewById(R.id.word2);
        if(prevod1!=null)
            word2.setText(prevod1);
        else
            word2.setText("Ne pronajden takov zbor");
    }

    private String najdiprevod(String theword) {
        InputStream input = getResources().openRawResource(R.raw.recnik);
        Scanner scan = new Scanner(input);
        while (scan.hasNext()){
            String line = scan.nextLine();
            String[] pieces = line.split("=");

            if (pieces[0].equalsIgnoreCase(theword)){
                return pieces[1];
            }
        }
        return null;
    }

}