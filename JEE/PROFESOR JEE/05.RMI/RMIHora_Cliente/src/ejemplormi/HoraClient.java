package ejemplormi;


import java.rmi.*;

public class HoraClient {

    public static void main(String[] args) {
        try {
              HoraItfz hs  = (HoraItfz) Naming.lookup("rmi://localhost:1099/Hora");            
              System.out.println("Objeto devuelto de lookup(): " + hs);
              
              String tempS = hs.getHora();
              System.out.println( tempS);
              
         } catch (Exception e) {
             System.out.println("Error en cliente " + e);
        }
    }
}

