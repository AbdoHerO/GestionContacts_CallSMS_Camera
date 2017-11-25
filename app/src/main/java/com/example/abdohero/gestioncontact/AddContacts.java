package com.example.abdohero.gestioncontact;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by abdohero on 11/11/17.
 */

public class AddContacts extends AppCompatActivity implements View.OnClickListener{
    private EditText  nom, prenom, age, email, phone;
    private TextView id;
    ArrayList<Contact> Contacts;
    private Button add , clear;
    private int conteur=1;

    public AddContacts(){
        Contacts = new ArrayList<>();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nom = (EditText) findViewById(R.id.nomAdd);
        prenom = (EditText) findViewById(R.id.prenomAdd);
        age = (EditText) findViewById(R.id.ageAdd);
        email = (EditText) findViewById(R.id.emailAdd);
        phone = (EditText) findViewById(R.id.phoneAdd);
        id  =(TextView) findViewById(R.id.idAdd);

        add =(Button)findViewById(R.id.add);
        clear =(Button)findViewById(R.id.clearADD);

        add.setOnClickListener(this);
        clear.setOnClickListener(this);

        id.setText(""+conteur);

    }


    @Override
    public void onClick(View view) {
        if(view.getId()==clear.getId()){
            clear();
        }
        if(view.getId()==add.getId()){
            ajouterContact();
        }

    }

    public void clear(){
        nom.setText("");
        prenom.setText("");
        age.setText("");
        email.setText("");
        phone.setText("");
    }
    public void ajouterContact(){
        Contact c = new Contact();
        if(!nom.getText().toString().equals("")&&!prenom.getText().toString().equals("")&&
            !age.getText().toString().equals("")&&!email.getText().toString().equals("")&&
            !phone.getText().toString().equals("")) {

            c.setId(id.getText().toString().trim());//trim() ==> supprimer l'espace
            c.setNom(nom.getText().toString());
            c.setPrenom(prenom.getText().toString());
            c.setAge(Integer.parseInt("" + age.getText().toString().trim()));
            c.setPhone(phone.getText().toString());
            c.setEmail(email.getText().toString());
            Contacts.add(c);
            clear();
            conteur++;
            id.setText("" + conteur);

            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "test.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] data1 = {1, 1, 0, 0};
            if (file.exists()) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
                    out.writeObject(data1);
                    out.close();
                    fileOutputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(this, "the contact is added", Toast.LENGTH_LONG).show();

            }
        }
        else {
            Toast.makeText(this, "All fields are obligatory", Toast.LENGTH_LONG).show();
        }



    }

    private void saveArrayList() {
        try {
            FileOutputStream fileOutputStream = openFileOutput("file.ser", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(Contacts);
            out.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ArrayList<Object> getSavedArrayList() {
        ArrayList<Object> savedArrayList = null;

        try {
            FileInputStream inputStream = openFileInput("file.ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            savedArrayList = (ArrayList<Object>) in.readObject();
            in.close();
            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return savedArrayList;
    }


    public void remove(EditText id){
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

            for (int i=0;i<Contacts.size();i++) {
                if (id.getText().toString().equals(Contacts.get(i).getId().toString())) {
                    flag=true;
                    position=i;
                }
            }
            if(flag==false){
                Toast.makeText(this, "the contact is not deleted", Toast.LENGTH_LONG).show();
            }
            else {
                Contacts.remove(position);
                Toast.makeText(this, "the contact is deleted", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void afficher(TextView id,EditText idsearch,EditText nom,EditText prenom,EditText age
                            ,EditText email,EditText phone){
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
}
