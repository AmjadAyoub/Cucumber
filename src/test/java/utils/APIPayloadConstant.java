package utils;

import org.json.JSONObject;

public class APIPayloadConstant {

    public static String createEmployeePayload(){
        String createEmployeePayload =
                "{\n" +
                        "  \"emp_firstname\": \"Bilal\",\n" +
                        "  \"emp_lastname\": \"Kim\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1986-05-22\",\n" +
                        "  \"emp_status\": \"Unknown\",\n" +
                        "  \"emp_job_title\": \"Tester lead\"\n" +
                        "}";
        return createEmployeePayload;

    }

    public static String createEmployeeJsonBody(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Bilal");
        obj.put("emp_lastname", "Kim");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1986-05-22");
        obj.put("emp_status", "Unknown");
        obj.put("emp_job_title", "Tester lead");

        return obj.toString();
    }

    public static String createEmployeePayloadDynamic(String firstname, String lastname, String middlename,
                                                      String gender, String dob,
                                                      String empStatus, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();


    }

    public static String adminPayload(){
        String adminPayload =
                "{\n" +
                        "  \"email\": \"Amjad@test.com\",\n" +
                        "  \"password\": \"Test@123\"\n" +
                        "}";
        return adminPayload;
    }
}
