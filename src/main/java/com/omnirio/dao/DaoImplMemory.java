package com.omnirio.dao;

import com.omnirio.model.Account;
import com.omnirio.model.CustomResponse;
import com.omnirio.model.User;
import com.omnirio.util.Utilities;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("InMemory")
public class DaoImplMemory implements DaoInterface{

    Map<String, User> userID_Users = new HashMap<>();
    Map<String, List<Account>> userID_Accounts = new HashMap<>();
    Map<String, Account> accountID_Accounts = new HashMap<>();

    @Override
    public CustomResponse getAllAccounts() {

        CustomResponse customResponse = new CustomResponse();
        customResponse.setMessage("All Accounts!");
        customResponse.setSuccess(true);

        Map<String, Object> map = new HashMap<>();

        JSONArray array = new JSONArray();
        for (Account account : accountID_Accounts.values()){
            array.put(Utilities.accountToJson(account));
        }

        map.put("Accounts", array);
        customResponse.setInfo(map);
        return customResponse;
    }

    @Override
    public CustomResponse getAccount(String accountID) {

        CustomResponse customResponse = new CustomResponse();
        customResponse.setMessage("All Accounts!");
        customResponse.setSuccess(true);

        Map<String, Object> map = new HashMap<>();
        map.put("Accounts", Utilities.accountToJson(accountID_Accounts.get(accountID)));
        customResponse.setInfo(map);
        return customResponse;
    }

    @Override
    public CustomResponse createAccount(Account account) {
        account.setAccountID(Utilities.generateUniqueID());
        accountID_Accounts.put(account.getAccountID(), account);

        CustomResponse customResponse = new CustomResponse();
        customResponse.setMessage("Account Created!");
        customResponse.setSuccess(true);

        Map<String, Object> map = new HashMap<>();
        map.put("Account", Utilities.accountToJson(account));
        customResponse.setInfo(map);
        return customResponse;
    }
}
