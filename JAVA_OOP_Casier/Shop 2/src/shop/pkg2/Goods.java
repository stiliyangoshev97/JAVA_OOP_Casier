/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.pkg2;

import java.time.LocalDate; // пакет за дати

/**
 *
 * @author stiliyangoshev97
 */
public class Goods {
    
    private int goodId;
    private String goodName;
    private LocalDate goodExpDate;
    private double goodPrice;
    
    public Goods(int goodId, String goodName, LocalDate goodExpDate, double goodPrice)
    {
        this.goodId = goodId;
        this. goodName = goodName;
        this.goodExpDate = goodExpDate;
        this.goodPrice = goodPrice;
    }
    
    public int getGoodId()
    {
        return goodId;
    }
    
    public String getGoodName()
    {
        return goodName;
    }
    
    public LocalDate getGoodExpDate()
    {
        return goodExpDate;
    }
    
    public double getGoodPrice()
    {
        return goodPrice;
    }
    
}
