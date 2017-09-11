/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ch.patino
 */
@RunWith(Arquillian.class)
public class HuecoPersistenceTest {
    
    @Inject
    private HuecoPersistence huecoPersistence;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los m�todos que se est�n probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

     /**
     *
     */
    private List<HuecoEntity> data = new ArrayList<HuecoEntity>();
	
    //persistence: es el objeto de la clase que se va a probar. El contenedor inyectar� una instancia de esta clase.
    //em: un EntityManager para verificar los datos directamente sobre la base de datos
    //utx: un UserTransactions para manipular los datos directamente sobre la base de datos
    //data: este arreglo contendr� el conjunto de datos de prueba
	
	
	
    public HuecoPersistenceTest()
    {
		
    }
	
	/**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyecci�n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
	{
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HuecoEntity.class.getPackage())
                .addPackage(HuecoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
    /**
     * Configuraci�n inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() throws Exception {
    }
    
     /**
     * Limpia las tablas que est�n implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from CompanyEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            HuecoEntity entity = factory.manufacturePojo(HuecoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una calificacion.
     */
    @Test
    public void createCalificacionTest()
    {
        PodamFactory factory = new PodamFactoryImpl();
        HuecoEntity newEntity = factory.manufacturePojo(HuecoEntity.class);
        HuecoEntity result = huecoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        HuecoEntity entity = em.find(HuecoEntity.class,result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de Califiaciones.
     */
    @Test
    public void getCalificacionesTest()
    {
        List<HuecoEntity> list = huecoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(HuecoEntity ent : list)
        {
            boolean found = false;
            for(HuecoEntity entity : data)
            {
                if(ent.getId().equals(entity.getId()))
                {
                    found= true;
                }
            }
            
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar una calificacion.
     */
    @Test
    public void getCalificacionTest()
    {
        HuecoEntity entity = data.get(0);
        HuecoEntity newEntity = huecoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    /**
     * prueba para eliminar una calificacion.
     */
    @Test
    public void deleteCalificacionTest()
    {
        HuecoEntity entity = data.get(0);
        huecoPersistence.delete(entity.getId());
        HuecoEntity deleted = em.find(HuecoEntity.class,entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateCalificacionTest()
    {
        HuecoEntity entity = data.get(0);
        PodamFactory factory  = new PodamFactoryImpl();
        HuecoEntity newEntity = factory.manufacturePojo(HuecoEntity.class);
        
        newEntity.setId(entity.getId());
        
        huecoPersistence.update(newEntity);
        
        HuecoEntity resp = em.find(HuecoEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of create method, of class CalificacionPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        fail("testCreate");
    }

    /**
     * Test of update method, of class CalificacionPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        fail("testUpdate");
    }

    /**
     * Test of delete method, of class CalificacionPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        fail("testDelet");
    }

    /**
     * Test of find method, of class CalificacionPersistence.
     */
    @Test
    public void testFind() throws Exception {
        fail("testFind");
    }

    /**
     * Test of findAll method, of class CalificacionPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        fail("testFindAll");
    }
    
    
}
