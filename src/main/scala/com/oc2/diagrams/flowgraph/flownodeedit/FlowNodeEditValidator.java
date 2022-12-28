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

import org.eclipse.glsp.server.features.directediting.ContextEditValidator;
import org.eclipse.glsp.server.features.directediting.RequestEditValidationAction;
import org.eclipse.glsp.server.features.directediting.ValidationStatus;
import org.eclipse.glsp.server.model.GModelState;

import com.google.inject.Inject;

public class FlowNodeEditValidator implements ContextEditValidator {

   @Override
   public String getContextId() { return "flowNode-editor"; }

   @Inject
   protected GModelState modelState;

   @SuppressWarnings("checkstyle:cyclomaticComplexity")
   @Override
   public ValidationStatus validate(final RequestEditValidationAction action) {
      String text = action.getText();
      if (text.startsWith(FlowNodeEditContextActionProvider.TYPE_PREFIX)) {
         String typeString = text.substring(FlowNodeEditContextActionProvider.TYPE_PREFIX.length());
         if (!typeString.equals("externalCallNode") && !typeString.equals("internalCallNode")
            && !typeString.equals("inputNode") && !typeString.equals("screenNode")) {
            return ValidationStatus
               .error(
                  "El tipo de nodo debe ser de tipo 'externalCallNode', 'internalCallNode', 'inputNode' or 'screenNode'. Valor no válido '"
                     + typeString + "'.");
         }
      }
      return ValidationStatus.ok();
   }

}
