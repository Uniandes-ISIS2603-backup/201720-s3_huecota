/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


/**
 *
 * @author ma.puentes
 */
@RunWith(Arquillian.class)
public class AccidentePersistenceTest
{
	
	 @Inject
    private AccidentePersistence persistence;

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
    private List<AccidenteEntity> data = new ArrayList<AccidenteEntity>();
	
	//persistence: es el objeto de la clase que se va a probar. El contenedor inyectar� una instancia de esta clase.
    //em: un EntityManager para verificar los datos directamente sobre la base de datos
    //utx: un UserTransactions para manipular los datos directamente sobre la base de datos
    //data: este arreglo contendr� el conjunto de datos de prueba
	
	
	
	public AccidentePersistenceTest()
	{
		
	}
	
	/**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de AccidenteEntity el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyecci�n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
	{
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AccidenteEntity.class.getPackage())
                .addPackage(AccidentePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
	
	@Test
	public void getAccidenteEntityTest()
	{
		AccidenteEntity entity = data.get(0);
		AccidenteEntity newEntity = persistence.find(entity.getId());
		Assert.assertNotNull(newEntity);
		Assert.assertEquals(entity.getName(), newEntity.getName());
	}
	
	@Test
	public void getAccidenteByNameTest()
	{
		AccidenteEntity entity = data.get(0);
		AccidenteEntity newEntity = persistence.find(entity.getId());
		Assert.assertNotNull(newEntity);
		Assert.assertEquals(entity.getId(), newEntity.getId());
	}
	@Test
	public void createAccidenteEntityTest()
	{
		PodamFactory factory = new PodamFactoryImpl();
		AccidenteEntity newEntity = factory.manufacturePojo(AccidenteEntity.class);
		AccidenteEntity result = persistence.create(newEntity);
		Assert.assertNotNull(result);
		AccidenteEntity entity = em.find(AccidenteEntity.class, result.getId());
		Assert.assertNotNull(entity);
		Assert.assertEquals(newEntity.getName(), entity.getName());
	}
	
	@Test
	public void updateAccidenteEntityTest()
	{
		AccidenteEntity entity = data.get(0);
		PodamFactory factory = new PodamFactoryImpl();
		AccidenteEntity newEntity = factory.manufacturePojo(AccidenteEntity.class);
		newEntity.setId(entity.getId());
		persistence.update(newEntity);
		AccidenteEntity resp = em.find(AccidenteEntity.class, entity.getId());
		Assert.assertEquals(newEntity.getName(), resp.getName());
	}
	
	@Test
	public void deleteAccidenteEntityTest()
	{
		AccidenteEntity entity = data.get(0);
		persistence.delete(entity.getId());
		AccidenteEntity deleted = em.find(AccidenteEntity.class, entity.getId());
		Assert.assertNull(deleted);
	}
	
	@Test
    public void getAccidentesTest()
   {
    List<AccidenteEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (AccidenteEntity ent : list)
	{
        boolean found = false;
        for (AccidenteEntity entity : data)
		{
            if (ent.getId().equals(entity.getId()))
			{
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
	@BeforeClass
	public static void setUpClass()
	{
		
	}
	
	@AfterClass
	public static void tearDownClass()
	{
		
	}
	
	@Before
	public void setUp()
	{
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }
		catch (Exception e)
		{
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1)
			{
                e1.printStackTrace();
            }
        }
    }
	
	@After
	public void tearDown()
	{
		
	}

	/**
	 * Test of create method, of class AccidentePersistence.
	 */
	@Test
	public void testCreate() throws Exception
	{
		
	}

	/**
	 * Test of update method, of class AccidentePersistence.
	 */
	@Test
	public void testUpdate() throws Exception
	{
		
	}

	/**
	 * Test of delete method, of class AccidentePersistence.
	 */
	@Test
	public void testDelete() throws Exception
	{
		
	}

	/**
	 * Test of find method, of class AccidentePersistence.
	 */
	@Test
	public void testFind() throws Exception
	{
		
	}

	/**
	 * Test of findAll method, of class AccidentePersistence.
	 */
	@Test
	public void testFindAll() throws Exception
	{
		
	}
	private void clearData()
	{
        em.createQuery("delete from AccidenteEntity").executeUpdate();
    }


	private void insertData()
	{
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++)
		{
            AccidenteEntity entity = factory.manufacturePojo(AccidenteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
}
