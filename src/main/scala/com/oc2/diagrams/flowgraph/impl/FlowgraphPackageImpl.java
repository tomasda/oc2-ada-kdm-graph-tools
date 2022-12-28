/**
 */
package com.oc2.diagrams.flowgraph.impl;

import com.oc2.diagrams.flowgraph.FlowDecision;
import com.oc2.diagrams.flowgraph.FlowElement;
import com.oc2.diagrams.flowgraph.FlowNode;
import com.oc2.diagrams.flowgraph.FlowParameter;
import com.oc2.diagrams.flowgraph.FlowParameters;
import com.oc2.diagrams.flowgraph.FlowgraphFactory;
import com.oc2.diagrams.flowgraph.FlowgraphPackage;
import com.oc2.diagrams.flowgraph.Icon;
import com.oc2.diagrams.flowgraph.LabeledEdge;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.glsp.graph.GraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowgraphPackageImpl extends EPackageImpl implements FlowgraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowParametersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labeledEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iconEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Registry
	 * @see FlowgraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FlowgraphPackageImpl() {
		super(eNS_URI, FlowgraphFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link FlowgraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FlowgraphPackage init() {
		if (isInited) return (FlowgraphPackage) Registry.INSTANCE.getEPackage(FlowgraphPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFlowgraphPackage = Registry.INSTANCE.get(eNS_URI);
		FlowgraphPackageImpl theFlowgraphPackage = registeredFlowgraphPackage instanceof FlowgraphPackageImpl ? (FlowgraphPackageImpl)registeredFlowgraphPackage : new FlowgraphPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		GraphPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFlowgraphPackage.createPackageContents();

		// Initialize created meta-data
		theFlowgraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFlowgraphPackage.freeze();

		// Update the registry and return the package
		Registry.INSTANCE.put(FlowgraphPackage.eNS_URI, theFlowgraphPackage);
		return theFlowgraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowElement() {
		return flowElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowElement_ElementType() {
		return (EAttribute)flowElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowElement_Name() {
		return (EAttribute)flowElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowNode() {
		return flowNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowNode_NodeType() {
		return (EAttribute)flowNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowNode_Description() {
		return (EAttribute)flowNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowNode_Parameters() {
		return (EReference)flowNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowNode_Expandable() {
		return (EAttribute)flowNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowNode_Expanded() {
		return (EAttribute)flowNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowDecision() {
		return flowDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowDecision_Snippet() {
		return (EAttribute)flowDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowDecision_DecisionType() {
		return (EAttribute)flowDecisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowParameters() {
		return flowParametersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowParameters_Parameter() {
		return (EReference)flowParametersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabeledEdge() {
		return labeledEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabeledEdge_Label() {
		return (EAttribute)labeledEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowParameter() {
		return flowParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIcon() {
		return iconEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowgraphFactory getFlowgraphFactory() {
		return (FlowgraphFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		flowElementEClass = createEClass(FLOW_ELEMENT);
		createEAttribute(flowElementEClass, FLOW_ELEMENT__ELEMENT_TYPE);
		createEAttribute(flowElementEClass, FLOW_ELEMENT__NAME);

		flowNodeEClass = createEClass(FLOW_NODE);
		createEAttribute(flowNodeEClass, FLOW_NODE__NODE_TYPE);
		createEAttribute(flowNodeEClass, FLOW_NODE__DESCRIPTION);
		createEReference(flowNodeEClass, FLOW_NODE__PARAMETERS);
		createEAttribute(flowNodeEClass, FLOW_NODE__EXPANDABLE);
		createEAttribute(flowNodeEClass, FLOW_NODE__EXPANDED);

		flowDecisionEClass = createEClass(FLOW_DECISION);
		createEAttribute(flowDecisionEClass, FLOW_DECISION__SNIPPET);
		createEAttribute(flowDecisionEClass, FLOW_DECISION__DECISION_TYPE);

		flowParametersEClass = createEClass(FLOW_PARAMETERS);
		createEReference(flowParametersEClass, FLOW_PARAMETERS__PARAMETER);

		labeledEdgeEClass = createEClass(LABELED_EDGE);
		createEAttribute(labeledEdgeEClass, LABELED_EDGE__LABEL);

		flowParameterEClass = createEClass(FLOW_PARAMETER);

		iconEClass = createEClass(ICON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GraphPackage theGraphPackage = (GraphPackage) Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

		// Add supertypes to classes
		flowElementEClass.getESuperTypes().add(theGraphPackage.getGNode());
		flowNodeEClass.getESuperTypes().add(this.getFlowElement());
		flowDecisionEClass.getESuperTypes().add(this.getFlowElement());
		flowParametersEClass.getESuperTypes().add(this.getFlowElement());
		labeledEdgeEClass.getESuperTypes().add(theGraphPackage.getGEdge());
		flowParameterEClass.getESuperTypes().add(theGraphPackage.getGModelElement());
		iconEClass.getESuperTypes().add(theGraphPackage.getGCompartment());

		// Initialize classes and features; add operations and parameters
		initEClass(flowElementEClass, FlowElement.class, "FlowElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFlowElement_ElementType(), ecorePackage.getEString(), "elementType", null, 1, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFlowElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowNodeEClass, FlowNode.class, "FlowNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFlowNode_NodeType(), ecorePackage.getEString(), "nodeType", null, 0, 1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlowNode_Description(), ecorePackage.getEString(), "description", null, 0, 1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowNode_Parameters(), this.getFlowParameters(), null, "parameters", null, 0, 1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlowNode_Expandable(), ecorePackage.getEBoolean(), "expandable", null, 1, 1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFlowNode_Expanded(), ecorePackage.getEBoolean(), "expanded", null, 1, 1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowDecisionEClass, FlowDecision.class, "FlowDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFlowDecision_Snippet(), ecorePackage.getEString(), "snippet", null, 0, 1, FlowDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlowDecision_DecisionType(), ecorePackage.getEString(), "decisionType", null, 0, 1, FlowDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowParametersEClass, FlowParameters.class, "FlowParameters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowParameters_Parameter(), this.getFlowParameter(), null, "parameter", null, 0, -1, FlowParameters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labeledEdgeEClass, LabeledEdge.class, "LabeledEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabeledEdge_Label(), ecorePackage.getEString(), "label", null, 0, 1, LabeledEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowParameterEClass, FlowParameter.class, "FlowParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iconEClass, Icon.class, "Icon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //FlowgraphPackageImpl
