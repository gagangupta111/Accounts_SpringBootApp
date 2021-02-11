package com.omnirio.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public enum Errors {

    INVALID_ACCOUNT_ID(405, "INVALID_ACCOUNT_ID", "");

    private int code;
    private String message;
    private String details;

    Errors(int code, String message, String details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public JSONObject AsJson(){
        JSONObject object = new JSONObject();
        try {
            object.put("code", code);
            object.put("message", message);
            object.put("details", details);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    public Map<String, Object> AsMap(){
        Map<String, Object> object = new HashMap<>();
        object.put("code", code);
        object.put("message", message);
        object.put("details", details);
        return object;
    }

}
