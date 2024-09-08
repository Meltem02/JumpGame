/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package nesne;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LENOVO
 */
public class FındıkTest {
    
    public FındıkTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of upDate method, of class Fındık.
     */
    @Test
    public void testUpDate() {
        System.out.println("upDate");
        Fındık instance = new Fındık();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBound method, of class Fındık.
     */
    @Test
    public void testGetBound() {
        System.out.println("getBound");
        Fındık instance = new Fındık();
        Rectangle expResult = null;
        Rectangle result = instance.getBound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class Fındık.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Fındık instance = new Fındık();
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Fındık.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Fındık instance = new Fındık();
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Fındık.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Fındık instance = new Fındık();
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Fındık.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        BufferedImage image = null;
        Fındık instance = new Fındık();
        instance.setImage(image);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOutOfScreen method, of class Fındık.
     */
    @Test
    public void testIsOutOfScreen() {
        System.out.println("isOutOfScreen");
        Fındık instance = new Fındık();
        boolean expResult = false;
        boolean result = instance.isOutOfScreen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class FındıkImpl extends Fındık {

        public FındıkImpl() throws Exception {
            super();
        }
    }
    
}
