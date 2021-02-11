package com.omnirio.util;

import com.omnirio.model.Account;
import com.omnirio.model.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Utilities {

    public static final String USER_URL = "https://userrolespringbootapp.herokuapp.com/omnirio/user";

    public static String getCurrentDate(){
        Date date = new Date();
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (Exception ex) {
            handleExceptions(ex);
        }
        return date != null;
    }

    public static String generateUniqueID() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

    public static StringBuilder fetchResponseString(HttpResponse response) {
        BufferedReader rd = null;
        StringBuilder result = new StringBuilder();
        if (response == null) {
            return result;
        }
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (IOException e) {
            handleExceptions(e);
        }
        return result;
    }

    public static User getUser(String userID) {

        try {

            Map<String, Object> res = new HashMap<>();

            String getURL = USER_URL + "/" + userID;

            HttpClient clientUpdate = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(getURL);

            HttpResponse httpResponse = clientUpdate.execute(httpGet);

            res.put("response", String.valueOf(httpResponse));
            if (httpResponse == null || httpResponse.getStatusLine() == null || httpResponse.getEntity() == null) {
                return null;
            }

            int status = Integer.parseInt(String.valueOf(httpResponse.getStatusLine().getStatusCode()));
            StringBuilder buffer1 = fetchResponseString(httpResponse);

            if (status >= 200 && status < 300) {
                JSONObject buffer = new JSONObject(buffer1.toString());
                return jsonToUser(buffer.getJSONObject("User"));
            } else {
                return null;
            }
        }catch (Exception e){
            handleExceptions(e);
            return null;
        }

    }

    public static User createDefaultUser(User user) {

        try {
            Map<String, Object> res = new HashMap<>();

            String createURL = USER_URL;

            HttpClient clientUpdate = new DefaultHttpClient();
            HttpPost post = new HttpPost(createURL);

            JSONObject payload = new JSONObject();

            payload = user.getBranch() == null ? payload : payload.put("branch", user.getBranch());
            payload = user.getDob() == null ? payload : payload.put("dob", user.getDob());
            payload = user.getGender() == null ? payload : payload.put("gender", user.getGender());
            payload = user.getPhoneNumber() == null ? payload : payload.put("phoneNumber", user.getPhoneNumber());
            payload = user.getUserName() == null ? payload : payload.put("userName", user.getUserName());

            StringEntity requestEntity = new StringEntity(payload.toString(), ContentType.APPLICATION_JSON);
            post.setEntity(requestEntity);

            HttpResponse httpResponse = clientUpdate.execute(post);

            res.put("response", String.valueOf(httpResponse));
            if (httpResponse == null || httpResponse.getStatusLine() == null || httpResponse.getEntity() == null) {
                return null;
            }

            int status = Integer.parseInt(String.valueOf(httpResponse.getStatusLine().getStatusCode()));
            StringBuilder buffer1 = fetchResponseString(httpResponse);

            if (status >= 200 && status < 300) {
                JSONObject buffer = new JSONObject(buffer1.toString());
                return jsonToUser(buffer.getJSONObject("User"));
            } else {
                return null;
            }
        }catch (Exception e){
            handleExceptions(e);
            return null;
        }

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

    public static boolean handleExceptions(Exception e){

        // Do something with exceptions
        return true;

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

    public static JSONObject userToJson(User user) {

        JSONObject object = new JSONObject();
        try {

            object = user.getUserID() != null ? object.put("userID", user.getUserID()) : object;
            object = user.getBranch() != null ? object.put("branch", user.getBranch()) : object;

            object = user.getDob() != null ? object.put("dob", user.getDob()) : object;
            object = user.getGender() != null ? object.put("gender", user.getGender()) : object;
            object = user.getPhoneNumber() != null ? object.put("phoneNumber", user.getPhoneNumber()) : object;
            object = user.getRoleName() != null ? object.put("roleName", user.getRoleName()) : object;

            object = user.getUserName() != null ? object.put("userName", user.getUserName()) : object;

        } catch (Exception e) {

        }
        return object;
    }

    public static User jsonToUser(JSONObject jsonObject) {

        User user = new User();

        try {
            user.setUserID(jsonObject.has("userID") ? jsonObject.getString("userID") : null);
            user.setBranch(jsonObject.has("branch") ? jsonObject.getString("branch") : null);
            user.setDob(jsonObject.has("dob") ? jsonObject.getString("dob") : null);
            user.setGender(jsonObject.has("gender") ? jsonObject.getString("gender") : null);
            user.setPhoneNumber(jsonObject.has("phoneNumber") ? jsonObject.getString("phoneNumber") : null);
            user.setRoleName(jsonObject.has("roleName") ? jsonObject.getString("roleName") : null);
            user.setUserName(jsonObject.has("userName") ? jsonObject.getString("userName") : null);

        } catch (Exception e) {

        }

        return user;
    }

}
