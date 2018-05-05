package com.company.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author ouzhx on 2018/5/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户基本信息")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ApiModelProperty("姓名")
  @Size(max = 20)
  private String username;

  @ApiModelProperty("密码-这里要求必须是邮箱格式-哈哈")
  @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
  private String password;

  @Column(name = "nick_name")
  private String nickName;

  @ApiModelProperty("性别")
  @Max(2)
  @Min(1)
  private Integer sex;

  @Column(name = "register_date")
  private Date registerDate;
}
