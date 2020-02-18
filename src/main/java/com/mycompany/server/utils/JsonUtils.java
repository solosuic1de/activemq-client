package com.mycompany.server.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.server.constant.Url;
import com.mycompany.server.model.entity.Employee;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class JsonUtils {
    private static final String MESSAGE_ID = "message_id";
    private static final String MESSAGE_URL = "message_url";
    private static final String MESSAGE_RESPONSE = "message_response";
    private static final String MESSAGE_EMPLOYEE_IDENTITY = "employee_id";
    private static final String MESSAGE_ERR = "error_cause";
    private static final String MESSAGE_VALUE = "message_value";

    public static String getAllMessage() {
        JSONObject object = new JSONObject();
        object.put(MESSAGE_ID, generateId());
        object.put(MESSAGE_URL, Url.GET_ALL.getUrl());
        return object.toString();
    }

    private JsonUtils() {
    }

    public static String getByIdMessage(int id) {
        JSONObject object = new JSONObject();
        object.put(MESSAGE_ID, generateId());
        object.put(MESSAGE_URL, Url.GET_BY_ID.getUrl());
        object.put(MESSAGE_EMPLOYEE_IDENTITY, id);
        return object.toString();
    }

    public static String addMessage(Employee employee) {
        JSONObject object = new JSONObject();
        JSONObject employeeObj = new JSONObject(employee);
        object.put(MESSAGE_URL, Url.ADD_EMPLOYEE.getUrl());
        object.put(MESSAGE_ID, generateId());
        object.put(MESSAGE_VALUE, employeeObj);
        return object.toString();
    }

    public static String deleteMessage(int id) {
        JSONObject object = new JSONObject();
        object.put(MESSAGE_ID, generateId());
        object.put(MESSAGE_URL, Url.DELETE.getUrl());
        object.put(MESSAGE_EMPLOYEE_IDENTITY, id);
        return object.toString();
    }

    private static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String getMessageId(String message) {
        JSONObject object = new JSONObject(message);
        return object.getString(MESSAGE_ID);
    }

    public static String getMessageResponse(String message) throws NoSuchElementException {
        JSONObject object = new JSONObject(message);
        String error;
        try {
            error = object.getString(MESSAGE_ERR);
        } catch (JSONException e) {
            return object.getJSONArray(MESSAGE_RESPONSE).toString();
        }
        throw new NoSuchElementException(error);

    }

    public static List<Employee> getList(String message) {
        Type listType = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        return new Gson().fromJson(message, listType);
    }

    public static Employee getEmployee(String message) {
        return getList(message).get(0);
    }

}
