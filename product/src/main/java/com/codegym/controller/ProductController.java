package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
@CrossOrigin("*")
public class ProductController {
  @Autowired
   private IProductService<Product> productService;
    @GetMapping("")
    private ResponseEntity<List<Product>> getAll() {
        List<Product> productList = productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@RequestBody Product product, @PathVariable Long id){
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>("Sửa thành công" ,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>("Xóa thành công" ,HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> showByName(@RequestParam String name) {
        List<Product> productList = productService.findByNameProduct(name);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
