package com.oc2.kdm.analysis.graphs

abstract class Graph {

  type Vertex
  type Node <: NodeIntf

  abstract class NodeIntf {
    var nodeName: String
    var nodeType: String
    var nodeCode: String
    def connectWith(node: Node, vertexType: String): Vertex
  }

  def nodes: List[Node]
  def vertexs: List[Vertex]
  def addNode(): Node
}
