package dao;

import entidad.Empleado;
import excepcion.EmpleadoNoEncontradoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.spi.PersistenceUnitTransactionType;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_DRIVER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_PASSWORD;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_URL;
import static org.eclipse.persistence.config.PersistenceUnitProperties.JDBC_USER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.LOGGING_LEVEL;
import static org.eclipse.persistence.config.PersistenceUnitProperties.LOGGING_SESSION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.LOGGING_THREAD;
import static org.eclipse.persistence.config.PersistenceUnitProperties.LOGGING_TIMESTAMP;
import static org.eclipse.persistence.config.PersistenceUnitProperties.TARGET_SERVER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.TRANSACTION_TYPE;
import org.eclipse.persistence.config.TargetServer;

public class EmpleadoDaoImpl
        implements EmpleadoDao {

    private final EntityManagerFactory emf;

    public EmpleadoDaoImpl() {
        Map properties = new HashMap();

        // Ensure RESOURCE_LOCAL transactions is used.
        properties.put(TRANSACTION_TYPE,
                PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

        // Configure the internal connection pool
        properties.put(JDBC_DRIVER, "org.apache.derby.jdbc.ClientDriver");
        properties.put(JDBC_URL, "jdbc:derby://localhost:1527/examenDic2015");
        properties.put(JDBC_USER, "oracle");
        properties.put(JDBC_PASSWORD, "welcome1");

        // Configure logging. FINE ensures all SQL is shown
        properties.put(LOGGING_LEVEL, "FINE");
        properties.put(LOGGING_TIMESTAMP, "false");
        properties.put(LOGGING_THREAD, "false");
        properties.put(LOGGING_SESSION, "false");

        // Ensure that no server-platform is configured
        properties.put(TARGET_SERVER, TargetServer.None);
        System.out.println(properties.toString());
        emf = Persistence.createEntityManagerFactory("empresaPU", properties);
    }

    @Override
    public Empleado leeEmpleado(long id) throws EmpleadoNoEncontradoException {
        EntityManager em = emf.createEntityManager();
        Empleado emp = em.find(Empleado.class, id);
        if (emp == null) {
            throw new EmpleadoNoEncontradoException("" + id);
        }

        return emp;
    }

    @Override
    public void borraEmpleado(long id) throws EmpleadoNoEncontradoException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Empleado emp = em.find(Empleado.class, id);
        if (emp == null) {
            throw new EmpleadoNoEncontradoException("" + id);
        }

        em.remove(emp);

        em.getTransaction().commit();
    }

    @Override
    public Empleado creaEmpleado(Empleado emp) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        return emp;
    }

    @Override
    public List<Empleado> leeTodosLosEmpleados() {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT e FROM Empleado e";
        TypedQuery<Empleado> query = em.createQuery(jpql, Empleado.class);

        return query.getResultList();
    }
}
