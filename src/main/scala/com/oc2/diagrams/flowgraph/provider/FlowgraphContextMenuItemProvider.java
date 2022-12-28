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
package com.oc2.diagrams.flowgraph.provider;

import static com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.INPUT_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE;
import static com.oc2.diagrams.flowgraph.utils.ModelTypes.SCREEN_NODE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.glsp.graph.GPoint;
import org.eclipse.glsp.server.features.contextmenu.ContextMenuItemProvider;
import org.eclipse.glsp.server.features.contextmenu.MenuItem;
import org.eclipse.glsp.server.model.GModelState;
import org.eclipse.glsp.server.operations.CreateNodeOperation;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.oc2.diagrams.flowgraph.handler.GridSnapper;

public class FlowgraphContextMenuItemProvider implements ContextMenuItemProvider {

   @Inject
   protected GModelState modelState;

   @Override
   public List<MenuItem> getItems(final List<String> selectedElementIds, final GPoint position,
      final Map<String, String> args) {
      if (modelState.isReadonly()) {
         return Collections.emptyList();
      }
      GPoint snappedPosition = GridSnapper.snap(position);
      MenuItem newExtCallNode = new MenuItem("newExtCallNode", "Llamada externa",
         Arrays.asList(new CreateNodeOperation(EXTERNAL_CALL_NODE, snappedPosition)), true);
      MenuItem newIntCallNode = new MenuItem("newIntCallNode", "Llamada interna",
         Arrays.asList(new CreateNodeOperation(INTERNAL_CALL_NODE, snappedPosition)), true);
      MenuItem newInputNode = new MenuItem("newInputNode", "Entrada",
         Arrays.asList(new CreateNodeOperation(INPUT_NODE, snappedPosition)), true);
      MenuItem newScreenNode = new MenuItem("newScreenNode", "Pantalla",
         Arrays.asList(new CreateNodeOperation(SCREEN_NODE, snappedPosition)), true);
      MenuItem newChildMenu = new MenuItem("new", "New",
         Arrays.asList(newExtCallNode, newIntCallNode, newInputNode, newScreenNode), "add",
         "0_new");
      return Lists.newArrayList(newChildMenu);
   }

}
