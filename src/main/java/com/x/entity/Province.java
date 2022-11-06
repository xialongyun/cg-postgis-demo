package com.x.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author X
 * @since 2022-11-06
 */
@Getter
@Setter
@TableName("province")
@ApiModel(value = "Province对象", description = "")
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("adcode")
    private Integer adcode;

    @TableField("name")
    private String name;

    @TableField("center")
    private Object center;

    @TableField("centroid")
    private Object centroid;

    @TableField("childrennum")
    private Integer childrennum;

    @TableField("the_geom")
    private Object theGeom;
}
