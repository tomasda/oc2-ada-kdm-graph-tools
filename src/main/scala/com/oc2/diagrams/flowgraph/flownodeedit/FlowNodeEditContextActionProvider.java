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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.glsp.server.features.contextactions.ContextActionsProvider;
import org.eclipse.glsp.server.features.contextactions.SetAutoCompleteValueAction;
import org.eclipse.glsp.server.features.directediting.LabeledAction;
import org.eclipse.glsp.server.model.GModelState;
import org.eclipse.glsp.server.types.EditorContext;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.oc2.diagrams.flowgraph.FlowNode;

public class FlowNodeEditContextActionProvider implements ContextActionsProvider {

   public static final String DESCRIPTION_PREFIX = "description:";
   public static final String TYPE_PREFIX = "type:";
   public static final String FLOW_NODE_PREFIX = "flowNode:";

   @Override
   public String getContextId() { return "flowNode-editor"; }

   @Inject
   protected GModelState modelState;

   @Override
   public List<? extends LabeledAction> getActions(final EditorContext editorContext) {
      String text = editorContext.getArgs().getOrDefault("text", "");
      Optional<FlowNode> flowNode = modelState.getIndex()
         .findElementByClass(editorContext.getSelectedElementIds().get(0), FlowNode.class);
      if (flowNode.isEmpty()) {
         return Collections.emptyList();
      }
      if (text.startsWith(TYPE_PREFIX)) {
         String id = flowNode.get().getId();
         return Lists.newArrayList(
            new LabeledAction("type:externalCallNode",
               Lists.newArrayList(new EditFlowNodeOperation(id, "nodeType", "externalCallNode"))),
            new LabeledAction("type:internalCallNode",
               Lists.newArrayList(new EditFlowNodeOperation(id, "nodeType", "interalCallNode"))),
            new LabeledAction("type:inputNode",
               Lists.newArrayList(new EditFlowNodeOperation(id, "nodeType", "inputNode"))),
            new LabeledAction("type:screenNode",
               Lists.newArrayList(new EditFlowNodeOperation(id, "nodeType", "screenNode"))));
      }
      if (text.startsWith(DESCRIPTION_PREFIX)) {
         return Collections.emptyList();
      }
      String flowNodeType = flowNode.get().getType().substring(FLOW_NODE_PREFIX.length());
      String description = flowNode.get().getDescription();
      return Lists.newArrayList(
         new SetAutoCompleteValueAction("Tipo:", "", TYPE_PREFIX + flowNodeType),
         new SetAutoCompleteValueAction("Descripción:", "", DESCRIPTION_PREFIX + description));
   }

}
