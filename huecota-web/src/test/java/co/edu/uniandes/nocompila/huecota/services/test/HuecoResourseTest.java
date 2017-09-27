/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.services.test;

import co.edu.uniandes.nocompila.huecota.resources.HuecoResource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 *
 * @author ch.patino
 */

@RunWith(Arquillian.class)
public class HuecoResourseTest {

    private static final String BASEPATH = System.getProperty("user.dir");
    String path = BASEPATH.concat("\\collections\\runners\\nocompilaCollectionRunner.bat");

    @Deployment(testable = true)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "huecota-web.war")
                // Se agrega las dependencias
                .addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml")
                        .importRuntimeDependencies().resolve()
                        .withTransitivity().asFile())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(HuecoResource.class.getPackage())
                // El archivo que contiene la configuracion a la base de datos.
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                // El archivo beans.xml es necesario para injeccion de dependencias.
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));

    }

    public void setPostmanCollectionValues() throws FileNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException, ExecutionException {

        try (FileWriter wrt = new FileWriter(path))
		{
            wrt.write("newman run ".concat(BASEPATH.concat("\\collections\\runners\\nocompilaCollectionRunner.postman_collection.json").concat(" --disable-unicode")));
            wrt.flush();
        }

    }

    /**
     * Test para la colección de postman
     */
    @Test
    @RunAsClient
    public void postman() throws FileNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException, ExecutionException{
      setPostmanCollectionValues();

        try {
            String prop = System.getProperty("user.dir");
            Process process = Runtime.getRuntime().exec(prop + "\\collections\\runners\\nocompilaCollectionRunner.bat");

            InputStream inputStream = process.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String ln;
            Logger log = Logger.getAnonymousLogger();

            while ((ln = bf.readLine()) != null) {
                line = line.concat(ln);
                System.out.println(ln);
            }

            inputStream.close();
            bf.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
