package com.x.utils.typehandler;

import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBWriter;

import java.io.IOException;

public class Json2GeomTypeHandler {
    public Geometry json2Geom(String s) throws IOException {
        GeometryJSON geometryJson = new GeometryJSON(7);
        Geometry read = geometryJson.read(s);
        return read;
    }
}
