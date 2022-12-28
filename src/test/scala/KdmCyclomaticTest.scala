
import com.google.gson.JsonObject
import com.liangdp.graphviz4s.Digraph
import com.oc2.kdm.analysis.cyclomaticcomplex.{KDMCyclomaticComplex, KDMCyclomaticComplexUnplugged}
import com.oc2.kdm.analysis.glsp.{GlspCreatorUtils, GlspWorkExampleCreatorUtils}
import com.oc2.kdm.analysis.graphs.{ConcreteDirectedGraph, GraphProperties, GraphTypes}
import com.oc2.kdm.analysis.programflow.{KDMProgramFlow, KDMProgramFlowUnplugged}
import com.oc2.kdm.kdm.Segment
import org.eclipse.glsp.example.workflow.utils.ModelTypes
import org.eclipse.glsp.example.workflow.wfgraph.ActivityNode
import org.eclipse.glsp.graph.{GEdge, GModelElement, GraphFactory}
import patterns.TestKdmModel

import java.io.{File, FileWriter, IOException}
import java.util
import scala.collection.JavaConverters._
import scala.collection.convert.ImplicitConversions.`list asScalaBuffer`
import scala.collection.mutable
import scala.util.matching.Regex

class KdmCyclomaticTest extends TestsUtils {

  /** Parámetros globales */
  val mapParamsFileName: String = "MAP_PARAMS.kdm"
  val src = "src/test/resources/samples/kdm/exampleSources/"
             //"src/test/resources/samples/kdm/nat2kdm/"
            //"src/test/resources/samples/kdm/sources/"
  val RESOURCE_PATH: String = //"/home/user/IntellijWorkspace/natural2glsp/src/test/scala/resources/"
            "/home/user/IntellijWorkspace/oc2-ada-kdm-graph-tools/src/test/resources/samples/kdm/cc/"
  val ccOutputGraph = "./src/test/resources/samples/kdm/cc/"
            //"/media/sf_D_DRIVE/OPEN/babel/Natural-Libraries/CODE_EXAMPLES"

  val ccGenGraph = true
  val ccGenGraphShowAtEnd = false
  val ccGenGLSP = false
  val ccGenGLSPgf = false
  val ccAllFiles = true
  val file =
                "FOR1.NSP"
//                "IF2.NSP"
//  "IF3.NSP"
//  "IF4.NSP"
//    "IF5.NSP"
//    "IF6.NSP"
//      "IF7.NSP"
//                "PHNTALIA.NSP"
//                "PHNNSIPA.NSN"
//                "PHNNSIRE.NSN"
//                "RDREADWN_2_1.NSN"
//                "RDREADWN_2_2.NSN"
//                "RDREADWN_2_3.NSN"
//                "RDREADWN_2_4.NSN"
//                "RDREADWN_2_5.NSN"


  "KdmCyclomaticTest process" should "work correctly" in {
    println(s"Calculate Cyclomatic Complexity")
    println(s"Reading Program kdm's")
    val files: util.List[File] = allFiles(src)

    val kdmNaturalModels: Seq[Segment] = files.collect {
      case f if !ccAllFiles && Seq(s"$file.kdm").contains(f.getName) =>
        getSequence(f)
      case f if ccAllFiles =>
        getSequence(f)
    }

    println(s"Making results")
    kdmNaturalModels.foreach { kdm: Segment =>
      calculateCyclomaticComplexity(kdm)
    }

  }

