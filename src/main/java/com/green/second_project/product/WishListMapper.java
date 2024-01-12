package com.green.second_project.product;

import com.green.second_project.product.model.ProductSelWishListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WishListMapper {
    List<ProductSelWishListVo> selWishList(int iuser);
}
