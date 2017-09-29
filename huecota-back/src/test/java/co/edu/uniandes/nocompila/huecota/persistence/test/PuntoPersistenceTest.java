/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence.test;

import co.edu.uniandes.nocompila.huecota.entities.PuntoEntity;
import co.edu.uniandes.nocompila.huecota.persistence.PuntoPersistence;
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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author c.martinezc1
 */
@RunWith(Arquillian.class)
public class PuntoPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PuntoEntity.class.getPackage())
                .addPackage(PuntoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public PuntoPersistenceTest () {
    
    }
    
    @Inject
    private PuntoPersistence puntoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
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
    
    private void clearData() 
    {
       em.createQuery("delete from PuntoEntity").executeUpdate();
    }
     
      private List<PuntoEntity> data = new ArrayList<PuntoEntity>();
      
      private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PuntoEntity entity = factory.manufacturePojo(PuntoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
      
        
@Test
public void createPuntoTest()
{
        PodamFactory factory = new PodamFactoryImpl();
        PuntoEntity newEntity = factory.manufacturePojo(PuntoEntity.class);
        PuntoEntity result = puntoPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        PuntoEntity entity = em.find(PuntoEntity.class,result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    
    
    /**
     *jj
     */
    @Test
    public void getPuntoTest()
    {
        PuntoEntity entity = data.get(0);
        PuntoEntity newEntity = puntoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    @Test
    public void deletePuntoTest()
    {
        PuntoEntity entity = data.get(0);
        puntoPersistence.delete(entity.getId());
        PuntoEntity deleted = em.find(PuntoEntity.class,entity.getId());
        Assert.assertNull(deleted);
    }
    
    public void updatePuntoTest()
    {
        PuntoEntity entity = data.get(0);
        PodamFactory factory  = new PodamFactoryImpl();
        PuntoEntity newEntity = factory.manufacturePojo(PuntoEntity.class);
        
        newEntity.setId(entity.getId());
        
        puntoPersistence.update(newEntity);
        
        PuntoEntity resp = em.find(PuntoEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
