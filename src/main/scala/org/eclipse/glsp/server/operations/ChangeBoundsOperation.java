/********************************************************************************
 * Copyright (c) 2019-2021 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package org.eclipse.glsp.server.operations;

import org.eclipse.glsp.server.types.ElementAndBounds;

import java.util.ArrayList;
import java.util.List;

public class ChangeBoundsOperation extends Operation {

   public static final String KIND = "changeBounds";

   private List<ElementAndBounds> newBounds;

   public ChangeBoundsOperation() {
      this(new ArrayList<>());
   }

   public ChangeBoundsOperation(final List<ElementAndBounds> newBounds) {
      super(KIND);
      this.newBounds = newBounds;
   }

   public List<ElementAndBounds> getNewBounds() { return newBounds; }

   public void setNewBounds(final List<ElementAndBounds> newBounds) { this.newBounds = newBounds; }

}
