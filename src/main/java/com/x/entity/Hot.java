package com.x.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-11-08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@TableName("hot")
public class Hot implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;

    @TableField("title")
    private String title;

    @TableField("st_asgeojson")
    private String stAsgeojson;

    @TableField("read_amount")
    private String readAmount;

    @TableField("comment_amount")
    private String commentAmount;

    @TableField("share_amount")
    private String shareAmount;

    @TableField("focus_amount")
    private String focusAmount;

    @TableField("hot_level")
    private String hotLevel;

    @TableField("gmt_createtime")
    private String gmtCreatetime;
}
