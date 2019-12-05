package com.zero.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {

    private String productId;
    /** 名字 */
    private String productName;
    /** 单价 */
    private BigDecimal productPrice;
    /** 库存 */
    private Integer productStock;
    /** 描述 */
    private String productDescription;
    /** 小图 */
    private String productIcon;
    /** 状态0正常，1下架 */
    private Integer productStatus;
    /** 类目编号 */
    private Integer categoryType;
}
