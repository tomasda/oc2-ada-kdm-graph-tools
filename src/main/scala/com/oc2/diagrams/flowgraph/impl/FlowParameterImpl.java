/**
 */
package com.oc2.diagrams.flowgraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.GraphPackage;

import com.oc2.diagrams.flowgraph.FlowParameter;
import com.oc2.diagrams.flowgraph.FlowgraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link FlowParameterImpl#getId <em>Id</em>}</li>
 * <li>{@link FlowParameterImpl#getCssClasses <em>Css Classes</em>}</li>
 * <li>{@link FlowParameterImpl#getChildren <em>Children</em>}</li>
 * <li>{@link FlowParameterImpl#getParent <em>Parent</em>}</li>
 * <li>{@link FlowParameterImpl#getTrace <em>Trace</em>}</li>
 * <li>{@link FlowParameterImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowParameterImpl extends MinimalEObjectImpl.Container implements FlowParameter {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCssClasses() <em>Css Classes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCssClasses()
	 * @generated
	 * @ordered
	 */
	protected EList cssClasses;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList children;

	/**
	 * The default value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected String trace = TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FlowParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return FlowgraphPackage.Literals.FLOW_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() { return id; }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_PARAMETER__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getCssClasses() {
		if (cssClasses == null) {
			cssClasses = new EDataTypeUniqueEList(String.class, this, FlowgraphPackage.FLOW_PARAMETER__CSS_CLASSES);
		}
		return cssClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList(GModelElement.class, this,
				FlowgraphPackage.FLOW_PARAMETER__CHILDREN, GraphPackage.GMODEL_ELEMENT__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GModelElement getParent() {
		if (eContainerFeatureID() != FlowgraphPackage.FLOW_PARAMETER__PARENT)
			return null;
		return (GModelElement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(GModelElement newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParent, FlowgraphPackage.FLOW_PARAMETER__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(GModelElement newParent) {
		if (newParent != eInternalContainer()
			|| (eContainerFeatureID() != FlowgraphPackage.FLOW_PARAMETER__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject) newParent).eInverseAdd(this, GraphPackage.GMODEL_ELEMENT__CHILDREN,
					GModelElement.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_PARAMETER__PARENT, newParent,
				newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTrace() { return trace; }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTrace(String newTrace) {
		String oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired())
			eNotify(
				new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_PARAMETER__TRACE, oldTrace, trace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getType() { return type; }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(
				new ENotificationImpl(this, Notification.SET, FlowgraphPackage.FLOW_PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_PARAMETER__CHILDREN:
				return ((InternalEList) getChildren()).basicAdd(otherEnd, msgs);
			case FlowgraphPackage.FLOW_PARAMETER__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((GModelElement) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_PARAMETER__CHILDREN:
				return ((InternalEList) getChildren()).basicRemove(otherEnd, msgs);
			case FlowgraphPackage.FLOW_PARAMETER__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FlowgraphPackage.FLOW_PARAMETER__PARENT:
				return eInternalContainer().eInverseRemove(this, GraphPackage.GMODEL_ELEMENT__CHILDREN,
					GModelElement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_PARAMETER__ID:
				return getId();
			case FlowgraphPackage.FLOW_PARAMETER__CSS_CLASSES:
				return getCssClasses();
			case FlowgraphPackage.FLOW_PARAMETER__CHILDREN:
				return getChildren();
			case FlowgraphPackage.FLOW_PARAMETER__PARENT:
				return getParent();
			case FlowgraphPackage.FLOW_PARAMETER__TRACE:
				return getTrace();
			case FlowgraphPackage.FLOW_PARAMETER__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_PARAMETER__ID:
				setId((String) newValue);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__CSS_CLASSES:
				getCssClasses().clear();
				getCssClasses().addAll((Collection) newValue);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection) newValue);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__PARENT:
				setParent((GModelElement) newValue);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__TRACE:
				setTrace((String) newValue);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__TYPE:
				setType((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_PARAMETER__ID:
				setId(ID_EDEFAULT);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__CSS_CLASSES:
				getCssClasses().clear();
				return;
			case FlowgraphPackage.FLOW_PARAMETER__CHILDREN:
				getChildren().clear();
				return;
			case FlowgraphPackage.FLOW_PARAMETER__PARENT:
				setParent((GModelElement) null);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__TRACE:
				setTrace(TRACE_EDEFAULT);
				return;
			case FlowgraphPackage.FLOW_PARAMETER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FlowgraphPackage.FLOW_PARAMETER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FlowgraphPackage.FLOW_PARAMETER__CSS_CLASSES:
				return cssClasses != null && !cssClasses.isEmpty();
			case FlowgraphPackage.FLOW_PARAMETER__CHILDREN:
				return children != null && !children.isEmpty();
			case FlowgraphPackage.FLOW_PARAMETER__PARENT:
				return getParent() != null;
			case FlowgraphPackage.FLOW_PARAMETER__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
			case FlowgraphPackage.FLOW_PARAMETER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", cssClasses: ");
		result.append(cssClasses);
		result.append(", trace: ");
		result.append(trace);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

	@Override
	public EMap<String, Object> getArgs() { // TODO Auto-generated method stub
		// return null;
		EMap<String, Object> map = new EcoreEMap<String, Object>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
			EStringToStringMapEntryImpl.class, this, EcorePackage.EANNOTATION__DETAILS);
		return map;
	}

} // FlowParameterImpl
