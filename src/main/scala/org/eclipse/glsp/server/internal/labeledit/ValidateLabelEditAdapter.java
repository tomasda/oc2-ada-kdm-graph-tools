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
package org.eclipse.glsp.server.internal.labeledit;

import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.server.features.directediting.ContextEditValidator;
import org.eclipse.glsp.server.features.directediting.LabelEditValidator;
import org.eclipse.glsp.server.features.directediting.RequestEditValidationAction;
import org.eclipse.glsp.server.features.directediting.ValidationStatus;
import org.eclipse.glsp.server.model.GModelState;

import java.util.Optional;

public class ValidateLabelEditAdapter implements ContextEditValidator {

   private final LabelEditValidator editLabelValidator;
   private final GModelState modelState;

   public ValidateLabelEditAdapter(final GModelState modelState, final LabelEditValidator editLabelValidator) {
      super();
      this.modelState = modelState;
      this.editLabelValidator = editLabelValidator;
   }

   @Override
   public String getContextId() { return LabelEditValidator.CONTEXT_ID; }

   @Override
   public ValidationStatus validate(final RequestEditValidationAction action) {
      Optional<GModelElement> element = modelState.getIndex().get(action.getModelElementId());
      if (element.isPresent()) {
         return editLabelValidator.validate(action.getText(), element.get());
      }
      return ValidationStatus.ok();
   }

}
