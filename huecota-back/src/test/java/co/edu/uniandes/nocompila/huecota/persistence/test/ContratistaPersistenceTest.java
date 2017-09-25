/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence.test;

import co.edu.uniandes.nocompila.huecota.entities.ContratistaEntity;
import co.edu.uniandes.nocompila.huecota.persistence.ContratistaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author lc.garavito
 */
@RunWith(Arquillian.class)
public class ContratistaPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase ContratistaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ContratistaPersistence persistence;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
    /**
     * Lista que contendrá el conjunto de los datos de prueba.
     */
    private List<ContratistaEntity> data = new ArrayList<ContratistaEntity>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Contratista, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ContratistaEntity.class.getPackage())
                .addPackage(ContratistaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public ContratistaPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Configuración inicial de cada prueba.
     */
    @Before
    public void setUp()
    {
        try
        {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                utx.rollback();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }
    
    /**
     * Borra los datos de la base de datos directamente.
     */
    private void clearData()
    {
        em.createQuery("delete from ContratistaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales necesarios para cada prueba utilizando Podam.
     */
    private void insertData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 3; i++)
        {
            ContratistaEntity entity = factory.manufacturePojo(ContratistaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ContratistaPersistence.
     */
    @Test
    public void createContratistaTest() throws Exception
    {
        PodamFactory factory = new PodamFactoryImpl();
        ContratistaEntity newEntity = factory.manufacturePojo(ContratistaEntity.class);
        ContratistaEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        ContratistaEntity entity = em.find(ContratistaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of update method, of class ContratistaPersistence.
     */
    @Test
    public void updateContratistaTest() throws Exception
    {
        ContratistaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ContratistaEntity newEntity = factory.manufacturePojo(ContratistaEntity.class);
        
        newEntity.setId(entity.getId());
        persistence.update(newEntity);
        ContratistaEntity result = em.find(ContratistaEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getName(), result.getName());
    }

    /**
     * Test of delete method, of class ContratistaPersistence.
     */
    @Test
    public void deleteContratistaTest() throws Exception
    {
        ContratistaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ContratistaEntity deleted = em.find(ContratistaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class ContratistaPersistence.
     */
    @Test
    public void getContratistaTest() throws Exception
    {
        ContratistaEntity entity = data.get(0);
        ContratistaEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class ContratistaPersistence.
     */
    @Test
    public void getContratistasTest() throws Exception
    {
        List<ContratistaEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ContratistaEntity ent : list)
        {
            boolean found = false;
            for (ContratistaEntity entity : data)
            {
                if (ent.getId().equals(entity.getId()))
                    found = true;
            }
            Assert.assertTrue(found);
        }
    }
    
}
