package net.sf.staccatocommons.instrument.examples;

import java.math.BigDecimal;



/**
 * @author flbulgarelli
 * 
 */
public class Account2 {

	private BigDecimal balance;

	public Account2(BigDecimal balance) {
		this.balance = balance;
	}

	@Loggeable
	public void deposit(@NonNegativeDecimal("amount") BigDecimal amount) {
		balance = balance.add(amount);
	}

	@Loggeable
	public void resetBalance() {
		balance = BigDecimal.ZERO;
	}

	public BigDecimal getBalance() {
		return balance;
	}

}