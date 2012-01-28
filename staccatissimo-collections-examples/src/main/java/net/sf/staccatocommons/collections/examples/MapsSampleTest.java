/*
 Copyright (c) 2012, The Staccato-Commons Team

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation; version 3 of the License.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.
 */
package net.sf.staccatocommons.collections.examples;

import static net.sf.staccatocommons.lang.tuple.Tuples.*;
import static org.junit.Assert.*;

import java.util.Map;

import net.sf.staccatocommons.collections.Maps;

import org.junit.Test;

/**
 * @author flbulgarelli
 * 
 */
public class MapsSampleTest {

  @Test
  public void sampleCreateFromTuples() throws Exception {
    Map<String, Integer> map = Maps.from( //
      _("Hello", 10),
      _("World", 20),
      _("StaccatoCommons", 30));

    assertEquals("{Hello=10, World=20, StaccatoCommons=30}", map.toString());
  }

  @Test
  public void testName() throws Exception {
  }
}
