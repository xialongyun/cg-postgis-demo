package com.x.utils.typehandler.geometryTypeHandler;

import com.x.utils.typehandler.geometryTypeHandler.AbstractGeometryTypeHandler;
import org.apache.ibatis.type.MappedTypes;
import org.postgis.MultiPolygon;

@MappedTypes(MultiPolygon.class)
public class MultiPolygonTypeHandler extends AbstractGeometryTypeHandler<MultiPolygon> {
}
