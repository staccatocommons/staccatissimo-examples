
package net.sf.staccatocommons.instrument.examples;

import java.math.BigDecimal;

import net.sf.staccatocommons.instrument.InstrumentationRunner;
import net.sf.staccatocommons.instrument.config.InstrumenterConfiguration;
import net.sf.staccatocommons.instrument.config.InstrumenterConfigurer;
import net.sf.staccatocommons.instrument.config.SimpleInstrumentationMark;
import net.sf.staccatocommons.io.Directory;

/**
 * @author flbulgarelli
 * 
 */
public class Test {

	@org.junit.BeforeClass
	public static void before() throws Exception {
		InstrumentationRunner.runInstrumentation(new InstrumenterConfigurer() {
			public void configureInstrumenter(InstrumenterConfiguration instrumenter) {
				instrumenter //
					.addAnnotationHanlder(new LogHandler())
					.addAnnotationHanlder(new NonNegativeDecimalHandler())
					.setInstrumentationMark(new SimpleInstrumentationMark("log-example", "instrumented-1.0"));
			}
		},
			new Directory("target/classes"),
			"");
	}

	@org.junit.Test(expected = IllegalArgumentException.class)
	public void testNegativeAmmount() throws Exception {
		Account2 account2 = new Account2(BigDecimal.valueOf(10));
		account2.resetBalance();
		account2.deposit(BigDecimal.valueOf(-10));
	}
}
