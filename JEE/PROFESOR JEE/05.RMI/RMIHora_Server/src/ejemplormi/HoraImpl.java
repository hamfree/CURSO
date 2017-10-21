package ejemplormi;

// Servant
import java.rmi.*;
import java.rmi.server.*;

// Los objetos remotos deben implementar una interface remota
// y heredar de UnicastRemoteObject que es Serializable
public class HoraImpl extends UnicastRemoteObject
        implements HoraItfz {

    public HoraImpl() throws java.rmi.RemoteException {
        super(); // Constructor de UnicastRemoteObject
    }

    public String getHora() throws RemoteException {
        
        return "La hora es  " + new java.util.Date();
    }
}
