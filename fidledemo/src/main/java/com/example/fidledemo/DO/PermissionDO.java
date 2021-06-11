package com.example.fidledemo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author WWJ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDO {
    private Long id;
    private String permission;
    private Long roleId;
}
