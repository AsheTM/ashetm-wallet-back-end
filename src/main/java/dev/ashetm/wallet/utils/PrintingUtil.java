package dev.ashetm.wallet.utils;

import java.io.PrintStream;
import java.util.List;
import java.util.function.BiFunction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Transaction;

@Aspect
public class PrintingUtil {
	
	private static final int lengthReceipt = 60;

	private static final PrintStream out = System.out;
	
	private static BiFunction<String, Integer, String> repeater = (stringToRepeat, n) -> {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0 ; i < n ; i++)
			stringBuilder.append(stringToRepeat);
		return stringBuilder.toString();
	}; 
	
	public static Account printReceipt(Account account) {
		out.println();
		out.println(repeater.apply("*", lengthReceipt));
		out.println("\t\tReceipt Account           ");
		out.println(account);
		for(Transaction transaction: account.getTransactions()) 
			printTransaction(transaction);
		out.println(repeater.apply("*", lengthReceipt));
		out.println();
		return account;
	}
	
	@Before("execution(*)")
	public static void printTransactions(List<Transaction> transactions) {
		if(!(!transactions.equals(null) && transactions.size() != 0)) return;
		for(Transaction transaction: transactions)
			printTransaction(transaction);
	}
	
	public static void printTransactions(Transaction... transactions) {
		if(!(!transactions.equals(null) && transactions.length != 0)) return;
		for(Transaction transaction: transactions)
			printTransaction(transaction);
	}
	
	public static void printTransaction(Transaction transaction) {
		if(!transaction.equals(null))
			out.println("\t\t" + transaction);
	}

}
