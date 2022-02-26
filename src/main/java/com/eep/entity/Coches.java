package com.eep.entity;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="coches")
public class Coches {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    private String marca;

    @NotEmpty(message="El modelo no puede estar vacío")
    private String modelo;

    @NotNull(message="El precio no puede estar vacío")
    @Min(value=1000,message="El precio mínimo es de 1000€")
    private double precio;

    @NotEmpty(message="El comentario no puede estar vacío")
    @Size(max=250, message="El comentario no puede exceder los 250 carácteres")
    private String comentarios;

    @NotEmpty(message="El combustible no puede estar vacío")
    private String combustible;

    @NotEmpty(message="La potencia no puede estar vacía")
    private String potencia;

    @NotEmpty(message="El número de puertas no puede estar vacío")
    private String numeropuertas;

    private String rutaimagen;

    public Coches() {
    }

    public Coches(int id, String marca, String modelo, double precio, String comentarios, String combustible, String potencia, String numeropuertas, String rutaimagen) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.comentarios = comentarios;
        this.combustible = combustible;
        this.potencia = potencia;
        this.numeropuertas = numeropuertas;
        this.rutaimagen = rutaimagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getNumeropuertas() {
        return numeropuertas;
    }

    public void setNumeropuertas(String numeropuertas) {
        this.numeropuertas = numeropuertas;
    }

    public String getRutaimagen() {
        return rutaimagen;
    }

    public void setRutaimagen(String rutaimagen) {
        this.rutaimagen = rutaimagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }
}
