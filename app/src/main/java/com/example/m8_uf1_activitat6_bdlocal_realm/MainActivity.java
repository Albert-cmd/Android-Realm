package com.example.m8_uf1_activitat6_bdlocal_realm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    RealmResults<PersonaBD> llistatPersones;
    Realm realm;
    EditText nom;
    EditText residencia;
    EditText edat;
    ListView llista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    public void guardar(View v) {


        nom = findViewById(R.id.nom);
        residencia = findViewById(R.id.residencia);
        edat = findViewById(R.id.edat);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                PersonaBD p1 = new PersonaBD(nom.getText().toString(),residencia.getText().toString(),Integer.parseInt(edat.getText().toString()));

                realm.copyToRealm(p1);

                Toast.makeText(MainActivity.this, "Guardat!!!", Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void actualitzar (View v){

        llista= findViewById(R.id.llista);

        llistatPersones = realm.where(PersonaBD.class).findAll();

        Log.i("BD", "DINS consultar");

        List<PersonaBD> personaBDS = getModelList();

        ArrayAdapter<PersonaBD> arrayAdapter = new ArrayAdapter<PersonaBD>(this, android.R.layout.simple_list_item_multiple_choice,personaBDS );

        llista.setAdapter(arrayAdapter);

        for (PersonaBD p : llistatPersones) {

                Log.i("BD", p.getnom()+ " " + p.getResidencia() + " " + p.getEdat());

        }



    }

    public List<PersonaBD> getModelList() {
       List<PersonaBD> list = new ArrayList<>();
        Realm realm;

            realm = Realm.getDefaultInstance();
            RealmResults<PersonaBD> results = realm
                    .where(PersonaBD.class)
                    .findAll();
            list.addAll(realm.copyFromRealm(results));
        return list;

    }




}
