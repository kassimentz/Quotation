package main;

import controller.QuotationController;

public class Main {

	 public static void main(String[] args) { 
		 QuotationController qc = new QuotationController();
		 //System.out.println(qc.currencyQuotation("USD", "EUR", 100.00, "20/11/2014"));
		 System.out.println(qc.currencyQuotation("USD", "EUR", 100.00, "28/12/2016"));
	 }
}
