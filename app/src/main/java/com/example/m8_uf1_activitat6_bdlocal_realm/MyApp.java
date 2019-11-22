package com.example.m8_uf1_activitat6_bdlocal_realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MyApp extends Application {



    @Override
    public void onCreate() {
        // Realm.init(this);
        super.onCreate();
        initRealm();
        Realm realm = Realm.getDefaultInstance();
        realm.close();
    }

    private void initRealm(){

        //Defineix una versió, i esborrar la BD si detecta una versió més antiga

        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder().schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }


}
