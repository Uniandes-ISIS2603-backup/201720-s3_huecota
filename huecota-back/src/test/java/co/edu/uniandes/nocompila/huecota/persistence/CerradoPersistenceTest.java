/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.CerradoEntity;
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
 * @author jpr.arango10
 */
@RunWith(Arquillian.class)
public class CerradoPersistenceTest {
         /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Abierto, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyecci�n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CerradoEntity.class.getPackage())
                .addPackage(AbiertoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public CerradoPersistenceTest () {}
            
    
     /**
     * Inyección de la dependencia a la clase AbiertoPersistence cuyos m�todos
     * se van a probar.
     */
    @Inject
    private CerradoPersistence cerradoPersistence;
    
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
        em.createQuery("delete from CerradoEntity").executeUpdate();
    }
    
    /**
     *
     */
    private List<CerradoEntity> data = new ArrayList<CerradoEntity>();
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CerradoEntity entity = factory.manufacturePojo(CerradoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una calificacion.
     */
    @Test
    public void createAbiertoTest()
    {
        PodamFactory factory = new PodamFactoryImpl();
        CerradoEntity newEntity = factory.manufacturePojo(CerradoEntity.class);
        CerradoEntity result = cerradoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        CerradoEntity entity = em.find(CerradoEntity.class,result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de Califiaciones.
     */
    @Test
    public void getAbiertoesTest()
    {
        List<CerradoEntity> list = cerradoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(CerradoEntity ent : list)
        {
            boolean found = false;
            for(CerradoEntity entity : data)
            {
                if(ent.getId().equals(entity.getId())){
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
    public void getAbiertoTest()
    {
        CerradoEntity entity = data.get(0);
        CerradoEntity newEntity = cerradoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    /**
     * prueba para eliminar una calificacion.
     */
    @Test
    public void deleteAbiertoTest()
    {
        CerradoEntity entity = data.get(0);
        cerradoPersistence.delete(entity.getId());
        CerradoEntity deleted = em.find(CerradoEntity.class,entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateAbiertoTest()
    {
        CerradoEntity entity = data.get(0);
        PodamFactory factory  = new PodamFactoryImpl();
        CerradoEntity newEntity = factory.manufacturePojo(CerradoEntity.class);
        
        newEntity.setId(entity.getId());
        
        cerradoPersistence.update(newEntity);
        
        CerradoEntity resp = em.find(CerradoEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
