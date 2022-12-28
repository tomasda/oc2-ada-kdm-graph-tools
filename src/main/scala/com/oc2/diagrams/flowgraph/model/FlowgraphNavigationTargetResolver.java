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
package com.oc2.diagrams.flowgraph.model;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import org.eclipse.glsp.server.features.navigation.NavigationTarget;
import org.eclipse.glsp.server.features.navigation.NavigationTargetResolution;
import org.eclipse.glsp.server.features.navigation.NavigationTargetResolver;
import org.eclipse.glsp.server.model.GModelState;

import com.google.inject.Inject;
import com.oc2.diagrams.flowgraph.FlowNode;

public class FlowgraphNavigationTargetResolver implements NavigationTargetResolver {
   @Inject
   protected GModelState modelState;

   @Override
   public NavigationTargetResolution resolve(final NavigationTarget navigationTarget) {
      if (navigationTarget.getArgs().containsKey("name")) {
         String name = navigationTarget.getArgs().get("name");
         Set<FlowNode> flowNodes = modelState.getIndex().findAll(modelState.getRoot(), FlowNode.class);
         Optional<FlowNode> element = flowNodes.stream().filter(node -> name.equals(node.getName())).findFirst();
         if (element.isPresent()) {
            return new NavigationTargetResolution(Arrays.asList(element.get().getId()));
         }
         return new NavigationTargetResolution(Arrays.asList(),
            createArgsWithWarning("Couldn't find element with name " + name));
      }
      return NavigationTargetResolution.EMPTY;
   }
}
