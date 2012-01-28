
package net.sf.staccatocommons.check.examples.juice;

import java.util.Date;

/**
 * @author flbulgarelli
 */
interface JuiceRecipe {

	/** Prepares the juice */
	Juice prepare();

}

interface Juice {
	// dont't care
}

interface Pineapple {}

interface Banana {}

interface OrangeJuice {

	public boolean isNotTooAcid();

	public Date getExpirationDate();

}