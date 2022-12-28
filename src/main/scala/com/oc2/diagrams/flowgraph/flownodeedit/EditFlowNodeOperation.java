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

public class EditFlowNodeOperation extends Operation {

   private String flowNodeId;
   private String feature;
   private String value;

   public EditFlowNodeOperation() {
      super("editFlowNode");
   }

   public EditFlowNodeOperation(final String flowNodeId, final String feature, final String value) {
      this();
      this.flowNodeId = flowNodeId;
      this.feature = feature;
      this.value = value;
   }

   public String getFlowNodeId() { return flowNodeId; }

   public void setFlowNodeId(final String flowNodeId) { this.flowNodeId = flowNodeId; }

   public String getFeature() { return feature; }

   public void setFeature(final String feature) { this.feature = feature; }

   public String getValue() { return value; }

   public void setValue(final String value) { this.value = value; }

}
