/**
 */
package com.oc2.diagrams.flowgraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link FlowParameters#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see FlowgraphPackage#getFlowParameters()
 * @model
 * @generated
 */
public interface FlowParameters extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference list.
	 * The list contents are of type {@link FlowParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference list.
	 * @see FlowgraphPackage#getFlowParameters_Parameter()
	 * @model type="com.oc2.diagrams.flowgraph.FlowParameter"
	 * @generated
	 */
	EList getParameter();

} // FlowParameters
