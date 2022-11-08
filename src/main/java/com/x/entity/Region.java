package com.x.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



//CREATE TABLE public.region(
//code integer PRIMARY KEY NOT NULL,
//name varchar(2048),
//parent integer,
//level varchar(2048),
//the_geom public.geometry);

/**
 * 统一处理省市区的数据
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Region {
    private  Integer adcode;
    @TableField("name")
    private String name;
    @TableField("parent")
    private Integer parent;
    @TableField("level")
    private String level;
    private Integer children;
    private Integer index;
    @TableField("the_geom")
    private Object theGeom;
    //private List<Region> children = new ArrayList<>();
}
