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
package com.oc2.diagrams.flowgraph;

import org.eclipse.glsp.graph.GraphExtension;
import org.eclipse.glsp.server.actions.ActionHandler;
import org.eclipse.glsp.server.di.MultiBinding;
import org.eclipse.glsp.server.diagram.DiagramConfiguration;
import org.eclipse.glsp.server.features.commandpalette.CommandPaletteActionProvider;
import org.eclipse.glsp.server.features.contextactions.ContextActionsProvider;
import org.eclipse.glsp.server.features.contextactions.RequestContextActionsHandler;
import org.eclipse.glsp.server.features.contextmenu.ContextMenuItemProvider;
import org.eclipse.glsp.server.features.core.model.SourceModelStorage;
import org.eclipse.glsp.server.features.directediting.ContextEditValidator;
import org.eclipse.glsp.server.features.directediting.LabelEditValidator;
import org.eclipse.glsp.server.features.navigation.NavigationTargetProvider;
import org.eclipse.glsp.server.features.navigation.NavigationTargetResolver;
import org.eclipse.glsp.server.features.popup.PopupModelFactory;
import org.eclipse.glsp.server.features.sourcemodelwatcher.FileWatcher;
import org.eclipse.glsp.server.features.sourcemodelwatcher.SourceModelWatcher;
import org.eclipse.glsp.server.features.validation.ModelValidator;
import org.eclipse.glsp.server.gmodel.GModelDiagramModule;
import org.eclipse.glsp.server.gmodel.GModelStorage;
import org.eclipse.glsp.server.layout.LayoutEngine;
import org.eclipse.glsp.server.operations.OperationHandler;

import com.oc2.diagrams.commons.handler.LogActionHandler;
import com.oc2.diagrams.flowgraph.flownodeedit.ApplyFlowNodeEditOperationHandler;
import com.oc2.diagrams.flowgraph.flownodeedit.EditFlowNodeOperationHandler;
import com.oc2.diagrams.flowgraph.flownodeedit.FlowNodeEditContextActionProvider;
import com.oc2.diagrams.flowgraph.flownodeedit.FlowNodeEditValidator;
import com.oc2.diagrams.flowgraph.handler.CreateEdgeHandler;
import com.oc2.diagrams.flowgraph.handler.CreateExternalCallNodeHandler;
import com.oc2.diagrams.flowgraph.handler.CreateFlowDecisionHandler;
import com.oc2.diagrams.flowgraph.handler.CreateFlowParametersHandler;
import com.oc2.diagrams.flowgraph.handler.CreateInputNodeHandler;
import com.oc2.diagrams.flowgraph.handler.CreateInternalCallNodeHandler;
import com.oc2.diagrams.flowgraph.handler.CreateLabeledEdgeHandler;
import com.oc2.diagrams.flowgraph.handler.CreateScreenNodeHandler;
import com.oc2.diagrams.flowgraph.handler.FlowgraphRequestContextActionsHandler;
import com.oc2.diagrams.flowgraph.labeledit.FlowgraphLabelEditValidator;
import com.oc2.diagrams.flowgraph.layout.FlowgraphLayoutEngine;
import com.oc2.diagrams.flowgraph.marker.FlowgraphModelValidator;
import com.oc2.diagrams.flowgraph.model.FlowgraphNavigationTargetResolver;
import com.oc2.diagrams.flowgraph.provider.FlowgraphCommandPaletteActionProvider;
import com.oc2.diagrams.flowgraph.provider.FlowgraphContextMenuItemProvider;
import com.oc2.diagrams.flowgraph.provider.NextNodeNavigationTargetProvider;
import com.oc2.diagrams.flowgraph.provider.NodeDocumentationNavigationTargetProvider;
import com.oc2.diagrams.flowgraph.provider.PreviousNodeNavigationTargetProvider;

public class FlowgraphDiagramModule extends GModelDiagramModule {

   @Override
   protected Class<? extends DiagramConfiguration> bindDiagramConfiguration() {
      return FlowgraphDiagramConfiguration.class;
   }

   @Override
   protected Class<? extends SourceModelStorage> bindSourceModelStorage() {
      return GModelStorage.class;
   }

   @Override
   protected Class<? extends SourceModelWatcher> bindSourceModelWatcher() {
      return FileWatcher.class;
   }

   @Override
   protected Class<? extends GraphExtension> bindGraphExtension() {
      return FlowgraphExtension.class;
   }

   @Override
   protected void configureContextActionsProviders(final MultiBinding<ContextActionsProvider> binding) {
      super.configureContextActionsProviders(binding);
      binding.add(FlowNodeEditContextActionProvider.class);
   }

   @Override
   protected void configureContextEditValidators(final MultiBinding<ContextEditValidator> binding) {
      super.configureContextEditValidators(binding);
      binding.add(FlowNodeEditValidator.class);
   }

   @Override
   protected void configureNavigationTargetProviders(final MultiBinding<NavigationTargetProvider> binding) {
      super.configureNavigationTargetProviders(binding);
      binding.add(NextNodeNavigationTargetProvider.class);
      binding.add(PreviousNodeNavigationTargetProvider.class);
      binding.add(NodeDocumentationNavigationTargetProvider.class);
   }

   @Override
   protected void configureOperationHandlers(final MultiBinding<OperationHandler> binding) {
      super.configureOperationHandlers(binding);
      binding.add(CreateExternalCallNodeHandler.class);
      binding.add(CreateInternalCallNodeHandler.class);
      binding.add(CreateInputNodeHandler.class);
      binding.add(CreateScreenNodeHandler.class);
      binding.add(CreateEdgeHandler.class);
      binding.add(CreateLabeledEdgeHandler.class);
      binding.add(CreateFlowDecisionHandler.class);
      binding.add(CreateFlowParametersHandler.class);
      binding.add(EditFlowNodeOperationHandler.class);
      binding.add(ApplyFlowNodeEditOperationHandler.class);
   }

   @Override
   protected void configureActionHandlers(final MultiBinding<ActionHandler> binding) {
      super.configureActionHandlers(binding);
      binding.rebind(RequestContextActionsHandler.class, FlowgraphRequestContextActionsHandler.class);
      binding.add(LogActionHandler.class);
   }

   @Override
   public Class<? extends PopupModelFactory> bindPopupModelFactory() {
      return FlowgraphPopupFactory.class;
   }

   @Override
   protected Class<? extends ModelValidator> bindModelValidator() {
      return FlowgraphModelValidator.class;
   }

   @Override
   protected Class<? extends LabelEditValidator> bindLabelEditValidator() {
      return FlowgraphLabelEditValidator.class;
   }

   @Override
   protected Class<? extends LayoutEngine> bindLayoutEngine() {
      return FlowgraphLayoutEngine.class;
   }

   @Override
   protected Class<? extends ContextMenuItemProvider> bindContextMenuItemProvider() {
      return FlowgraphContextMenuItemProvider.class;
   }

   @Override
   protected Class<? extends CommandPaletteActionProvider> bindCommandPaletteActionProvider() {
      return FlowgraphCommandPaletteActionProvider.class;
   }

   @Override
   protected Class<? extends NavigationTargetResolver> bindNavigationTargetResolver() {
      return FlowgraphNavigationTargetResolver.class;
   }

   @Override
   public String getDiagramType() { return "flowgraph-diagram"; }

}
