/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import dao.EmpresaDao;
import dao.EmpresaDaoImpl;
import entidad.Empleado;
import entidad.Empresa;
import java.util.List;

/**
 *
 * @author curso
 */
public class Juanfrancisco_3App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testEmpresaEmpleado();
        testEmpleadoEmpresa();
    }

    

    private static void testEmpresaEmpleado() {
        /*
         1. Crear dos entidades de tipo Empleado y otra de tipo Empresa.
         2. Asociar los Empleados a la empresa y grabar la Empresa a la BBDD.
         3. Leer la Empresa recién grabada e imprimir los empleados de la empresa.
         */
        System.out.println("\ntestEmpresaEmpleado() - INICIO");
        System.out.println("\n1. Crear dos entidades de tipo Empleado y otra de tipo Empresa.");
        Empleado emp1 = new Empleado("Juan Francisco", 46);
        Empleado emp2 = new Empleado("Jorge Sanz", 32);
        Empresa corp = new Empresa("Spanish Consulting");
        
        System.out.println("\n2. Asociar los Empleados a la empresa y grabar la Empresa a la BBDD.");
        emp1.setEmpresa(corp);
        emp2.setEmpresa(corp);
        corp.contratarEmpleado(emp1);
        corp.contratarEmpleado(emp2);
        
        EmpresaDao dao = new EmpresaDaoImpl();
        dao.creaEmpresa(corp);
        
        System.out.println("\n3. Leer la Empresa recién grabada e imprimir los empleados de la empresa.");
        Empresa miCorporacion = dao.leeEmpresa(corp.getId());
        for (Empleado e : miCorporacion.getEmpleados()){
            System.out.println(e.toString());
        }
        System.out.println("testEmpresaEmpleado() - FINAL");
    }

    private static void testEmpleadoEmpresa() {
        /*
         1. Crear una entidad de tipo Empleado y otra de tipo Empresa y asociarlas.
         2. Grabar en la BBDD el Empleado (no la empresa).
         3. Leer la lista de Empresas de la BBDD y por cada Empresa leída imprimir todos
         sus Empleados. En este punto, hay que comprobar que aparece la Empresa
         creada en este método y que el correspondiente Empleado está en la Empresa.
         */
        System.out.println("\ntestEmpleadoEmpresa() - INICIO");
        System.out.println("\n1. Crear una entidad de tipo Empleado y otra de tipo Empresa y asociarlas.");
        Empleado empleado = new Empleado("Juan", 41);
        Empresa empresa = new Empresa("Spanish Consulting");
        empresa.contratarEmpleado(empleado);
        empleado.setEmpresa(empresa);
        System.out.println(empleado.toString());
        System.out.println(empresa.toString());
        
        System.out.println("\n2. Grabar en la BBDD el Empleado (no la empresa).");
        EmpleadoDao daoEmpleado = new EmpleadoDaoImpl();
        Empleado tmp = daoEmpleado.creaEmpleado(empleado);
        System.out.println("Empleado grabado : " + tmp.toString());
        
        System.out.println("\n3. Leer la lista de Empresas de la BBDD y por cada Empresa leída imprimir todos\n" +
"         sus Empleados");
        EmpresaDao daoEmpresa = new EmpresaDaoImpl();
        List<Empresa> todasLasEmpresas = daoEmpresa.getTodasLasEmpresas();
        for (Empresa e : todasLasEmpresas){
            System.out.println(e.toString());
            for (Empleado emp : e.getEmpleados()){
                System.out.println("\t" + emp.toString());
            }
        }
        System.out.println("testEmpleadoEmpresa() - FINAL");

    }

}
