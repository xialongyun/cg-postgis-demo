package com.x.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigInteger;

import com.x.config.typehandler.PolygonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.postgis.Geometry;

/**
 * <p>
 * 
 * </p>
 *
 * @author X
 * @since 2022-11-05
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@TableName(value = "market", autoResultMap = true)
public class Market implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "gid", type = IdType.AUTO)
    private Integer gid;

    @TableField("bin")
    private BigInteger bin;

    @TableField(typeHandler = PolygonTypeHandler.class)
    private Geometry theGeom;
}
