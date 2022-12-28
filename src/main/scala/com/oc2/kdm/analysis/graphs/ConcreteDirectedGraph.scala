package com.oc2.kdm.analysis.graphs

class ConcreteDirectedGraph extends DirectedGraph {
  var name: String = ""
  type Vertex = VertexImpl
  type Node = NodeImpl
  protected def newNode: Node = new NodeImpl
  protected def newVertex(d: Node, until: Node, typ: String): Vertex =
    new VertexImpl(d, until, typ)
}
