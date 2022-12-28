/**
 */
package com.oc2.diagrams.flowgraph.impl;

import com.oc2.diagrams.flowgraph.FlowDecision;
import com.oc2.diagrams.flowgraph.FlowgraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link FlowDecisionImpl#getSnippet <em>Snippet</em>}</li>
 *   <li>{@link FlowDecisionImpl#getDecisionType <em>Decision Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowDecisionImpl extends FlowElementImpl implements FlowDecision {
	/**
	 * The default value of the '{@link #getSnippet() <em>Snippet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnippet()
	 * @generated
	 * @ordered
	 */
	protected static final String SNIPPET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSnippet() <em>Snippet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnippet()
	 * @generated
	 * @ordered
	 */
	protected String snippet = SNIPPET_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecisionType() <em>Decision Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisionType()
	 * @generated
	 * @ordered
	 */
	protected static final String DECISION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDecisionType() <em>Decision Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisionType()
	 * @generated
	 * @ordered
	 */
	protected String decisionType = DECISION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowDecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return FlowgraphPackage.Literals.FLOW_DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnippet(String newSnippet) {
		String oldSnippet = snippet;
		snippet = newSnippet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_DECISION__SNIPPET, oldSnippet, snippet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDecisionType() {
		return decisionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecisionType(String newDecisionType) {
		String oldDecisionType = decisionType;
		decisionType = newDecisionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_DECISION__DECISION_TYPE, oldDecisionType, decisionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_DECISION__SNIPPET:
				return getSnippet();
			case FlowgraphPackage.FLOW_DECISION__DECISION_TYPE:
				return getDecisionType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_DECISION__SNIPPET:
				setSnippet((String)newValue);
				return;
			case FlowgraphPackage.FLOW_DECISION__DECISION_TYPE:
				setDecisionType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_DECISION__SNIPPET:
				setSnippet(SNIPPET_EDEFAULT);
				return;
			case FlowgraphPackage.FLOW_DECISION__DECISION_TYPE:
				setDecisionType(DECISION_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_DECISION__SNIPPET:
				return SNIPPET_EDEFAULT == null ? snippet != null : !SNIPPET_EDEFAULT.equals(snippet);
			case FlowgraphPackage.FLOW_DECISION__DECISION_TYPE:
				return DECISION_TYPE_EDEFAULT == null ? decisionType != null : !DECISION_TYPE_EDEFAULT.equals(decisionType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (snippet: ");
		result.append(snippet);
		result.append(", decisionType: ");
		result.append(decisionType);
		result.append(')');
		return result.toString();
	}

} //FlowDecisionImpl
