/*******************************************************************************
 * Copyright (c) 2019 EclipseSource and others.
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
 ******************************************************************************/
package org.eclipse.glsp.server.layout;

/**
 * Whether and when a diagram server needs to compute the org.eclipse.glsp.layout of the model.
 *
 * The org.eclipse.glsp.layout is computed with the org.eclipse.glsp.layout engine configured, so a value other
 * than <code>NONE</code> here makes sense only if such an engine is available.
 */
public enum ServerLayoutKind {
   /**
    * The server re-layouts the diagram on all changes automatically. Layout
    * information stored in the model will be overwritten.
    */
   AUTOMATIC,

   /**
    * The server re-layouts the diagram only if manually triggered by a
    * <code>LayoutAction</code>. The org.eclipse.glsp.layout information must be stored in the model
    * and will be overwritten on org.eclipse.glsp.layout.
    */
   MANUAL,

   /**
    * The server never layouts the diagram. This requires that the org.eclipse.glsp.layout
    * information is stored in the model.
    */
   NONE
}
