/********************************************************************************
 * Copyright (c) 2020-2021 EclipseSource and others.
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

import java.util.Optional;

import org.eclipse.glsp.server.model.GModelState;
import org.eclipse.glsp.server.operations.AbstractOperationHandler;
import org.eclipse.glsp.server.types.GLSPServerException;

import com.google.inject.Inject;
import com.oc2.diagrams.flowgraph.FlowNode;

public class EditFlowNodeOperationHandler extends AbstractOperationHandler<EditFlowNodeOperation> {

   @Inject
   protected GModelState modelState;

   @Override
   protected void executeOperation(final EditFlowNodeOperation operation) {
      Optional<FlowNode> flowNode = modelState.getIndex().findElementByClass(operation.getFlowNodeId(), FlowNode.class);
      if (flowNode.isEmpty()) {
         throw new RuntimeException("Cannot find node with id '" + operation.getFlowNodeId() + "'");
      }
      switch (operation.getFeature()) {
         case "description":
            flowNode.get().setDescription(operation.getValue());
            break;
         case "nodeType":
            flowNode.get().setNodeType(operation.getValue());
            break;
         default:
            throw new GLSPServerException("Cannot edit task at feature '" + operation.getFeature() + "'");
      }
   }

}
