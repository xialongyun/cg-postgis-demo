package com.x.utils.typehandler.jsonTypeHandler;

import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBWriter;

import java.io.IOException;

public class Json2WBKTypeHandler {

    public static String json2WBK(String json) throws IOException {
        //POLYGON((120.903339 31.071658,120.892817 31.087234,120.871772 31.087234,120.86125 31.071658,120.871772 31.056081,120.892817 31.056081,120.903339 31.071658)))
        //POLYGON ((120.903339 31.071658, 120.892817 31.087234, 120.871772 31.087234, 120.86125 31.071658, 120.871772 31.056081, 120.892817 31.056081, 120.903339 31.071658))

        GeometryJSON geometryJson = new GeometryJSON(6);
        Geometry read = geometryJson.read(json);
        System.out.println(read);
        WKBWriter wkbWriter = new WKBWriter();
        byte[] write = wkbWriter.write(read);
        String wbk = WKBWriter.bytesToHex(write);
        return wbk;
    }
}
