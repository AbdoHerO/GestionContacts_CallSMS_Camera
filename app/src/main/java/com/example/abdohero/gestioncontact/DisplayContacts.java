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

class DisplayContacts extends AddContacts implements View.OnClickListener{
    private EditText idsearch, nom, prenom, age, email, phone;
    private TextView id;
    private Button next , back , search;
    //private int conteurId=Integer.parseInt(""+idsearch.getText().toString().trim());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        idsearch = (EditText) findViewById(R.id.idsearchDis);
        nom = (EditText) findViewById(R.id.nomDis);
        prenom = (EditText) findViewById(R.id.prenomDis);
        age = (EditText) findViewById(R.id.ageDis);
        email = (EditText) findViewById(R.id.emailDis);
        phone = (EditText) findViewById(R.id.phoneDis);
        id = (TextView) findViewById(R.id.idDis);

        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        search = (Button) findViewById(R.id.searchDis);

        next.setOnClickListener(this);
        search.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==search.getId()){
            super.afficher(id,idsearch,nom,prenom,age,email,phone);
        }
        if(view.getId()==next.getId()){
           // next();
        }
        if(view.getId()==back.getId()){
           // back();
        }
    }
    /*private void afficher(){
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
    }*/

    public void next(){
        if(id.getText().toString().equals("")){
            Toast.makeText(this, "the field is empty", Toast.LENGTH_LONG).show();
        }
        else {
            int count=Integer.parseInt(""+id.getText().toString())+1;
            if(count<=Contacts.size()+1){
                id.setText(count);
                nom.setText(Contacts.get(count-1).getNom());
                prenom.setText(Contacts.get(count-1).getPrenom());
                age.setText(""+Contacts.get(count-1).getAge());
                email.setText(Contacts.get(count-1).getEmail());
                phone.setText(Contacts.get(count-1).getPhone());
            }
        }
    }

    public void back(){
        if(id.getText().toString().equals("")){
            Toast.makeText(this, "the field is empty", Toast.LENGTH_LONG).show();
        }
        else {
            int count=Integer.parseInt(""+id.getText().toString())-1;
            if(count>0){
                id.setText(count);
                nom.setText(Contacts.get(count-1).getNom());
                prenom.setText(Contacts.get(count-1).getPrenom());
                age.setText(""+Contacts.get(count-1).getAge());
                email.setText(Contacts.get(count-1).getEmail());
                phone.setText(Contacts.get(count-1).getPhone());
            }
        }
    }

}