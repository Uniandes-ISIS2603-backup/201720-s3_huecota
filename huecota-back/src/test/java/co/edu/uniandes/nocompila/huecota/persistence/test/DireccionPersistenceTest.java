/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence.test;

/**
 *
 * @author ma.puentes
 */

import co.edu.uniandes.nocompila.huecota.entities.DireccionEntity;
import co.edu.uniandes.nocompila.huecota.persistence.DireccionPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
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
public class DireccionPersistenceTest
{
	
	 @Inject
    private DireccionPersistence persistence;

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
    private List<DireccionEntity> data = new ArrayList<DireccionEntity>();
	
	public DireccionPersistenceTest()
	{
		
	}
	
	/**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de DireccionEntity el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyecci�n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
	{
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DireccionEntity.class.getPackage())
                .addPackage(DireccionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
	
	@Test
	public void getDireccionEntityTest()
	{
		DireccionEntity entity = data.get(0);
		DireccionEntity newEntity = persistence.find(entity.getId());
		Assert.assertNotNull(newEntity);
		Assert.assertEquals(entity.getName(), newEntity.getName());
	}
	
	@Test
	public void getDireccionByNameTest()
	{
		DireccionEntity entity = data.get(0);
		DireccionEntity newEntity = persistence.find(entity.getId());
		Assert.assertNotNull(newEntity);
		Assert.assertEquals(entity.getId(), newEntity.getId());
	}
	@Test
	public void createDireccionEntityTest()
	{
		PodamFactory factory = new PodamFactoryImpl();
		DireccionEntity newEntity = factory.manufacturePojo(DireccionEntity.class);
		DireccionEntity result = persistence.create(newEntity);
		Assert.assertNotNull(result);
		DireccionEntity entity = em.find(DireccionEntity.class, result.getId());
		Assert.assertNotNull(entity);
		Assert.assertEquals(newEntity.getName(), entity.getName());
	}
	
	@Test
	public void updateDireccionEntityTest()
	{
		DireccionEntity entity = data.get(0);
		PodamFactory factory = new PodamFactoryImpl();
		DireccionEntity newEntity = factory.manufacturePojo(DireccionEntity.class);
		newEntity.setId(entity.getId());
		persistence.update(newEntity);
		DireccionEntity resp = em.find(DireccionEntity.class, entity.getId());
		Assert.assertEquals(newEntity.getName(), resp.getName());
	}
	
	@Test
	public void deleteDireccionEntityTest()
	{
		DireccionEntity entity = data.get(0);
		persistence.delete(entity.getId());
		DireccionEntity deleted = em.find(DireccionEntity.class, entity.getId());
		Assert.assertNull(deleted);
	}
	
	@Test
    public void getDireccionesTest()
   {
    List<DireccionEntity> list = persistence.findAll();
    Assert.assertEquals(data.size(), list.size());
    for (DireccionEntity ent : list)
	{
        boolean found = false;
        for (DireccionEntity entity : data)
		{
            if (ent.getId().equals(entity.getId()))
			{
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
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
	
	
	/**
	 * Test of update method, of class DireccionPersistence.
	 */
	
	private void clearData()
	{
        em.createQuery("delete from DireccionEntity").executeUpdate();
    }


	private void insertData()
	{
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++)
		{
            DireccionEntity entity = factory.manufacturePojo(DireccionEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
}

