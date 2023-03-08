package com.example.clientapirest.controlador;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {

    @RequestMapping("/")
    public ModelAndView raiz() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/clientes")
    public ModelAndView clientes() {
        ModelAndView mv = new ModelAndView();
        String url = "http://localhost:8081/clientes/todos";
        RestTemplate rest = new RestTemplate();
        Cliente[] arrayClientes = rest.getForObject(url, Cliente[].class);
        mv.addObject("clientes",arrayClientes);
        mv.setViewName("clientes");
        return mv;
    }

    @RequestMapping("clientes/new")
    public ModelAndView newCliente() {
        ModelAndView mv = new ModelAndView();
        Cliente c = new Cliente();
        c.setNif("");
        c.setNombre("");
        c.setDomicilio("");
        c.setTlf("");
        c.setCiudad("Madrid");
        mv.addObject("cliente", c);
        mv.setViewName("newcliente");
        return mv;
    }
    @RequestMapping("clientes/new/guardar")
    public String guardarNewCliente(Cliente c) {
        ModelAndView mv = new ModelAndView();
        String url = "http://localhost:8081/clientes/nuevo";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Cliente> httpEntity = new HttpEntity<Cliente>(c,headers);
        ResponseEntity<String> respuesta =
                rest.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(respuesta);
        return "redirect:/clientes";
    }

    @RequestMapping("clientes/edit")
    public ModelAndView editCliente(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String nif = request.getParameter("nif");
        String url = "http://localhost:8081/clientes/"+nif;
        RestTemplate rest = new RestTemplate();
        Cliente c = rest.getForObject(url, Cliente.class);
        mv.addObject("cliente", c);
        mv.setViewName("editcliente");
        return mv;
    }

    @RequestMapping("clientes/edit/guardar")
    public String guardarEditCliente(Cliente c) {
        ModelAndView mv = new ModelAndView();
        String url = "http://localhost:8081/clientes/modificar";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Cliente> httpEntity = new HttpEntity<Cliente>(c,headers);
        ResponseEntity<String> respuesta =
                rest.exchange(url, HttpMethod.PUT, httpEntity, String.class);


        System.out.println(respuesta);
        return "redirect:/clientes";
    }







}
