package com.x.config.typehandler;

import org.apache.ibatis.type.MappedTypes;
import org.postgis.Polygon;

@MappedTypes(Polygon.class)
public class PolygonTypeHandler extends AbstractGeometryTypeHandler<Polygon> {
}
