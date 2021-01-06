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
public class QuestaoAbertaTest {
    
    public QuestaoAbertaTest() {
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
     * Test of imprimeResposta method, of class QuestaoAberta.
     */
    @Test
    public void testImprimeResposta() {
        System.out.println("imprimeResposta");
        QuestaoAberta instance = null;
        String expResult = "";
        String result = instance.imprimeResposta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeAlternativa method, of class QuestaoAberta.
     */
    @Test
    public void testImprimeAlternativa() {
        System.out.println("imprimeAlternativa");
        QuestaoAberta instance = null;
        String expResult = "";
        String result = instance.imprimeAlternativa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class QuestaoAberta.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object questao = null;
        QuestaoAberta instance = null;
        boolean expResult = false;
        boolean result = instance.equals(questao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class QuestaoAberta.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        QuestaoAberta instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
