/**
 */
package com.oc2.diagrams.flowgraph.impl;

import com.oc2.diagrams.flowgraph.FlowNode;
import com.oc2.diagrams.flowgraph.FlowParameters;
import com.oc2.diagrams.flowgraph.FlowgraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link FlowNodeImpl#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link FlowNodeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link FlowNodeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link FlowNodeImpl#isExpandable <em>Expandable</em>}</li>
 *   <li>{@link FlowNodeImpl#isExpanded <em>Expanded</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowNodeImpl extends FlowElementImpl implements FlowNode {
	/**
	 * The default value of the '{@link #getNodeType() <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeType() <em>Node Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected String nodeType = NODE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected FlowParameters parameters;

	/**
	 * The default value of the '{@link #isExpandable() <em>Expandable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExpandable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPANDABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExpandable() <em>Expandable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExpandable()
	 * @generated
	 * @ordered
	 */
	protected boolean expandable = EXPANDABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isExpanded() <em>Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExpanded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPANDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExpanded() <em>Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExpanded()
	 * @generated
	 * @ordered
	 */
	protected boolean expanded = EXPANDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return FlowgraphPackage.Literals.FLOW_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeType(String newNodeType) {
		String oldNodeType = nodeType;
		nodeType = newNodeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_NODE__NODE_TYPE, oldNodeType, nodeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_NODE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowParameters getParameters() {
		if (parameters != null && parameters.eIsProxy()) {
			InternalEObject oldParameters = (InternalEObject)parameters;
			parameters = (FlowParameters)eResolveProxy(oldParameters);
			if (parameters != oldParameters) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowgraphPackage.FLOW_NODE__PARAMETERS, oldParameters, parameters));
			}
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowParameters basicGetParameters() {
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(FlowParameters newParameters) {
		FlowParameters oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_NODE__PARAMETERS, oldParameters, parameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExpandable() {
		return expandable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandable(boolean newExpandable) {
		boolean oldExpandable = expandable;
		expandable = newExpandable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_NODE__EXPANDABLE, oldExpandable, expandable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExpanded() {
		return expanded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpanded(boolean newExpanded) {
		boolean oldExpanded = expanded;
		expanded = newExpanded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_NODE__EXPANDED, oldExpanded, expanded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_NODE__NODE_TYPE:
				return getNodeType();
			case FlowgraphPackage.FLOW_NODE__DESCRIPTION:
				return getDescription();
			case FlowgraphPackage.FLOW_NODE__PARAMETERS:
				if (resolve) return getParameters();
				return basicGetParameters();
			case FlowgraphPackage.FLOW_NODE__EXPANDABLE:
				return isExpandable() ? Boolean.TRUE : Boolean.FALSE;
			case FlowgraphPackage.FLOW_NODE__EXPANDED:
				return isExpanded() ? Boolean.TRUE : Boolean.FALSE;
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
			case FlowgraphPackage.FLOW_NODE__NODE_TYPE:
				setNodeType((String)newValue);
				return;
			case FlowgraphPackage.FLOW_NODE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FlowgraphPackage.FLOW_NODE__PARAMETERS:
				setParameters((FlowParameters)newValue);
				return;
			case FlowgraphPackage.FLOW_NODE__EXPANDABLE:
				setExpandable(((Boolean)newValue).booleanValue());
				return;
			case FlowgraphPackage.FLOW_NODE__EXPANDED:
				setExpanded(((Boolean)newValue).booleanValue());
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
			case FlowgraphPackage.FLOW_NODE__NODE_TYPE:
				setNodeType(NODE_TYPE_EDEFAULT);
				return;
			case FlowgraphPackage.FLOW_NODE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FlowgraphPackage.FLOW_NODE__PARAMETERS:
				setParameters((FlowParameters)null);
				return;
			case FlowgraphPackage.FLOW_NODE__EXPANDABLE:
				setExpandable(EXPANDABLE_EDEFAULT);
				return;
			case FlowgraphPackage.FLOW_NODE__EXPANDED:
				setExpanded(EXPANDED_EDEFAULT);
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
			case FlowgraphPackage.FLOW_NODE__NODE_TYPE:
				return NODE_TYPE_EDEFAULT == null ? nodeType != null : !NODE_TYPE_EDEFAULT.equals(nodeType);
			case FlowgraphPackage.FLOW_NODE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FlowgraphPackage.FLOW_NODE__PARAMETERS:
				return parameters != null;
			case FlowgraphPackage.FLOW_NODE__EXPANDABLE:
				return expandable != EXPANDABLE_EDEFAULT;
			case FlowgraphPackage.FLOW_NODE__EXPANDED:
				return expanded != EXPANDED_EDEFAULT;
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
		result.append(" (nodeType: ");
		result.append(nodeType);
		result.append(", description: ");
		result.append(description);
		result.append(", expandable: ");
		result.append(expandable);
		result.append(", expanded: ");
		result.append(expanded);
		result.append(')');
		return result.toString();
	}

} //FlowNodeImpl
