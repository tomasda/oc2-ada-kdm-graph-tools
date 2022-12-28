/********************************************************************************
 * Copyright (c) 2019-2022 EclipseSource and others.
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
package com.oc2.diagrams.flowgraph.marker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.glsp.graph.GEdge;
import org.eclipse.glsp.graph.GLabel;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.server.features.validation.Marker;
import org.eclipse.glsp.server.features.validation.MarkerKind;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.glsp.server.model.GModelState;

import com.google.inject.Inject;
import com.oc2.diagrams.flowgraph.FlowDecision;
import com.oc2.diagrams.flowgraph.FlowNode;
import com.oc2.diagrams.flowgraph.utils.ModelTypes;

public class FlowgraphModelValidator implements ModelValidator {

   @Inject
   protected GModelState modelState;

   @Override
   public List<Marker> validate(final GModelElement... elements) {
      List<Marker> markers = new ArrayList<>();

      for (GModelElement element : elements) {
         if (element instanceof FlowNode) {
            markers.addAll(validateFlowNode(modelState, element));
         } else if (element instanceof FlowDecision) {
            markers.addAll(validateFlowDecision(modelState, element));
         }
         if (element.getChildren() != null) {
            markers.addAll(validate(element.getChildren().toArray(new GModelElement[element.getChildren().size()])));
         }
      }
      return markers;
   }

   private static List<Marker> validateFlowNode(final GModelState modelState, final GModelElement flowNode) {
      List<Marker> markers = new ArrayList<>();
      validateFlowNode_isInterrupt(modelState, flowNode).ifPresent(m -> markers.add(m));
      validateFlowNode_labelStartsUpperCase(modelState, flowNode).ifPresent(m -> markers.add(m));
      return markers;
   }

   @SuppressWarnings("checkstyle:MethodName")
   private static Optional<Marker> validateFlowNode_isInterrupt(final GModelState modelState,
      final GModelElement element) {
      FlowNode flowNode = (FlowNode) element;
      if ("inputNode".equals(flowNode.getNodeType())) {
         return Optional
            .of(new Marker("Input node", "This is an input node", element.getId(), MarkerKind.INFO));
      }
      if ("screenNode".equals(flowNode.getNodeType())) {
         return Optional
            .of(new Marker("Screen node", "This is a screen node", element.getId(), MarkerKind.INFO));
      }
      return Optional.empty();
   }

   @SuppressWarnings("checkstyle:MethodName")
   private static Optional<Marker> validateFlowNode_labelStartsUpperCase(final GModelState modelState,
      final GModelElement element) {
      FlowNode flowNode = (FlowNode) element;

      boolean hasLowerCaseLabel = flowNode.getChildren().stream()
         .filter(c -> ModelTypes.LABEL_HEADING.equals(c.getType()))
         .filter(GLabel.class::isInstance)
         .map(GLabel.class::cast)
         .map(GLabel::getText)
         .anyMatch(text -> text.length() > 0 && !Character.isUpperCase(text.charAt(0)));

      if (hasLowerCaseLabel) {
         return Optional.of(new Marker("Flow node label in upper case",
            "Flow node names should start with upper case letters", element.getId(), MarkerKind.WARNING));
      }
      return Optional.empty();
   }

   private static List<Marker> validateFlowDecision(final GModelState modelState,
      final GModelElement decisionNode) {
      List<Marker> markers = new ArrayList<>();
      validateFlowDecision_hasOneIncomingEdge(modelState, decisionNode).ifPresent(m -> markers.add(m));
      return markers;
   }

   @SuppressWarnings("checkstyle:MethodName")
   private static Optional<Marker> validateFlowDecision_hasOneIncomingEdge(final GModelState modelState,
      final GModelElement decisionNode) {
      Collection<GEdge> incomingEdges = modelState.getIndex().getIncomingEdges(decisionNode);
      if (incomingEdges.size() > 1) {
         return Optional.of(new Marker("Too many incoming edges", "Decision node may only have one incoming edge.",
            decisionNode.getId(), MarkerKind.ERROR));
      } else if (incomingEdges.size() == 0) {
         return Optional.of(new Marker("Missing incoming edge", "Decision node must have one incoming edge.",
            decisionNode.getId(), MarkerKind.ERROR));
      }
      return Optional.empty();
   }

}
