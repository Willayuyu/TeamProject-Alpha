package com.example.fidledemo.BO;

import com.example.fidledemo.DO.GoodsIndentDO;
import com.example.fidledemo.DO.GoodsInfoDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二手物品订单项
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsIndentBO extends BaseOrder
{
  /**
   * 二手物品信息
   */
  private GoodsInfoBO goodsInfo;

  /**
   * 生成新的二手评价
   * @param pubId
   * @param accId
   * @param goodsInfo
   */
  public GoodsIndentBO(Long pubId, Long accId, GoodsInfoBO goodsInfo)
  {
    super(pubId, accId);
    this.goodsInfo = goodsInfo;
  }

  /**
   * 获得GoodsIndentDO
   * @return
   */
  public GoodsIndentDO getGoodsIndentDO()
  {
    GoodsIndentDO goodsIndentDO=new GoodsIndentDO();
    goodsIndentDO.setGoodsId(this.goodsInfo.getId());
    goodsIndentDO.setBuyerId(accId);
    goodsIndentDO.setSellerId(pubId);
    goodsIndentDO.setSellerEvaluated(pubEvaluated);
    goodsIndentDO.setBuyerEvaluated(accEvaluated);
    return goodsIndentDO;
  }


}
