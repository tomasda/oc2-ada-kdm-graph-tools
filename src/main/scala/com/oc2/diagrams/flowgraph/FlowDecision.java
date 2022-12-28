/**
 */
package com.oc2.diagrams.flowgraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link FlowDecision#getSnippet <em>Snippet</em>}</li>
 *   <li>{@link FlowDecision#getDecisionType <em>Decision Type</em>}</li>
 * </ul>
 *
 * @see FlowgraphPackage#getFlowDecision()
 * @model
 * @generated
 */
public interface FlowDecision extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Snippet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snippet</em>' attribute.
	 * @see #setSnippet(String)
	 * @see FlowgraphPackage#getFlowDecision_Snippet()
	 * @model
	 * @generated
	 */
	String getSnippet();

	/**
	 * Sets the value of the '{@link FlowDecision#getSnippet <em>Snippet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snippet</em>' attribute.
	 * @see #getSnippet()
	 * @generated
	 */
	void setSnippet(String value);

	/**
	 * Returns the value of the '<em><b>Decision Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decision Type</em>' attribute.
	 * @see #setDecisionType(String)
	 * @see FlowgraphPackage#getFlowDecision_DecisionType()
	 * @model
	 * @generated
	 */
	String getDecisionType();

	/**
	 * Sets the value of the '{@link FlowDecision#getDecisionType <em>Decision Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decision Type</em>' attribute.
	 * @see #getDecisionType()
	 * @generated
	 */
	void setDecisionType(String value);

} // FlowDecision