  "KdmCyclomaticUnpluggedTest process" should "work correctly" in {
    println(s"Calculate Unplugged Cyclomatic Complexity")
    println(s"Reading Program kdm's")
    val files = allFiles(src)

    val kdmNaturalModels: Seq[Segment] = files.collect {
      case f if !ccAllFiles && Seq(s"$file.kdm").contains(f.getName) =>
        getSequence(f)
      case f if ccAllFiles =>
        getSequence(f)
    }
    println(s"Making results")
    kdmNaturalModels.foreach { kdm: Segment =>
      println(s"${kdm.getName.substring(0,kdm.getName.indexOf("."))}")
      /** Obtención de los Mapas */
      /* Para simular la carga de Mapas en base al programa que se esté leyendo aplicamos esta configuración
       * Una vez el kdmNaturalModel contenga esta información se obtendrá de ahí los mapas a cargar */
      /* Para PHNTALIA.NSP los mapas que se cargan son FCI1GBC0.NSM , PHNMALIA.NSM y PHNMALI1.NSM*/
//      var mapfilesnames: Array[String] = Array()
//      if (kdm.getName.equals("PHNTALIA")) {
//        mapfilesnames = Array("PHNMALIA_001", "PHNMALI1_001") // "FCI1GBC0" , no está entre la última versión de los ficheros
//      } else if (kdm.getName.equals("PHNNSIRE")) {
//        mapfilesnames = Array("PHNMSIPA_001", "PHNMSIP1_001")
//      } else if (kdm.getName.equals("PHNNSIPA")) {
//        mapfilesnames = Array("PHNMSIPA_001", "PHNMSIP1_001")
//      }
//      val kdmMapModel: Seq[Segment] = mapfilesnames.map { f =>
//        val kdm: Segment = TestKdmModel.load(file = s"$src$f.kdm").asInstanceOf[Segment]
//        kdm.setName(f.split("\\.").head)
//        kdm
//      }

      calculateUnpluggedCyclomaticComplexity(kdm)
    }
  }

  "KdmProgramFlowTest process" should "work correctly" in {
    println(s"Create Program Flow Graph")
    println(s"Reading Program kdm's")
    val files = allFiles(src)

    val g_printStatments: Regex = {
//      """.*""".r
    """CALLNAT|PERFORM|USING MAP|INPUT""".r
    }
    val g_printCodeBoxes = false
    // Imprime los métodos contenidos en el fichero del programa
    val g_printSubMethods = false

    val kdmNaturalModels: Seq[Segment] = files.collect {
      case f if !ccAllFiles && Seq(s"$file.kdm").contains(f.getName) =>
        getSequence(f)
      case f if ccAllFiles =>
        getSequence(f)
    }
    println(s"Making results")
    kdmNaturalModels.foreach { kdm: Segment =>
      /** Obtención de los Mapas */
      /* Para simular la carga de Mapas en base al programa que se esté leyendo aplicamos esta configuración
       * Una vez el kdmNaturalModel contenga esta información se obtendrá de ahí los mapas a cargar */
      /* Para PHNTALIA.NSP los mapas que se cargan son FCI1GBC0.NSM , PHNMALIA.NSM y PHNMALI1.NSM*/
      //      var mapfilesnames: Array[String] = Array()
      //      if (kdm.getName.equals("PHNTALIA")) {
      //        mapfilesnames = Array("PHNMALIA_001", "PHNMALI1_001") // "FCI1GBC0" , no está entre la última versión de los ficheros
      //      } else if (kdm.getName.equals("PHNNSIRE")) {
      //        mapfilesnames = Array("PHNMSIPA_001", "PHNMSIP1_001")
      //      } else if (kdm.getName.equals("PHNNSIPA")) {
      //        mapfilesnames = Array("PHNMSIPA_001", "PHNMSIP1_001")
      //      }
      //      val kdmMapModel: Seq[Segment] = mapfilesnames.map { f =>
      //        val kdm: Segment = TestKdmModel.load(file = s"$src$f.kdm").asInstanceOf[Segment]
      //        kdm.setName(f.split("\\.").head)
      //        kdm
      //      }

      println(s"Running Program Flow Test for ${kdm.getName}")
      val programFlowProcess = new KDMProgramFlow
      val res: ConcreteDirectedGraph = programFlowProcess.execute(kdm,g_printSubMethods,g_printStatments,g_printCodeBoxes)
      if (ccGenGraph)
      //Generación de Grafos con Graphviz
        genGraph(res, null)
      if (ccGenGLSP)
      //Generación del modelo en formato Json para GLSP
        render2glsp(res)
      if (ccGenGLSPgf)
      //Generación del modelo en formato Json para GLSP
      {
        val glspcu = new GlspCreatorUtils
        val args = Map(GraphProperties.GRAPH_ID -> "glsp-graph3", GraphProperties.GRAPH_REVISION -> "1", GraphProperties.GRAPH_TYPE -> "graph", GraphProperties.GRAPH_LABEL -> "")
        val glspJson = glspcu.render2glsp(res, args)
        saveToFile(glspJson, RESOURCE_PATH, res.name + ".fg")
      }
    }
  }

