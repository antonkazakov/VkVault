package com.antonkazakov.vkvault.dependency_injection.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by antonkazakov on 21.09.16.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    RealmConfiguration provideRealmConfiguration(Application application) {

        return new RealmConfiguration.Builder(application)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    @Provides
    @Singleton
    Realm provideRealm(RealmConfiguration realmConfiguration) {

        return Realm.getInstance(realmConfiguration);
    }

}
