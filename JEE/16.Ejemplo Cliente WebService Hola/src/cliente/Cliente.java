package cliente;

public class Cliente {

    public static void main(String[] args) {
        String nombre = "Juan Francisco";
        String respuesta = saludar(nombre);
        System.out.println("La respuesta fue : '" + respuesta + "'.");
       
        
    }

    private static String saludar(java.lang.String nombre) {
        cws.SaludoWS_Service service = new cws.SaludoWS_Service();
        cws.SaludoWS port = service.getSaludoWSPort();
        return port.saludar(nombre);
    }

}
