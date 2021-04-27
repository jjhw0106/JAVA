
package atm;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class User {
	private String id;
	private String pw;
	private String name;
	ArrayList<Account> accList = new ArrayList<Account>();

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	String getPw() {
		return pw;
	}

	void setPw(String pw) {
		this.pw = pw;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

}

