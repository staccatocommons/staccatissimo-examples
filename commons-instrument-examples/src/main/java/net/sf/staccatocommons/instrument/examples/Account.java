package net.sf.staccatocommons.instrument.examples;

import java.math.BigDecimal;
import java.util.logging.Logger;



/**
 * @author flbulgarelli
 * 
 */
public class Account {

	private BigDecimal balance;

	private static final Logger logger = Logger.getLogger(Account.class.getCanonicalName());

	public Account(BigDecimal balance) {
		this.balance = balance;
	}

	public void deposit(BigDecimal amount) {
		if (amount == null) {
			String message = "amount must not be null";
			logger.severe(message);
			throw new IllegalArgumentException(message);
		}
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			String message = "amount must be positive";
			logger.severe(message);
			throw new IllegalArgumentException(message);
		}
		balance = balance.add(amount);
		logger.warning("deposit");
	}

	public void resetBalance() {
		balance = BigDecimal.ZERO;
		logger.warning("resetBalance");
	}

	public BigDecimal getBalance() {
		return balance;
	}

}