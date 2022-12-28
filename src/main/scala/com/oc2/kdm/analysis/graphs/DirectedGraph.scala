package com.oc2.kdm.analysis.graphs

abstract class DirectedGraph extends Graph {
  type Vertex <: VertexImpl
  class VertexImpl(source: Node, dest: Node, vertex_Type: String) {
    def vertexType: String =  vertex_Type
    def since: Node = source
    def until: Node = dest
  }
  class NodeImpl extends NodeIntf {
    self: Node =>
    def connectWith(node: Node, vertexType: String): Vertex = {

      val vertex = newVertex(this, node, vertexType) // ahora legal
      vertexs = vertex :: vertexs
      vertex
    }

    override var nodeName: String = self.nodeName
    override var nodeType: String = self.nodeType
    override var nodeCode: String = self.nodeCode
  }
  protected def newNode: Node
  protected def newVertex(since: Node, until: Node, typ: String): Vertex
  var nodes: List[Node] = Nil
  var vertexs: List[Vertex] = Nil
  def addNode(): Node = {
    val nodo = newNode
    nodes = nodo :: nodes
    nodo
  }
}
