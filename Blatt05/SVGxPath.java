package Blatt05;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

/**
 * @author Samuel Gröner
 * Blatt 05
 * Tut 03
 *
 * referencesheet -> {@link Blatt05}
 * */
public class SVGxPath {

    /** 5.
     * reads picture.svg and changes some things and than writes it in a new file
     * */
    public static void main(String[] args) throws Exception {
        //reading document
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("src/Blatt05/picture.svg");
        XPath xPath = XPathFactory.newInstance().newXPath();
        //crating expressions
        XPathExpression xPathRaysExpression = xPath.compile("//g[@id=\"sun\"]/line");
        XPathExpression xPathSunExpression = xPath.compile("//g[@id=\"sun\"]/circle");
        XPathExpression xPathTreeExpression = xPath.compile("//g[@id=\"tree\"]");
        XPathExpression xPathGrassExpression = xPath.compile("//g[@id=\"grass\"]/line");
        //removing rays
        NodeList nodeListR = (NodeList) xPathRaysExpression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodeListR.getLength(); i++) {
            nodeListR.item(i).getParentNode().removeChild(nodeListR.item(i));
        }
        //sun loses ring and decides to become red
        Element elementS = (Element) xPathSunExpression.evaluate(document, XPathConstants.NODE);
        elementS.setAttribute("fill","red");
        elementS.setAttribute("stroke",null);
        //tree goes for a walk
        Element elementT = (Element) xPathTreeExpression.evaluate(document, XPathConstants.NODE);
        elementT.setAttribute("transform","translate(500,200)");
        //grass grows
        NodeList nodeListG = (NodeList) xPathGrassExpression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodeListG.getLength(); i++) {
            Element elementG = (Element) nodeListG.item(i);
            int x = Integer.parseInt(elementG.getAttribute("x2"));
            int y = Integer.parseInt(elementG.getAttribute("y2"));
            elementG.setAttribute("x2", "" + (x + 10));
            elementG.setAttribute("y2", "" + (y*2));
        }
        //writing changes in a new file
        Transformer transformer = TransformerFactory.newDefaultInstance().newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("src/Blatt05/modifiedPicture.svg"));
    }
}
