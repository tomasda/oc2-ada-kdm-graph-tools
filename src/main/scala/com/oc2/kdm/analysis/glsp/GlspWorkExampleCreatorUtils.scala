package com.oc2.kdm.analysis.glsp

import com.google.gson.{GsonBuilder, JsonElement}
import org.eclipse.glsp.example.workflow.utils.{ModelTypes, WorkflowBuilder}
import org.eclipse.glsp.example.workflow.wfgraph.impl.IconImpl
import org.eclipse.glsp.example.workflow.wfgraph.{ActivityNode, Category, TaskNode}
import org.eclipse.glsp.graph.builder.impl.GArguments
import org.eclipse.glsp.graph.gson.GraphGsonConfigurator
import org.eclipse.glsp.graph.impl.GLabelImpl
import org.eclipse.glsp.graph.util.GConstants
import org.eclipse.glsp.graph.{GGraph, GraphFactory}

import java.io.{FileWriter, IOException}


class GlspWorkExampleCreatorUtils() {
  private val gsonConfigurator = new GraphGsonConfigurator().withDefaultTypes
  private val V_GRAB = "vGrab"
  private val H_GRAB = "hGrab"
  private val H_ALIGN = "hAlign"

  def categoryCreator(name: String, x: Int, y: Int, id: String): Category = {
    val arguments: java.util.Map[String, java.lang.Object] = new java.util.HashMap[String, java.lang.Object]()
    arguments.put("radiusBottomLeft", 5.0.asInstanceOf[Object])
    arguments.put("radiusTopLeft", 5.0.asInstanceOf[Object])
    arguments.put("radiusTopRight", 5.0.asInstanceOf[Object])
    arguments.put("radiusBottomRight", 5.0.asInstanceOf[Object])
    val layoutOptions: java.util.Map[String, java.lang.Object] = new java.util.HashMap[String, java.lang.Object]()
    layoutOptions.put("prefWidth",67.82421875.asInstanceOf[Object])
    layoutOptions.put("paddingRight", 10.0.asInstanceOf[Object])
    layoutOptions.put("prefHeight", 30.0.asInstanceOf[Object])

    val wfb = new WorkflowBuilder.CategoryNodeBuilder(name)
      .id(id)
      .position(x,y)
      .size(88,37)
      .layout(GConstants.Layout.VBOX)
      .layoutOptions(layoutOptions)
      .addArguments(arguments)

    val cat = wfb.build()
    cat.getChildren
    cat.getLayoutOptions.put(H_ALIGN, "center")
    cat.getLayoutOptions.put(H_GRAB, true.asInstanceOf[Object])
    cat.getLayoutOptions.put(V_GRAB, true.asInstanceOf[Object])
    cat
  }

  def taskNodeCreator(name: String, taskType: String, x: Int, y: Int, id:String): TaskNode = {

    val wfb =  new WorkflowBuilder.TaskNodeBuilder("task:manual", name, taskType, 0).position(x,y)
      .addArguments(GArguments.cornerRadius(5))
      .addCssClass("task")
      .id(id)
      .layout(GConstants.Layout.VBOX)

    val task = wfb.build
    task.setTaskType(taskType)
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

  def decisionCreator(x: Int, y: Int, id:String): ActivityNode ={
    val typ_e: String = "activityNode:decision"
    val nodeType = ModelTypes.toNodeType("activityNode:decision")
    val d1: WorkflowBuilder.ActivityNodeBuilder = new WorkflowBuilder.ActivityNodeBuilder(typ_e, nodeType)
    d1.id(id)
      .position(x, y)
      .size(32, 32)
      .`type`("activityNode:decision")
      //.layout(GConstants.Layout.FREEFORM)
    d1.build()
  }

  def forkCreator(x: Int, y: Int, id:String): ActivityNode ={
    val typ_e: String = ModelTypes.toNodeType(ModelTypes.FORK_NODE)
    val nodeType = ModelTypes.toNodeType(ModelTypes.FORK_NODE)
    val d1: WorkflowBuilder.ActivityNodeBuilder = new WorkflowBuilder.ActivityNodeBuilder(typ_e, nodeType)
    d1.id(id)
      .position(x, y)
      .size(10, 50)
      .`type`(ModelTypes.FORK_NODE)
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

  def saveToFile(jsonGraph: String,RESOURCE_PATH: String,fileName: String): Unit = { //Save file
    var file: FileWriter = null
    try { // Constructs a FileWriter given a file name, using the platform's default charset
      file = new FileWriter(RESOURCE_PATH + fileName)
      file.write(jsonGraph)
      System.out.println(s"Successfully Copied JSON Object to File...$fileName")
      //System.out.println("\nJSON Object: " + jsonGraph)
    } catch {
      case e: IOException =>
        e.printStackTrace()
    } finally try {
      file.flush()
      file.close()
    } catch {
      case e: IOException =>
        // TODO Auto-generated catch block
        e.printStackTrace()
    }
  }

}
