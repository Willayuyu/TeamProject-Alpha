package com.example.fidledemo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author WWJ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDO {
    private Long id;
    private String roleName;
    private Long adminId;
    private List<PermissionDO> permissionList;
}
