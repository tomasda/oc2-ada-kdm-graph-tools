package com.oc2.kdm.analysis.glsp

import com.google.gson.{GsonBuilder, JsonElement, JsonObject}
import com.oc2.diagrams.flowgraph.{FlowDecision, FlowNode, FlowParameter}
import com.oc2.diagrams.flowgraph.impl.IconImpl
import com.oc2.diagrams.flowgraph.utils.FlowgraphBuilder
import com.oc2.kdm.analysis.graphs.{ConcreteDirectedGraph, GraphProperties, GraphTypes}
import org.eclipse.glsp.graph.builder.impl.GArguments
import org.eclipse.glsp.graph.gson.GraphGsonConfigurator
import org.eclipse.glsp.graph.impl.GLabelImpl
import org.eclipse.glsp.graph.util.GConstants
import org.eclipse.glsp.graph.{GEdge, GGraph, GModelElement, GraphFactory}
import java.io.{FileWriter, IOException}
import java.util
import scala.collection.JavaConverters.seqAsJavaListConverter


class GlspCreatorUtils() {

  private val gsonConfigurator = new GraphGsonConfigurator().withDefaultTypes
  private val V_GRAB = "vGrab"
  private val H_GRAB = "hGrab"
  private val H_ALIGN = "hAlign"

  class nodeImpl{
    var ident: Int = _
    var graphIndex: Int = _
    var nodeName: String = _
    var nodeType: String = _
    var nodeCode: String = _
  }
  class vertexImpl{
    var since: String = _
    var until: String = _
    var vertexType: String = _
  }

  def nodeCreator(id:String, name: String, fnType:String, nodeType: String, snippet:String, x: Int, y: Int): FlowNode = {
    //final String type, final String nodeType, final String name, final String description
    val wfb =  new FlowgraphBuilder.FlowNodeBuilder(fnType, nodeType, name, snippet).position(x,y)
      .addArguments(GArguments.cornerRadius(5))
      .addCssClass(com.oc2.diagrams.flowgraph.utils.ModelTypes.FLOW_NODE).addCssClass(com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE))
      .id(id)
      .layout(GConstants.Layout.VBOX)

    val task = wfb.build
    task.setNodeType(nodeType)
    val t1D = GraphFactory.eINSTANCE.createGDimension
    t1D.setHeight(30)
    t1D.setWidth(123)
    task.setSize(t1D)

    val ic = task.getChildren.get(0).asInstanceOf[IconImpl]
    val icP = GraphFactory.eINSTANCE.createGPoint
    icP.setX(5)
    icP.setY(5)
    ic.setPosition(icP)
    val idD = GraphFactory.eINSTANCE.createGDimension
    idD.setHeight(20)
    idD.setWidth(25)
    ic.setSize(idD)
    ic.setLayout(null)
    ic.setType("icon")
    val lb = task.getChildren.get(1).asInstanceOf[GLabelImpl]
    val lbP = GraphFactory.eINSTANCE.createGPoint
    lbP.setX(31)
    lbP.setY(7)
    lb.setPosition(lbP)
    val lbD = GraphFactory.eINSTANCE.createGDimension
    lbD.setHeight(16)
    lbD.setWidth(82)
    lb.setSize(lbD)
    val lbA = GraphFactory.eINSTANCE.createGPoint
    lbA.setX(41)
    lbA.setY(13)
    lb.setAlignment(lbA)
    task
  }

  def decisionCreator(id:String, name:String, nodeType: String, snippet:String,x: Int, y: Int): FlowDecision ={

    val d1: FlowgraphBuilder.FlowDecisionBuilder = new FlowgraphBuilder.FlowDecisionBuilder(nodeType,name,snippet)
    d1.id(id)
      .position(x, y)
      .size(32, 32)
      //.`type`("activityNode:decision")
      //.layout(GConstants.Layout.FREEFORM)
    d1.build()
  }

