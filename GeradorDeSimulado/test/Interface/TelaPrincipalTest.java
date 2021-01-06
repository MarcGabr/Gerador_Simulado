/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.WindowEvent;
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
public class TelaPrincipalTest {
    
    public TelaPrincipalTest() {
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
     * Test of main method, of class TelaPrincipal.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] argv = null;
        TelaPrincipal.main(argv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowOpened method, of class TelaPrincipal.
     */
    @Test
    public void testWindowOpened() {
        System.out.println("windowOpened");
        TelaPrincipal instance = new TelaPrincipal();
        WindowEvent we = new WindowEvent(instance, WindowEvent.WINDOW_CLOSING);
        
        instance.windowOpened(we);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowClosing method, of class TelaPrincipal.
     */
    @Test
    public void testWindowClosing() {
        System.out.println("windowClosing");
        WindowEvent we = null;
        TelaPrincipal instance = new TelaPrincipal();
        instance.windowClosing(we);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowClosed method, of class TelaPrincipal.
     */
    @Test
    public void testWindowClosed() {
        System.out.println("windowClosed");
        WindowEvent we = null;
        TelaPrincipal instance = new TelaPrincipal();
        instance.windowClosed(we);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowIconified method, of class TelaPrincipal.
     */
    @Test
    public void testWindowIconified() {
        System.out.println("windowIconified");
        WindowEvent we = null;
        TelaPrincipal instance = new TelaPrincipal();
        instance.windowIconified(we);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowDeiconified method, of class TelaPrincipal.
     */
    @Test
    public void testWindowDeiconified() {
        System.out.println("windowDeiconified");
        WindowEvent we = null;
        TelaPrincipal instance = new TelaPrincipal();
        instance.windowDeiconified(we);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowActivated method, of class TelaPrincipal.
     */
    @Test
    public void testWindowActivated() {
        System.out.println("windowActivated");
        WindowEvent we = null;
        TelaPrincipal instance = new TelaPrincipal();
        instance.windowActivated(we);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of windowDeactivated method, of class TelaPrincipal.
     */
    @Test
    public void testWindowDeactivated() {
        System.out.println("windowDeactivated");
        WindowEvent we = null;
        TelaPrincipal instance = new TelaPrincipal();
        instance.windowDeactivated(we);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
