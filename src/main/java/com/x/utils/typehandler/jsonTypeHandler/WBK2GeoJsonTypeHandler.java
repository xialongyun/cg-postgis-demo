package com.x.utils.typehandler.jsonTypeHandler;

import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.jts.WKBReader;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBWriter;

import java.io.IOException;

public class WBK2GeoJsonTypeHandler {
    public static void WBK2GeoJson() throws ParseException, IOException {
        WKBReader reader = new WKBReader( );
        Geometry geometry = reader.read(WKBReader.hexToBytes("0101000020E61000002C39382229FD5D4085716007088C3E40"));
        // 设置保留6位小数，否则GeometryJSON默认保留4位小数
        GeometryJSON geometryJson = new GeometryJSON(7);
        String s = geometryJson.toString(geometry);
        System.out.println(s);

        Geometry read = geometryJson.read("{\"type\":\"Point\",\"coordinates\":[119.9556356,30.5469975]}");
        System.out.println(read.toString());
        WKBWriter wkbWriter = new WKBWriter();
        byte[] write = wkbWriter.write(geometry);
        String s1 = WKBWriter.toHex(write);
        System.out.println(s1);

    }
}
