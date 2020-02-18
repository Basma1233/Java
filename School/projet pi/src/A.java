/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class A {
    private static A inst;
    public A(){
        }
  
        public static A getInstance(){
            if (inst==null)
                inst =new A();
            return inst;
        
        
    }
    
}
