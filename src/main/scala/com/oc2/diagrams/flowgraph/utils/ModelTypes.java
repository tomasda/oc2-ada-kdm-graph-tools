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
package com.oc2.diagrams.flowgraph.utils;

public final class ModelTypes {
   private ModelTypes() {}

   public static final String LABEL_HEADING = "label:heading";
   public static final String LABEL_TEXT = "label:text";
   public static final String COMP_HEADER = "comp:header";
   public static final String LABEL_ICON = "label:icon";
   public static final String LABELED_EDGE = "edge:labeled";
   public static final String ICON = "icon";
   public static final String FLOW_NODE = "flowNode";
   public static final String EXTERNAL_CALL_NODE = FLOW_NODE + ":externalCallNode";
   public static final String INTERNAL_CALL_NODE = FLOW_NODE + ":internalCallNode";
   public static final String INPUT_NODE = FLOW_NODE + ":inputNode";
   public static final String SCREEN_NODE = FLOW_NODE + ":screenNode";
   public static final String FLOW_DECISION = "flowDecision";
   // public static final String BINARY_DECISION = FLOW_DECISION + ":binary";
   // public static final String MULTIPLE_DECISION = FLOW_DECISION + ":multiple";
   public static final String FLOW_PARAMETERS = "flowParameters";
   public static final String FLOW_PARAMETER = "flowParameter";
   public static final String STRUCTURE = "struct";

   @SuppressWarnings("checkstyle:CyclomaticComplexity")
   public static String toElementType(final String type) {
      switch (type) {
         case EXTERNAL_CALL_NODE:
            return "externalCallNode";
         case INTERNAL_CALL_NODE:
            return "internalCallNode";
         case INPUT_NODE:
            return "inputNode";
         case SCREEN_NODE:
            return "screenNode";
         case FLOW_DECISION:
            return "flowDecision";
         case FLOW_PARAMETERS:
            return "flowParameters";
         default:
            return "unknown";
      }
   }
}
