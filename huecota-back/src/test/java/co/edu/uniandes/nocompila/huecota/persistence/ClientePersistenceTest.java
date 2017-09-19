/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.ClienteEntity;
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
public class ClientePersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public ClientePersistenceTest () {}
    
    @Inject
    private ClientePersistence clientePersistence;
    
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
    
     private void clearData() {
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
     
      private List<ClienteEntity> data = new ArrayList<ClienteEntity>();
      
      private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
      
    
@Test
    public void createClienteTest()
    {
        PodamFactory factory = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        ClienteEntity result = clientePersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        ClienteEntity entity = em.find(ClienteEntity.class,result.getId());
        
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
    public void getClientesTest()
    {
        List<ClienteEntity> list = clientePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(ClienteEntity ent : list)
        {
            boolean found = false;
            for(ClienteEntity entity : data)
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
     *jj
     */
    @Test
    public void getClienteTest()
    {
        ClienteEntity entity = data.get(0);
        ClienteEntity newEntity = clientePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    @Test
    public void deleteClienteTest()
    {
        ClienteEntity entity = data.get(0);
        clientePersistence.delete(entity.getId());
        ClienteEntity deleted = em.find(ClienteEntity.class,entity.getId());
        Assert.assertNull(deleted);
    }
    
    public void updateClienteTest()
    {
        ClienteEntity entity = data.get(0);
        PodamFactory factory  = new PodamFactoryImpl();
        ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
        
        newEntity.setId(entity.getId());
        
        clientePersistence.update(newEntity);
        
        ClienteEntity resp = em.find(ClienteEntity.class, entity.getId());
        
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

}