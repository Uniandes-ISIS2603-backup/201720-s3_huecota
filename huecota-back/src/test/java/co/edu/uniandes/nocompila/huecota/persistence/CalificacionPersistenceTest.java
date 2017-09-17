/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.CalificacionEntity;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author le.viana
 */
@RunWith(Arquillian.class)
public class CalificacionPersistenceTest {
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Calificacion, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyecci�n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public CalificacionPersistenceTest (){}
    
     /**
     * Inyecci�n de la dependencia a la clase CalificacionPersistence cuyos m�todos
     * se van a probar.
     */
    @Inject
    private CalificacionPersistence calificacionPersistence;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los m�todos que se est�n probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

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
     *
     */
    private List<CalificacionEntity> data = new ArrayList<CalificacionEntity>();
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CalificacionEntity entity = factory.manufacturePojo(CalificacionEntity.class);

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
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = calificacionPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        CalificacionEntity entity = em.find(CalificacionEntity.class,result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de Califiaciones.
     */
    @Test
    public void getCalificacionesTest()
    {
        List<CalificacionEntity> list = calificacionPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(CalificacionEntity ent : list)
        {
            boolean found = false;
            for(CalificacionEntity entity : data)
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
        CalificacionEntity entity = data.get(0);
        CalificacionEntity newEntity = calificacionPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    /**
     * prueba para eliminar una calificacion.
     */
    @Test
    public void deleteCalificacionTest()
    {
        CalificacionEntity entity = data.get(0);
        calificacionPersistence.delete(entity.getId());
        CalificacionEntity deleted = em.find(CalificacionEntity.class,entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateCalificacionTest()
    {
        CalificacionEntity entity = data.get(0);
        PodamFactory factory  = new PodamFactoryImpl();
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        
        newEntity.setId(entity.getId());
        
        calificacionPersistence.update(newEntity);
        
        CalificacionEntity resp = em.find(CalificacionEntity.class, entity.getId());
        
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
