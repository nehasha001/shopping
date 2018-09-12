package com.example.shopping.controllers;


import com.example.shopping.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getOrders(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("orders");
        ResponseEntity<Order[]> responseEntity =restTemplate.getForEntity("http://localhost:8092/orders", Order[].class);
        System.out.println("before response order method");
        Order[] o = (responseEntity.getBody());
        System.out.println("lenght of the table rows " + o.length); //lenght of the table rows
        request.setAttribute("o", Arrays.asList(o));
        System.out.println("after arrays list");
        return view;

    }
    /* @RequestMapping(value = "/orderSave", method = RequestMethod.POST)
     public String createOrder(@ModelAttribute Order o) {
         System.out.println("before order");
         restTemplate.postForEntity("http://localhost:8092/orders",o, Order.class);
         System.out.println("after order");
         return "adminhome";
     }*/
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminhome() {
        System.out.println("before adminhome");
        return "adminhome";
    }
    /*@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String openAdd() {
        System.out.println("before openAdd");
        return "addorder";
    }*/
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    public String openDelete() {
        System.out.println("before openDelete");
        return "deleteorder";
    }
    @RequestMapping(value = "/delor", method = RequestMethod.GET)
    public ModelAndView deleteOrder(@ModelAttribute Order order, HttpServletRequest request){
        System.out.println("before delor" + order);
        String url = "http://localhost:8092/orders?id=";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("id", order.getOid());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Order> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.DELETE,
                entity,
                Order.class);

        request.setAttribute("a",  response.getBody());
        /*restTemplate.getForEntity("http://localhost:8092//ordersid", Order.class);*/
      /*  System.out.println("before response order method");
        return "orders";*/
        ModelAndView view = new ModelAndView();
        System.out.println("if orders method");
        view.setViewName("orders");
        return view;
    }
    @RequestMapping(value = "/updateOrder", method = RequestMethod.GET)
    public String openUpdate() {
        System.out.println("before update");
        return "updateorder";
    }
    @RequestMapping(value = "/uporder", method = RequestMethod.PUT)
    public String updateCell(@ModelAttribute Order o) {
        System.out.println("before updateCell");
        restTemplate.put("http://localhost:8092/cell",o, Order.class);
        System.out.println("after updateCell");
        return "adminhome";
    }
}
