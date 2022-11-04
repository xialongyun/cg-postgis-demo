package com.x.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("nyc_buildings")
public class NycBuildings implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gid", type = IdType.AUTO)
    private Integer gid;

    @TableField("bin")
    private Long bin;

    @TableField("the_geom")
    private Object theGeom;
}
