package unitTestCases;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Currency;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import osCommerceTerminal.Configuration;
import osCommerceTerminal.Price;
import osCommerceTerminal.ProductItem;
import osCommerceTerminal.ShoppingCart;

class testShoppingCartPriceInDefaultCurrency {

	static ShoppingCart sc1;
    static ShoppingCart sc2;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
		//Obtenemos la instancia de configuración
		Configuration c=Configuration.getInstance();
				
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//Creamos un shopping cart
				sc1 = new ShoppingCart("MyFirstShoppingCart");
						
				//Creamos y añadimos product items
				ProductItem p1 = new ProductItem("Camiseta", 18 , 1);
				ProductItem p2 = new ProductItem("Pantalones", 68, 1);
				sc1.addProductItem(p1);
				sc1.addProductItem(p2);
						
				
				//Creamos otro shopping cart
				sc2 = new ShoppingCart("MySecondShoppingCart");
				
				//Creamos y añadimos product items
				ProductItem p3 = new ProductItem("Blusa", 40, 2);
				ProductItem p4 = new ProductItem("Calcetines", 6, 3);
				sc2.addProductItem(p3);
				sc2.addProductItem(p4);}

@AfterEach
	void tearDown() throws Exception {}

@Test
void testSimplePrice() {
assertEquals(98, sc2.totalPrice().getAmount());}
	
@Test
void testPriceWithQuantities() {
assertEquals(86, sc1.totalPrice().getAmount());}
		
	 				
	@Test
	void addProductItemAndCheckPrice() {
	sc1.addProductItem(new ProductItem("objeto",40,1));
	assertEquals(126, sc1.totalPrice().getAmount());
		    
		    
	sc2.addProductItem(new ProductItem("objeto2",100,1));
	double x = 198;
	assertEquals(x, sc2.totalPrice().getAmount());} 
					
		
	@Test
	void removeProductItemAndCheckPrice() {
	sc2.removeProductItem(1);
	double x = 80;
	assertEquals(x, sc2.totalPrice().getAmount());}
			
@Test
void checkPriceWithOtherCurrencies() throws Exception {
NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
System.out.println("EUR (Actual): " + defaultFormat.format(sc2.totalPrice().getAmount()));
Currency GBPCurrency=Currency.getInstance("GBP");
System.out.println(sc2.totalPrice(GBPCurrency).getAmount());
double x = 86.17924000000001;
assertEquals(x, sc2.totalPrice(GBPCurrency).getAmount());}		
}
