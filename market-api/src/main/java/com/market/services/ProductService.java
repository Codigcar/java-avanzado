package com.market.services;

import com.market.dtos.CreateProductDTO;
import com.market.dtos.ProductDTO;

public interface ProductService {

    ProductDTO registerProduct(CreateProductDTO createProductDTO) throws Exception;

}
