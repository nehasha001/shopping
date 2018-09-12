package com.example.shopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Jersey {
    @RequestMapping(value = "/jersey")
    public ModelAndView viewJersey() {

        ModelAndView modelAndView = new ModelAndView("jersey");
        return modelAndView;

    }


}






/*
package com.example.shopping.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
@Controller
public class Jersey {

//        @Autowired
//        RestTemplate restTemplate;


        @RequestMapping(value = "/jersey", method = RequestMethod.GET)
        public ModelAndView getJersey(HttpServletRequest request) {
            ModelAndView view = new ModelAndView();
            view.setViewName("Jersey");
//            ResponseEntity<Jersey[]> responseEntity = restTemplate.getForEntity("http://localhost:8090/jersey", Jersey[].class);
//            System.out.println("before response jersey method");
//            Jersey[] jersey = (responseEntity.getBody());
//            System.out.println("lenght of the table rows " + jersey.length); //lenght of the table rows
//            request.setAttribute("jersey", Arrays.asList(jersey)); // create list
       */
/* if(responseEntity.getStatusCode() == HttpStatus.OK){
            ModelAndView view = new ModelAndView();
            view.setViewName("hello");
            view.addObject(responseEntity.getBody());
            return view;
        }*//*

//shows data in jsp

            System.out.println("after jersey");
            return view;

        }

        @RequestMapping(value = "/addJersey", method = RequestMethod.GET)
        public String openAdd() {
            System.out.println("before openAdd");
            return "addjerseys";
        }

        @RequestMapping(value = "/deleteJersey", method = RequestMethod.GET)
        public String openDelete() {
            System.out.println("before openDelete");
            return "delete";
        }

        @RequestMapping(value = "/updateJersey", method = RequestMethod.GET)
        public String openUpdate() {
            System.out.println("before update");
            return "update";
        }

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public String createJersey(@ModelAttribute Jersey jersey) {
            System.out.println("before hello");
//            restTemplate.postForEntity("http://localhost:8090/jersey", jersey, Jersey.class);
            System.out.println("after hello");
            return "jerseys";
        }

        @RequestMapping(value = "/del", method = RequestMethod.DELETE)
        public String deleteJersey(@ModelAttribute Jersey jersey) {
            System.out.println("before del");

//            restTemplate.delete("http://localhost:8090/Jerseys", jersey, Jersey.class);
            System.out.println("after del");
            return "hello";
        }

        @RequestMapping(value = "/update", method = RequestMethod.PUT)
        public String updateJersey(@ModelAttribute Jersey jersey) {
            System.out.println("before updateJersey");
//            restTemplate.put("http://localhost:8090/jersey",  Jersey.class);
            System.out.println("after updateJersey");
            return "hello";
        }
    }



*/
