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
public class QuestaoTest {
    
    public QuestaoTest() {
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
     * Test of setPergunta method, of class Questao.
     */
    @Test
    public void testSetPergunta() {
        System.out.println("setPergunta");
        String pergunta = "";
        Questao instance = null;
        instance.setPergunta(pergunta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssunto method, of class Questao.
     */
    @Test
    public void testGetAssunto() {
        System.out.println("getAssunto");
        Questao instance = null;
        Assunto expResult = null;
        Assunto result = instance.getAssunto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqualsPergunta method, of class Questao.
     */
    @Test
    public void testIsEqualsPergunta() {
        System.out.println("isEqualsPergunta");
        Questao o = null;
        Questao instance = null;
        boolean expResult = false;
        boolean result = instance.isEqualsPergunta(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeQuestao method, of class Questao.
     */
    @Test
    public void testImprimeQuestao() {
        System.out.println("imprimeQuestao");
        Questao instance = null;
        String expResult = "";
        String result = instance.imprimeQuestao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Questao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object questao = null;
        Questao instance = null;
        boolean expResult = false;
        boolean result = instance.equals(questao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeResposta method, of class Questao.
     */
    @Test
    public void testImprimeResposta() {
        System.out.println("imprimeResposta");
        Questao instance = null;
        String expResult = "";
        String result = instance.imprimeResposta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeAlternativa method, of class Questao.
     */
    @Test
    public void testImprimeAlternativa() {
        System.out.println("imprimeAlternativa");
        Questao instance = null;
        String expResult = "";
        String result = instance.imprimeAlternativa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Questao.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Questao instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPergunta method, of class Questao.
     */
    @Test
    public void testGetPergunta() {
        System.out.println("getPergunta");
        Questao instance = null;
        String expResult = "";
        String result = instance.getPergunta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class QuestaoImpl extends Questao {

        public QuestaoImpl() {
            super("", null);
        }

        public boolean equals(Object questao) {
            return false;
        }

        public String imprimeResposta() {
            return "";
        }

        public String imprimeAlternativa() {
            return "";
        }

        public String getTipo() {
            return "";
        }
    }
    
}
