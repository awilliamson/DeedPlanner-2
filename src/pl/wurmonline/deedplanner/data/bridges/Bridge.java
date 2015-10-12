package pl.wurmonline.deedplanner.data.bridges;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pl.wurmonline.deedplanner.data.Map;
import pl.wurmonline.deedplanner.data.Tile;
import pl.wurmonline.deedplanner.util.XMLSerializable;

public class Bridge implements XMLSerializable {
    
    public static Bridge createBridge(Map map, Tile firstTile, Tile secondTile, int firstFloor, int secondFloor, BridgeData data, BridgeType type, BridgePartType[] segments, int additionalData) {
        if (!data.isCompatibleType(type)) {
            return null;
        }
        
        int startX = Math.min(firstTile.getX(), secondTile.getX());
        int endX = Math.max(firstTile.getX(), secondTile.getX());
        int startY = Math.min(firstTile.getY(), secondTile.getY());
        int endY = Math.max(firstTile.getY(), secondTile.getY());
        
        int maxWidth = data.getMaxWidth() - 1;
        if (maxWidth < endX - startX && maxWidth < endY - startY) {
            return null;
        }
        
        Bridge bridge = new Bridge(map, data, type, firstTile, secondTile, firstFloor, secondFloor, segments, additionalData);
        data.constructBridge(map, bridge, startX, startY, endX, endY, firstFloor, secondFloor, type, segments, additionalData);
        map.addBridge(bridge);
        
        return bridge;
    }
    
    private final Map map;
    private final BridgeData data;
    private final BridgeType type;
    private final Tile firstTile;
    private final Tile secondTile;
    private final int firstFloor;
    private final int secondFloor;
    private final BridgePartType[] segments;
    private final int additionalData;
    
    public Bridge(Map map, BridgeData data, BridgeType type, Tile firstTile, Tile secondTile, int firstFloor, int secondFloor, BridgePartType[] segments, int additionalData) {
        this.map = map;
        this.data = data;
        this.type = type;
        this.firstTile = firstTile;
        this.secondTile = secondTile;
        this.firstFloor = firstFloor;
        this.secondFloor = secondFloor;
        this.segments = segments;
        this.additionalData = additionalData;
    }
    
    public Bridge(Map map, Element element) {
        this.map = map;
        this.data = BridgeData.getData(element.getAttribute("data"));
        this.type = BridgeType.getType(element.getAttribute("type"));
        int firstX = Integer.parseInt(element.getAttribute("firstX"));
        int firstY = Integer.parseInt(element.getAttribute("firstY"));
        this.firstTile = map.getTile(firstX, firstY);
        this.firstFloor = Integer.parseInt(element.getAttribute("firstFloor"));
        int secondX = Integer.parseInt(element.getAttribute("secondX"));
        int secondY = Integer.parseInt(element.getAttribute("secondY"));
        this.secondTile = map.getTile(secondX, secondY);
        this.secondFloor = Integer.parseInt(element.getAttribute("secondFloor"));
        this.additionalData = Integer.parseInt(element.getAttribute("sag"));
        
        this.segments = BridgePartType.decodeSegments(element.getTextContent());
    }
    
    public void destroy() {
        int startX = Math.min(firstTile.getX(), secondTile.getX());
        int endX = Math.max(firstTile.getX(), secondTile.getX());
        int startY = Math.min(firstTile.getY(), secondTile.getY());
        int endY = Math.max(firstTile.getY(), secondTile.getY());
        
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                map.getTile(x, y).setBridgePart(null);
            }
        }
    }
    
    public BridgeData getData() {
        return data;
    }
    
    public BridgeType getType() {
        return type;
    }

    public void serialize(Document doc, Element root) {
        Element bridgeElement = doc.createElement("bridge");
        bridgeElement.setAttribute("firstX", Integer.toString(firstTile.getX()));
        bridgeElement.setAttribute("firstY", Integer.toString(firstTile.getY()));
        bridgeElement.setAttribute("firstFloor", Integer.toString(firstFloor));
        bridgeElement.setAttribute("secondX", Integer.toString(secondTile.getX()));
        bridgeElement.setAttribute("secondY", Integer.toString(secondTile.getY()));
        bridgeElement.setAttribute("secondFloor", Integer.toString(secondFloor));
        bridgeElement.setAttribute("data", data.toString());
        bridgeElement.setAttribute("type", type.toString());
        bridgeElement.setAttribute("sag", Integer.toString(additionalData));
        
        bridgeElement.setTextContent(BridgePartType.encodeSegments(segments));
        
        root.appendChild(bridgeElement);
    }
    
}
