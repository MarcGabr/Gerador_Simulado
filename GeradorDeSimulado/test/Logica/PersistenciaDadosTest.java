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
public class PersistenciaDadosTest {
    
    public PersistenciaDadosTest() {
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
     * Test of pegaDados method, of class PersistenciaDados.
     */
    @Test
    public void testPegaDados() {
        System.out.println("pegaDados");
        Prova expResult = null;
        Prova result = PersistenciaDados.pegaDados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardaDados method, of class PersistenciaDados.
     */
    @Test
    public void testGuardaDados() throws Exception {
        System.out.println("guardaDados");
        Prova prova = null;
        PersistenciaDados.guardaDados(prova);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
