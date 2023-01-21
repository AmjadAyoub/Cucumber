package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// to change the order of execution we use fix method order since it is executing in top to bottom
// which is not good because will create error. Create employee should be before get employee
//this method sorters will execute my methods in ascending/alphabetically order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    // one thing to remember
    // base URI - base URL
    //and then using when keyword, we will send the end point


     // URL we got it from swagger
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    // we need to perform CRUD operations

    //get a valid token from postman
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJpYXQiOjE2NzQxNjE4MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDIwNTAyNCwidXNlcklkIjoiNDc2MiJ9." +
            "Bg_Pl_JxySjGcu9Q5jKXUoGHSC9NPgpMMW30WUEHfWI";

    static String employee_id;

    @Test
    public void bgetOneEmployee(){
        // prepare the request
        //to prepare the request, we use request specification
        RequestSpecification request = given().header("Authorization",token).header("Content-Type","applicatoin/json")
                .queryParam("employee_id",employee_id);

        // to hit the end point / to make the request which will return response
       Response response = request.when().get("/getOneEmployee.php");

        //System.out.println(response.asString());

        response.prettyPrint();   // it will print same as sout method

        //verifying the status code
        response.then().assertThat().statusCode(200);

        //using jsonpath method, we are extracting the value from the response body/
        String firstName = response.jsonPath().getString("employee.emp_firstname");
        System.out.println(firstName);

        //first way of assertion
        Assert.assertEquals(firstName,"Bilal");

        //second way of assertion to verify the value in response body using hamcrest matchers
        // enter manually the import class in line 10
        response.then().assertThat().body("employee.emp_firstname", equalTo("Bilal"));

    }

@Test
    public void acreateEmployee(){
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Bilal\",\n" +
                        "  \"emp_lastname\": \"Kim\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1986-05-22\",\n" +
                        "  \"emp_status\": \"Unknown\",\n" +
                        "  \"emp_job_title\": \"Tester lead\"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        //verifying the status code which is 201
        response.then().assertThat().statusCode(201);
        //getting the employee id from the response and use it as static one
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Kim"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("ms"));

        //verify console header: get it from response header in console in postman
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");


    }

    @Test
    public void cupdateEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Ahmad\",\n" +
                        "  \"emp_lastname\": \"Kamal\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1990-11-15\",\n" +
                        "  \"emp_status\": \"probation\",\n" +
                        "  \"emp_job_title\": \"team leader\"\n" +
                        "}");

       Response response = request.when().put("/updateEmployee.php");
       response.prettyPrint();

       // verification
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", employee_id);

        //to hit the end point/ to make the request which will return response
        // we use same get one employee method
        Response response = request.when().get("/getOneEmployee.php");

        // System.out.println(response.asString());
        response.prettyPrint();
        //verifying the status code
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("employee.emp_job_title", equalTo("team leader"));




    }



}
