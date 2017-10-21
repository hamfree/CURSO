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
public class Juanfrancisco_1App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testEmpleado();
        testEmpresa();
    }

    private static void testEmpleado() {
        System.out.println("\ntestEmpleado() - INICIO");
        Empleado emp = new Empleado("Juan Francisco", 46);
        Empleado otroEmp = null;
        EmpleadoDao dao = new EmpleadoDaoImpl();
        System.out.println("\n1. Creando el empleado :" + emp.toString());
        emp = dao.creaEmpleado(emp);
        System.out.println("\n1. Empleado devuelto por el DAO: " + emp.toString());
        System.out.println("\n2. Buscando el empleado creado con id : " + emp.getId());
        otroEmp = dao.leeEmpleado(emp.getId());
        System.out.println("\n2. Resultado de la busqueda : " + otroEmp.toString());
        System.out.println("\n3. Listar todos los empleados que están en la BD.");
        List<Empleado> empleados = dao.leeTodosLosEmpleados();
        for (Empleado e : empleados) {
            System.out.println(e.toString() + "\n");
        }
        System.out.println("testEmpleado() - FIN");
    }

    private static void testEmpresa() {
        System.out.println("\ntestEmpresa() - INICIO");
        Empresa corp1 = new Empresa("Microsoft");
        Empresa corp2 = new Empresa("Google");
        EmpresaDao dao = new EmpresaDaoImpl();
        System.out.println("\n1. Creando las dos empresas...");
        dao.creaEmpresa(corp1);
        dao.creaEmpresa(corp2);
        System.out.println("\n2. Mostrando todas las empresas en la bd...");
        List<Empresa> todasLasEmpresas = dao.getTodasLasEmpresas();
        for (Empresa e : todasLasEmpresas) {
            System.out.println(e.toString());
        }
        System.out.println("testEmpresa() - FIN");
    }

}
