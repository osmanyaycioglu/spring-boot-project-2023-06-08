package com.spring.training.springbootproject.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.training.springbootproject.rest.models.MyResponse;
import com.spring.training.springbootproject.rest.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/my/first/rest")
public class MyFirstRest {

    // @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "Hello GET";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Hello POST";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "Hello PUT";
    }

    @PatchMapping("/hello")
    public String hello4() {
        return "Hello PATCH";
    }

    @DeleteMapping("/hello")
    public String hello5() {
        return "Hello DELETE";
    }

    @GetMapping("/hello2/{xyz}/static/{abc}")
    public String hellop2(@PathVariable("xyz") String name,
                          @PathVariable("abc") String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @GetMapping("/hello3")
    public String hellop3(@RequestParam("xyz") String name,
                          @RequestParam("abc") String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @GetMapping("/hello4/{xyz}")
    public String hellop4(@PathVariable("xyz") String name,
                          @RequestParam("abc") String surname) {
        return "Hello 4 " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String hellop5(@RequestHeader("xyz") String name,
                          @RequestHeader("abc") String surname) {
        return "Hello 5 " + name + " " + surname;
    }

    @GetMapping("/hello6")
    public String hellop6(@MatrixVariable("xyz") String name,
                          @MatrixVariable("abc") String surname) {
        return "Hello 6 " + name + " " + surname;
    }

    @PostMapping("/hello7")
    public String hellop7(@ModelAttribute("xyz") String name,
                          @ModelAttribute("abc") String surname,
                          HttpServletRequest request) {
        return "Hello 7 " + name + " " + surname;
    }

    @PostMapping("/hello8")
    public MyResponse hellop8(@RequestBody Person personParam) {
        return MyResponse.builder()
                         .withResponse("Hello 8 " + personParam)
                         .withMessage("SUCCESS")
                         .withCode(100)
                         .build();
    }

    @PostMapping(value = "/hello9", consumes = {MediaType.APPLICATION_JSON_VALUE,
                                                MediaType.APPLICATION_XML_VALUE
    }, produces = {MediaType.APPLICATION_JSON_VALUE,
                   MediaType.APPLICATION_XML_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public MyResponse hellop9(@RequestBody Person personParam) {
        return MyResponse.builder()
                         .withResponse("Hello 8 " + personParam)
                         .withMessage("SUCCESS")
                         .withCode(100)
                         .build();
    }

    @PostMapping(value = "/hello10")
    public Person hellop10(HttpServletRequest httpRequestParam) throws Exception {
        String             xyzLoc          = httpRequestParam.getParameter("xyz");
        ServletInputStream inputStreamLoc  = httpRequestParam.getInputStream();
        ObjectMapper       objectMapperLoc = new ObjectMapper();
        try {
            Person personLoc = objectMapperLoc.readValue(inputStreamLoc,
                                                         Person.class);
            return personLoc;
        } catch (IOException eParam) {
            throw new RuntimeException(eParam);
        }
    }

    @PostMapping("/hello11")
    public ResponseEntity<MyResponse> hellop11(@RequestBody Person personParam) {
        return ResponseEntity.status(215)
                             .header("testHeader",
                                     "testValue")
                             .body(MyResponse.builder()
                                             .withResponse("Hello 8 " + personParam)
                                             .withMessage("SUCCESS")
                                             .withCode(100)
                                             .build());
    }

    @PostMapping("/hello12/{op}")
    public ResponseEntity<?> hellop12(@PathVariable("op") String op,
                                      HttpServletRequest httpRequestParam) {
        switch (op) {

            case "add":
            default:
                return ResponseEntity.status(215)
                                     .header("testHeader",
                                             "testValue")
                                     .body(MyResponse.builder()
                                                     .withResponse("Hello 8 ")
                                                     .withMessage("SUCCESS")
                                                     .withCode(100)
                                                     .build());

        }
    }

}
