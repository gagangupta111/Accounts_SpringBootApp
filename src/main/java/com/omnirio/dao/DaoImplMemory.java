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

        map.put("Account", array);
        customResponse.setInfo(map);
        return customResponse;
    }

    @Override
    public CustomResponse getAccount(String accountID) {

        Account account = accountID_Accounts.get(accountID);
        if (accountID_Accounts.get(accountID) == null){
            CustomResponse customResponse = new CustomResponse();
            customResponse.setMessage("Account Not Found!");
            customResponse.setSuccess(false);
            return customResponse;
        }

        CustomResponse customResponse = new CustomResponse();
        customResponse.setMessage("All Accounts!");
        customResponse.setSuccess(true);

        Map<String, Object> map = new HashMap<>();
        map.put("Account", Utilities.accountToJson(accountID_Accounts.get(accountID)));
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

    @Override
    public CustomResponse updateAccount(Account account) {

        Account updatedAccount = null;

        for (Account loopAccount : accountID_Accounts.values()){
            if (loopAccount.getAccountID().equalsIgnoreCase(account.getAccountID())){

                loopAccount.setAccountID(account.getAccountID());
                loopAccount.setOpenDate(account.getOpenDate());
                loopAccount.setFlagAge(account.getFlagAge());
                loopAccount.setCustomerID(account.getCustomerID());
                loopAccount.setBranch(account.getBranch());
                loopAccount.setAccountType(account.getAccountType());
                updatedAccount = loopAccount;
                break;
            }
        }
        if (updatedAccount == null){
            CustomResponse customResponse = new CustomResponse();
            customResponse.setMessage("Account Not Found!");
            customResponse.setSuccess(false);
            return customResponse;
        }else {
            CustomResponse customResponse = new CustomResponse();
            customResponse.setMessage("Account Updated!");
            customResponse.setSuccess(true);

            Map<String, Object> map = new HashMap<>();
            map.put("Account", Utilities.accountToJson(updatedAccount));
            customResponse.setInfo(map);
            return customResponse;
        }
    }

    @Override
    public CustomResponse deleteAccount(String accountID) {

        Account deleted = accountID_Accounts.get(accountID);
        if (accountID_Accounts.get(accountID) == null){
            CustomResponse customResponse = new CustomResponse();
            customResponse.setMessage("Account Not Found!");
            customResponse.setSuccess(false);
            return customResponse;
        }else {
            accountID_Accounts.remove(accountID);
            CustomResponse customResponse = new CustomResponse();
            customResponse.setMessage("Account Deleted!");
            customResponse.setSuccess(true);

            Map<String, Object> map = new HashMap<>();
            map.put("Account", Utilities.accountToJson(deleted));
            customResponse.setInfo(map);
            return customResponse;
        }
    }

    public CustomResponse getUserAllAccounts(String userID){

        JSONArray jsonArray = new JSONArray();
        for (Account account : accountID_Accounts.values()){
            jsonArray.put(Utilities.accountToJson(account));
        }

        CustomResponse customResponse = new CustomResponse();
        customResponse.setMessage("Account Found!");
        customResponse.setSuccess(true);

        Map<String, Object> map = new HashMap<>();
        map.put("Account", jsonArray);
        customResponse.setInfo(map);
        return customResponse;

    }
}
