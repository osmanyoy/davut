package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.services.MyPersonManager;

@RestController
public class MyRestWS {

    @Autowired
    private MyPersonManager mpm;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    //    @GetMapping("/hello2/{isim}")
    //    public String hello(@PathVariable("isim") final String name,
    //                        @RequestHeader("soyisim") final String surname,
    //                        @RequestParam("yas") final int age) {
    //        return ("Hello " + name + " " + surname + " " + age);
    //    }
    //
    //    @RequestMapping(method = RequestMethod.POST,
    //                    consumes = {
    //                                 MediaType.APPLICATION_JSON_VALUE,
    //                                 MediaType.APPLICATION_XML_VALUE
    //                    },
    //                    produces = {
    //                                 MediaType.APPLICATION_JSON_VALUE,
    //                                 MediaType.APPLICATION_XML_VALUE
    //                    },
    //                    value = "/hello3")
    //    public MyPerson getMyPerson(@Validated @RequestBody final MyPerson myPersonParam) {
    //        String nameLoc = myPersonParam.getName();
    //        myPersonParam.setName(nameLoc + "test");
    //        if (myPersonParam.getAge() > 40) {
    //            throw new IllegalArgumentException("test");
    //        }
    //        return myPersonParam;
    //    }
    //
    //    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
    //    @ExceptionHandler(value = IllegalArgumentException.class)
    //    public String expHandler(final IllegalArgumentException ill) {
    //        return "Error";
    //    }
    //
    //
    //    @RequestMapping(method = RequestMethod.POST,
    //                    consumes = {
    //                                 MediaType.APPLICATION_JSON_VALUE,
    //                                 MediaType.APPLICATION_XML_VALUE
    //                    },
    //                    produces = {
    //                                 MediaType.APPLICATION_JSON_VALUE,
    //                                 MediaType.APPLICATION_XML_VALUE
    //                    },
    //                    value = "/hello3")
    //    public ResponseEntity<?> getMyPerson2(@RequestBody final MyPerson myPersonParam) {
    //        this.mpm.saveMyPerson(myPersonParam);
    //        String nameLoc = myPersonParam.getName();
    //        myPersonParam.setName(nameLoc + "test");
    //        if (myPersonParam.getAge() > 40) {
    //            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
    //                                 .body("Error oldu");
    //        }
    //        return ResponseEntity.ok(myPersonParam);
    //    }

}
