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

import java.util.Optional;

import org.eclipse.glsp.graph.GBounds;
import org.eclipse.glsp.graph.GHtmlRoot;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GPreRenderedElement;
import org.eclipse.glsp.graph.builder.impl.GHtmlRootBuilder;
import org.eclipse.glsp.graph.builder.impl.GPreRenderedElementBuilder;
import org.eclipse.glsp.server.features.popup.PopupModelFactory;
import org.eclipse.glsp.server.features.popup.RequestPopupModelAction;

public class FlowgraphPopupFactory implements PopupModelFactory {

   private String generateTitle(final FlowElement fElement) {
      return fElement.getName();
   }

   private String generateBody(final FlowElement fElement) {
      if (fElement instanceof FlowNode) {
         FlowNode node = (FlowNode) fElement;
         return String.format(NL + "Tipo: %s" + NL + "Descripción: %s" + NL, node.getNodeType(),
            node.getDescription());
      } else if (fElement instanceof FlowDecision) {
         FlowDecision decision = (FlowDecision) fElement;
         return String.format(NL + "Tipo: %s" + NL + "Código: %s" + NL, decision.getDecisionType(),
            decision.getSnippet());
      }
      return "";
   }

   private static final String NL = "<br/>";

   @Override
   public Optional<GHtmlRoot> createPopupModel(final GModelElement element, final RequestPopupModelAction action) {
      if (element != null && (element instanceof FlowNode || element instanceof FlowDecision)) {
         FlowElement fElement = (FlowElement) element;
         GBounds bounds = action.getBounds();

         GPreRenderedElement popupTitle = new GPreRenderedElementBuilder()
            .id("popup-title")
            .code("<div class=\"sprotty-popup-title\">" + generateTitle(fElement) + "</div>")
            .build();

         GPreRenderedElement popupBody = new GPreRenderedElementBuilder()
            .id("popup-body")
            .code("<div class=\"sprotty-popup-body\">" + generateBody(fElement) + "</div>")
            .build();

         GHtmlRoot root = new GHtmlRootBuilder()
            .canvasBounds(bounds)
            .id("sprotty-popup")
            .add(popupTitle)
            .add(popupBody)
            .build();

         return Optional.of(root);
      }
      return Optional.empty();

   }

}
