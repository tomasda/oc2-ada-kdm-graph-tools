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

import org.eclipse.glsp.server.actions.ActionDispatcher;
import org.eclipse.glsp.server.model.GModelState;
import org.eclipse.glsp.server.operations.AbstractOperationHandler;
import org.eclipse.glsp.server.types.GLSPServerException;

import com.google.inject.Inject;

public class ApplyFlowNodeEditOperationHandler extends AbstractOperationHandler<ApplyFlowNodeEditOperation> {

   @Inject
   protected ActionDispatcher actionDispatcher;

   @Inject
   protected GModelState modelState;

   @Override
   protected void executeOperation(final ApplyFlowNodeEditOperation operation) {
      String text = operation.getExpression();
      if (text.startsWith(FlowNodeEditContextActionProvider.DESCRIPTION_PREFIX)) {
         String descriptionString = text.substring(FlowNodeEditContextActionProvider.DESCRIPTION_PREFIX.length());
         actionDispatcher
            .dispatch(new EditFlowNodeOperation(operation.getFlowNodeId(), "description", descriptionString));
      } else if (text.startsWith(FlowNodeEditContextActionProvider.TYPE_PREFIX)) {
         String typeString = text.substring(FlowNodeEditContextActionProvider.TYPE_PREFIX.length());
         actionDispatcher.dispatch(new EditFlowNodeOperation(operation.getFlowNodeId(), "nodeType", typeString));
      } else {
         throw new GLSPServerException(
            "Cannot process 'ApplyFlowNodeEditOperation' expression: " + operation.getExpression());
      }
   }

}
