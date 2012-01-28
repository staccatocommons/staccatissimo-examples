package net.sf.staccatocommons.instrument.examples;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;
import net.sf.staccatocommons.instrument.context.MethodAnnotationContext;
import net.sf.staccatocommons.instrument.handler.MethodAnnotationHandler;



/**
 * @author flbulgarelli
 * 
 */
public class LogHandler implements MethodAnnotationHandler<Loggeable> {

	public Class<Loggeable> getSupportedAnnotationType() {
		return Loggeable.class;
	}

	public void preProcessAnnotatedMethod(Loggeable annotation, MethodAnnotationContext context)
		throws CannotCompileException {
		if (!hasLogger(context)) {
			CtClass declaringClass = context.getMethod().getDeclaringClass();
			CtField field = CtField.make(
				"private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(\""
					+ declaringClass.getName() + "\");",
				declaringClass);
			declaringClass.addField(field);
		}
	}

	public void postProcessAnnotatedMethod(Loggeable annotation, MethodAnnotationContext context)
		throws CannotCompileException {
		context.getMethod().insertAfter("logger.warning(\"" + context.getMethod().getName() + "\");");
		context.getMethod().addCatch("logger.severe($e.getMessage());throw $e;", getThrowable(context));
	}

	private boolean hasLogger(MethodAnnotationContext context) {
		try {
			context.getMethod().getDeclaringClass().getField("logger");
			return true;
		} catch (NotFoundException e) {
			return false;
		}
	}

	private CtClass getThrowable(MethodAnnotationContext context) {
		try {
			return context.getClassPool().get(Throwable.class.getCanonicalName());
		} catch (NotFoundException e) {
			// can never happen
			throw new AssertionError(e);
		}
	}
}
