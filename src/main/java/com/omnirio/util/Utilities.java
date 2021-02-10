package com.omnirio.util;

import com.omnirio.model.Account;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Utilities {

    public static String generateUniqueID() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

    public static JSONObject accountToJson(Account account) {

        JSONObject object = new JSONObject();
        try {

            object = account.getAccountID() != null ? object.put("accountID", account.getAccountID()) : object;
            object = account.getAccountType() != null ? object.put("accountType", account.getAccountType()) : object;
            object = account.getBranch() != null ? object.put("branch", account.getBranch()) : object;
            object = account.getCustomerID() != null ? object.put("customerID", account.getCustomerID()) : object;
            object = account.getFlagAge() != null ? object.put("flagAge", account.getFlagAge()) : object;
            object = account.getOpenDate() != null ? object.put("openDate", account.getOpenDate()) : object;

        } catch (Exception e) {

        }
        return object;
    }

    public static Account jsonToAccount(JSONObject jsonObject) {

        Account account = new Account();

        try {
            account.setAccountID(jsonObject.has("accountID") ? jsonObject.getString("accountID") : null);
            account.setAccountType(jsonObject.has("accountType") ? jsonObject.getString("accountType") : null);
            account.setBranch(jsonObject.has("branch") ? jsonObject.getString("branch") : null);
            account.setCustomerID(jsonObject.has("customerID") ? jsonObject.getString("customerID") : null);
            account.setFlagAge(jsonObject.has("flagAge") ? jsonObject.getString("flagAge") : null);
            account.setOpenDate(jsonObject.has("openDate") ? jsonObject.getString("openDate") : null);
        } catch (Exception e) {

        }
        return account;
    }

}
