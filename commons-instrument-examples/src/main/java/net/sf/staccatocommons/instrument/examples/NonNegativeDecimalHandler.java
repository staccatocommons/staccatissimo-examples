
package net.sf.staccatocommons.instrument.examples;

import javassist.CannotCompileException;
import net.sf.staccatocommons.instrument.context.ArgumentAnnotationContext;
import net.sf.staccatocommons.instrument.handler.ArgumentAnnotationHandler;

/**
 * @author flbulgarelli
 * 
 */
public class NonNegativeDecimalHandler implements ArgumentAnnotationHandler<NonNegativeDecimal> {

	public Class<NonNegativeDecimal> getSupportedAnnotationType() {
		return NonNegativeDecimal.class;
	}

	public void processAnnotatedArgument(NonNegativeDecimal annotation,
		ArgumentAnnotationContext context) throws CannotCompileException {
		context.getArgumentBehavior().insertBefore(
			"if (" + context.getArgumentIdentifier() + ".compareTo(java.math.BigDecimal.ZERO) < 0) { "
				+ "throw new IllegalArgumentException(\"" + annotation.value() + " must be positive\"); }");
	}
}
