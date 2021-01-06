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
public class QuestaoMultiplaEscolhaComTest {
    
    public QuestaoMultiplaEscolhaComTest() {
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
     * Test of imprimeResposta method, of class QuestaoMultiplaEscolhaCom.
     */
    @Test
    public void testImprimeResposta() {
        System.out.println("imprimeResposta");
        QuestaoMultiplaEscolhaCom instance = null;
        String expResult = "";
        String result = instance.imprimeResposta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeAlternativa method, of class QuestaoMultiplaEscolhaCom.
     */
    @Test
    public void testImprimeAlternativa() {
        System.out.println("imprimeAlternativa");
        QuestaoMultiplaEscolhaCom instance = null;
        String expResult = "";
        String result = instance.imprimeAlternativa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemCerto method, of class QuestaoMultiplaEscolhaCom.
     */
    @Test
    public void testGetItemCerto() {
        System.out.println("getItemCerto");
        String resposta = "";
        QuestaoMultiplaEscolhaCom instance = null;
        int expResult = 0;
        int result = instance.getItemCerto(resposta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlternativa method, of class QuestaoMultiplaEscolhaCom.
     */
    @Test
    public void testGetAlternativa() {
        System.out.println("getAlternativa");
        QuestaoMultiplaEscolhaCom instance = null;
        String[] expResult = null;
        String[] result = instance.getAlternativa();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResposta method, of class QuestaoMultiplaEscolhaCom.
     */
    @Test
    public void testGetResposta() {
        System.out.println("getResposta");
        QuestaoMultiplaEscolhaCom instance = null;
        boolean[] expResult = null;
        boolean[] result = instance.getResposta();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class QuestaoMultiplaEscolhaCom.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object questao = null;
        QuestaoMultiplaEscolhaCom instance = null;
        boolean expResult = false;
        boolean result = instance.equals(questao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class QuestaoMultiplaEscolhaCom.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        QuestaoMultiplaEscolhaCom instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
