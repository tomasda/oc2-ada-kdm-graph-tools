package com.oc2.diagrams.flowgraph.impl;

import com.oc2.diagrams.flowgraph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowgraphFactoryImpl extends EFactoryImpl implements FlowgraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FlowgraphFactory init() {
		try {
			FlowgraphFactory theFlowgraphFactory = (FlowgraphFactory)EPackage.Registry.INSTANCE.getEFactory(FlowgraphPackage.eNS_URI);
			if (theFlowgraphFactory != null) {
				return theFlowgraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FlowgraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowgraphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FlowgraphPackage.FLOW_ELEMENT: return createFlowElement();
			case FlowgraphPackage.FLOW_NODE: return createFlowNode();
			case FlowgraphPackage.FLOW_DECISION: return createFlowDecision();
			case FlowgraphPackage.FLOW_PARAMETERS: return createFlowParameters();
			case FlowgraphPackage.LABELED_EDGE: return createLabeledEdge();
			case FlowgraphPackage.FLOW_PARAMETER: return createFlowParameter();
			case FlowgraphPackage.ICON: return createIcon();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowElement createFlowElement() {
		FlowElementImpl flowElement = new FlowElementImpl();
		return flowElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowNode createFlowNode() {
		FlowNodeImpl flowNode = new FlowNodeImpl();
		return flowNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowDecision createFlowDecision() {
		FlowDecisionImpl flowDecision = new FlowDecisionImpl();
		return flowDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowParameters createFlowParameters() {
		FlowParametersImpl flowParameters = new FlowParametersImpl();
		return flowParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabeledEdge createLabeledEdge() {
		LabeledEdgeImpl labeledEdge = new LabeledEdgeImpl();
		return labeledEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowParameter createFlowParameter() {
		FlowParameterImpl flowParameter = new FlowParameterImpl();
		return flowParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Icon createIcon() {
		IconImpl icon = new IconImpl();
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowgraphPackage getFlowgraphPackage() {
		return (FlowgraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static FlowgraphPackage getPackage() {
		return FlowgraphPackage.eINSTANCE;
	}

} //FlowgraphFactoryImpl
