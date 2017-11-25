package com.example.abdohero.gestioncontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by abdohero on 11/11/17.
 */

class RemoveContacts extends AppCompatActivity implements View.OnClickListener{

    private EditText id;
    private Button remove;
    private AddContacts addContacts = new AddContacts();
    //private int conteurId=Integer.parseInt(""+id.getText().toString().trim());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        id  =(EditText)findViewById(R.id.idremove);
        remove = (Button)findViewById(R.id.removebutton);

        remove.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==remove.getId()){
            remove();
        }
    }


    public void remove(){
        boolean flag=false;
        int position=-1;
        if(id.getText().toString().equals("")){
            Toast.makeText(this, "the field is empty", Toast.LENGTH_LONG).show();
        }
        else {
            /*for (Contact object: Contacts) {
                if(id.getText().toString().equals(object.getId().toString())){
                    Contacts.remove(Integer.parseInt(""+object.getId().toString().trim())-1);
                    Toast.makeText(this, "the contact is deleted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "the contact is not deleted", Toast.LENGTH_LONG).show();

                }
            }*/
            //Integer.parseInt(""+id.getText().toString())==Contacts.get(i).getId()

            for (int i=0;i<addContacts.Contacts.size();i++) {
                if (id.getText().toString().equals(addContacts.Contacts.get(i).getId().toString())) {
                    flag=true;
                    position=i;
                }
            }
            if(flag==false){
                Toast.makeText(this, "the contact is not deleted", Toast.LENGTH_LONG).show();
            }
            else {
                addContacts.Contacts.remove(position);
                Toast.makeText(this, "the contact is deleted", Toast.LENGTH_LONG).show();
            }
        }
    }


   /* public void removeContact(){
        if(id.getText().toString().equals("")){
            Toast.makeText(RemoveContacts.this, "the field is empty", Toast.LENGTH_LONG).show();
        }
        else {
            for(int i=0;i<Contacts.size();i++){
                //Integer.parseInt(""+id.getText().toString())==Contacts.get(i).getId()
                if(id.getText().toString().equals(Contacts.get(i).getId().toString())){
                    Contacts.remove(i);
                    Toast.makeText(RemoveContacts.this, "the contact is deleted", Toast.LENGTH_LONG).show();
                }
            }
        }
    }*/
}
