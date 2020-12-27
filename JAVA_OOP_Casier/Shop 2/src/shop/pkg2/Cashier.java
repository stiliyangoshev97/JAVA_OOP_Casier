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
public class Cashier {
    
    private int cashierId;
    private String cashierName;
    
    public Cashier(int cashierId, String cashierName)
    {
        this.cashierId = cashierId;
        this.cashierName = cashierName;
    }
    
    public void setCashierName(String cashierName)
    {
        this.cashierName = cashierName;
    }
    
    public void setCashierID(int cashierId)
    {
        this.cashierId = cashierId;
    }
    
    
    public int getCashierId()
    {
        return cashierId;
    }
    
    
     public String getCashierName()
    {
        return cashierName;
    }
    
}