  "KdmProgramFlowUnpluggedTest process" should "work correctly" in {
    println(s"Create Program Flow Graph")
    println(s"Reading Program kdm's")
    val files = allFiles(src)

    val g_printStatments: Regex = {
      //      """.*""".r
      """CALLNAT|PERFORM|USING MAP|INPUT""".r
    }

    val kdmNaturalModels: Seq[Segment] = files.collect {
      case f if !ccAllFiles && Seq(s"$file.kdm").contains(f.getName) =>
        getSequence(f)
      case f if ccAllFiles =>
        getSequence(f)
    }
    println(s"Making results")
    kdmNaturalModels.foreach { kdm: Segment =>
      println(s"Running Program Flow Test for ${kdm.getName.substring(0,kdm.getName.indexOf("."))}")
      calculateUnpluggedFlow(kdm,g_printStatments)
    }
  }

  def getSequence(f: File): Segment = {
    val kdm: Segment = TestKdmModel.load(file = f.getAbsolutePath).asInstanceOf[Segment]
    kdm.setName(f.getName.split("_").head)
    kdm
  }

  def calculateUnpluggedCyclomaticComplexity(x: Segment): Unit = {

    val cyclomaticProcess = new KDMCyclomaticComplexUnplugged
    val res: Seq[ConcreteDirectedGraph] = cyclomaticProcess.execute(x)
    res.foreach { res =>
      println(s"Cálculo de la complejidad ciclomática de ${res.name}, ${res.nodes.size} Nodos, ${res.vertexs.size} Vertices/Aristas.")
      /**
       * Complejidad Ciclomática
       * CC = A - N + 2  (Aristas - Nodos + 2)
       *
       * Riesgo
       * Una vez calculada la complejidad ciclomática de un fragmento de código, se puede determinar el riesgo que supone utilizando los rangos definidos en la siguiente tabla:
       *
       * Complejidad Ciclomática	Evaluación del Riesgo
       * 1-10	Programa Simple, sin mucho riesgo
       * 11-20	Más complejo, riesgo moderado
       * 21-50	Complejo, Programa de alto riesgo
       * 50	Programa no testeable, Muy alto riesgo
       */

      val cc = res.vertexs.size - res.nodes.size + 2
      val ccVal = s"CC = $cc ${
        cc match {
          case x if 0 until 10 contains x => "Sin mucho riesgo"
          case x if 11 until 20 contains x => "Riesgo moderado"
          case x if 21 until 50 contains x => "Alto riesgo"
          case _ => "Muy alto riesgo"
        }
      }"
      println(ccVal)

      if (ccGenGraph)
      //Generación de Grafos con Graphviz
        genGraph(res, ccVal)
      if (ccGenGLSP)
      //Generación del modelo en formato Json para GLSP
        render2glsp(res)
      if (ccGenGLSPgf)
      //Generación del modelo en formato Json para GLSP
      {
        val glspcu = new GlspCreatorUtils
        val args = Map(GraphProperties.GRAPH_ID -> "glsp-graph3", GraphProperties.GRAPH_REVISION -> "1", GraphProperties.GRAPH_TYPE -> "graph", GraphProperties.GRAPH_LABEL -> ccVal)
        val glspJson = glspcu.render2glsp(res, args)
        saveToFile(glspJson, RESOURCE_PATH, res.name + ".fg")
      }
    }
  }

  def calculateUnpluggedFlow(x: Segment, printStatments: Regex): Unit = {

    val process = new KDMProgramFlowUnplugged
    val res: Seq[ConcreteDirectedGraph] = process.execute(x,printStatments)
    res.foreach { res =>
      if (ccGenGraph)
      //Generación de Grafos con Graphviz
        genGraph(res, null)
      if (ccGenGLSP)
      //Generación del modelo en formato Json para GLSP
        render2glsp(res)
      if (ccGenGLSPgf)
      //Generación del modelo en formato Json para GLSP
      {
        val glspcu = new GlspCreatorUtils
        val args = Map(GraphProperties.GRAPH_ID -> "glsp-graph3", GraphProperties.GRAPH_REVISION -> "1", GraphProperties.GRAPH_TYPE -> "graph", GraphProperties.GRAPH_LABEL -> "")
        val glspJson = glspcu.render2glsp(res, args)
        saveToFile(glspJson, RESOURCE_PATH, res.name + ".fg")
      }
    }
  }

  def calculateCyclomaticComplexity(x: Segment): Unit = {

    val cyclomaticProcess = new KDMCyclomaticComplex
    val res: ConcreteDirectedGraph = cyclomaticProcess.execute(x)

    println(s"Cálculo de la complejidad ciclomática de ${res.name}, ${res.nodes.size} Nodos, ${res.vertexs.size} Vertices/Aristas.")
      /**
       * Complejidad Ciclomática
       * CC = A - N + 2  (Aristas - Nodos + 2)
       *
       * Riesgo
       * Una vez calculada la complejidad ciclomática de un fragmento de código, se puede determinar el riesgo que supone utilizando los rangos definidos en la siguiente tabla:
       *
       * Complejidad Ciclomática	Evaluación del Riesgo
       * 1-10	Programa Simple, sin mucho riesgo
       * 11-20	Más complejo, riesgo moderado
       * 21-50	Complejo, Programa de alto riesgo
       * 50	Programa no testeable, Muy alto riesgo
       */
    val cc = res.vertexs.size - res.nodes.size + 2
    val ccVal = s"CC = $cc ${
      cc match {
        case x if 0 until 10 contains x => "Sin mucho riesgo"
        case x if 11 until 20 contains x => "Riesgo moderado"
        case x if 21 until 50 contains x => "Alto riesgo"
        case _ => "Muy alto riesgo"
      }
    }"
    println(ccVal)
    if (ccGenGraph)
      //Generación de Grafos con Graphviz
      genGraph(res, ccVal)
    if (ccGenGLSP)
      //Generación del modelo en formato Json para GLSP
      render2glsp(res)
    if (ccGenGLSPgf) {
    //Generación del modelo en formato Json para GLSP
      val glspcu = new GlspCreatorUtils
      val args = Map(GraphProperties.GRAPH_ID -> "glsp-graph3",GraphProperties.GRAPH_REVISION -> "1",GraphProperties.GRAPH_TYPE -> "graph",GraphProperties.GRAPH_LABEL -> ccVal)
      val glspJson = glspcu.render2glsp(res,args)
      saveToFile(glspJson,RESOURCE_PATH,res.name+".fg")
    }

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

  def genGraph (res: ConcreteDirectedGraph , ccVal: String):Unit={
    var index = 1
    var nodos: Seq[(Int, Int, String, String, String)] =  res.nodes.reverse.map{ x=>
      val res = (x.hashCode(), index, x.nodeName, x.nodeType, x.nodeCode)
      index +=1
      res
    }

    val vertices: Array[(String, String, String)] = res.vertexs.map(x=>
      (nodos.find(_._1==x.since.hashCode()).get._2.toString , nodos.find(_._1==x.until.hashCode()).get._2.toString, x.vertexType)).toArray

    val dot = new Digraph(comment = "")
    dot.graphAttr.put("layout","dot") // Tipos que valen para grafos dot
                                      // regular fdp sfdp
                                      // malo neato circo twopi osage
    dot.graphAttr.put("beautify","true")

    // Impresión de la caja con el resultado de la complejidad ciclomática.
    if (ccVal!=null) {
      val a: mutable.Map[String, String] = dot.nodeAttr
      a += ("fontcolor" -> "black") += ("color" -> "black") += ("fillcolor" -> "white") += ("shape" -> GraphvizTypes.BOX3D)
      dot.node(name = "Complejidad Ciclomática", label = ccVal, a)
    }

    nodos.foreach{x =>
      var nname:String = ""
      if (x._2.toString!=null)
        nname = x._2.toString
      var nlabel:String = ""
      if (x._3!=null)
        nlabel = x._3
      var nlabelParam:String = ""
      if (x._5!=null)
        nlabelParam = x._5
      val a: mutable.Map[String, String] = dot.nodeAttr
      // Establece el tipo de nodo según su tipo
      a += ("fontcolor"->"black") += ("color"->"black") += ("fillcolor"->"white")

      x._4 match {
        case GraphTypes.CODE => a += ("shape"->GraphvizTypes.FOLDER)
          a += ("style"->"\"\"")
          a += ("color"->"brown")
          nlabel = "code"

        case GraphTypes.INPUT =>a += ("shape"->GraphvizTypes.COMPONENT)
          a += ("style"->"\"\"")

        case GraphTypes.IF =>a += ("shape"->GraphvizTypes.DIAMOND)
          a += ("style"->"\"\"")

        case GraphTypes.FOR =>a += ("shape"->GraphvizTypes.MDIAMOND)
          a += ("style"->"\"\"")
          a += ("color"->"brown")

        case GraphTypes.OUTPUT =>a += ("shape"->GraphvizTypes.POINT)
          a += ("style"->"rounded")
          a += ("fillcolor"->"black")
          a += ("height"->".2")
          a += ("width"->".2")

        case GraphTypes.INITIAL => a+= ("shape"->GraphvizTypes.INVHOUSE)
          a += ("style"->"\"rounded, filled\"")
          a += ("fillcolor"->"black")
          a += ("fontcolor"->"white")

        case GraphTypes.ENDING => a+= ("shape"->GraphvizTypes.HOUSE)
          a += ("style"->"\"rounded, filled\"")
          a += ("fillcolor"->"black")
          a += ("fontcolor"->"white")

        case GraphTypes.CALL => a += ("shape"->GraphvizTypes.COMPONENT)
          //a += ("style"->"")
          a += ("color"->"grey")

        case GraphTypes.REPEAT => a += ("shape"->GraphvizTypes.NOTE)
         nlabel="REPEAT"
          a += ("color"->"grey")

        case _ => a += ("shape"->GraphvizTypes.CIRCLE)
          a += ("style"->"\"\"")
          a += ("color"->"grey")

      }

      dot.node(name=nname, label=nlabel + " "+ nlabelParam,a)

    }
    vertices.foreach{x=>
      val a: mutable.Map[String, String] = dot.edgeAttr
      x._3 match {
        case GraphTypes.EDGE_TRUE => a += ("color"->"black")
        case GraphTypes.EDGE_FALSE => a += ("color"->"red")
        case GraphTypes.IF => a += ("color"->"black")
        case GraphTypes.ELSE => a += ("color"->"red")
        case _ =>
      }

      dot.edge(x._1,x._2,null,a)

    }
    // Renderizado del grafo
    dot.render(format="png", fileName = s"${res.name}.gv", directory = ccOutputGraph, view = ccGenGraphShowAtEnd)
  }

  def render2glsp(res: ConcreteDirectedGraph): Unit = {
    println(s"Running glsp Render")
    val kdmUtils = new GlspWorkExampleCreatorUtils
    val graph = GraphFactory.eINSTANCE.createGGraph

    graph.setType("graph")
    graph.setRevision(1)
    graph.setId("graphId")

    var index = 1
    val nodos: Seq[(Int, Int, String, String, String)] = res.nodes.reverse.map{ x=>
      val res = (x.hashCode(), index, x.nodeName, x.nodeType, x.nodeCode)
      index +=1
      res
    }

    val vertices: Array[(String, String, String)] = res.vertexs.map(x=>
      (nodos.find(_._1==x.since.hashCode()).get._2.toString , nodos.find(_._1==x.until.hashCode()).get._2.toString, x.vertexType)).toArray

    var yPos = 5

    var n: Seq[GModelElement] = nodos.map { n =>
      yPos += 40

      val res: ActivityNode = n._4 match {
        case GraphTypes.FOR =>
          //kdmUtils.categoryCreator(n._3,5, yPos, n._2.toString)
          kdmUtils.taskNodeCreator(n._3,"", 5, yPos, n._2.toString)
        case GraphTypes.ENDING =>
          kdmUtils.forkCreator(5, yPos, n._2.toString)
        case GraphTypes.INITIAL =>
          kdmUtils.forkCreator(5, yPos, n._2.toString)
        case GraphTypes.INPUT =>
          kdmUtils.decisionCreator(5, yPos, n._2.toString)
        case GraphTypes.CODE =>
          val name = n._4
          //val taskType = ModelTypes.toNodeType(ModelTypes.CATEGORY)
          kdmUtils.categoryCreator(name, 5, yPos, n._2.toString)
        case _ =>
          val name = n._5
          val taskType = ModelTypes.toNodeType(ModelTypes.MANUAL_TASK)
          kdmUtils.taskNodeCreator(name, taskType, 5, yPos, n._2.toString)
      }
      res
    }

    var v: Seq[GEdge] = vertices.map{ v=>
      val edgeOptions: java.util.Map[String, java.lang.Object] = new java.util.HashMap[String, java.lang.Object]()
      edgeOptions.put("edgePadding",10.asInstanceOf[Object])
      val edge = GraphFactory.eINSTANCE.createGEdge
      edge.setId(s"edge${v._1}${v._2}")
      edge.setType("edge")
      edge.setSourceId(v._1)
      edge.setTargetId(v._2)
      edge.getArgs.putAll(edgeOptions)
      edge
    }

//    val intro: ActivityNode = kdmUtils.forkCreator(20,20,0.toString)
//    n = n :+ intro
    val edge = GraphFactory.eINSTANCE.createGEdge
    edge.setId(s"edge01")
    edge.setType("edge")
    edge.setSourceId(0.toString)
    edge.setTargetId(1.toString)
    v = v :+ edge
    val dat = n ++ v
    val data: util.ArrayList[GModelElement] = toArrayList(dat.toList)
    graph.getChildren.addAll(data)

    val jsonGraph: JsonObject = kdmUtils.writeToJson(graph).getAsJsonObject

    val jsonGraphPrettyPrint: String = kdmUtils.jsonPrettyPrint(jsonGraph)

    kdmUtils.saveToFile(jsonGraphPrettyPrint,RESOURCE_PATH,res.name+".wf")

  }

