package com.omnirio.service;

import com.omnirio.dao.DaoInterface;
import com.omnirio.model.Account;
import com.omnirio.model.CustomResponse;
import com.omnirio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    @Qualifier("InMemory")
    private DaoInterface dao;

    public CustomResponse getAllAccounts(){

        return dao.getAllAccounts();
    }

    public CustomResponse getAccount(String accountID){

        return dao.getAccount(accountID);
    }

    public CustomResponse createAccount(Account account){

        return dao.createAccount(account);
    }




}
