package ejemplormi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HoraClient {

    public static void main(String[] args) {
        try {
            HoraItfz hs = (HoraItfz) Naming.lookup("rmi://localhost:1099/Hora");
            System.out.println("Objeto devuelto por el Naming: " + hs);
            String tmp = hs.getHora();
            System.out.println("Resultado de hs.getHora(): " + tmp);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("Error en el cliente :" + e.getLocalizedMessage());
        }
    }
}
