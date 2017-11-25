package com.example.abdohero.gestioncontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by abdohero on 11/11/17.
 */

class UpdateContacts extends AddContacts implements View.OnClickListener {
    private EditText idsearch, nom, prenom, age, email, phone;
    private TextView id;
    private int conteur=1;
    private Button update , clear , search;
   // private int conteurId=Integer.parseInt(""+idsearch.getText().toString().trim());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        idsearch=(EditText)findViewById(R.id.idsearchUP);
        nom = (EditText) findViewById(R.id.nomUP);
        prenom = (EditText) findViewById(R.id.prenomUP);
        age = (EditText) findViewById(R.id.ageUP);
        email = (EditText) findViewById(R.id.emailUP);
        phone = (EditText) findViewById(R.id.phoneUP);
        id  =(TextView) findViewById(R.id.idUP);

        update =(Button)findViewById(R.id.update);
        clear =(Button)findViewById(R.id.clearUP);
        search=(Button)findViewById(R.id.searchUP);

        update.setOnClickListener(this);
        search.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==search.getId()){
            afficher();
        }
        if(view.getId()==update.getId()){
            update();
        }

    }
    private void afficher(){
        if(idsearch.getText().toString().equals("")){
            Toast.makeText(this, "the field is empty", Toast.LENGTH_LONG).show();
        }
        else {
            for(int i=0;i<Contacts.size();i++){
                //if(Integer.parseInt(""+idsearch.getText().toString())==Contacts.get(i).getId()){
                if(idsearch.getText().toString().equals(Contacts.get(i).getId().toString())){
                    id.setText(Contacts.get(i).getId().toString());
                    nom.setText(Contacts.get(i).getNom().toString());
                    prenom.setText(Contacts.get(i).getPrenom().toString());
                    age.setText(""+Contacts.get(i).getAge());
                    email.setText(Contacts.get(i).getEmail().toString());
                    phone.setText(Contacts.get(i).getPhone().toString());
                    Toast.makeText(this, "the contact is display", Toast.LENGTH_LONG).show();

                }
            }
        }
    }

    public void clear(){
        nom.setText("");
        prenom.setText("");
        age.setText("");
        email.setText("");
        phone.setText("");
        idsearch.setText("");
        id.setText("");
    }
    public void update(){
        Contact c = new Contact();
        if(!nom.getText().toString().equals("")&&!prenom.getText().toString().equals("")&&
                !age.getText().toString().equals("")&&!email.getText().toString().equals("")&&
                !phone.getText().toString().equals("")){
          //c.setId(Integer.parseInt(""+idsearch.getText().toString()));
            c.setId(id.getText().toString());//trim() ==> supprimer l'espace
            c.setNom(nom.getText().toString());
            c.setPrenom(prenom.getText().toString());
            c.setAge(Integer.parseInt(""+age.getText().toString().trim()));
            c.setPhone(phone.getText().toString());
            c.setEmail(email.getText().toString());
            Contacts.set(Integer.parseInt(""+idsearch.getText().toString())-1,c);
            Toast.makeText(UpdateContacts.this, "the contact is Edited", Toast.LENGTH_LONG).show();
            clear();
        }
        else {
            Toast.makeText(UpdateContacts.this, "All fields are obligatory", Toast.LENGTH_LONG).show();
        }
    }
}
