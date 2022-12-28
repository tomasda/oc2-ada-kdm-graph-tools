/********************************************************************************
 * Copyright (c) 2019 EclipseSource and others.
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
package org.eclipse.glsp.graph.builder.impl;

import org.eclipse.glsp.graph.DefaultTypes;
import org.eclipse.glsp.graph.GHtmlRoot;
import org.eclipse.glsp.graph.GraphFactory;
import org.eclipse.glsp.graph.builder.AbstractGHtmlRootBuilder;

public class GHtmlRootBuilder extends AbstractGHtmlRootBuilder<GHtmlRoot, GHtmlRootBuilder> {

   public GHtmlRootBuilder() {
      this(DefaultTypes.HTML);
   }

   public GHtmlRootBuilder(String type) {
      super(type);
   }

   @Override
   protected GHtmlRoot instantiate() {
      return GraphFactory.eINSTANCE.createGHtmlRoot();
   }

   @Override
   protected GHtmlRootBuilder self() {
      return this;
   }

}
