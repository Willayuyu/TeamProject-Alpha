package com.example.fidledemo.VO;

import com.example.fidledemo.BO.ReportMessageBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author WWJ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReportVO {
    private PageInfoVO pageInfo;
    private List<ReportMessageBO> reports;
}
