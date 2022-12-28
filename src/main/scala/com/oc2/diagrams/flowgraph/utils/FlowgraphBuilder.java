/********************************************************************************
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
 ********************************************************************************/
package com.oc2.diagrams.flowgraph.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.glsp.graph.GCompartment;
import org.eclipse.glsp.graph.GLabel;
import org.eclipse.glsp.graph.builder.AbstractGCompartmentBuilder;
import org.eclipse.glsp.graph.builder.AbstractGEdgeBuilder;
import org.eclipse.glsp.graph.builder.AbstractGNodeBuilder;
import org.eclipse.glsp.graph.builder.GModelElementBuilder;
import org.eclipse.glsp.graph.builder.impl.GCompartmentBuilder;
import org.eclipse.glsp.graph.builder.impl.GLabelBuilder;
import org.eclipse.glsp.graph.util.GConstants;

import com.oc2.diagrams.flowgraph.FlowDecision;
import com.oc2.diagrams.flowgraph.FlowElement;
import com.oc2.diagrams.flowgraph.FlowNode;
import com.oc2.diagrams.flowgraph.FlowParameter;
import com.oc2.diagrams.flowgraph.FlowParameters;
import com.oc2.diagrams.flowgraph.FlowgraphFactory;
import com.oc2.diagrams.flowgraph.Icon;
import com.oc2.diagrams.flowgraph.LabeledEdge;

public final class FlowgraphBuilder {

   private static final String V_GRAB = "vGrab";
   private static final String H_GRAB = "hGrab";
   private static final String H_ALIGN = "hAlign";

   public static class LabeledEdgeBuilder extends AbstractGEdgeBuilder<LabeledEdge, LabeledEdgeBuilder> {

      private String label;

      public LabeledEdgeBuilder() {
         super(ModelTypes.LABELED_EDGE);
      }

      public LabeledEdgeBuilder label(final String label) {
         this.label = label;
         return self();
      }

      @Override
      protected void setProperties(final LabeledEdge edge) {
         super.setProperties(edge);
         edge.setLabel(label);
         edge.getChildren().add(createCompartmentHeader(edge));
      }

      // private GCompartment createLabelCompartment(final LabeledEdge edge) {
      // Map<String, Object> layoutOptions = new HashMap<>();

      // return new GCompartmentBuilder(ModelTypes.COMP_HEADER) //
      // .id(edge.getId() + "_header") //
      // .layout(GConstants.Layout.HBOX) //
      // .layoutOptions(layoutOptions) //
      // .add(createCompartmentHeader(edge)) //
      // .build();
      // }

      private GLabel createCompartmentHeader(final LabeledEdge edge) {
         // GPoint point = edge.getRoutingPoints().get(0);
         return new GLabelBuilder(ModelTypes.LABEL_HEADING) //
            .id(edge.getId() + "_classname") //
            // .alignment(point)
            .text(edge.getLabel()) //
            .build();
      }

      @Override
      protected LabeledEdge instantiate() {
         LabeledEdge edge = FlowgraphFactory.eINSTANCE.createLabeledEdge();
         return edge;
      }

      @Override
      protected LabeledEdgeBuilder self() {
         return this;
      }

   }

   public static class FlowElementBuilder extends AbstractGNodeBuilder<FlowElement, FlowElementBuilder> {
      protected String elementType;
      protected String name;

      public FlowElementBuilder(final String type, final String elementType, final String name) {
         super(type);
         this.elementType = elementType;
         this.name = name;
      }

      @Override
      protected void setProperties(final FlowElement element) {
         super.setProperties(element);
         element.setElementType(elementType);
         element.setName(name);
      }

      @Override
      protected FlowElement instantiate() {
         return FlowgraphFactory.eINSTANCE.createFlowElement();
      }

      @Override
      protected FlowElementBuilder self() {
         return this;
      }
   }

   public static class FlowNodeBuilder extends AbstractGNodeBuilder<FlowNode, FlowNodeBuilder> {
      private final String nodeType;
      private final String name;
      private final String description;

      public FlowNodeBuilder(final String type, final String nodeType, final String name, final String description) {
         super(type);
         this.nodeType = nodeType;
         this.name = name;
         this.description = description;
      }

      @Override
      protected FlowNode instantiate() {
         return FlowgraphFactory.eINSTANCE.createFlowNode();
      }

      @Override
      protected FlowNodeBuilder self() {
         return this;
      }

      @Override
      public void setProperties(final FlowNode flowNode) {
         super.setProperties(flowNode);
         flowNode.setNodeType(nodeType);
         flowNode.setName(name);
         flowNode.setDescription(description);
         flowNode.setLayout(GConstants.Layout.HBOX);
         flowNode.getLayoutOptions().put("paddingRight", 10);
         flowNode.getChildren().add(createCompartmentIcon(flowNode));
         flowNode.getChildren().add(createCompartmentHeader(flowNode));
      }

      private Icon createCompartmentIcon(final FlowNode flowNode) {
         return new IconBuilder().id(flowNode.getId() + "_icon").build();
      }

      private GLabel createCompartmentHeader(final FlowNode flowNode) {
         return new GLabelBuilder(ModelTypes.LABEL_HEADING) //
            .id(flowNode.getId() + "_classname") //
            .text(flowNode.getName()) //
            .build();
      }

   }

