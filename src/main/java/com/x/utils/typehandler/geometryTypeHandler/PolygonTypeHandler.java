package com.x.utils.typehandler.geometryTypeHandler;

import com.x.utils.typehandler.geometryTypeHandler.AbstractGeometryTypeHandler;
import org.apache.ibatis.type.MappedTypes;
import org.postgis.Polygon;

@MappedTypes(Polygon.class)
public class PolygonTypeHandler extends AbstractGeometryTypeHandler<Polygon> {
}
