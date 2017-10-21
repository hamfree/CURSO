package ejemplormi;


import java.rmi.*;

public class HoraServer  {
    public static void main(String[] args)  {

        try {
        
            HoraImpl miHora = new HoraImpl();

            // Naming.rebind("Hora",miHora); // tb valido
            Naming.rebind("//localhost:1099/Hora",miHora); // Registrado obj servant. toStub

            System.out.println("Servidor arrancado ...");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

