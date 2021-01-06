/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
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
public class ProvaTest {
    
    public ProvaTest() {
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
     * Test of getAssuntos method, of class Prova.
     */
    @Test
    public void testGetAssuntos() {
        System.out.println("getAssuntos");
        Prova instance = new Prova();
        ArrayList<Assunto> expResult = null;
        ArrayList<Assunto> result = instance.getAssuntos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestoes method, of class Prova.
     */
    @Test
    public void testGetQuestoes() {
        System.out.println("getQuestoes");
        Prova instance = new Prova();
        ArrayList<Questao> expResult = null;
        ArrayList<Questao> result = instance.getQuestoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestoesPergunta method, of class Prova.
     */
    @Test
    public void testGetQuestoesPergunta() {
        System.out.println("getQuestoesPergunta");
        String pergunta = "";
        Prova instance = new Prova();
        ArrayList<Questao> expResult = null;
        ArrayList<Questao> result = instance.getQuestoesPergunta(pergunta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestoesAssunto method, of class Prova.
     */
    @Test
    public void testGetQuestoesAssunto() {
        System.out.println("getQuestoesAssunto");
        Assunto assunto = null;
        Prova instance = new Prova();
        ArrayList<Questao> expResult = null;
        ArrayList<Questao> result = instance.getQuestoesAssunto(assunto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of geraProvaDoc method, of class Prova.
     */
    @Test
    public void testGeraProvaDoc() {
        System.out.println("geraProvaDoc");
        Assunto assunto = null;
        int qtdQuestoes = 0;
        String data = "";
        String file = "";
        String disciplina = "";
        Float valor = null;
        String professor = "";
        Prova instance = new Prova();
        boolean expResult = false;
        boolean result = instance.geraProvaDoc(assunto, qtdQuestoes, data, file, disciplina, valor, professor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of geraTXT method, of class Prova.
     */
    @Test
    public void testGeraTXT() throws Exception {
        System.out.println("geraTXT");
        Assunto assunto = null;
        boolean tipo = false;
        String arquivo = "";
        Prova instance = new Prova();
        instance.geraTXT(assunto, tipo, arquivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of geraCSV method, of class Prova.
     */
    @Test
    public void testGeraCSV() throws Exception {
        System.out.println("geraCSV");
        String file = "";
        Prova instance = new Prova();
        instance.geraCSV(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
