package com.example.clientapirest.controlador;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;


public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String nif;
    @JsonProperty
    private String nombre;
    @JsonProperty
    private String domicilio;
    @JsonProperty
    private String tlf;
    @JsonProperty
    private String ciudad;

    public Cliente() {

    }

    public Cliente(String nif, String ciudad, String domicilio, String nombre, String tlf) {
        super();
        this.nif = nif;
        this.ciudad = ciudad;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.tlf = tlf;
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return this.tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }


}