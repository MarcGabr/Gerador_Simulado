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
public class GeneratorPDFTest {
    
    public GeneratorPDFTest() {
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
     * Test of gerar method, of class GeneratorPDF.
     */
    @Test
    public void testGerar() {
        System.out.println("gerar");
        String[] prova = null;
        String data = "";
        String file = "";
        int qtd = 0;
        String disciplina = "";
        Float valor = null;
        String professor = "";
        GeneratorPDF.gerar(prova, data, file, qtd, disciplina, valor, professor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
