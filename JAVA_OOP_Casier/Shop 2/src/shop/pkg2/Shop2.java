/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.pkg2;

import java.time.LocalDate; // пакет за дати
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stiliyangoshev97
 */
public class Shop2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Обект касиер
        Cashier cashier1 = new Cashier(0, "");
        Cashier cashier2 = new Cashier(0, "");
        Cashier cashier3 = new Cashier(0, "");
       
        // Обект стока
        LocalDate expDate = LocalDate.now();  // инициализация на срок на годност на стоката
        Goods good = new Goods(0, "Cheese", expDate, 3);
        
        System.out.println("Goods information");
        System.out.println("Good Name: " + good.getGoodName()); // Име на стоката
        System.out.println("Good " + good.getGoodName() + " ID is: " + good.getGoodId()); // ID на стоката
        System.out.println("Good " + good.getGoodName() + " Expires: " + good.getGoodExpDate()); // Срок на годност
        System.out.println("Good " + good.getGoodName() + " Price: " + good.getGoodPrice()); // Цена на стоката
        
        System.out.println("");
        
        Magazine magazine = new Magazine(15);
       
        //int cashierId = cashier.getCashierId(); /// инициализация на ID на касиер
        magazine.addCashier(cashier1, "Nicolas", 0);
        magazine.addCashier(cashier2, "Vladimir", 1);
        magazine.addCashier(cashier3, "Ivet", 2);
        
        System.out.println("Cashier Information");
        
        // Списък с касиери
        System.out.println("Cashier List");
        System.out.println(magazine.getCashierList());
        
        // Отпечатване на ID номера на всеки един от касиерите
        System.out.println("Cashier IDs: ");
        System.out.println(magazine.getCashier(cashier1) + " ID is " + cashier1.getCashierId());
        System.out.println(magazine.getCashier(cashier2) + " ID is " + cashier2.getCashierId());
        System.out.println(magazine.getCashier(cashier3) + " ID is " + cashier3.getCashierId());

        
        System.out.println("");
        System.out.println("Magazine information");
        System.out.println("Can good " + good.getGoodName() + " be sold: " + magazine.goodsSold());
        
        int receiptId = 0; // инициализация на поредния номер на касовата бележка
        
        
        
        // Купуваме стока
        System.out.println("\nBuying Cheese: ");
        magazine.buyStock(good, 2, cashier1.getCashierName());
        if(magazine.getBuy() == true) // проверка дали е купена стоката
        {
            receiptId = 1; // задаваме стойност на поредния номер касова бележка (1 зашото е първата издадена)
        }
        int goodsSold = magazine.getGoodsSold(); // Общо Количество купена стока до сега
        System.out.println(good.getGoodName() + " sold: " + goodsSold); // Име на купената стока и количеството което е купено
        System.out.println("Number of receipts: " + magazine.getReceiptNumber());
       // magazine.SetShopProfit(good.getGoodPrice());
        double shopProfit = magazine.getShopProfit();
        System.out.println("Shop Profit: " + shopProfit); // Печалба на магазина от продадената стока
        
        
        // Инициализация на двете каси
        NewThread cashierDesk1 = new NewThread("Cashier Desk 2");
        Thread t1 = new Thread(cashierDesk1, "Cashier Desk 2");
        NewThread cashierDesk2 = new NewThread("Cashier Desk 3");
        Thread t2 = new Thread(cashierDesk2, "Cashier Desk 3");
        
        try
        {
            t1.join();
            t2.join();
        }
         catch ( Exception e) 
        {
            System.out.println("Interrupted");
        }
        
        // Стариране на threadovete
        t1.start();
        t2.start();
        
        
        // Обект касова бележка
        double receiptGoodsPrice = magazine.getShopProfit();
        LocalDate receiptDate = LocalDate.now();
        Receipt receipt = new Receipt(receiptId, cashier1.getCashierName(), good.getGoodName(), receiptDate, magazine.getGoodsSold(), receiptGoodsPrice);
        
        // Записване в файл на касовата бележка
        receipt.SaveIntoFile(magazine.getReceiptNumber(), receiptGoodsPrice, cashier1.getCashierName(),  magazine.getGoodAmount(), good.getGoodPrice(), "Cashier Desk 1");
        
        // Четене от файл
        System.out.println("\nReading from file");
        receipt.ReadFromFile();
        
       
       
                
     
        // Купуване на стока
        System.out.println("\nBuying Cheese: ");
        magazine.buyStock(good, 1, cashier3.getCashierName());
        if(magazine.getBuy() == true) // проверка дали е купена стоката
        {
            receipt.ReceiptIdIncrement(receiptId); // инкрементираме поредния номер на касовата бележка
            receiptId = receipt.getReceiptId(); // пореден номер на касовата бележка
            receiptGoodsPrice = magazine.getShopProfit(); // приход от закупените стоки според тяхното количество
            
        }
        goodsSold = magazine.getGoodsSold(); // Количество купена стока
        System.out.println(good.getGoodName() + " sold: " + goodsSold); // Име на купената стока и количеството което е купено
        System.out.println("Number of receipts: " + magazine.getReceiptNumber());
        shopProfit = magazine.getShopProfit();
        System.out.println("Shop Profit: " + shopProfit); // Печалба на магазина от продадената стока
        
        // Записване в файл на касовата бележка
        receipt.SaveIntoFile(magazine.getReceiptNumber(), receiptGoodsPrice, cashier2.getCashierName(), magazine.getGoodAmount(), good.getGoodPrice(), t1.getName());
        
        // Четене от файл
        System.out.println("\nReading from file");
        receipt.ReadFromFile();
       
        
      
        
        // Купуване на стока
        System.out.println("\nBuying Cheese: ");
        magazine.buyStock(good, 2, cashier2.getCashierName());
        if(magazine.getBuy() == true) // проверка дали е купена стоката
        {
            receipt.ReceiptIdIncrement(receiptId); // инкрементираме поредния номер на касовата бележка
            receiptId = receipt.getReceiptId(); // пореден номер на касовата бележка
            receiptGoodsPrice = magazine.getShopProfit(); // приход от закупените стоки според тяхното количество
        }
        goodsSold = magazine.getGoodsSold(); // Количество купена стока
        System.out.println(good.getGoodName() + " sold: " + goodsSold); // Име на купената стока и количеството което е купено
        System.out.println("Number of receipts: " + magazine.getReceiptNumber());
        shopProfit = magazine.getShopProfit();
        System.out.println("Shop Profit: " + shopProfit); // Печалба на магазина от продадената стока
        // Записване в файл на касовата бележка
        receipt.SaveIntoFile(magazine.getReceiptNumber(), receiptGoodsPrice, cashier3.getCashierName(), magazine.getGoodAmount(), good.getGoodPrice(), t2.getName());
        // Четене от файл
        System.out.println("\nReading from file");
        receipt.ReadFromFile();
       
      
       
        
     
        System.out.println("\n");
        
        

        
        
    }
    
}
