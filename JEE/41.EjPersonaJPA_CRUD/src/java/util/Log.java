/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author curso
 */
public class Log {
    private Log(){}
    
    /**
     * Muestra una salida por pantalla de mensajes de depuración
     * @param clazz
     * @param msg
     * @param tipo
     * @param metodo
     * @param params
     * @param resultado 
     */
    private static void log(String clazz,String msg, String tipo, String metodo, String params, Object resultado){
        String salida;
        
        if (tipo == null){
            salida = "..." + msg;
        } else if ( tipo.equalsIgnoreCase("inicio")){
            salida = clazz + "." + metodo + "(" + params + ") - INICIO ";
        } else if (tipo.equalsIgnoreCase("final")){
            salida = clazz + "." + metodo + "() - Devuelve :" + resultado.toString() + " - FINAL ";
        } else {
            salida = "¿?";
        }
        System.out.println(salida);
    }
}
