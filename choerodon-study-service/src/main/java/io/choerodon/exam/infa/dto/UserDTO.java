package io.choerodon.exam.infa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.choerodon.exam.api.validator.UserValidator;
import io.choerodon.mybatis.entity.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@Table(name = "iam_user")
@Data
@NoArgsConstructor
@ToString
public class UserDTO extends BaseDTO {

    public static final String EMAIL_REG = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

    public static final String PHONE_REG = "^((13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\d{8})?$";

    public static final String LOGIN_NAME_REG = "^(?!\\-)[a-zA-Z0-9\\_\\-\\.]+(?<!\\.git|\\.atom|\\.)$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键ID/非必填")
    private Long id;

    @ApiModelProperty(value = "登录名/必填")
    @Pattern(regexp = LOGIN_NAME_REG, message = "error.user.loginName.regex")
    private String loginName;

    @ApiModelProperty(value = "邮箱/必填")
    @Pattern(regexp = EMAIL_REG, message = "error.user.email.illegal",
            groups = {UserValidator.UserGroup.class, UserValidator.UserInfoGroup.class})
    @NotEmpty(message = "error.user.email.empty",
            groups = {UserValidator.UserGroup.class, UserValidator.UserInfoGroup.class})
    private String email;

    @ApiModelProperty(value = "组织ID/非必填")
    private Long organizationId;
    @Transient
    private String originalPassword;

    @ApiModelProperty(value = "密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "hash_password")
    private String password;

    @ApiModelProperty(value = "用户名/必填")
    @NotEmpty(groups = UserValidator.UserGroup.class)
    private String realName;

    @ApiModelProperty(value = "国际电话区号/非必填")
    private String internationalTelCode;

    @ApiModelProperty(value = "手机号/非必填")
    @Pattern(regexp = PHONE_REG, message = "error.phone.illegal",
            groups = {UserValidator.UserGroup.class, UserValidator.UserInfoGroup.class})
    private String phone;

    @ApiModelProperty(value = "头像/非必填")
    private String imageUrl;
    private String profilePhoto;

    @ApiModelProperty(value = "是否启用/非必填")
    @Column(name = "is_enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "是否是LDAP用户/非必填")
    @Column(name = "is_ldap")
    private Boolean ldap;

    @ApiModelProperty(value = "语言/非必填")
    private String language;

    @ApiModelProperty(value = "时区/非必填")
    private String timeZone;
    private Date lastPasswordUpdatedAt;
    private Date lastLoginAt;

    @Transient
    @ApiModelProperty(value = "组织名称/非必填")
    private String organizationName;

    /**
     * 只用于返回该数据，不读入
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String organizationCode;

    @Transient
    private String uuid;
    /**
     * 连续登录错误次数超出规定次数后是否锁定账户
     */
    @Column(name = "is_locked")
    @ApiModelProperty(value = "是否被锁定/非必填")
    private Boolean locked;

    private Date lockedUntilAt;
    private Integer passwordAttempt;

    @ApiModelProperty(value = "是否是ROOT用户/非必填")
    @Column(name = "is_admin")
    private Boolean admin;

    @Transient
    private Long sourceId;
}