//  def aa():Unit ={
//    val a = new FlowgraphBuilder.FlowDecisionBuilder("","", "")
//    val b = new FlowgraphBuilder.FlowNodeBuilder("","", "", "")
//    val c = new FlowgraphBuilder.FlowParameterBuilder("")
//    val dList = EList[FlowParameter]
//    val d = new FlowgraphBuilder.FlowParametersBuilder("", dList)
//    val e = new FlowgraphBuilder.IconBuilder()
//    val f = new FlowgraphBuilder.FlowElementBuilder("","", "")
//    val g = new FlowgraphBuilder.LabeledEdgeBuilder()
//  }

  def forkCreator(x: Int, y: Int, id:String): FlowParameter ={

    //val nodeType = ModelTypes.FLOW_PARAMETER
    val d1: FlowgraphBuilder.FlowParameterBuilder = new FlowgraphBuilder.FlowParameterBuilder(id)
    d1.id(id)
      //.position(x, y)
      //.size(10, 50)
      //.`type`(ModelTypes.FLOW_PARAMETER)
      //.layout(GConstants.Layout.FREEFORM)
    d1.build()
  }

   def writeToJson(graph: GGraph): JsonElement = {
    val gson = gsonConfigurator.configureGsonBuilder(new GsonBuilder).create
    gson.toJsonTree(graph)
  }

  def jsonPrettyPrint(graph: JsonElement): String = {
    val gson = new GsonBuilder().setPrettyPrinting().create
    gson.toJson(graph)
  }

  def render2glsp(directedGraph: ConcreteDirectedGraph, args: Map[String,String]): String = {
    println(s"Running glsp Render to Json")

    // Conversión de formato directedGraph a Nodos y Vertices previo a la creación glsp
    var index = 1
//    val graphNodes: Seq[(Int, Int, String, String, String)] = res.nodes.reverse.map{ x=>
//      val res = (x.hashCode(), index, x.nodeName, x.nodeType, x.nodeCode)
//      index +=1
//      res
//    }
    val graphNodes: Seq[nodeImpl] = directedGraph.nodes.reverse.map{ x=>
      val res:nodeImpl = new nodeImpl
      res.ident = x.hashCode()
      res.graphIndex = index
      res.nodeName = x.nodeName
      res.nodeType = x.nodeType
      res.nodeCode = x.nodeCode
      index +=1
      res
    }

    //val graphVertexs: Array[(String, String, String)] = res.vertexs.map(x=> (graphNodes.find(_._1==x.since.hashCode()).get._2.toString , graphNodes.find(_._1==x.until.hashCode()).get._2.toString, x.vertexType)).toArray
    val graphVertexs: Seq[vertexImpl] = directedGraph.vertexs.map { x =>
      val vertex: vertexImpl = new vertexImpl
      vertex.since = graphNodes.find(_.ident == x.since.hashCode()).get.graphIndex.toString
      vertex.until = graphNodes.find(_.ident == x.until.hashCode()).get.graphIndex.toString
      vertex.vertexType = x.vertexType
      vertex
    }

    //Creación del grafo en formato glsp
    val glspCreator = new GlspCreatorUtils
    val graph = GraphFactory.eINSTANCE.createGGraph

    graph.setType(args(GraphProperties.GRAPH_TYPE)) //"graph")
    graph.setRevision(args(GraphProperties.GRAPH_REVISION).toInt) //1)
    graph.setId(args(GraphProperties.GRAPH_ID)) //"glsp-graph3")

    var xPos = 5
    var yPos = 5

    var glspNodes: Seq[GModelElement] = graphNodes.map { n =>
      yPos += 50

      var res: GModelElement = n.nodeType match {
        //(x.hashCode(), index, x.nodeName, x.nodeType, x.nodeCode)
        case GraphTypes.INITIAL =>
          glspCreator.nodeCreator(n.graphIndex.toString, n.nodeName,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n.nodeCode, xPos, 0)
        case GraphTypes.ENDING =>
          glspCreator.nodeCreator(n.graphIndex.toString, n.nodeName,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n.nodeCode, xPos-100, yPos+100)
        case GraphTypes.FOR =>
          xPos += 50
          glspCreator.decisionCreator(n.graphIndex.toString, n.nodeName, n.nodeType, n.nodeCode, xPos, yPos )
        case GraphTypes.IF =>
          //val nodeType = "IF"
          xPos += 50
          glspCreator.decisionCreator(n.graphIndex.toString, n.nodeName, n.nodeType, n.nodeCode, xPos, yPos )
        case GraphTypes.CODE =>
          val name = n.nodeType
          glspCreator.nodeCreator(n.graphIndex.toString,name,com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE), n.nodeCode, xPos+40, yPos)
        case GraphTypes.OUTPUT =>
          glspCreator.nodeCreator(n.graphIndex.toString, n.nodeName,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n.nodeCode, xPos, yPos+50)
        case GraphTypes.CALL =>
          n.nodeName match {
            case x if x.matches("""PERFORM.*""") => glspCreator.nodeCreator(n.graphIndex.toString, n.nodeCode, com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n.nodeName, xPos+80, yPos-50)
            case x if x.matches("""USING MAP.*""") => glspCreator.nodeCreator(n.graphIndex.toString, n.nodeCode, com.oc2.diagrams.flowgraph.utils.ModelTypes.SCREEN_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.SCREEN_NODE), n.nodeName, xPos+80, yPos-50)
            case _  => glspCreator.nodeCreator(n.graphIndex.toString, n.nodeCode, com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE), n.nodeName, xPos+80, yPos-50)
          }
        case GraphTypes.REPEAT =>
          //val nodeType = "IF"
          glspCreator.decisionCreator(n.graphIndex.toString, n.nodeName, n.nodeType, n.nodeCode, xPos, yPos )
        case _ =>
          val name = n.nodeCode
          glspCreator.nodeCreator(n.graphIndex.toString,name,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n.nodeCode, xPos-50, yPos)

      }
      res
    }

    var v: Seq[GEdge] = graphVertexs.map{ v=>
      val edgeOptions: java.util.Map[String, java.lang.Object] = new java.util.HashMap[String, java.lang.Object]()
      edgeOptions.put("edgePadding",10.asInstanceOf[Object])
      val edge = GraphFactory.eINSTANCE.createGEdge
      edge.setId(s"edge${v.since}${v.until}")
      edge.setType("edge")
      edge.setSourceId(v.since)
      edge.setTargetId(v.until)
      edge.getArgs.putAll(edgeOptions)
      edge
    }

    //    val intro: ActivityNode = kdmUtils.forkCreator(20,20,0.toString)
    //    glspNodes = glspNodes :+ intro
    val edge = GraphFactory.eINSTANCE.createGEdge
    edge.setId(s"edge01")
    edge.setType("edge")
    edge.setSourceId(0.toString)
    edge.setTargetId(1.toString)

    if (args(GraphProperties.GRAPH_LABEL).nonEmpty){
      val cc = glspCreator.nodeCreator("-1", args(GraphProperties.GRAPH_LABEL),com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), args(GraphProperties.GRAPH_LABEL), 150, 0)
      glspNodes = glspNodes :+ cc
    }
    v = v :+ edge
    val dat = glspNodes ++ v
    val data: util.ArrayList[GModelElement] = toArrayList(dat.toList)
    graph.getChildren.addAll(data)

    val jsonGraph: JsonObject = glspCreator.writeToJson(graph).getAsJsonObject

    val jsonGraphPrettyPrint: String = glspCreator.jsonPrettyPrint(jsonGraph)

    jsonGraphPrettyPrint

  }

  def toArrayList[T](input: List[T]): java.util.ArrayList[T] = new java.util.ArrayList[T](input.asJava)
}
