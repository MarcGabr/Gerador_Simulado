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
public class QuestaoVouFTest {
    
    public QuestaoVouFTest() {
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
     * Test of imprimeResposta method, of class QuestaoVouF.
     */
    @Test
    public void testImprimeResposta() {
        System.out.println("imprimeResposta");
        QuestaoVouF instance = null;
        String expResult = "";
        String result = instance.imprimeResposta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResposta method, of class QuestaoVouF.
     */
    @Test
    public void testGetResposta() {
        System.out.println("getResposta");
        QuestaoVouF instance = null;
        boolean expResult = false;
        boolean result = instance.getResposta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeAlternativa method, of class QuestaoVouF.
     */
    @Test
    public void testImprimeAlternativa() {
        System.out.println("imprimeAlternativa");
        QuestaoVouF instance = null;
        String expResult = "";
        String result = instance.imprimeAlternativa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class QuestaoVouF.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object questao = null;
        QuestaoVouF instance = null;
        boolean expResult = false;
        boolean result = instance.equals(questao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class QuestaoVouF.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        QuestaoVouF instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
