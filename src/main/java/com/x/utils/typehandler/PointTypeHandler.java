package com.x.utils.typehandler;


import org.apache.ibatis.type.MappedTypes;
import org.postgis.Point;

@MappedTypes(Point.class)
public class PointTypeHandler extends AbstractGeometryTypeHandler<Point> {
}
