package assigment;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BankModule implements Container, Iterator {
	
	private String bankName;
	private String countryOfOrigen;
	private Account[] list;
	private int index;
	private int id;
	
	public BankModule(String name, String origen, Account[] list, int id) {
		this.bankName = name;
		this.countryOfOrigen = origen;
		this.list = list;
		this.id = id;
		index = 0;
	}
	
	public void addAccount(String name, String number, double balance) {
		list = Arrays.copyOf(list, list.length + 1);
		list[list.length - 1] = new Account(name, number, balance);
	}
	public void remove(int index) {
		Account temp= list[index];
		list[index]=list[list.length-1];
		list[list.length-1]=temp;
		list = Arrays.copyOf(list, list.length -1);
	}
	

	public boolean hasNext() {
		return index < list.length;
	}

	public Object next() {
		Account acc = list[index++];
		return acc;
	}

	public Iterator iterator() {
		return new BankModule(bankName, countryOfOrigen, list, id);
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getCountryOfOrigen() {
		return countryOfOrigen;
	}



	public void setCountryOfOrigen(String countryOfOrigen) {
		this.countryOfOrigen = countryOfOrigen;
	}



	public Account[] getList() {
		return list;
	}



	public void setList(Account[] list) {
		this.list = list;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalAccount() {
		return list.length;
	}


	

}
