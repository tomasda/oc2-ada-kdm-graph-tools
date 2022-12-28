/**
 */
package com.oc2.diagrams.flowgraph.util;

import com.oc2.diagrams.flowgraph.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.glsp.graph.GBoundsAware;
import org.eclipse.glsp.graph.GCompartment;
import org.eclipse.glsp.graph.GEdge;
import org.eclipse.glsp.graph.GEdgeLayoutable;
import org.eclipse.glsp.graph.GLayouting;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GNode;
import org.eclipse.glsp.graph.GShapeElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see FlowgraphPackage
 * @generated
 */
public class FlowgraphSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FlowgraphPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowgraphSwitch() {
		if (modelPackage == null) {
			modelPackage = FlowgraphPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FlowgraphPackage.FLOW_ELEMENT: {
				FlowElement flowElement = (FlowElement)theEObject;
				Object result = caseFlowElement(flowElement);
				if (result == null) result = caseGNode(flowElement);
				if (result == null) result = caseGShapeElement(flowElement);
				if (result == null) result = caseGEdgeLayoutable(flowElement);
				if (result == null) result = caseGLayouting(flowElement);
				if (result == null) result = caseGModelElement(flowElement);
				if (result == null) result = caseGBoundsAware(flowElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowgraphPackage.FLOW_NODE: {
				FlowNode flowNode = (FlowNode)theEObject;
				Object result = caseFlowNode(flowNode);
				if (result == null) result = caseFlowElement(flowNode);
				if (result == null) result = caseGNode(flowNode);
				if (result == null) result = caseGShapeElement(flowNode);
				if (result == null) result = caseGEdgeLayoutable(flowNode);
				if (result == null) result = caseGLayouting(flowNode);
				if (result == null) result = caseGModelElement(flowNode);
				if (result == null) result = caseGBoundsAware(flowNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowgraphPackage.FLOW_DECISION: {
				FlowDecision flowDecision = (FlowDecision)theEObject;
				Object result = caseFlowDecision(flowDecision);
				if (result == null) result = caseFlowElement(flowDecision);
				if (result == null) result = caseGNode(flowDecision);
				if (result == null) result = caseGShapeElement(flowDecision);
				if (result == null) result = caseGEdgeLayoutable(flowDecision);
				if (result == null) result = caseGLayouting(flowDecision);
				if (result == null) result = caseGModelElement(flowDecision);
				if (result == null) result = caseGBoundsAware(flowDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowgraphPackage.FLOW_PARAMETERS: {
				FlowParameters flowParameters = (FlowParameters)theEObject;
				Object result = caseFlowParameters(flowParameters);
				if (result == null) result = caseFlowElement(flowParameters);
				if (result == null) result = caseGNode(flowParameters);
				if (result == null) result = caseGShapeElement(flowParameters);
				if (result == null) result = caseGEdgeLayoutable(flowParameters);
				if (result == null) result = caseGLayouting(flowParameters);
				if (result == null) result = caseGModelElement(flowParameters);
				if (result == null) result = caseGBoundsAware(flowParameters);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowgraphPackage.LABELED_EDGE: {
				LabeledEdge labeledEdge = (LabeledEdge)theEObject;
				Object result = caseLabeledEdge(labeledEdge);
				if (result == null) result = caseGEdge(labeledEdge);
				if (result == null) result = caseGModelElement(labeledEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowgraphPackage.FLOW_PARAMETER: {
				FlowParameter flowParameter = (FlowParameter)theEObject;
				Object result = caseFlowParameter(flowParameter);
				if (result == null) result = caseGModelElement(flowParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowgraphPackage.ICON: {
				Icon icon = (Icon)theEObject;
				Object result = caseIcon(icon);
				if (result == null) result = caseGCompartment(icon);
				if (result == null) result = caseGShapeElement(icon);
				if (result == null) result = caseGLayouting(icon);
				if (result == null) result = caseGModelElement(icon);
				if (result == null) result = caseGBoundsAware(icon);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFlowElement(FlowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Node</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFlowNode(FlowNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Decision</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFlowDecision(FlowDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Parameters</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFlowParameters(FlowParameters object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labeled Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labeled Edge</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLabeledEdge(LabeledEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Parameter</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFlowParameter(FlowParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Icon</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIcon(Icon object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GModel Element</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGModelElement(GModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GBounds Aware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GBounds Aware</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGBoundsAware(GBoundsAware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GShape Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GShape Element</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGShapeElement(GShapeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GEdge Layoutable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GEdge Layoutable</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGEdgeLayoutable(GEdgeLayoutable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GLayouting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GLayouting</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGLayouting(GLayouting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GNode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GNode</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGNode(GNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GEdge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GEdge</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGEdge(GEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GCompartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GCompartment</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGCompartment(GCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //FlowgraphSwitch
