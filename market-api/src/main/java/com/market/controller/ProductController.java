package com.market.controller;

import com.market.dtos.CreateProductDTO;
import com.market.dtos.ProductDTO;
import com.market.responses.MarketResponse;
import com.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    MarketResponse<ProductDTO> registerProduct(@RequestBody @Valid CreateProductDTO createProductDTO) throws Exception{

        return new MarketResponse<>("200","Producto agregado", productService.registerProduct(createProductDTO));
    }

}
