package com.example.abdohero.gestioncontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button add, remove, search, display, update,callssm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListenersButton();
        //inist();
        add = (Button) findViewById(R.id.addLayout);
        remove = (Button) findViewById(R.id.removelayout);
        display = (Button) findViewById(R.id.displayLayout);
        callssm = (Button) findViewById(R.id.callsmsLayout);
        search = (Button) findViewById(R.id.searchLayout);
        update = (Button) findViewById(R.id.updateLayout);

        add.setOnClickListener(this);
        update.setOnClickListener(this);
        remove.setOnClickListener(this);
        search.setOnClickListener(this);
        callssm.setOnClickListener(this);
        display.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addLayout:
                Intent add =new Intent(MainActivity.this,AddContacts.class);
                startActivity(add);
                break;
            case R.id.removelayout:
                Intent remove =new Intent(MainActivity.this,RemoveContacts.class);
                startActivity(remove);
                break;
            case R.id.updateLayout:
                Intent update =new Intent(MainActivity.this,UpdateContacts.class);
                startActivity(update);
                break;
            case R.id.searchLayout:
                Intent search =new Intent(MainActivity.this,SearchContacts.class);
                startActivity(search);
                break;
            case R.id.displayLayout:
                Intent display =new Intent(MainActivity.this,DisplayContacts.class);
                startActivity(display);
                break;
            case R.id.callsmsLayout:
                Intent callsms =new Intent(MainActivity.this,CallSMSContacts.class);
                startActivity(callsms);
                break;

        }
    }
}

