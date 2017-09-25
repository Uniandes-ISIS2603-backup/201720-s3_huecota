/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence.test;

import co.edu.uniandes.nocompila.huecota.entities.ImagenEntity;
import co.edu.uniandes.nocompila.huecota.persistence.ImagenPersistence;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author le.viana
 */
@RunWith(Arquillian.class)
public class ImagenPersistenceTest {
    
    /**
     * 
     * @return Devuelve el jar de Arquillian va a desplegar en el Glassfish
     * embedido. El jar contiene las clases de Imagen, el descriptor de la
     * base de datos y el arvhico beans.xml para resolver la inyeccion de 
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ImagenEntity.class.getPackage())
                .addPackage(ImagenPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    public ImagenPersistenceTest(){}
    
    /**
     * Inyeccion de la dependencia a la clase ImagenPersistence cuyos metodos se van a probar.
     */
    @Inject
    private ImagenPersistence imagenPersistence;
    
    /**
     * Contexto de persistencia que se va a utilizar para acceder a la Base de 
     * datos por fuera de los metodos que se estan probando.
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
    public static void setUpClass()throws Exception{}
    
    @AfterClass
    public static void tearDownClass() throws Exception {}
    
    /**
     * Configuracion inicial de la prueba.
     */
    @Before
    public void setUp()
    {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }catch(Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    @After
    public void tearDown() throws Exception {}
    
    /**
     * Limpia las tablas que estan implicadas en la prueba.
     */
    private void clearData()
    {
        em.createQuery("delete from ImagenEntity").executeUpdate();
    }
    
    private List<ImagenEntity> data = new ArrayList<ImagenEntity>();
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData(){
        PodamFactory factory  = new PodamFactoryImpl();
        for(int i = 0; i < 3; i++) {
            ImagenEntity entity = factory.manufacturePojo(ImagenEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
        
    }
    
    /**
     * Prueba para crear una imagen.
     */
    @Test
    public void createImagenTest()
    {
        PodamFactory factory = new PodamFactoryImpl();
        ImagenEntity newEntity = factory.manufacturePojo(ImagenEntity.class);
        ImagenEntity result = imagenPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ImagenEntity entity = em.find(ImagenEntity.class,result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de imagenes.
     */
    @Test
    public void getImagenesTest()
    {
        List<ImagenEntity> list = imagenPersistence.findAll();
        
        Assert.assertEquals(data.size(), list.size());
        
        for(ImagenEntity ent: list)
        {
            boolean found  = false;
            
            for(ImagenEntity entity : data)
            {
                if(ent.getId().equals(entity.getId()))
                {
                    found = true;
                }
            }
            
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar una Imagen.
     */
    @Test
    public void getImagenTest()
    {
        ImagenEntity entity = data.get(0);
        ImagenEntity newEntity = imagenPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    /**
     * prueba para eliminar una imagen.
     */
    @Test
    public void deleteImagenTest()
    {
        ImagenEntity entity = data.get(0);
        imagenPersistence.delete(entity.getId());
        ImagenEntity deleted = em.find(ImagenEntity.class,entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateImagenTest()
    {
        ImagenEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ImagenEntity newEntity = factory.manufacturePojo(ImagenEntity.class);
        
        newEntity.setId(entity.getId());
        
        imagenPersistence.update(newEntity);
        
        ImagenEntity resp = em.find(ImagenEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getName(),resp.getName());
    }
}
