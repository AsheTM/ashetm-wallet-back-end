package dev.ashetm.wallet.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private static int counter = 0;
	
	{ counter++; }
	
	private int id = -1;
	
	private String fullName;
	
	private List<Account> accounts = new ArrayList<>();

	public Client() {
		this.id = counter;
	}

	public Client(String fullName) {
		this.id = counter;
		this.fullName = fullName;
	}

	public Client(String fullName, List<Account> accounts) {
		this.id = counter;
		this.fullName = fullName;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void setAccount(Account account) {
		this.accounts.add(account);
	}

	public static ClientBuilder builder() {
		return new ClientBuilder();
	}
	
	public static class ClientBuilder {
		
		private Client client = new Client();

		public ClientBuilder() { }
		
		public ClientBuilder(Client transaction) {
			this.client = transaction;
		}
		
		public ClientBuilder fullName(String fullName) {
			this.client.setFullName(fullName);
			return this;
		}
		
		public ClientBuilder accounts(List<Account> accounts) {
			this.client.setAccounts(accounts);
			return this;
		}
		
		public Client build() {
			return this.client;
		}
		
	}

}
