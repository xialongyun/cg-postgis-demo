package com.x.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@TableName("spatial_ref_sys")
public class SpatialRefSys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("srid")
    private Integer srid;

    @TableField("auth_name")
    private String authName;

    @TableField("auth_srid")
    private Integer authSrid;

    @TableField("srtext")
    private String srtext;

    @TableField("proj4text")
    private String proj4text;
}
