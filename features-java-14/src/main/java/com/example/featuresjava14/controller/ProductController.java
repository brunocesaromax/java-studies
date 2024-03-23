package com.example.featuresjava14.controller;

import com.example.featuresjava14.config.SwaggerConfig;
import com.example.featuresjava14.enumerate.ProductStatus;
import com.example.featuresjava14.model.Product;
import com.example.featuresjava14.records.ProductDTO;
import com.example.featuresjava14.records.ProductRecord;
import com.example.featuresjava14.repository.ProductRepository;
import com.example.featuresjava14.service.ProductService;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = SwaggerConfig.PRODUCTS_API_TAG)
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    //Usando uma record como um tipo temporário
    record Response(@JsonProperty List<Product>list, @JsonProperty int total) {
    }

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping
    public Response findAll() {
        var list = productRepository.findAll();
        return new Response(list, list.size());
    }

    @GetMapping("{id}")
    public @ResponseBody
    ProductRecord findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping//Pode se utilizar records como dtos
    public ProductRecord create(@Valid @RequestBody ProductDTO productDTO) {
//        return productRepository.save(productDTO.toEntity());
        var status = switch (productDTO.status()) {
            case 1 -> ProductStatus.ACTIVE;
            case 0 -> ProductStatus.INACTIVE;
            default -> throw new IllegalArgumentException("Opção inválida!");
        };

        return productService.create(productDTO.name(), status);
    }
}
