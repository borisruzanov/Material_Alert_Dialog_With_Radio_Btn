package com.borisruzanov.alertdialogwithradiobuttons;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    String[] items = { " First ", " Second ", " Third "};
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Second parameter changing style for Dialog
        builder = new  AlertDialog.Builder(MainActivity.this,R.style.DialogTheme);
        builder.setTitle("Choose variant");

        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               result = items[i];
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == items[0].indexOf(" First ")){
                    Toast.makeText(getApplicationContext(), result,Toast.LENGTH_LONG).show();
                } else if ( i == items[0].indexOf(" Second "))
                Toast.makeText(getApplicationContext(), result,Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.println(" CANCEL pressed");
            }
        });

        alertDialog = builder.create();
        alertDialog.show();
    }
}
