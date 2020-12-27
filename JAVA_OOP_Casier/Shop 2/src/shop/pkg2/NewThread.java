/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.pkg2;

/**
 *
 * @author stiliyangoshev97
 */
public class NewThread implements Runnable
{
    private String threadName;

    
    public NewThread(String threadName)
    {     
         this.threadName = threadName;
    }
  
    @Override
    public void run()
    {
         System.out.println("\nCurrently working paydesks: " + threadName);
    }
    
    
    
}
