/**
 */
package com.oc2.diagrams.flowgraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link FlowNode#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link FlowNode#getDescription <em>Description</em>}</li>
 *   <li>{@link FlowNode#getParameters <em>Parameters</em>}</li>
 *   <li>{@link FlowNode#isExpandable <em>Expandable</em>}</li>
 *   <li>{@link FlowNode#isExpanded <em>Expanded</em>}</li>
 * </ul>
 *
 * @see FlowgraphPackage#getFlowNode()
 * @model
 * @generated
 */
public interface FlowNode extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Type</em>' attribute.
	 * @see #setNodeType(String)
	 * @see FlowgraphPackage#getFlowNode_NodeType()
	 * @model
	 * @generated
	 */
	String getNodeType();

	/**
	 * Sets the value of the '{@link FlowNode#getNodeType <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Type</em>' attribute.
	 * @see #getNodeType()
	 * @generated
	 */
	void setNodeType(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see FlowgraphPackage#getFlowNode_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link FlowNode#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference.
	 * @see #setParameters(FlowParameters)
	 * @see FlowgraphPackage#getFlowNode_Parameters()
	 * @model
	 * @generated
	 */
	FlowParameters getParameters();

	/**
	 * Sets the value of the '{@link FlowNode#getParameters <em>Parameters</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' reference.
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(FlowParameters value);

	/**
	 * Returns the value of the '<em><b>Expandable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expandable</em>' attribute.
	 * @see #setExpandable(boolean)
	 * @see FlowgraphPackage#getFlowNode_Expandable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isExpandable();

	/**
	 * Sets the value of the '{@link FlowNode#isExpandable <em>Expandable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expandable</em>' attribute.
	 * @see #isExpandable()
	 * @generated
	 */
	void setExpandable(boolean value);

	/**
	 * Returns the value of the '<em><b>Expanded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expanded</em>' attribute.
	 * @see #setExpanded(boolean)
	 * @see FlowgraphPackage#getFlowNode_Expanded()
	 * @model required="true"
	 * @generated
	 */
	boolean isExpanded();

	/**
	 * Sets the value of the '{@link FlowNode#isExpanded <em>Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expanded</em>' attribute.
	 * @see #isExpanded()
	 * @generated
	 */
	void setExpanded(boolean value);

} // FlowNode
