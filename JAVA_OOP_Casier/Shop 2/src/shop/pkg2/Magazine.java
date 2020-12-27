/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.pkg2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stiliyangoshev97
 */
public class Magazine {

    private List<Cashier> cashierList;

    private boolean buy; // булева променлива - купена ли е стоката или не? при метод bought
    private boolean goodsWasSold; // булева променлива - стоката е купена при метод goodSold
    private int goodsSold; // брой продадени стоки

    private int receiptNumber; // брой на касови бележки
    private int goodN; // количество стока
    private double shopProfit;  // приход на магазина

    private int goodAmount;
    
  

    public Magazine(int goodsN) // конструктор
    {
        cashierList = new ArrayList<>();
        this.goodN = goodsN;
    }
    
    public void addCashier(Cashier cashier, String cashierName, int cashierId)
    {
        cashier.setCashierName(cashierName);
        cashier.setCashierID(cashierId);
        cashierList.add(cashier);
    }
    
    

    public String getCashierList() // Принтваме името на касиерите
    {
        for (int i = 0; i < cashierList.size(); i++) {
            System.out.println("Cashier " + (i + 1) + " " + cashierList.get(i).getCashierName());
        }
        return "";
    }
    
    public int getCashierListSize()
    {
        return cashierList.size();
    }

    // Метод за извикване на имената на касиери по тяхното ID
    public String getCashier(Cashier cashier) {
           return cashier.getCashierName();
    }
    
    public String getCashierName()
    {
        return cashierList.get(3).getCashierName();
    }

    // Проверка дали имаме минимум 1 от стоката за да може да се продаде
    public boolean goodsSold() {

        if (this.goodN == 0) {
            this.goodsWasSold = false; // стоката не е продадена защото няма достатъчно от нея
            return false;
        }
        this.goodsWasSold = true; // стоката е продадена защото има достатъчно от нея

        return true;
    }

    public void tryCatch() // Хвърля изключение ако стоката свърши
    {
        if (this.goodsWasSold == false) {
            throw new ArithmeticException("OUT OF STOCK EXCEPTION!");
        }

    }

    // Метод за купуване на стока
    
    public boolean buyStock(Goods good, int goodAmount, String cashierName) // добави stockPrice за shopProfit 
    {
        if (goodsSold() == true) { // проверка дали стоката може да бъде купена според нейното количество
            this.receiptNumber = this.receiptNumber + 1; // инкремент на брой касови бележки
            System.out.println(good.getGoodName() + " was bought. " + "Quantity bought: " + goodAmount); // колко бройки от стоката са купени
            this.goodN = this.goodN - goodAmount; // броя на стоката намалява според броя купени стоки
            System.out.println("Remaining number of " + good.getGoodName() + ": " + this.goodN); // оставащ брой за купуване на стоката
            this.buy = true; // стоката е купена
            this.goodAmount = goodAmount; // брой купена стока
            int goodsSold = goodAmount; // брой купени стоки е равен на количеството което е искано да се купи
            this.goodsSold = this.goodsSold + goodsSold;  // брой продадени стоки 
            this.shopProfit = this.shopProfit + good.getGoodPrice() * goodAmount; // приход на магазина 

            return true;
        } else {

            System.out.println("Sorry.. WE ARE OUT OF STOCK: " + good.getGoodName());
            tryCatch();
            System.out.println("Current good quantity bought: " + goodsSold); // количество купено от стоката до сега
            this.buy = false; // стоката не е купена защото няма достатъчно количество от нея
        }
        return false;

    }

    public int getGoodsSold() // метод за показване на брой купени стоки 
    {
        return goodsSold;
    }

    public int getReceiptNumber() // метод за показване на броя на издадените касови бележки
    {
        return receiptNumber;
    }

    public boolean getBuy() // метод за показване на булевата на стойност на buy
    {
        return buy;
    }

    public double getShopProfit() // метод за показване на прихода на магазина
    {
        return shopProfit;
    }

    public int getGoodAmount() // метод за показване на количеството искана за купуване стока
    {
        return goodAmount;
    }
    
   /* public void Pay1(String threadName)
    {
        Thread t1 = new Thread(new NewThread(threadName));
        t1.start();
    }
    
    public void Pay2(String threadName)
    {
        Thread t2 = new Thread(new NewThread(threadName));
        t2.start();
    }
    */
}
