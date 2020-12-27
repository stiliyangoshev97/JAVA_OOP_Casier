/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.pkg2;

import java.time.LocalDate; // пакет за дати

import java.io.*;

/**
 *
 * @author stiliyangoshev97
 */
public class Receipt {
    
    private int receiptId; // пореден номер на касова бележка
    private String cashierName;
    private String goodName;
    private LocalDate receiptDate; // дата на издаване на касовата бележка
    private int receiptGoodsQuantity; // количество от купената стока
    private double receiptGoodsPrice; // приход от купената стока който зависи от количеството което се купува
    
    private int payDeskNumber;
    
    
    
    
    public Receipt(int receiptId, String cashierName, String goodName, LocalDate receiptDate, int receiptGoodsQuantity, double receiptGoodsPrice)
    {
        this.receiptId = receiptId;
        this.cashierName = cashierName;
        this.goodName = goodName;
        this.receiptDate = receiptDate;
        this.receiptGoodsQuantity = receiptGoodsQuantity;
        this.receiptGoodsPrice = receiptGoodsPrice;
    }
    
   
    
    public void ReceiptIdIncrement(int receiptId) // инктеремент на пореден номер касова бележка когато се издава нова
    {
        this.receiptId = receiptId + 1;
    }
    
    public int getReceiptId()
    {
        return receiptId;
    }
    
    public String getCashierName()
    {
        return cashierName;
    }
    
    public String getGoodName()
    {
        return goodName;
    }
    
    public LocalDate getReceiptDate() // метод за показване кога е издадена касовата бележка
    {
        return receiptDate;
    }
    
    public int getReceiptGoodsQuantity() // метод за показване на количеството от стоката която е закупена
    {
        return receiptGoodsQuantity;
    }
    
    public double getReceiptGoodsPrice() // метод за показване на обшия приход от купената стока за касовата бележка
    {
        return receiptGoodsPrice;
    }
    
    // метод за записване в файл на данните на касовата бележка
    public void SaveIntoFile(int receiptNumber, double receiptGoodsPrice, String cashierName, int goodAmount, double goodPrice, String cashierDesk) {
    try
    {
        FileWriter fw = new FileWriter(this.receiptId + ".txt");
        PrintWriter pw = new PrintWriter(fw, true);
        
        LocalDate goodExpDate = LocalDate.now();
        Goods goodsPrice = new Goods(0, "Cheese", goodExpDate, 3);
        pw.println("----------------------");
        pw.println("Receipt ID: " + receiptId);
        pw.println("Receipt Made On: " + receiptDate);
        pw.println("Good Sold: " + goodName);
        pw.println(goodName + " price is: " + goodPrice);
        pw.println("Quantity: " + goodAmount);
        pw.println("Final price: " + goodsPrice.getGoodPrice() * goodAmount);
        pw.println("Number of receipts: " + receiptNumber);      
        pw.println("Cashier who sold the good: " + cashierName);
        pw.println("Cashier " + cashierName + " working on " + "paydesk " + cashierDesk);
        pw.println("----------------------");
        pw.close();  
    }
    catch(IOException e) 
    {
        System.out.println("Something went wrong..."); // exception ако файла не е намерен
    }
    }
    
    // Четене от файл
    public void ReadFromFile() 
    {
        try
        {
            FileReader fr = new FileReader(this.receiptId + ".txt");
            BufferedReader br = new BufferedReader(fr);

            String str; 
            while ((str = br.readLine()) != null) // четене на всеки ред от файла
            {
                System.out.println(str + "\n");
            }

            br.close(); // спираме четенето
        }

        catch(IOException e)
        {
            System.out.println("Cannot find the file to read from..."); // exception ако файла за четене не бъде намерен
        }
    }
    
    public int payDeskNumber()
    {
        for(int i = 0; i < 2; i++)
        {
            this.payDeskNumber =+ 1;
        }  
        return this.payDeskNumber;
    }
    
    
}
