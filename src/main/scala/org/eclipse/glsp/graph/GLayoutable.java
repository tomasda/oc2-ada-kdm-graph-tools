/**
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
 * ********************************************************************************
 */
package org.eclipse.glsp.graph;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GLayoutable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link GLayoutable#getLayoutOptions <em>Layout Options</em>}</li>
 * </ul>
 *
 * @see GraphPackage#getGLayoutable()
 * @model
 * @generated
 */
public interface GLayoutable extends EObject {
   /**
    * Returns the value of the '<em><b>Layout Options</b></em>' map.
    * The key is of type {@link String},
    * and the value is of type {@link Object},
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the value of the '<em>Layout Options</em>' map.
    * @see GraphPackage#getGLayoutable_LayoutOptions()
    * @model mapType="org.eclipse.glsp.graph.StringToObjectMapEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject&gt;"
    * @generated
    */
   EMap<String, Object> getLayoutOptions();

} // GLayoutable
