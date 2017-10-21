package com.spring.bean;

public class Estudiante {

    private String nombre;
    private int edad;
    private Direccion direccion;

    
    // Constructores
    // Sin argumentos
    public Estudiante() {
    }

    public Estudiante(int edad) {
        this.edad = edad;
    }

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }
    
    public Estudiante(Direccion direccion) {
        this.direccion = direccion;
    }

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    

    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
    // Representacion textual de los valores de la clase...
    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + '}';
    }

}
