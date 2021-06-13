package com.example.fidledemo.VO;

import com.example.fidledemo.BO.AdminBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO
{
   private Long id;
   private String account;
   private String token;
}
