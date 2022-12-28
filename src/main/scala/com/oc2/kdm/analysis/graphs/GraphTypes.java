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
package com.oc2.kdm.analysis.graphs;

public final class GraphTypes {
   private GraphTypes() {}

   public static final String INITIAL = "initial:node";
   public static final String ENDING = "ending:node";
   public static final String INPUT = "input:node";
   public static final String OUTPUT = "output:node";
   public static final String CODE = "code:node";
   public static final String CALL = "call:node";

   public static final String EDGE = "principal:edge";
   public static final String EDGE_TRUE = "true:edge";
   public static final String EDGE_FALSE = "false:edge";

   public static final String FOR = "for:loop";
   public static final String REPEAT = "repeat:loop";

   public static final String IF = "if:decision";
   public static final String ELSE = "else:decision";


   @SuppressWarnings("checkstyle:CyclomaticComplexity")
   public static String toGraphType(final String type) {
      switch (type) {
         case CODE:
            return "code";
         case FOR:
            return "for";
         case INPUT:
            return "forkNode";
         case OUTPUT:
            return "forkNode";
         case REPEAT:
            return "joinNode";
         case IF:
            return "manual";
         case ELSE:
            return "automated";
         default:
            return "unknown";
      }
   }
}
