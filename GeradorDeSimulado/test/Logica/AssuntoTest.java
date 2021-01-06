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
public class AssuntoTest {
    
    public AssuntoTest() {
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
     * Test of getAtivo method, of class Assunto.
     */
    @Test
    public void testGetAtivo() {
        System.out.println("getAtivo");
        Assunto instance = null;
        boolean expResult = false;
        boolean result = instance.getAtivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtivo method, of class Assunto.
     */
    @Test
    public void testSetAtivo() {
        System.out.println("setAtivo");
        boolean b = false;
        Assunto instance = null;
        instance.setAtivo(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Assunto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Assunto instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssunto method, of class Assunto.
     */
    @Test
    public void testSetAssunto() {
        System.out.println("setAssunto");
        String assunto = "";
        Assunto instance = null;
        instance.setAssunto(assunto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addQuestao method, of class Assunto.
     */
    @Test
    public void testAddQuestao() {
        System.out.println("addQuestao");
        Assunto instance = null;
        boolean expResult = false;
        boolean result = instance.addQuestao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeQuestao method, of class Assunto.
     */
    @Test
    public void testRemoveQuestao() {
        System.out.println("removeQuestao");
        Assunto instance = null;
        boolean expResult = false;
        boolean result = instance.removeQuestao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Assunto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Assunto instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidade method, of class Assunto.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        Assunto instance = null;
        int expResult = 0;
        int result = instance.getQuantidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Assunto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Assunto instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Assunto.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Assunto instance = null;
        String expResult = "";
        String result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
