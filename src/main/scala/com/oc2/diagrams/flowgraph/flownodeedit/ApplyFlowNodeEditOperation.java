/********************************************************************************
 * Copyright (c) 2020 EclipseSource and others.
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
package com.oc2.diagrams.flowgraph.flownodeedit;

import org.eclipse.glsp.server.operations.Operation;

public class ApplyFlowNodeEditOperation extends Operation {

   private String flowNodeId;
   private String expression;

   public ApplyFlowNodeEditOperation() {
      super("applyFlowNodeEdit");
   }

   public ApplyFlowNodeEditOperation(final String flowNodeId, final String expression) {
      this();
      this.flowNodeId = flowNodeId;
      this.expression = expression;
   }

   public String getFlowNodeId() { return flowNodeId; }

   public void setFlowNodeId(final String flowNodeId) { this.flowNodeId = flowNodeId; }

   public String getExpression() { return expression; }

   public void setExpression(final String expression) { this.expression = expression; }

}
