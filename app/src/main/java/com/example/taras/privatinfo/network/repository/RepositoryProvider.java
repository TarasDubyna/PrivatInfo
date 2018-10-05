package com.example.taras.privatinfo.network.repository;

import com.example.taras.privatinfo.network.DataRepository;

public class RepositoryProvider {

    private static Repository sRepository;

    public static Repository getRepository(){
        if (sRepository == null){
            sRepository = new DataRepository();
        }
        return sRepository;
    }
}
