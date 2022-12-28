/********************************************************************************
 * Copyright (c) 2021-2022 EclipseSource and others.
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
package com.oc2.diagrams.flowgraph.handler;

import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.glsp.graph.GNode;
import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.graph.builder.impl.GArguments;
import org.eclipse.glsp.server.model.GModelState;
import org.eclipse.glsp.server.utils.GModelUtil;

import com.oc2.diagrams.flowgraph.FlowgraphPackage;
import com.oc2.diagrams.flowgraph.utils.FlowgraphBuilder.FlowParameterBuilder;
import com.oc2.diagrams.flowgraph.utils.FlowgraphBuilder.FlowParametersBuilder;
import com.oc2.diagrams.flowgraph.utils.ModelTypes;

public class CreateFlowParametersHandler extends CreateFlowgraphNodeOperationHandler {

   public CreateFlowParametersHandler() {
      super(ModelTypes.FLOW_PARAMETERS);
   }

   protected FlowParametersBuilder builder(final Optional<GPoint> point, final GModelState modelState) {
      int nodeCounter = GModelUtil.generateId(FlowgraphPackage.Literals.FLOW_PARAMETER, "flowParameters", modelState);
      String name = "Parameters" + nodeCounter;
      return new FlowParametersBuilder(name, ECollections.asEList(
         new FlowParameterBuilder("param1").build(),
         new FlowParameterBuilder("param2").build(),
         new FlowParameterBuilder("param3").build()))
         .position(point.orElse(null))
         .addArguments(GArguments.cornerRadius(5))
         .addCssClass("flowParameters");
   }

   @Override
   protected GNode createNode(final Optional<GPoint> point, final Map<String, String> args) {
      return builder(point, modelState).build();
   }

   @Override
   public String getLabel() { return "Parámetros"; }
}
