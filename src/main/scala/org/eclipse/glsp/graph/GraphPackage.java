/**
 * Copyright (c) 2019-2022 EclipseSource and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * ********************************************************************************
 */
package org.eclipse.glsp.graph;

import org.eclipse.emf.ecore.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see GraphFactory
 * @model kind="package"
 * @generated
 */
public interface GraphPackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "graph";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "http://www.eclipse.org/glsp/graph";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "graph";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   GraphPackage eINSTANCE = org.eclipse.glsp.graph.impl.GraphPackageImpl.init();

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GArgumentableImpl <em>GArgumentable</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GArgumentableImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGArgumentable()
    * @generated
    */
   int GARGUMENTABLE = 19;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GARGUMENTABLE__ARGS = 0;

   /**
    * The number of structural features of the '<em>GArgumentable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GARGUMENTABLE_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>GArgumentable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GARGUMENTABLE_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link GModelElement <em>GModel Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see GModelElement
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGModelElement()
    * @generated
    */
   int GMODEL_ELEMENT = 0;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT__ARGS = GARGUMENTABLE__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT__ID = GARGUMENTABLE_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT__CSS_CLASSES = GARGUMENTABLE_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT__CHILDREN = GARGUMENTABLE_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT__PARENT = GARGUMENTABLE_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT__TRACE = GARGUMENTABLE_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT__TYPE = GARGUMENTABLE_FEATURE_COUNT + 5;

   /**
    * The number of structural features of the '<em>GModel Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT_FEATURE_COUNT = GARGUMENTABLE_FEATURE_COUNT + 6;

   /**
    * The number of operations of the '<em>GModel Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ELEMENT_OPERATION_COUNT = GARGUMENTABLE_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link GShapeElement <em>GShape Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see GShapeElement
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGShapeElement()
    * @generated
    */
   int GSHAPE_ELEMENT = 1;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__ARGS = GMODEL_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__ID = GMODEL_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__CSS_CLASSES = GMODEL_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__CHILDREN = GMODEL_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__PARENT = GMODEL_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__TRACE = GMODEL_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__TYPE = GMODEL_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__POSITION = GMODEL_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__SIZE = GMODEL_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT__LAYOUT_OPTIONS = GMODEL_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>GShape Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT_FEATURE_COUNT = GMODEL_ELEMENT_FEATURE_COUNT + 3;

   /**
    * The number of operations of the '<em>GShape Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_ELEMENT_OPERATION_COUNT = GMODEL_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GModelRootImpl <em>GModel Root</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GModelRootImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGModelRoot()
    * @generated
    */
   int GMODEL_ROOT = 3;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__ARGS = GMODEL_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__ID = GMODEL_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__CSS_CLASSES = GMODEL_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__CHILDREN = GMODEL_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__PARENT = GMODEL_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__TRACE = GMODEL_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__TYPE = GMODEL_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Canvas Bounds</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__CANVAS_BOUNDS = GMODEL_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Revision</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT__REVISION = GMODEL_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>GModel Root</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT_FEATURE_COUNT = GMODEL_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of operations of the '<em>GModel Root</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GMODEL_ROOT_OPERATION_COUNT = GMODEL_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GGraphImpl <em>GGraph</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GGraphImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGGraph()
    * @generated
    */
   int GGRAPH = 2;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__ARGS = GMODEL_ROOT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__ID = GMODEL_ROOT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__CSS_CLASSES = GMODEL_ROOT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__CHILDREN = GMODEL_ROOT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__PARENT = GMODEL_ROOT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__TRACE = GMODEL_ROOT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__TYPE = GMODEL_ROOT__TYPE;

   /**
    * The feature id for the '<em><b>Canvas Bounds</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__CANVAS_BOUNDS = GMODEL_ROOT__CANVAS_BOUNDS;

   /**
    * The feature id for the '<em><b>Revision</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__REVISION = GMODEL_ROOT__REVISION;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__POSITION = GMODEL_ROOT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__SIZE = GMODEL_ROOT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH__LAYOUT_OPTIONS = GMODEL_ROOT_FEATURE_COUNT + 2;

   /**
    * The number of structural features of the '<em>GGraph</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH_FEATURE_COUNT = GMODEL_ROOT_FEATURE_COUNT + 3;

   /**
    * The number of operations of the '<em>GGraph</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GGRAPH_OPERATION_COUNT = GMODEL_ROOT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GNodeImpl <em>GNode</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GNodeImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGNode()
    * @generated
    */
   int GNODE = 4;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__ARGS = GSHAPE_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__ID = GSHAPE_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__CSS_CLASSES = GSHAPE_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__CHILDREN = GSHAPE_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__PARENT = GSHAPE_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__TRACE = GSHAPE_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__TYPE = GSHAPE_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__POSITION = GSHAPE_ELEMENT__POSITION;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__SIZE = GSHAPE_ELEMENT__SIZE;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__LAYOUT_OPTIONS = GSHAPE_ELEMENT__LAYOUT_OPTIONS;

   /**
    * The feature id for the '<em><b>Edge Placement</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__EDGE_PLACEMENT = GSHAPE_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Layout</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE__LAYOUT = GSHAPE_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>GNode</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE_FEATURE_COUNT = GSHAPE_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of operations of the '<em>GNode</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GNODE_OPERATION_COUNT = GSHAPE_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GEdgeImpl <em>GEdge</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GEdgeImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGEdge()
    * @generated
    */
   int GEDGE = 5;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__ARGS = GMODEL_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__ID = GMODEL_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__CSS_CLASSES = GMODEL_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__CHILDREN = GMODEL_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__PARENT = GMODEL_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__TRACE = GMODEL_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__TYPE = GMODEL_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Routing Points</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__ROUTING_POINTS = GMODEL_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Source Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__SOURCE_ID = GMODEL_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Target Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__TARGET_ID = GMODEL_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Source</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__SOURCE = GMODEL_ELEMENT_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Target</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__TARGET = GMODEL_ELEMENT_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>Router Kind</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE__ROUTER_KIND = GMODEL_ELEMENT_FEATURE_COUNT + 5;

   /**
    * The number of structural features of the '<em>GEdge</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_FEATURE_COUNT = GMODEL_ELEMENT_FEATURE_COUNT + 6;

   /**
    * The number of operations of the '<em>GEdge</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_OPERATION_COUNT = GMODEL_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GCompartmentImpl <em>GCompartment</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GCompartmentImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGCompartment()
    * @generated
    */
   int GCOMPARTMENT = 6;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__ARGS = GSHAPE_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__ID = GSHAPE_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__CSS_CLASSES = GSHAPE_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__CHILDREN = GSHAPE_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__PARENT = GSHAPE_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__TRACE = GSHAPE_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__TYPE = GSHAPE_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__POSITION = GSHAPE_ELEMENT__POSITION;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__SIZE = GSHAPE_ELEMENT__SIZE;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__LAYOUT_OPTIONS = GSHAPE_ELEMENT__LAYOUT_OPTIONS;

   /**
    * The feature id for the '<em><b>Layout</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT__LAYOUT = GSHAPE_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>GCompartment</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT_FEATURE_COUNT = GSHAPE_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>GCompartment</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GCOMPARTMENT_OPERATION_COUNT = GSHAPE_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GAlignableImpl <em>GAlignable</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GAlignableImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGAlignable()
    * @generated
    */
   int GALIGNABLE = 18;

   /**
    * The feature id for the '<em><b>Alignment</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GALIGNABLE__ALIGNMENT = 0;

   /**
    * The number of structural features of the '<em>GAlignable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GALIGNABLE_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>GAlignable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GALIGNABLE_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GLabelImpl <em>GLabel</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GLabelImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGLabel()
    * @generated
    */
   int GLABEL = 7;

   /**
    * The feature id for the '<em><b>Alignment</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__ALIGNMENT = GALIGNABLE__ALIGNMENT;

   /**
    * The feature id for the '<em><b>Edge Placement</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__EDGE_PLACEMENT = GALIGNABLE_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__ARGS = GALIGNABLE_FEATURE_COUNT + 1;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__ID = GALIGNABLE_FEATURE_COUNT + 2;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__CSS_CLASSES = GALIGNABLE_FEATURE_COUNT + 3;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__CHILDREN = GALIGNABLE_FEATURE_COUNT + 4;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__PARENT = GALIGNABLE_FEATURE_COUNT + 5;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__TRACE = GALIGNABLE_FEATURE_COUNT + 6;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__TYPE = GALIGNABLE_FEATURE_COUNT + 7;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__POSITION = GALIGNABLE_FEATURE_COUNT + 8;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__SIZE = GALIGNABLE_FEATURE_COUNT + 9;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__LAYOUT_OPTIONS = GALIGNABLE_FEATURE_COUNT + 10;

   /**
    * The feature id for the '<em><b>Text</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL__TEXT = GALIGNABLE_FEATURE_COUNT + 11;

   /**
    * The number of structural features of the '<em>GLabel</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL_FEATURE_COUNT = GALIGNABLE_FEATURE_COUNT + 12;

   /**
    * The number of operations of the '<em>GLabel</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLABEL_OPERATION_COUNT = GALIGNABLE_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GIssueMarkerImpl <em>GIssue Marker</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GIssueMarkerImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGIssueMarker()
    * @generated
    */
   int GISSUE_MARKER = 8;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__ARGS = GSHAPE_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__ID = GSHAPE_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__CSS_CLASSES = GSHAPE_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__CHILDREN = GSHAPE_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__PARENT = GSHAPE_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__TRACE = GSHAPE_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__TYPE = GSHAPE_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__POSITION = GSHAPE_ELEMENT__POSITION;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__SIZE = GSHAPE_ELEMENT__SIZE;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__LAYOUT_OPTIONS = GSHAPE_ELEMENT__LAYOUT_OPTIONS;

   /**
    * The feature id for the '<em><b>Issues</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER__ISSUES = GSHAPE_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>GIssue Marker</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER_FEATURE_COUNT = GSHAPE_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>GIssue Marker</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_MARKER_OPERATION_COUNT = GSHAPE_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GPortImpl <em>GPort</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GPortImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGPort()
    * @generated
    */
   int GPORT = 9;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__ARGS = GSHAPE_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__ID = GSHAPE_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__CSS_CLASSES = GSHAPE_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__CHILDREN = GSHAPE_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__PARENT = GSHAPE_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__TRACE = GSHAPE_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__TYPE = GSHAPE_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__POSITION = GSHAPE_ELEMENT__POSITION;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__SIZE = GSHAPE_ELEMENT__SIZE;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT__LAYOUT_OPTIONS = GSHAPE_ELEMENT__LAYOUT_OPTIONS;

   /**
    * The number of structural features of the '<em>GPort</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT_FEATURE_COUNT = GSHAPE_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of operations of the '<em>GPort</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPORT_OPERATION_COUNT = GSHAPE_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GButtonImpl <em>GButton</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GButtonImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGButton()
    * @generated
    */
   int GBUTTON = 10;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__ARGS = GSHAPE_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__ID = GSHAPE_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__CSS_CLASSES = GSHAPE_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__CHILDREN = GSHAPE_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__PARENT = GSHAPE_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__TRACE = GSHAPE_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__TYPE = GSHAPE_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__POSITION = GSHAPE_ELEMENT__POSITION;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__SIZE = GSHAPE_ELEMENT__SIZE;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__LAYOUT_OPTIONS = GSHAPE_ELEMENT__LAYOUT_OPTIONS;

   /**
    * The feature id for the '<em><b>Enabled</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON__ENABLED = GSHAPE_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>GButton</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON_FEATURE_COUNT = GSHAPE_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>GButton</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBUTTON_OPERATION_COUNT = GSHAPE_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link GBoundsAware <em>GBounds Aware</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see GBoundsAware
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGBoundsAware()
    * @generated
    */
   int GBOUNDS_AWARE = 11;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS_AWARE__POSITION = 0;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS_AWARE__SIZE = 1;

   /**
    * The number of structural features of the '<em>GBounds Aware</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS_AWARE_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>GBounds Aware</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS_AWARE_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GPointImpl <em>GPoint</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GPointImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGPoint()
    * @generated
    */
   int GPOINT = 12;

   /**
    * The feature id for the '<em><b>X</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPOINT__X = 0;

   /**
    * The feature id for the '<em><b>Y</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPOINT__Y = 1;

   /**
    * The number of structural features of the '<em>GPoint</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPOINT_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>GPoint</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPOINT_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GDimensionImpl <em>GDimension</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GDimensionImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGDimension()
    * @generated
    */
   int GDIMENSION = 13;

   /**
    * The feature id for the '<em><b>Width</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GDIMENSION__WIDTH = 0;

   /**
    * The feature id for the '<em><b>Height</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GDIMENSION__HEIGHT = 1;

   /**
    * The number of structural features of the '<em>GDimension</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GDIMENSION_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>GDimension</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GDIMENSION_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link GEdgeLayoutable <em>GEdge Layoutable</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see GEdgeLayoutable
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGEdgeLayoutable()
    * @generated
    */
   int GEDGE_LAYOUTABLE = 14;

   /**
    * The feature id for the '<em><b>Edge Placement</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_LAYOUTABLE__EDGE_PLACEMENT = 0;

   /**
    * The number of structural features of the '<em>GEdge Layoutable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_LAYOUTABLE_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>GEdge Layoutable</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_LAYOUTABLE_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GEdgePlacementImpl <em>GEdge Placement</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GEdgePlacementImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGEdgePlacement()
    * @generated
    */
   int GEDGE_PLACEMENT = 15;

   /**
    * The feature id for the '<em><b>Position</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_PLACEMENT__POSITION = 0;

   /**
    * The feature id for the '<em><b>Offset</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_PLACEMENT__OFFSET = 1;

   /**
    * The feature id for the '<em><b>Side</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_PLACEMENT__SIDE = 2;

   /**
    * The feature id for the '<em><b>Rotate</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_PLACEMENT__ROTATE = 3;

   /**
    * The number of structural features of the '<em>GEdge Placement</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_PLACEMENT_FEATURE_COUNT = 4;

   /**
    * The number of operations of the '<em>GEdge Placement</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GEDGE_PLACEMENT_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GLayoutableImpl <em>GLayoutable</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GLayoutableImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGLayoutable()
    * @generated
    */
   int GLAYOUTABLE = 25;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLAYOUTABLE__LAYOUT_OPTIONS = 0;

   /**
    * The number of structural features of the '<em>GLayoutable</em>' class.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLAYOUTABLE_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>GLayoutable</em>' class.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLAYOUTABLE_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link GLayouting <em>GLayouting</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see GLayouting
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGLayouting()
    * @generated
    */
   int GLAYOUTING = 16;

   /**
    * The feature id for the '<em><b>Layout Options</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLAYOUTING__LAYOUT_OPTIONS = GLAYOUTABLE__LAYOUT_OPTIONS;

   /**
    * The feature id for the '<em><b>Layout</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLAYOUTING__LAYOUT = GLAYOUTABLE_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>GLayouting</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLAYOUTING_FEATURE_COUNT = GLAYOUTABLE_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>GLayouting</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GLAYOUTING_OPERATION_COUNT = GLAYOUTABLE_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GBoundsImpl <em>GBounds</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GBoundsImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGBounds()
    * @generated
    */
   int GBOUNDS = 17;

   /**
    * The feature id for the '<em><b>X</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS__X = 0;

   /**
    * The feature id for the '<em><b>Y</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS__Y = 1;

   /**
    * The feature id for the '<em><b>Width</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS__WIDTH = 2;

   /**
    * The feature id for the '<em><b>Height</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS__HEIGHT = 3;

   /**
    * The number of structural features of the '<em>GBounds</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS_FEATURE_COUNT = 4;

   /**
    * The number of operations of the '<em>GBounds</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GBOUNDS_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GIssueImpl <em>GIssue</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GIssueImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGIssue()
    * @generated
    */
   int GISSUE = 20;

   /**
    * The feature id for the '<em><b>Severity</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE__SEVERITY = 0;

   /**
    * The feature id for the '<em><b>Message</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE__MESSAGE = 1;

   /**
    * The number of structural features of the '<em>GIssue</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>GIssue</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GISSUE_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GHtmlRootImpl <em>GHtml Root</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GHtmlRootImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGHtmlRoot()
    * @generated
    */
   int GHTML_ROOT = 21;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__ARGS = GMODEL_ROOT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__ID = GMODEL_ROOT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__CSS_CLASSES = GMODEL_ROOT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__CHILDREN = GMODEL_ROOT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__PARENT = GMODEL_ROOT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__TRACE = GMODEL_ROOT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__TYPE = GMODEL_ROOT__TYPE;

   /**
    * The feature id for the '<em><b>Canvas Bounds</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__CANVAS_BOUNDS = GMODEL_ROOT__CANVAS_BOUNDS;

   /**
    * The feature id for the '<em><b>Revision</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__REVISION = GMODEL_ROOT__REVISION;

   /**
    * The feature id for the '<em><b>Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT__CLASSES = GMODEL_ROOT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>GHtml Root</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT_FEATURE_COUNT = GMODEL_ROOT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>GHtml Root</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GHTML_ROOT_OPERATION_COUNT = GMODEL_ROOT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GPreRenderedElementImpl <em>GPre Rendered Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GPreRenderedElementImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGPreRenderedElement()
    * @generated
    */
   int GPRE_RENDERED_ELEMENT = 22;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__ARGS = GMODEL_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__ID = GMODEL_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__CSS_CLASSES = GMODEL_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__CHILDREN = GMODEL_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__PARENT = GMODEL_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__TRACE = GMODEL_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__TYPE = GMODEL_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Code</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT__CODE = GMODEL_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>GPre Rendered Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT_FEATURE_COUNT = GMODEL_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of operations of the '<em>GPre Rendered Element</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GPRE_RENDERED_ELEMENT_OPERATION_COUNT = GMODEL_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.GShapePreRenderedElementImpl <em>GShape Pre Rendered Element</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.GShapePreRenderedElementImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGShapePreRenderedElement()
    * @generated
    */
   int GSHAPE_PRE_RENDERED_ELEMENT = 23;

   /**
    * The feature id for the '<em><b>Args</b></em>' map.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__ARGS = GPRE_RENDERED_ELEMENT__ARGS;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__ID = GPRE_RENDERED_ELEMENT__ID;

   /**
    * The feature id for the '<em><b>Css Classes</b></em>' attribute list.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__CSS_CLASSES = GPRE_RENDERED_ELEMENT__CSS_CLASSES;

   /**
    * The feature id for the '<em><b>Children</b></em>' containment reference list.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__CHILDREN = GPRE_RENDERED_ELEMENT__CHILDREN;

   /**
    * The feature id for the '<em><b>Parent</b></em>' container reference.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__PARENT = GPRE_RENDERED_ELEMENT__PARENT;

   /**
    * The feature id for the '<em><b>Trace</b></em>' attribute.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__TRACE = GPRE_RENDERED_ELEMENT__TRACE;

   /**
    * The feature id for the '<em><b>Type</b></em>' attribute.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__TYPE = GPRE_RENDERED_ELEMENT__TYPE;

   /**
    * The feature id for the '<em><b>Code</b></em>' attribute.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__CODE = GPRE_RENDERED_ELEMENT__CODE;

   /**
    * The feature id for the '<em><b>Position</b></em>' containment reference.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__POSITION = GPRE_RENDERED_ELEMENT_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Size</b></em>' containment reference.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT__SIZE = GPRE_RENDERED_ELEMENT_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>GShape Pre Rendered Element</em>' class.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT_FEATURE_COUNT = GPRE_RENDERED_ELEMENT_FEATURE_COUNT + 2;

   /**
    * The number of operations of the '<em>GShape Pre Rendered Element</em>' class.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int GSHAPE_PRE_RENDERED_ELEMENT_OPERATION_COUNT = GPRE_RENDERED_ELEMENT_OPERATION_COUNT + 0;

   /**
    * The meta object id for the '{@link org.eclipse.glsp.graph.impl.StringToObjectMapEntryImpl <em>String To Object Map Entry</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.glsp.graph.impl.StringToObjectMapEntryImpl
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getStringToObjectMapEntry()
    * @generated
    */
   int STRING_TO_OBJECT_MAP_ENTRY = 24;

   /**
    * The feature id for the '<em><b>Key</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_TO_OBJECT_MAP_ENTRY__KEY = 0;

   /**
    * The feature id for the '<em><b>Value</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_TO_OBJECT_MAP_ENTRY__VALUE = 1;

   /**
    * The number of structural features of the '<em>String To Object Map Entry</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_TO_OBJECT_MAP_ENTRY_FEATURE_COUNT = 2;

   /**
    * The number of operations of the '<em>String To Object Map Entry</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STRING_TO_OBJECT_MAP_ENTRY_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link GSeverity <em>GSeverity</em>}' enum.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see GSeverity
    * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGSeverity()
    * @generated
    */
   int GSEVERITY = 26;

   /**
    * Returns the meta object for class '{@link GModelElement <em>GModel Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GModel Element</em>'.
    * @see GModelElement
    * @generated
    */
   EClass getGModelElement();

   /**
    * Returns the meta object for the attribute '{@link GModelElement#getId <em>Id</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Id</em>'.
    * @see GModelElement#getId()
    * @see #getGModelElement()
    * @generated
    */
   EAttribute getGModelElement_Id();

   /**
    * Returns the meta object for the attribute list '{@link GModelElement#getCssClasses <em>Css Classes</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute list '<em>Css Classes</em>'.
    * @see GModelElement#getCssClasses()
    * @see #getGModelElement()
    * @generated
    */
   EAttribute getGModelElement_CssClasses();

   /**
    * Returns the meta object for the containment reference list '{@link GModelElement#getChildren <em>Children</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Children</em>'.
    * @see GModelElement#getChildren()
    * @see #getGModelElement()
    * @generated
    */
   EReference getGModelElement_Children();

   /**
    * Returns the meta object for the container reference '{@link GModelElement#getParent <em>Parent</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the container reference '<em>Parent</em>'.
    * @see GModelElement#getParent()
    * @see #getGModelElement()
    * @generated
    */
   EReference getGModelElement_Parent();

   /**
    * Returns the meta object for the attribute '{@link GModelElement#getTrace <em>Trace</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Trace</em>'.
    * @see GModelElement#getTrace()
    * @see #getGModelElement()
    * @generated
    */
   EAttribute getGModelElement_Trace();

   /**
    * Returns the meta object for the attribute '{@link GModelElement#getType <em>Type</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Type</em>'.
    * @see GModelElement#getType()
    * @see #getGModelElement()
    * @generated
    */
   EAttribute getGModelElement_Type();

   /**
    * Returns the meta object for class '{@link GShapeElement <em>GShape Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GShape Element</em>'.
    * @see GShapeElement
    * @generated
    */
   EClass getGShapeElement();

   /**
    * Returns the meta object for class '{@link GGraph <em>GGraph</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GGraph</em>'.
    * @see GGraph
    * @generated
    */
   EClass getGGraph();

   /**
    * Returns the meta object for class '{@link GModelRoot <em>GModel Root</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GModel Root</em>'.
    * @see GModelRoot
    * @generated
    */
   EClass getGModelRoot();

   /**
    * Returns the meta object for the containment reference '{@link GModelRoot#getCanvasBounds <em>Canvas Bounds</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Canvas Bounds</em>'.
    * @see GModelRoot#getCanvasBounds()
    * @see #getGModelRoot()
    * @generated
    */
   EReference getGModelRoot_CanvasBounds();

   /**
    * Returns the meta object for the attribute '{@link GModelRoot#getRevision <em>Revision</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Revision</em>'.
    * @see GModelRoot#getRevision()
    * @see #getGModelRoot()
    * @generated
    */
   EAttribute getGModelRoot_Revision();

   /**
    * Returns the meta object for class '{@link GNode <em>GNode</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GNode</em>'.
    * @see GNode
    * @generated
    */
   EClass getGNode();

   /**
    * Returns the meta object for class '{@link GEdge <em>GEdge</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GEdge</em>'.
    * @see GEdge
    * @generated
    */
   EClass getGEdge();

   /**
    * Returns the meta object for the containment reference list '{@link GEdge#getRoutingPoints <em>Routing Points</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Routing Points</em>'.
    * @see GEdge#getRoutingPoints()
    * @see #getGEdge()
    * @generated
    */
   EReference getGEdge_RoutingPoints();

   /**
    * Returns the meta object for the attribute '{@link GEdge#getSourceId <em>Source Id</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Source Id</em>'.
    * @see GEdge#getSourceId()
    * @see #getGEdge()
    * @generated
    */
   EAttribute getGEdge_SourceId();

   /**
    * Returns the meta object for the attribute '{@link GEdge#getTargetId <em>Target Id</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Target Id</em>'.
    * @see GEdge#getTargetId()
    * @see #getGEdge()
    * @generated
    */
   EAttribute getGEdge_TargetId();

   /**
    * Returns the meta object for the reference '{@link GEdge#getSource <em>Source</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Source</em>'.
    * @see GEdge#getSource()
    * @see #getGEdge()
    * @generated
    */
   EReference getGEdge_Source();

   /**
    * Returns the meta object for the reference '{@link GEdge#getTarget <em>Target</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Target</em>'.
    * @see GEdge#getTarget()
    * @see #getGEdge()
    * @generated
    */
   EReference getGEdge_Target();

   /**
    * Returns the meta object for the attribute '{@link GEdge#getRouterKind <em>Router Kind</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Router Kind</em>'.
    * @see GEdge#getRouterKind()
    * @see #getGEdge()
    * @generated
    */
   EAttribute getGEdge_RouterKind();

   /**
    * Returns the meta object for class '{@link GCompartment <em>GCompartment</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GCompartment</em>'.
    * @see GCompartment
    * @generated
    */
   EClass getGCompartment();

   /**
    * Returns the meta object for class '{@link GLabel <em>GLabel</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GLabel</em>'.
    * @see GLabel
    * @generated
    */
   EClass getGLabel();

   /**
    * Returns the meta object for the attribute '{@link GLabel#getText <em>Text</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Text</em>'.
    * @see GLabel#getText()
    * @see #getGLabel()
    * @generated
    */
   EAttribute getGLabel_Text();

   /**
    * Returns the meta object for class '{@link GIssueMarker <em>GIssue Marker</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GIssue Marker</em>'.
    * @see GIssueMarker
    * @generated
    */
   EClass getGIssueMarker();

   /**
    * Returns the meta object for the containment reference list '{@link GIssueMarker#getIssues <em>Issues</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Issues</em>'.
    * @see GIssueMarker#getIssues()
    * @see #getGIssueMarker()
    * @generated
    */
   EReference getGIssueMarker_Issues();

   /**
    * Returns the meta object for class '{@link GPort <em>GPort</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GPort</em>'.
    * @see GPort
    * @generated
    */
   EClass getGPort();

   /**
    * Returns the meta object for class '{@link GButton <em>GButton</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GButton</em>'.
    * @see GButton
    * @generated
    */
   EClass getGButton();

   /**
    * Returns the meta object for the attribute '{@link GButton#isEnabled <em>Enabled</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Enabled</em>'.
    * @see GButton#isEnabled()
    * @see #getGButton()
    * @generated
    */
   EAttribute getGButton_Enabled();

   /**
    * Returns the meta object for class '{@link GBoundsAware <em>GBounds Aware</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GBounds Aware</em>'.
    * @see GBoundsAware
    * @generated
    */
   EClass getGBoundsAware();

   /**
    * Returns the meta object for the containment reference '{@link GBoundsAware#getPosition <em>Position</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Position</em>'.
    * @see GBoundsAware#getPosition()
    * @see #getGBoundsAware()
    * @generated
    */
   EReference getGBoundsAware_Position();

   /**
    * Returns the meta object for the containment reference '{@link GBoundsAware#getSize <em>Size</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Size</em>'.
    * @see GBoundsAware#getSize()
    * @see #getGBoundsAware()
    * @generated
    */
   EReference getGBoundsAware_Size();

   /**
    * Returns the meta object for class '{@link GPoint <em>GPoint</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GPoint</em>'.
    * @see GPoint
    * @generated
    */
   EClass getGPoint();

   /**
    * Returns the meta object for the attribute '{@link GPoint#getX <em>X</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>X</em>'.
    * @see GPoint#getX()
    * @see #getGPoint()
    * @generated
    */
   EAttribute getGPoint_X();

   /**
    * Returns the meta object for the attribute '{@link GPoint#getY <em>Y</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Y</em>'.
    * @see GPoint#getY()
    * @see #getGPoint()
    * @generated
    */
   EAttribute getGPoint_Y();

   /**
    * Returns the meta object for class '{@link GDimension <em>GDimension</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GDimension</em>'.
    * @see GDimension
    * @generated
    */
   EClass getGDimension();

   /**
    * Returns the meta object for the attribute '{@link GDimension#getWidth <em>Width</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Width</em>'.
    * @see GDimension#getWidth()
    * @see #getGDimension()
    * @generated
    */
   EAttribute getGDimension_Width();

   /**
    * Returns the meta object for the attribute '{@link GDimension#getHeight <em>Height</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Height</em>'.
    * @see GDimension#getHeight()
    * @see #getGDimension()
    * @generated
    */
   EAttribute getGDimension_Height();

   /**
    * Returns the meta object for class '{@link GEdgeLayoutable <em>GEdge Layoutable</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GEdge Layoutable</em>'.
    * @see GEdgeLayoutable
    * @generated
    */
   EClass getGEdgeLayoutable();

   /**
    * Returns the meta object for the containment reference '{@link GEdgeLayoutable#getEdgePlacement <em>Edge Placement</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Edge Placement</em>'.
    * @see GEdgeLayoutable#getEdgePlacement()
    * @see #getGEdgeLayoutable()
    * @generated
    */
   EReference getGEdgeLayoutable_EdgePlacement();

   /**
    * Returns the meta object for class '{@link GEdgePlacement <em>GEdge Placement</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GEdge Placement</em>'.
    * @see GEdgePlacement
    * @generated
    */
   EClass getGEdgePlacement();

   /**
    * Returns the meta object for the attribute '{@link GEdgePlacement#getPosition <em>Position</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Position</em>'.
    * @see GEdgePlacement#getPosition()
    * @see #getGEdgePlacement()
    * @generated
    */
   EAttribute getGEdgePlacement_Position();

   /**
    * Returns the meta object for the attribute '{@link GEdgePlacement#getOffset <em>Offset</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Offset</em>'.
    * @see GEdgePlacement#getOffset()
    * @see #getGEdgePlacement()
    * @generated
    */
   EAttribute getGEdgePlacement_Offset();

   /**
    * Returns the meta object for the attribute '{@link GEdgePlacement#getSide <em>Side</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Side</em>'.
    * @see GEdgePlacement#getSide()
    * @see #getGEdgePlacement()
    * @generated
    */
   EAttribute getGEdgePlacement_Side();

   /**
    * Returns the meta object for the attribute '{@link GEdgePlacement#isRotate <em>Rotate</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Rotate</em>'.
    * @see GEdgePlacement#isRotate()
    * @see #getGEdgePlacement()
    * @generated
    */
   EAttribute getGEdgePlacement_Rotate();

   /**
    * Returns the meta object for class '{@link GLayouting <em>GLayouting</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GLayouting</em>'.
    * @see GLayouting
    * @generated
    */
   EClass getGLayouting();

   /**
    * Returns the meta object for the attribute '{@link GLayouting#getLayout <em>Layout</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Layout</em>'.
    * @see GLayouting#getLayout()
    * @see #getGLayouting()
    * @generated
    */
   EAttribute getGLayouting_Layout();

   /**
    * Returns the meta object for class '{@link GBounds <em>GBounds</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GBounds</em>'.
    * @see GBounds
    * @generated
    */
   EClass getGBounds();

   /**
    * Returns the meta object for the attribute '{@link GBounds#getX <em>X</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>X</em>'.
    * @see GBounds#getX()
    * @see #getGBounds()
    * @generated
    */
   EAttribute getGBounds_X();

   /**
    * Returns the meta object for the attribute '{@link GBounds#getY <em>Y</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Y</em>'.
    * @see GBounds#getY()
    * @see #getGBounds()
    * @generated
    */
   EAttribute getGBounds_Y();

   /**
    * Returns the meta object for the attribute '{@link GBounds#getWidth <em>Width</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Width</em>'.
    * @see GBounds#getWidth()
    * @see #getGBounds()
    * @generated
    */
   EAttribute getGBounds_Width();

   /**
    * Returns the meta object for the attribute '{@link GBounds#getHeight <em>Height</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Height</em>'.
    * @see GBounds#getHeight()
    * @see #getGBounds()
    * @generated
    */
   EAttribute getGBounds_Height();

   /**
    * Returns the meta object for class '{@link GAlignable <em>GAlignable</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GAlignable</em>'.
    * @see GAlignable
    * @generated
    */
   EClass getGAlignable();

   /**
    * Returns the meta object for the containment reference '{@link GAlignable#getAlignment <em>Alignment</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Alignment</em>'.
    * @see GAlignable#getAlignment()
    * @see #getGAlignable()
    * @generated
    */
   EReference getGAlignable_Alignment();

   /**
    * Returns the meta object for class '{@link GArgumentable <em>GArgumentable</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GArgumentable</em>'.
    * @see GArgumentable
    * @generated
    */
   EClass getGArgumentable();

   /**
    * Returns the meta object for the map '{@link GArgumentable#getArgs <em>Args</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the map '<em>Args</em>'.
    * @see GArgumentable#getArgs()
    * @see #getGArgumentable()
    * @generated
    */
   EReference getGArgumentable_Args();

   /**
    * Returns the meta object for class '{@link GIssue <em>GIssue</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GIssue</em>'.
    * @see GIssue
    * @generated
    */
   EClass getGIssue();

   /**
    * Returns the meta object for the attribute '{@link GIssue#getSeverity <em>Severity</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Severity</em>'.
    * @see GIssue#getSeverity()
    * @see #getGIssue()
    * @generated
    */
   EAttribute getGIssue_Severity();

   /**
    * Returns the meta object for the attribute '{@link GIssue#getMessage <em>Message</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Message</em>'.
    * @see GIssue#getMessage()
    * @see #getGIssue()
    * @generated
    */
   EAttribute getGIssue_Message();

   /**
    * Returns the meta object for class '{@link GHtmlRoot <em>GHtml Root</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GHtml Root</em>'.
    * @see GHtmlRoot
    * @generated
    */
   EClass getGHtmlRoot();

   /**
    * Returns the meta object for the attribute list '{@link GHtmlRoot#getClasses <em>Classes</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute list '<em>Classes</em>'.
    * @see GHtmlRoot#getClasses()
    * @see #getGHtmlRoot()
    * @generated
    */
   EAttribute getGHtmlRoot_Classes();

   /**
    * Returns the meta object for class '{@link GPreRenderedElement <em>GPre Rendered Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GPre Rendered Element</em>'.
    * @see GPreRenderedElement
    * @generated
    */
   EClass getGPreRenderedElement();

   /**
    * Returns the meta object for the attribute '{@link GPreRenderedElement#getCode <em>Code</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Code</em>'.
    * @see GPreRenderedElement#getCode()
    * @see #getGPreRenderedElement()
    * @generated
    */
   EAttribute getGPreRenderedElement_Code();

   /**
    * Returns the meta object for class '{@link GShapePreRenderedElement <em>GShape Pre Rendered Element</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GShape Pre Rendered Element</em>'.
    * @see GShapePreRenderedElement
    * @generated
    */
   EClass getGShapePreRenderedElement();

   /**
    * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Object Map Entry</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>String To Object Map Entry</em>'.
    * @see java.util.Map.Entry
    * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
    *        valueDataType="org.eclipse.emf.ecore.EJavaObject"
    * @generated
    */
   EClass getStringToObjectMapEntry();

   /**
    * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Key</em>'.
    * @see java.util.Map.Entry
    * @see #getStringToObjectMapEntry()
    * @generated
    */
   EAttribute getStringToObjectMapEntry_Key();

   /**
    * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Value</em>'.
    * @see java.util.Map.Entry
    * @see #getStringToObjectMapEntry()
    * @generated
    */
   EAttribute getStringToObjectMapEntry_Value();

   /**
    * Returns the meta object for class '{@link GLayoutable <em>GLayoutable</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>GLayoutable</em>'.
    * @see GLayoutable
    * @generated
    */
   EClass getGLayoutable();

   /**
    * Returns the meta object for the map '{@link GLayoutable#getLayoutOptions <em>Layout Options</em>}'.
    * <!-- begin-user-doc -->
   	 * <!-- end-user-doc -->
    * @return the meta object for the map '<em>Layout Options</em>'.
    * @see GLayoutable#getLayoutOptions()
    * @see #getGLayoutable()
    * @generated
    */
   EReference getGLayoutable_LayoutOptions();

   /**
    * Returns the meta object for enum '{@link GSeverity <em>GSeverity</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for enum '<em>GSeverity</em>'.
    * @see GSeverity
    * @generated
    */
   EEnum getGSeverity();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   GraphFactory getGraphFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    *   <li>each class,</li>
    *   <li>each feature of each class,</li>
    *   <li>each operation of each class,</li>
    *   <li>each enum,</li>
    *   <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * @generated
    */
   interface Literals {
      /**
       * The meta object literal for the '{@link GModelElement <em>GModel Element</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see GModelElement
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGModelElement()
       * @generated
       */
      EClass GMODEL_ELEMENT = eINSTANCE.getGModelElement();

      /**
       * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GMODEL_ELEMENT__ID = eINSTANCE.getGModelElement_Id();

      /**
       * The meta object literal for the '<em><b>Css Classes</b></em>' attribute list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GMODEL_ELEMENT__CSS_CLASSES = eINSTANCE.getGModelElement_CssClasses();

      /**
       * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GMODEL_ELEMENT__CHILDREN = eINSTANCE.getGModelElement_Children();

      /**
       * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GMODEL_ELEMENT__PARENT = eINSTANCE.getGModelElement_Parent();

      /**
       * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GMODEL_ELEMENT__TRACE = eINSTANCE.getGModelElement_Trace();

      /**
       * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GMODEL_ELEMENT__TYPE = eINSTANCE.getGModelElement_Type();

      /**
       * The meta object literal for the '{@link GShapeElement <em>GShape Element</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see GShapeElement
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGShapeElement()
       * @generated
       */
      EClass GSHAPE_ELEMENT = eINSTANCE.getGShapeElement();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GGraphImpl <em>GGraph</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GGraphImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGGraph()
       * @generated
       */
      EClass GGRAPH = eINSTANCE.getGGraph();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GModelRootImpl <em>GModel Root</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GModelRootImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGModelRoot()
       * @generated
       */
      EClass GMODEL_ROOT = eINSTANCE.getGModelRoot();

      /**
       * The meta object literal for the '<em><b>Canvas Bounds</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GMODEL_ROOT__CANVAS_BOUNDS = eINSTANCE.getGModelRoot_CanvasBounds();

      /**
       * The meta object literal for the '<em><b>Revision</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GMODEL_ROOT__REVISION = eINSTANCE.getGModelRoot_Revision();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GNodeImpl <em>GNode</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GNodeImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGNode()
       * @generated
       */
      EClass GNODE = eINSTANCE.getGNode();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GEdgeImpl <em>GEdge</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GEdgeImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGEdge()
       * @generated
       */
      EClass GEDGE = eINSTANCE.getGEdge();

      /**
       * The meta object literal for the '<em><b>Routing Points</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GEDGE__ROUTING_POINTS = eINSTANCE.getGEdge_RoutingPoints();

      /**
       * The meta object literal for the '<em><b>Source Id</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GEDGE__SOURCE_ID = eINSTANCE.getGEdge_SourceId();

      /**
       * The meta object literal for the '<em><b>Target Id</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GEDGE__TARGET_ID = eINSTANCE.getGEdge_TargetId();

      /**
       * The meta object literal for the '<em><b>Source</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GEDGE__SOURCE = eINSTANCE.getGEdge_Source();

      /**
       * The meta object literal for the '<em><b>Target</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GEDGE__TARGET = eINSTANCE.getGEdge_Target();

      /**
       * The meta object literal for the '<em><b>Router Kind</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GEDGE__ROUTER_KIND = eINSTANCE.getGEdge_RouterKind();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GCompartmentImpl <em>GCompartment</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GCompartmentImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGCompartment()
       * @generated
       */
      EClass GCOMPARTMENT = eINSTANCE.getGCompartment();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GLabelImpl <em>GLabel</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GLabelImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGLabel()
       * @generated
       */
      EClass GLABEL = eINSTANCE.getGLabel();

      /**
       * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GLABEL__TEXT = eINSTANCE.getGLabel_Text();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GIssueMarkerImpl <em>GIssue Marker</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GIssueMarkerImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGIssueMarker()
       * @generated
       */
      EClass GISSUE_MARKER = eINSTANCE.getGIssueMarker();

      /**
       * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GISSUE_MARKER__ISSUES = eINSTANCE.getGIssueMarker_Issues();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GPortImpl <em>GPort</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GPortImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGPort()
       * @generated
       */
      EClass GPORT = eINSTANCE.getGPort();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GButtonImpl <em>GButton</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GButtonImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGButton()
       * @generated
       */
      EClass GBUTTON = eINSTANCE.getGButton();

      /**
       * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GBUTTON__ENABLED = eINSTANCE.getGButton_Enabled();

      /**
       * The meta object literal for the '{@link GBoundsAware <em>GBounds Aware</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see GBoundsAware
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGBoundsAware()
       * @generated
       */
      EClass GBOUNDS_AWARE = eINSTANCE.getGBoundsAware();

      /**
       * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GBOUNDS_AWARE__POSITION = eINSTANCE.getGBoundsAware_Position();

      /**
       * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GBOUNDS_AWARE__SIZE = eINSTANCE.getGBoundsAware_Size();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GPointImpl <em>GPoint</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GPointImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGPoint()
       * @generated
       */
      EClass GPOINT = eINSTANCE.getGPoint();

      /**
       * The meta object literal for the '<em><b>X</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GPOINT__X = eINSTANCE.getGPoint_X();

      /**
       * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GPOINT__Y = eINSTANCE.getGPoint_Y();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GDimensionImpl <em>GDimension</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GDimensionImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGDimension()
       * @generated
       */
      EClass GDIMENSION = eINSTANCE.getGDimension();

      /**
       * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GDIMENSION__WIDTH = eINSTANCE.getGDimension_Width();

      /**
       * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GDIMENSION__HEIGHT = eINSTANCE.getGDimension_Height();

      /**
       * The meta object literal for the '{@link GEdgeLayoutable <em>GEdge Layoutable</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see GEdgeLayoutable
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGEdgeLayoutable()
       * @generated
       */
      EClass GEDGE_LAYOUTABLE = eINSTANCE.getGEdgeLayoutable();

      /**
       * The meta object literal for the '<em><b>Edge Placement</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GEDGE_LAYOUTABLE__EDGE_PLACEMENT = eINSTANCE.getGEdgeLayoutable_EdgePlacement();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GEdgePlacementImpl <em>GEdge Placement</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GEdgePlacementImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGEdgePlacement()
       * @generated
       */
      EClass GEDGE_PLACEMENT = eINSTANCE.getGEdgePlacement();

      /**
       * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GEDGE_PLACEMENT__POSITION = eINSTANCE.getGEdgePlacement_Position();

      /**
       * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GEDGE_PLACEMENT__OFFSET = eINSTANCE.getGEdgePlacement_Offset();

      /**
       * The meta object literal for the '<em><b>Side</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GEDGE_PLACEMENT__SIDE = eINSTANCE.getGEdgePlacement_Side();

      /**
       * The meta object literal for the '<em><b>Rotate</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GEDGE_PLACEMENT__ROTATE = eINSTANCE.getGEdgePlacement_Rotate();

      /**
       * The meta object literal for the '{@link GLayouting <em>GLayouting</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see GLayouting
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGLayouting()
       * @generated
       */
      EClass GLAYOUTING = eINSTANCE.getGLayouting();

      /**
       * The meta object literal for the '<em><b>Layout</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GLAYOUTING__LAYOUT = eINSTANCE.getGLayouting_Layout();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GBoundsImpl <em>GBounds</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GBoundsImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGBounds()
       * @generated
       */
      EClass GBOUNDS = eINSTANCE.getGBounds();

      /**
       * The meta object literal for the '<em><b>X</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GBOUNDS__X = eINSTANCE.getGBounds_X();

      /**
       * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GBOUNDS__Y = eINSTANCE.getGBounds_Y();

      /**
       * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GBOUNDS__WIDTH = eINSTANCE.getGBounds_Width();

      /**
       * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GBOUNDS__HEIGHT = eINSTANCE.getGBounds_Height();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GAlignableImpl <em>GAlignable</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GAlignableImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGAlignable()
       * @generated
       */
      EClass GALIGNABLE = eINSTANCE.getGAlignable();

      /**
       * The meta object literal for the '<em><b>Alignment</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GALIGNABLE__ALIGNMENT = eINSTANCE.getGAlignable_Alignment();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GArgumentableImpl <em>GArgumentable</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GArgumentableImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGArgumentable()
       * @generated
       */
      EClass GARGUMENTABLE = eINSTANCE.getGArgumentable();

      /**
       * The meta object literal for the '<em><b>Args</b></em>' map feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference GARGUMENTABLE__ARGS = eINSTANCE.getGArgumentable_Args();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GIssueImpl <em>GIssue</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GIssueImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGIssue()
       * @generated
       */
      EClass GISSUE = eINSTANCE.getGIssue();

      /**
       * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GISSUE__SEVERITY = eINSTANCE.getGIssue_Severity();

      /**
       * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GISSUE__MESSAGE = eINSTANCE.getGIssue_Message();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GHtmlRootImpl <em>GHtml Root</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GHtmlRootImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGHtmlRoot()
       * @generated
       */
      EClass GHTML_ROOT = eINSTANCE.getGHtmlRoot();

      /**
       * The meta object literal for the '<em><b>Classes</b></em>' attribute list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GHTML_ROOT__CLASSES = eINSTANCE.getGHtmlRoot_Classes();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GPreRenderedElementImpl <em>GPre Rendered Element</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GPreRenderedElementImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGPreRenderedElement()
       * @generated
       */
      EClass GPRE_RENDERED_ELEMENT = eINSTANCE.getGPreRenderedElement();

      /**
       * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute GPRE_RENDERED_ELEMENT__CODE = eINSTANCE.getGPreRenderedElement_Code();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GShapePreRenderedElementImpl <em>GShape Pre Rendered Element</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GShapePreRenderedElementImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGShapePreRenderedElement()
       * @generated
       */
      EClass GSHAPE_PRE_RENDERED_ELEMENT = eINSTANCE.getGShapePreRenderedElement();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.StringToObjectMapEntryImpl <em>String To Object Map Entry</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.StringToObjectMapEntryImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getStringToObjectMapEntry()
       * @generated
       */
      EClass STRING_TO_OBJECT_MAP_ENTRY = eINSTANCE.getStringToObjectMapEntry();

      /**
       * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute STRING_TO_OBJECT_MAP_ENTRY__KEY = eINSTANCE.getStringToObjectMapEntry_Key();

      /**
       * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute STRING_TO_OBJECT_MAP_ENTRY__VALUE = eINSTANCE.getStringToObjectMapEntry_Value();

      /**
       * The meta object literal for the '{@link org.eclipse.glsp.graph.impl.GLayoutableImpl <em>GLayoutable</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.eclipse.glsp.graph.impl.GLayoutableImpl
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGLayoutable()
       * @generated
       */
      EClass GLAYOUTABLE = eINSTANCE.getGLayoutable();

      /**
       * The meta object literal for the '<em><b>Layout Options</b></em>' map feature.
       * <!-- begin-user-doc -->
      	 * <!-- end-user-doc -->
       * @generated
       */
      EReference GLAYOUTABLE__LAYOUT_OPTIONS = eINSTANCE.getGLayoutable_LayoutOptions();

      /**
       * The meta object literal for the '{@link GSeverity <em>GSeverity</em>}' enum.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see GSeverity
       * @see org.eclipse.glsp.graph.impl.GraphPackageImpl#getGSeverity()
       * @generated
       */
      EEnum GSEVERITY = eINSTANCE.getGSeverity();

   }

} //GraphPackage
