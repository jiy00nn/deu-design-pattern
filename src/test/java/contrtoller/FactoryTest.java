/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrtoller;

import controller.Managing;
import controller.ManagingFactory;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author wndgk
 */
public class FactoryTest {

    @Test
    public void testgetManaging() {
        System.out.println("getManaging Test");
        ManagingFactory mf = new ManagingFactory();
        Managing managing = mf.getManaging("User");
        managing.Search("test");        
    }
}
