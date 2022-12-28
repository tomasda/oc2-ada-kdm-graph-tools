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
package com.oc2.diagrams.flowgraph;

import static com.oc2.diagrams.flowgraph.utils.ModelTypes.COMP_HEADER;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.FLOW_DECISION;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.FLOW_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.FLOW_PARAMETERS;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.ICON;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.INPUT_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.LABELED_EDGE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.LABEL_HEADING;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.LABEL_ICON;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.LABEL_TEXT;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.SCREEN_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.STRUCTURE;
import static org.eclipse.glsp.graph.DefaultTypes.EDGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.glsp.graph.DefaultTypes;
import org.eclipse.glsp.graph.GraphPackage;
import org.eclipse.glsp.server.diagram.BaseDiagramConfiguration;
import org.eclipse.glsp.server.layout.ServerLayoutKind;
import org.eclipse.glsp.server.types.EdgeTypeHint;
import org.eclipse.glsp.server.types.ShapeTypeHint;

public class FlowgraphDiagramConfiguration extends BaseDiagramConfiguration {

   @Override
   public Map<String, EClass> getTypeMappings() {
      Map<String, EClass> mappings = DefaultTypes.getDefaultTypeMappings();
      mappings.put(LABEL_HEADING, GraphPackage.Literals.GLABEL);
      mappings.put(LABEL_TEXT, GraphPackage.Literals.GLABEL);
      mappings.put(COMP_HEADER, GraphPackage.Literals.GCOMPARTMENT);
      mappings.put(LABEL_ICON, GraphPackage.Literals.GLABEL);
      mappings.put(LABELED_EDGE, GraphPackage.Literals.GEDGE);
      mappings.put(ICON, FlowgraphPackage.Literals.ICON);
      mappings.put(FLOW_NODE, FlowgraphPackage.Literals.FLOW_NODE);
      mappings.put(FLOW_DECISION, FlowgraphPackage.Literals.FLOW_DECISION);
      mappings.put(FLOW_PARAMETERS, FlowgraphPackage.Literals.FLOW_PARAMETERS);
      mappings.put(STRUCTURE, GraphPackage.Literals.GCOMPARTMENT);
      return mappings;
   }

   @Override
   public List<ShapeTypeHint> getShapeTypeHints() {
      List<ShapeTypeHint> nodeHints = new ArrayList<>();
      nodeHints.add(new ShapeTypeHint(EXTERNAL_CALL_NODE, true, true, true, true));
      nodeHints.add(new ShapeTypeHint(INTERNAL_CALL_NODE, true, true, true, true));
      nodeHints.add(new ShapeTypeHint(INPUT_NODE, true, true, true, true));
      nodeHints.add(new ShapeTypeHint(SCREEN_NODE, true, true, true, true));
      ShapeTypeHint catHint = new ShapeTypeHint(FLOW_PARAMETERS, true, true, true, true);
      catHint.setContainableElementTypeIds(
         Arrays.asList(FLOW_DECISION, EXTERNAL_CALL_NODE, INTERNAL_CALL_NODE, INPUT_NODE, SCREEN_NODE,
            FLOW_PARAMETERS));
      nodeHints.add(catHint);
      nodeHints.add(createDefaultShapeTypeHint(FLOW_DECISION));
      return nodeHints;
   }

   @Override
   public ShapeTypeHint createDefaultShapeTypeHint(final String elementId) {
      // Override the default-default: for the Workflow example, we want all nodes
      // to be reparentable
      return new ShapeTypeHint(elementId, true, true, true, true);
   }

   @Override
   public List<EdgeTypeHint> getEdgeTypeHints() {
      List<EdgeTypeHint> edgeHints = new ArrayList<>();
      edgeHints.add(createDefaultEdgeTypeHint(EDGE));
      EdgeTypeHint labeledEdgeHint = super.createDefaultEdgeTypeHint(LABELED_EDGE);
      labeledEdgeHint.setSourceElementTypeIds(Arrays.asList(FLOW_DECISION));
      labeledEdgeHint.setTargetElementTypeIds(
         Arrays.asList(EXTERNAL_CALL_NODE, INTERNAL_CALL_NODE, INPUT_NODE, SCREEN_NODE, FLOW_DECISION));
      edgeHints.add(labeledEdgeHint);
      return edgeHints;
   }

   @Override
   public EdgeTypeHint createDefaultEdgeTypeHint(final String elementId) {
      EdgeTypeHint hint = super.createDefaultEdgeTypeHint(elementId);
      hint.setSourceElementTypeIds(
         Arrays.asList(FLOW_DECISION, EXTERNAL_CALL_NODE, INTERNAL_CALL_NODE, INPUT_NODE, SCREEN_NODE));
      hint.setTargetElementTypeIds(
         Arrays.asList(FLOW_DECISION, EXTERNAL_CALL_NODE, INTERNAL_CALL_NODE, INPUT_NODE, SCREEN_NODE));
      return hint;
   }

   @Override
   public ServerLayoutKind getLayoutKind() { return ServerLayoutKind.MANUAL; }

   @Override
   public boolean needsClientLayout() {
      return true;
   }

}