//  def renderfg2glsp(res: ConcreteDirectedGraph, ccVal: String): Unit = {
//    println(s"Running fg glsp Render")
//    val glspCreator = new GlspfgCreatorUtils
//    val graph = GraphFactory.eINSTANCE.createGGraph
//
//    graph.setType("graph")
//    graph.setRevision(1)
//    graph.setId("glsp-graph3")
//
//    var index = 1
//    val nodos: Seq[(Int, Int, String, String, String)] = res.nodes.reverse.map{ x=>
//      val res = (x.hashCode(), index, x.nodeName, x.nodeType, x.nodeCode)
//      index +=1
//      res
//    }
//
//    val vertices: Array[(String, String, String)] = res.vertexs.map(x=> (nodos.find(_._1==x.since.hashCode()).get._2.toString , nodos.find(_._1==x.until.hashCode()).get._2.toString, x.vertexType)).toArray
//    var xPos = 5
//    var yPos = 5
//
//    var n: Seq[GModelElement] = nodos.map { n =>
//      yPos += 50
//
//      var res: GModelElement = n._4 match {
//        case GraphTypes.INITIAL =>
//          glspCreator.nodeCreator(n._2.toString, n._3,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n._5, xPos, 0)
//        case GraphTypes.ENDING =>
//          glspCreator.nodeCreator(n._2.toString, n._3,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n._5, xPos-100, yPos+100)
//        case GraphTypes.FOR =>
//          xPos += 50
//          glspCreator.decisionCreator(n._2.toString, n._3, n._4, n._5, xPos, yPos )
//        case GraphTypes.IF =>
//          //val nodeType = "IF"
//          xPos += 50
//          glspCreator.decisionCreator(n._2.toString, n._3, n._4, n._5, xPos, yPos )
//        case GraphTypes.CODE =>
//          val name = n._4
//          glspCreator.nodeCreator(n._2.toString,name,com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE), n._5, xPos+40, yPos)
//        case GraphTypes.OUTPUT =>
//          glspCreator.nodeCreator(n._2.toString, n._3,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n._5, xPos, yPos+50)
//        case GraphTypes.CALL =>
//          n._3 match {
//            case x if x.matches("""PERFORM.*""") => glspCreator.nodeCreator(n._2.toString, n._5, com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n._3, xPos+80, yPos-50)
//            case x if x.matches("""USING MAP.*""") => glspCreator.nodeCreator(n._2.toString, n._5, com.oc2.diagrams.flowgraph.utils.ModelTypes.SCREEN_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.SCREEN_NODE), n._3, xPos+80, yPos-50)
//            case _  => glspCreator.nodeCreator(n._2.toString, n._5, com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.EXTERNAL_CALL_NODE), n._3, xPos+80, yPos-50)
//          }
//        case GraphTypes.REPEAT =>
//          //val nodeType = "IF"
//          glspCreator.decisionCreator(n._2.toString, n._3, n._4, n._5, xPos, yPos )
//        case _ =>
//          val name = n._5
//          glspCreator.nodeCreator(n._2.toString,name,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), n._5, xPos-50, yPos)
//
//      }
//      res
//    }
//
//    var v: Seq[GEdge] = vertices.map{ v=>
//      val edgeOptions: java.util.Map[String, java.lang.Object] = new java.util.HashMap[String, java.lang.Object]()
//      edgeOptions.put("edgePadding",10.asInstanceOf[Object])
//      val edge = GraphFactory.eINSTANCE.createGEdge
//      edge.setId(s"edge${v._1}${v._2}")
//      edge.setType("edge")
//      edge.setSourceId(v._1)
//      edge.setTargetId(v._2)
//      edge.getArgs.putAll(edgeOptions)
//      edge
//    }
//
//    //    val intro: ActivityNode = kdmUtils.forkCreator(20,20,0.toString)
//    //    n = n :+ intro
//    val edge = GraphFactory.eINSTANCE.createGEdge
//    edge.setId(s"edge01")
//    edge.setType("edge")
//    edge.setSourceId(0.toString)
//    edge.setTargetId(1.toString)
//
//    val cc = glspCreator.nodeCreator("-1", ccVal,com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE, com.oc2.diagrams.flowgraph.utils.ModelTypes.toElementType(com.oc2.diagrams.flowgraph.utils.ModelTypes.INTERNAL_CALL_NODE), ccVal, 150, 0)
//
//    v = v :+ edge
//    if (ccVal!=null)
//      n = n :+ cc
//    val dat = n ++ v
//    val data: util.ArrayList[GModelElement] = toArrayList(dat.toList)
//    graph.getChildren.addAll(data)
//
//    val jsonGraph: JsonObject = glspCreator.writeToJson(graph).getAsJsonObject
//
//    val jsonGraphPrettyPrint: String = glspCreator.jsonPrettyPrint(jsonGraph)
//
//    glspCreator.saveToFile(jsonGraphPrettyPrint,RESOURCE_PATH,res.name+".fg")
//
//  }

  def toArrayList[T](input: List[T]): java.util.ArrayList[T] = new java.util.ArrayList[T](input.asJava)

}
