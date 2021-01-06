/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raykson santos
 */
public class EnviarMailTest {
    
    public EnviarMailTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of mudarServidor method, of class EnviarMail.
     */
    @Test
    public void testMudarServidor() {
        System.out.println("mudarServidor");
        String servidorMailSmtpMuda = "";
        String portaSMTPMailMuda = "";
        EnviarMail.mudarServidor(servidorMailSmtpMuda, portaSMTPMailMuda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMail method, of class EnviarMail.
     */
    @Test
    public void testSendMail() {
        System.out.println("sendMail");
        String[] to = null;
        String assunto = "";
        String file = "";
        boolean expResult = false;
        boolean result = EnviarMail.sendMail(to, assunto, file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
