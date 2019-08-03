package io.choerodon.exam.infa.dto;

import io.choerodon.mybatis.entity.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by zhao'yin
 * Date 2019/8/3.
 */
@Data
@NoArgsConstructor
@ToString
@Table(name = "fd_organization")
public class OrganizationDTO extends BaseDTO {

    private static final String CODE_REGULAR_EXPRESSION = "^[a-z](([a-z0-9]|-(?!-))*[a-z0-9])*$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键/非必填")
    private Long id;

    @ApiModelProperty(value = "组织名/必填")
    @NotEmpty(message = "error.organization.name.empty")
    @Size(min = 1, max = 32, message = "error.organization.name.size")
    private String name;

    @ApiModelProperty(value = "组织编码/必填")
    @NotEmpty(message = "error.code.empty")
    @Pattern(regexp = CODE_REGULAR_EXPRESSION, message = "error.code.illegal")
    @Size(min = 1, max = 15, message = "error.organization.code.size")
    private String code;

    private Long userId;

    private String address;

    @ApiModelProperty(value = "组织类别")
    private String category;

    @ApiModelProperty(value = "组织图标url")
    private String imageUrl;

    @Column(name = "is_enabled")
    @ApiModelProperty(value = "是否启用/非必填/默认：true")
    private Boolean enabled;

    @ApiModelProperty(value = "组织官网地址")
    private String homePage;

    @Transient
    private List<ProjectDTO> projects;

    @Transient
    @ApiModelProperty(value = "项目数量")
    private Integer projectCount;

    @Transient
    private String ownerLoginName;

    @Transient
    private String ownerRealName;

    @Transient
    private String ownerPhone;

    @Transient
    private String ownerEmail;

    @Transient
    private Boolean isInto = true;

    @Transient
    private Date creationDate;
}