   public static class IconBuilder extends AbstractGCompartmentBuilder<Icon, IconBuilder> {

      public IconBuilder() {
         super(ModelTypes.ICON);
      }

      @Override
      protected Icon instantiate() {
         return FlowgraphFactory.eINSTANCE.createIcon();
      }

      @Override
      protected IconBuilder self() {
         return this;
      }

   }

   public static class FlowDecisionBuilder extends AbstractGNodeBuilder<FlowDecision, FlowDecisionBuilder> {
      private String decisionType;
      private final String name;
      private String snippet;

      public FlowDecisionBuilder(final String decisionType, String name, final String snippet) {
         super(ModelTypes.FLOW_DECISION);
         this.decisionType = decisionType;
         this.name = name;
         this.snippet = snippet;
      }

      @Override
      protected FlowDecision instantiate() {
         return FlowgraphFactory.eINSTANCE.createFlowDecision();
      }

      @Override
      protected FlowDecisionBuilder self() {
         return this;
      }

      public void setSnippet(final String snippet) { this.snippet = snippet; }

      @Override
      protected void setProperties(final FlowDecision decision) {
         super.setProperties(decision);
         decision.setDecisionType(decisionType);
         decision.setName(name);
         decision.setSnippet(snippet);
         decision.setLayout(GConstants.Layout.VBOX);
         decision.getLayoutOptions().put(H_ALIGN, "center");
         decision.getLayoutOptions().put(H_GRAB, false);
         decision.getLayoutOptions().put(V_GRAB, false);
         decision.getCssClasses().add("flowDecision");
         decision.getChildren().add(createLabelCompartment(decision));
         decision.getChildren().add(createStructCompartment(decision));
      }

      private GCompartment createLabelCompartment(final FlowDecision decision) {
         Map<String, Object> layoutOptions = new HashMap<>();

         return new GCompartmentBuilder(ModelTypes.COMP_HEADER) //
            .id(decision.getId() + "_header") //
            .layout(GConstants.Layout.HBOX) //
            .layoutOptions(layoutOptions) //
            .add(createCompartmentHeader(decision)) //
            .build();
      }

      private GLabel createCompartmentHeader(final FlowDecision decision) {
         return new GLabelBuilder(ModelTypes.LABEL_HEADING) //
            .id(decision.getId() + "_classname") //
            .text(decision.getName()) //
            .build();
      }

      private GCompartment createStructCompartment(final FlowDecision decision) {
         Map<String, Object> layoutOptions = new HashMap<>();
         layoutOptions.put(H_ALIGN, "left");
         layoutOptions.put(H_GRAB, true);
         layoutOptions.put(V_GRAB, true);
         GCompartmentBuilder structCompartmentBuilder = new GCompartmentBuilder(ModelTypes.STRUCTURE) //
            .id(decision.getId() + "_struct") //
            .layout(GConstants.Layout.FREEFORM) //
            .layoutOptions(layoutOptions);
         return structCompartmentBuilder //
            .build();
      }
   }

   public static class FlowParametersBuilder extends AbstractGNodeBuilder<FlowParameters, FlowParametersBuilder> {
      private final String name;
      private final EList<FlowParameter> parameterList;

      public FlowParametersBuilder(final String name, final EList<FlowParameter> parameterList) {
         super(ModelTypes.FLOW_PARAMETERS);
         this.name = name;
         this.parameterList = parameterList;
      }

      @Override
      protected FlowParameters instantiate() {
         return FlowgraphFactory.eINSTANCE.createFlowParameters();
      }

      @Override
      protected FlowParametersBuilder self() {
         return this;
      }

      @Override
      public void setProperties(final FlowParameters flowParameters) {
         super.setProperties(flowParameters);
         flowParameters.setName(name);
         flowParameters.getParameter().addAll(parameterList);
         flowParameters.setLayout(GConstants.Layout.HBOX);
         flowParameters.getLayoutOptions().put("paddingRight", 10);
         flowParameters.getChildren().add(createCompartmentIcon(flowParameters));
         flowParameters.getChildren().add(createCompartmentHeader(flowParameters));
      }

      private Icon createCompartmentIcon(final FlowParameters flowParameters) {
         return new IconBuilder().id(flowParameters.getId() + "_icon").build();
      }

      private GLabel createCompartmentHeader(final FlowParameters flowParameters) {
         return new GLabelBuilder(ModelTypes.LABEL_HEADING) //
            .id(flowParameters.getId() + "_classname") //
            .text(flowParameters.getName()) //
            .build();
      }
   }

   public static class FlowParameterBuilder extends GModelElementBuilder<FlowParameter, FlowParameterBuilder> {

      private final String id;

      public FlowParameterBuilder(final String id) {
         super(ModelTypes.FLOW_PARAMETER);
         this.id = id;
      }

      @Override
      protected FlowParameter instantiate() {
         return FlowgraphFactory.eINSTANCE.createFlowParameter();
      }

      @Override
      protected FlowParameterBuilder self() {
         return this;
      }

      @Override
      public void setProperties(final FlowParameter flowParameter) {
         flowParameter.setId(id);
         super.setProperties(flowParameter);
      }

   }

   private FlowgraphBuilder() {}
}
