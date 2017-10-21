
public class Todos
{
    public static void main( String[] args )
    {
//        com.spring.apps.factory.ClienteWebApp.main( null );
//        com.spring.apps.factory.ConsolaApp.main( null );
//        com.spring.apps.factory.InventarioNocturnoApp.main( null );
//        com.spring.apps.factory.MovilApp.main( null );

        com.spring.apps.ioc.ClienteWebApp.main( null );
        com.spring.apps.ioc.ConsolaApp.main( null );
        com.spring.apps.ioc.InventarioNocturnoApp.main( null );
        com.spring.apps.ioc.MovilApp.main( null );

        System.out.format( "%n%n%n%n" );

        com.spring.apps.manual.ClienteWebApp.main( null );
        com.spring.apps.manual.ConsolaApp.main( null );
        com.spring.apps.manual.InventarioNocturnoApp.main( null );
        com.spring.apps.manual.MovilApp.main( null );
    }
}
