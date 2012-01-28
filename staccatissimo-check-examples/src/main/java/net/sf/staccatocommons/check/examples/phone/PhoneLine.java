
package net.sf.staccatocommons.check.examples.phone;

import net.sf.staccatocommons.defs.partial.ContainsAware;

public interface PhoneLine {
  boolean isBusy();

  ContainsAware<CallDestination> getAllowedDestinations();
}