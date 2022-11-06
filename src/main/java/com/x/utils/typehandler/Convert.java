package com.x.utils.typehandler;

import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

import java.io.IOException;
import java.io.StringWriter;

public class Convert {

    public static void wkb2WKT() {

    }

    public static void WKT2wkb() {

    }

    public static void wkb2Json() {

    }

    public static void json2wkb() {

    }

    public static String wkt2Json(String wkt) throws IOException {
        String json = null;
        try {
            WKTReader reader = new WKTReader();
            Geometry geometry = reader.read(wkt);
            StringWriter writer = new StringWriter();
            GeometryJSON g = new GeometryJSON();
            g.write(geometry, writer);
            json = writer.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return json;
    }

//    public static void Json2wkt(String geoJson) {
//        //Geometry geometry =
//    }
//
//
//    public static Geometry wkt2Geom(String geoJson) throws IOException {
//        GeometryJSON geometryJson = new GeometryJSON();
//        return geometryJson.read(geoJson);
//    }
//
//    public static String geom2wkt(Geometry geom) throws IOException {
//        WKTWriter wktWriter = new WKTWriter();
//        String write = wktWriter.write(geom);
//        return write;
//    }

    public static void main(String[] args) throws ParseException, IOException {
        String s = "{\"type\":\"Polygon\",\"coordinates\":[[[120.903339,31.071658],[120.892817,31.087234],[120.871772,31.087234],[120.86125,31.071658],[120.871772,31.056081],[120.892817,31.056081],[120.903339,31.071658]]]}";
//        Geometry geometry = Convert.wkt2Geom(s);
//        System.out.println(geometry);
//
//        String wkt = Convert.geom2wkt(geometry);
//        System.out.println(wkt);

        String json = Convert.wkt2Json(s);
        System.out.println(json);
    }
}
