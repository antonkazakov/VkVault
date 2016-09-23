package com.antonkazakov.vkvault.repository;

import android.support.annotation.NonNull;

/**
 * Created by antonkazakov on 23.09.16.
 */

public class DocsRepositoryProvider {

    private static DocsRepository docsRepository;

    private DocsRepositoryProvider() {}

    @NonNull
    public static DocsRepository provideGithubRepository() {
        if (docsRepository == null) {
            docsRepository = new DocsRepositoryImpl();
        }
        return docsRepository;
    }

}
