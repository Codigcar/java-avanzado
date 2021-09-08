package com.market.services.impl;

import com.market.dtos.CreateProductDTO;
import com.market.dtos.ProductDTO;
import com.market.entities.Category;
import com.market.entities.Product;
import com.market.repositories.CategoryRepository;
import com.market.repositories.ProductRepository;
import com.market.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductDTO registerProduct(CreateProductDTO createProductDTO) throws Exception {

        Optional<Category> categoryDB = categoryRepository.findById(createProductDTO.getCategoryId());
        if(!categoryDB.isPresent())
            throw new Exception("Category Not Found");

        Product product = new Product();
        Product productDB;

        try{

            product.setDescription(createProductDTO.getDescription());
            product.setStock(createProductDTO.getStock());
            product.setPrice(createProductDTO.getPrice());
            product.setStatus(1);
            product.setCategory(categoryDB.get());

            productDB=productRepository.save(product);


        }catch (Exception e){
            throw new Exception("Internal Server Error");
        }

        return  modelMapper.map(productDB,ProductDTO.class);
    }

}
