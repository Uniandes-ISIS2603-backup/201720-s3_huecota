/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence.test;

import co.edu.uniandes.nocompila.huecota.entities.CuentaCobroEntity;
import co.edu.uniandes.nocompila.huecota.persistence.CuentaCobroPersistence;
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
public class CuentaCobroPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase CuentaCobroPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private CuentaCobroPersistence persistence;
    
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
    private List<CuentaCobroEntity> data = new ArrayList<CuentaCobroEntity>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de CuentaCobro, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CuentaCobroEntity.class.getPackage())
                .addPackage(CuentaCobroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public CuentaCobroPersistenceTest() {
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
    public void setUp() {
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
    
    @After
    public void tearDown() {
    }

    /**
     * Borra los datos de la base de datos directamente.
     */
    private void clearData()
    {
        em.createQuery("delete from CuentaCobroEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales necesarios para cada prueba utilizando Podam.
     */
    private void insertData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 3; i++)
        {
            CuentaCobroEntity entity = factory.manufacturePojo(CuentaCobroEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Test of create method, of class CuentaCobroPersistence.
     */
    @Test
    public void createCuentaCobroTest() throws Exception
    {
        PodamFactory factory = new PodamFactoryImpl();
        CuentaCobroEntity newEntity = factory.manufacturePojo(CuentaCobroEntity.class);
        CuentaCobroEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        CuentaCobroEntity entity = em.find(CuentaCobroEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of update method, of class CuentaCobroPersistence.
     */
    @Test
    public void updateCuentaCobroTest() throws Exception
    {
        CuentaCobroEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CuentaCobroEntity newEntity = factory.manufacturePojo(CuentaCobroEntity.class);
        
        newEntity.setId(entity.getId());
        persistence.update(newEntity);
        CuentaCobroEntity result = em.find(CuentaCobroEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getName(), result.getName());
    }

    /**
     * Test of delete method, of class CuentaCobroPersistence.
     */
    @Test
    public void deleteCuentaCobroTest() throws Exception
    {
        CuentaCobroEntity entity = data.get(0);
        persistence.delete(entity.getId());
        CuentaCobroEntity deleted = em.find(CuentaCobroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class CuentaCobroPersistence.
     */
    @Test
    public void getCuentaCobroTest() throws Exception
    {
        CuentaCobroEntity entity = data.get(0);
        CuentaCobroEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class CuentaCobroPersistence.
     */
    @Test
    public void getContratistasTest() throws Exception
    {
        List<CuentaCobroEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CuentaCobroEntity ent : list)
        {
            boolean found = false;
            for (CuentaCobroEntity entity : data)
            {
                if (ent.getId().equals(entity.getId()))
                    found = true;
            }
            Assert.assertTrue(found);
        }
    }
    
}
