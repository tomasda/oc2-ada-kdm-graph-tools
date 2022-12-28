/**
 */
package com.oc2.diagrams.flowgraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see FlowgraphPackage
 * @generated
 */
public interface FlowgraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FlowgraphFactory eINSTANCE = com.oc2.diagrams.flowgraph.impl.FlowgraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Element</em>'.
	 * @generated
	 */
	FlowElement createFlowElement();

	/**
	 * Returns a new object of class '<em>Flow Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Node</em>'.
	 * @generated
	 */
	FlowNode createFlowNode();

	/**
	 * Returns a new object of class '<em>Flow Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Decision</em>'.
	 * @generated
	 */
	FlowDecision createFlowDecision();

	/**
	 * Returns a new object of class '<em>Flow Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Parameters</em>'.
	 * @generated
	 */
	FlowParameters createFlowParameters();

	/**
	 * Returns a new object of class '<em>Labeled Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Labeled Edge</em>'.
	 * @generated
	 */
	LabeledEdge createLabeledEdge();

	/**
	 * Returns a new object of class '<em>Flow Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Parameter</em>'.
	 * @generated
	 */
	FlowParameter createFlowParameter();

	/**
	 * Returns a new object of class '<em>Icon</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon</em>'.
	 * @generated
	 */
	Icon createIcon();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FlowgraphPackage getFlowgraphPackage();

} //FlowgraphFactory
