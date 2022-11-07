package com.x.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.x.utils.typehandler.geometryTypeHandler.MultiPolygonTypeHandler;
import com.x.utils.typehandler.geometryTypeHandler.PointTypeHandler;
import com.x.utils.typehandler.geometryTypeHandler.PolygonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.postgis.Geometry;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 
 * </p>
 *
 * @author X
 * @since 2022-11-07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@TableName(value = "province", autoResultMap = true)
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("adcode")
    private Integer adcode;

    @TableField("name")
    private String name;

    //@TableField(typeHandler = PointTypeHandler.class)
    private Object center;

    //@TableField(typeHandler = PointTypeHandler.class)
    private Object centroid;

    @TableField("children")
    private Integer children;

    @TableField(typeHandler = MultiPolygonTypeHandler.class)
    private Object theGeom;
}
