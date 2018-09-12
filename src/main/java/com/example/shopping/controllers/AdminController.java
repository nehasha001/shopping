package com.example.shopping.controllers;
import com.example.shopping.models.AdminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;



    @Controller
    public class AdminController {
        @Autowired
        RestTemplate restTemplate;

        @RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
        public ModelAndView getAdmins(HttpServletRequest request) {
            ModelAndView view = new ModelAndView();
            view.setViewName("adminlist");
            ResponseEntity<AdminLogin[]> responseEntity = restTemplate.getForEntity("http://localhost:8092/login", AdminLogin[].class);
            System.out.println("before response adminlogin method");
            AdminLogin[] logins = (responseEntity.getBody());
            System.out.println("lenght of the table rows " + logins.length); //lenght of the table rows
            request.setAttribute("logins", Arrays.asList(logins)); // create list
            System.out.println("after adminlogin");
            return view;

        }
        @RequestMapping(value = "/loginprocess", method = RequestMethod.GET)
        public ModelAndView login(@ModelAttribute AdminLogin adminLogin, HttpServletRequest request) {
/*String[] s =new String[2];
        s[0]=request.getParameter("userName");
        System.out.println("user "+s);
        s[1]=request.getParameter("password");
        System.out.println("after enter password"+s);
        System.out.println("after enter password"+s[]);
        System.out.println("at arrays to string : "+Arrays.toString(s));*/
            System.out.println("user "+adminLogin.getUserName()+" "+adminLogin.getPassword());
            String url = "http://localhost:8092/login/{userId}";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("userId", adminLogin.getUserName());

            HttpEntity<?> entity = new HttpEntity<>(headers);

            HttpEntity<AdminLogin> response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    AdminLogin.class);

            request.setAttribute("a",  response.getBody());


        /*        System.out.printlan("before response adminhome method");
AdminLogin[] login1 = (responseEntity.getBody());
if(login1.equals(adminLogin.getPassword())){
    ModelAndView view = new ModelAndView();
    System.out.println("if adminhome method");
    view.setViewName("adminhome");

    *//*view.addObject(responseEntity.getBody());*//*
    return view;
}*/
       /* System.out.println("admin login  "+Arrays.toString(login1));
        System.out.println("lenght of the table rows " + login1.length); //lenght of the table rows
        request.setAttribute("logins", Arrays.asList(login1));
        request.setAttribute("str", Arrays.asList(s));
        System.out.println("admin login  "+login1[0]);*/
            // ModelAndView view = new ModelAndView();

      /*  if (login1!=null){
           System.out.println("after if response adminhome method");
          // view.setViewName("adminhome");
           return "testinguser";
       }
        System.out.println("after response adminhome method");
       return "loginpage";
            }*/
//        if(responseEntity.equals(adminLogin)){
//
//            ModelAndView view = new ModelAndView();
//            System.out.println("if adminhome method");
//            view.setViewName("adminhome");
//            view.addObject(responseEntity.getBody());
//            return view;
//        }

            ModelAndView view = new ModelAndView();
            System.out.println("if adminhome method");
            view.setViewName("adminhome");
            return view;

        }
        @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
        public String openLogin() {
            System.out.println("before openAdd");
            return "loginpage";
        }

        @RequestMapping(value = "/addadmin", method = RequestMethod.GET)
        public String addAdmin() {
            System.out.println("before openAdd");
            return "addadmin";
        }
        @RequestMapping(value = "/deleteadmin", method = RequestMethod.GET)
        public String adminDelete() {
            System.out.println("before openDelete");
            return "deleteadmin";
        }
        @RequestMapping(value = "/logout", method = RequestMethod.GET)
        public String oouLogin() {
            System.out.println("before openAdd");
            return "homepage";
        }
        /*  @RequestMapping(value = "/updateadmin", method = RequestMethod.GET)
          public String openUpdate() {
              System.out.println("before update");
              return "updateadmin";
          }*/
        @RequestMapping(value = "/addlog", method = RequestMethod.POST)
        public String createAdmin(@ModelAttribute AdminLogin adminLogin) {
            System.out.println("before adminLogin");
            restTemplate.postForEntity("http://localhost:8092/login",adminLogin, AdminLogin.class);
            System.out.println("after adminLogin");
            return "adminhome";
        }
   /* @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public String deleteCell(@ModelAttribute Cell cell) {
        System.out.println("before del");

        restTemplate.delete("http://localhost:8092/cell",cell, Cell.class);
        System.out.println("after del");
        return "hello";
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateCell(@ModelAttribute Cell cell) {
        System.out.println("before updateCell");
        restTemplate.put("http://localhost:8092/cell",cell, Cell.class);
        System.out.println("after updateCell");
        return "hello";
    }*/
    }
