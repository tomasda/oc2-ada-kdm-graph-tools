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
package com.oc2.diagrams.flowgraph.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.glsp.graph.GEdge;
import org.eclipse.glsp.server.features.navigation.NavigationTarget;
import org.eclipse.glsp.server.features.navigation.NavigationTargetProvider;
import org.eclipse.glsp.server.model.GModelState;
import org.eclipse.glsp.server.types.EditorContext;
import org.eclipse.glsp.server.utils.ClientOptionsUtil;
import org.eclipse.glsp.server.utils.MapUtil;

import com.google.inject.Inject;
import com.oc2.diagrams.flowgraph.FlowNode;

public abstract class AbstractNextOrPreviousNavigationTargetProvider implements NavigationTargetProvider {

   @Inject
   protected GModelState modelState;

   @Override
   public List<? extends NavigationTarget> getTargets(final EditorContext editorContext) {
      Optional<String> sourceUri = MapUtil.getValue(modelState.getClientOptions(), ClientOptionsUtil.SOURCE_URI);
      return editorContext.getSelectedElementIds().stream()
         .flatMap(id -> modelState.getIndex().get(id).stream())
         .filter(FlowNode.class::isInstance).map(FlowNode.class::cast)
         .flatMap(flowNode -> getEdges(flowNode, modelState).stream())
         .map(edge -> getSourceOrTarget(edge))
         .map(id -> new NavigationTarget(sourceUri.orElse(""), createElementIdMap(id)))
         .collect(Collectors.toList());
   }

   private Map<String, String> createElementIdMap(final String id) {
      Map<String, String> map = new HashMap<>();
      map.put(NavigationTarget.ELEMENT_IDS, id);
      return map;
   }

   protected abstract Collection<GEdge> getEdges(FlowNode flowNode, GModelState modelState);

   protected abstract String getSourceOrTarget(GEdge edge);
}
