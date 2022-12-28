package patterns

import com.oc2.kdm.action.ActionPackage
import com.oc2.kdm.build.BuildPackage
import com.oc2.kdm.code.{CodeFactory, CodePackage, MethodKind}
import com.oc2.kdm.conceptual.ConceptualPackage
import com.oc2.kdm.core.CorePackage
import com.oc2.kdm.data.DataPackage
import com.oc2.kdm.kdm.{KdmFactory, KdmPackage}
import com.oc2.kdm.platform.PlatformPackage
import com.oc2.kdm.source.SourcePackage
import com.oc2.kdm.structure.StructurePackage
import com.oc2.kdm.ui.{UiFactory, UiPackage}
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import java.io.File
import scala.collection.JavaConverters.asScalaBufferConverter


object TestKdmModel {

  private val resourceSet = new ResourceSetImpl
  resourceSet.getResourceFactoryRegistry.getExtensionToFactoryMap.put("kdm", new XMIResourceFactoryImpl)
  resourceSet.getResourceFactoryRegistry.getExtensionToFactoryMap.put("lang", new XMIResourceFactoryImpl)
  registerPackages()

  private def registerPackages(): Unit = {
    val registry = resourceSet.getPackageRegistry
    registry.put("http://www.opencanarias.com/oc2/kdm/core", CorePackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/kdm", KdmPackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/source", SourcePackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/code", CodePackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/action", ActionPackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/data", DataPackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/structure", StructurePackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/platform", PlatformPackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/ui", UiPackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/build", BuildPackage.eINSTANCE)
    registry.put("http://www.opencanarias.com/oc2/kdm/conceptual", ConceptualPackage.eINSTANCE)
  }

  def load(file:String): EObject = {
    val resource = resourceSet.createResource(URI.createFileURI(new File(file).getAbsolutePath))
    resource.load(null)
    resource.getContents.asScala.head
  }

  val model: EObject = {
    val segment = KdmFactory.eINSTANCE.createSegment
    segment.setName("Test")
    val model1 = CodeFactory.eINSTANCE.createCodeModel
    model1.setName("Model1")

    val st1 = CodeFactory.eINSTANCE.createStorableUnit
    st1.setName("var1")
    model1.getCodeElement.add(st1)

    val st2 = CodeFactory.eINSTANCE.createStorableUnit
    st2.setName("var2")
    val st2FormatAttribute = KdmFactory.eINSTANCE.createAttribute
    st2FormatAttribute.setTag("format")
    st2FormatAttribute.setValue("%d")
    st2.getAttribute.add(st2FormatAttribute)
    model1.getCodeElement.add(st2)

    val m1 = CodeFactory.eINSTANCE.createMethodUnit
    m1.setName("method1")
    m1.setKind(MethodKind.CONSTRUCTOR)
    model1.getCodeElement.add(m1)
    val model2 = UiFactory.eINSTANCE.createUIModel
    model2.setName("UIModel")
    val screen = UiFactory.eINSTANCE.createScreen
    screen.setName("Main")
    model2.getUIElement.add(screen)
    val field = UiFactory.eINSTANCE.createUIField
    field.setName("Field1")

    val fieldDate = UiFactory.eINSTANCE.createUIField
    fieldDate.setName("FieldDate")
    val typeAttribute = KdmFactory.eINSTANCE.createAttribute
    typeAttribute.setTag("type")
    typeAttribute.setValue("date")

    val formatAttribute = KdmFactory.eINSTANCE.createAttribute
    formatAttribute.setTag("format")
    formatAttribute.setValue("dd-MM-yyyy")
    fieldDate.getAttribute.add(typeAttribute)
    fieldDate.getAttribute.add(formatAttribute)

    model2.getUIElement.add(field)
    model2.getUIElement.add(fieldDate)
    segment.getModel.add(model1)
    segment.getModel.add(model2)
    segment
  }

  def save(file:String, contents: List[EObject]): Unit = {
    val resource = resourceSet.createResource(URI.createFileURI(new File(file).getAbsolutePath))
    for (content <- contents) resource.getContents.add(content)
    resource.save(null)
  }

  def save(file:String, contents: EObject): Unit = save(file, List(contents))

}
