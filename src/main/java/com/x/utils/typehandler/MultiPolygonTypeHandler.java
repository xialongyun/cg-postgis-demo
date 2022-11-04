package com.x.utils.typehandler;

import org.apache.ibatis.type.MappedTypes;
import org.postgis.MultiPolygon;

@MappedTypes(MultiPolygon.class)
public class MultiPolygonTypeHandler extends AbstractGeometryTypeHandler<MultiPolygon> {
}
