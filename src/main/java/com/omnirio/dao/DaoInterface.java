package com.omnirio.dao;


import com.omnirio.model.Account;
import com.omnirio.model.CustomResponse;
import com.omnirio.model.User;

public interface DaoInterface {

    CustomResponse getAllAccounts();
    CustomResponse getAccount(String accountID);
    CustomResponse createAccount(Account account);

    CustomResponse updateAccount(Account account);
    CustomResponse deleteAccount(String accountID);

    CustomResponse getUserAllAccounts(String userID);
}
