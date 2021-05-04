package com.example.fidledemo.BO;

import com.example.fidledemo.DO.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 二手物品信息类
 * @author 11313
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfoBO extends BaseInformation
{
  //状态

  /**
   * 在售
   */
  public static final Integer SELLING=0;

  /**
   * 售出
   */
  public static final Integer SOLD=1;

  /**
   * 售价
   */
  private BigDecimal price;

  /**
   * 原价
   */
  private BigDecimal originalPrice;

  /**
   * 图片列表
   */
  private List<ImageBO> imageList;

  /**
   * 新旧程度
   */
  private Integer condition;

  /**
   * 状态
   */
  private Integer sold;

  /**
   * 生成新的二手物品
   * @param pubId
   * @param title
   * @param description
   * @param tagList
   * @param categoryId
   * @param categoryDesignation
   * @param price
   * @param originalPrice
   * @param imageList
   * @param condition
   */
  public GoodsInfoBO(Long pubId, String title, String description, List<TagBO> tagList, Integer categoryId, String categoryDesignation,BigDecimal price,
                     BigDecimal originalPrice, List<ImageBO> imageList, Integer condition)
  {
    super(pubId, title, description, tagList, categoryId, categoryDesignation, TagBO.GOODS);
    this.price = price;
    this.originalPrice = originalPrice;
    this.imageList = imageList;
    this.condition = condition;
    this.sold=SELLING;
  }

  /**
   * 获得GoodsInfoDO
   * @return
   */
  public GoodsInfoDO getGoodsInfoDO()
  {
    GoodsInfoDO goodsInfoDO=new GoodsInfoDO();
    goodsInfoDO.setSellerId(this.pubId);
    goodsInfoDO.setTitle(this.title);
    goodsInfoDO.setPrice(this.price);
    goodsInfoDO.setOriginalPrice(this.originalPrice);
    goodsInfoDO.setDescription(this.description);
    goodsInfoDO.setCategory(this.category.getCategoryId());
    goodsInfoDO.setCondition(this.condition);
    goodsInfoDO.setSold(this.sold);
    return goodsInfoDO;
  }

  /**
   * 获得TagOfGoodsDO列表
   * @return
   */
  public List<TagOfGoodsDO> getTagOfGoodsDOList()
  {
    List<TagOfGoodsDO> list=new ArrayList<>();
    for (TagBO tagBO:tagList)
    {
      TagOfGoodsDO tagDO=new TagOfGoodsDO();
      tagDO.setContent(tagBO.getContent());
      list.add(tagDO);
    }
    return list;
  }

  /**
   * 获得GoodsTagDO列表
   * @return
   */
  public List<GoodsTagDO> getGoodsTagDOList()
  {
    List<GoodsTagDO> list=new ArrayList<>();
    for (TagBO tagBO:tagList)
    {
      GoodsTagDO tagDO=new GoodsTagDO();
      tagDO.setTagId(tagBO.getId());
      tagDO.setGoodsId(this.id);
      list.add(tagDO);
    }
    return list;
  }

  /**
   * 获得GoodsImageDO列表
   * @return
   */
  public List<GoodsImageDO> getGoodsImageDOList()
  {
    List<GoodsImageDO> list=new ArrayList<>();
    for (ImageBO imageBO:imageList)
    {
      GoodsImageDO imageDO=new GoodsImageDO();
      imageDO.setGoodsId(this.id);
      imageDO.setImageLink(imageBO.getImageLink());
      list.add(imageDO);
    }
    return list;
  }


  @Override
  public String toString() {
    return "GoodsInfoBO{" +
        "price=" + price +
        ", originalPrice=" + originalPrice +
        ", imageList=" + imageList +
        ", condition=" + condition +
        ", sold=" + sold +
        ", id=" + id +
        ", pubId=" + pubId +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", tagList=" + tagList +
        ", category=" + category +
        ", gmtInfo=" + gmtInfo +
        '}';
  }
}