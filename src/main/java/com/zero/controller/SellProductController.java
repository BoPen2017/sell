package com.zero.controller;

import com.zero.dto.OrderDTO;
import com.zero.entity.ProductCategory;
import com.zero.entity.ProductInfo;
import com.zero.exception.SellException;
import com.zero.form.ProductForm;
import com.zero.service.CategoryService;
import com.zero.service.ProductService;
import com.zero.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    /**
     * 订单列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "3") Integer size,
                             Map<String,Object> map) {
        PageRequest request = new PageRequest(page-1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);
    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId")String productId,Map<String,Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/no_sale")
    public ModelAndView noSale(@RequestParam("productId")String productId,Map<String,Object> map) {
        try {
            productService.noSale(productId);
        } catch (SellException e) {
            map.put("msg",e.getMessage());
            map.put("url","/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false)String productId,Map<String,Object> map){
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }
        // 查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index",map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form, BindingResult bindingResult,Map<String,Object> map){
        if (bindingResult.hasErrors()) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            if (!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productService.findOne(form.getProductId());
            } else {
                form.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form,productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/seller/product/list");
        return new ModelAndView("common/success",map);
    }
}
