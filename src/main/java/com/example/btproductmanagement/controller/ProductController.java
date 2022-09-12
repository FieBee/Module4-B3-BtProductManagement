package com.example.btproductmanagement.controller;


import com.example.btproductmanagement.dao.IProductDAO;
import com.example.btproductmanagement.dao.ProductDAO;
import com.example.btproductmanagement.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

   private final IProductDAO productDAO = new ProductDAO();

   @GetMapping("")
   public String index(Model model) {
      List<Product> products = productDAO.findAll();
      model.addAttribute("products", products);
      return "/index";
   }

   @GetMapping("/create")
   public String create(Model model){
      model.addAttribute("product",new Product());
      return "/create";
   }

   @PostMapping("/save")
   public String save(Product product){
      product.setId((int) (Math.random()*10000));
      productDAO.save(product);
      return "redirect:/products";
   }

   @GetMapping("{id}/edit")
   public String edit(@PathVariable int id,Model model){
      model.addAttribute("product",productDAO.findById(id));
      return "/edit";
   }

   @PostMapping("/update")
   public String update(Product product){
      productDAO.update(product.getId(),product);
      return "redirect:/products";
   }


   @GetMapping("/{id}/delete")
   public String delete(@PathVariable int id,Model model){
      model.addAttribute("product",productDAO.findById(id));
      return "/delete";
   }
   @PostMapping("/delete")
   public String delete(Product product, RedirectAttributes redirect){
      productDAO.remote(product.getId());
      redirect.addFlashAttribute("success","Removed product successfully!");
      return "redirect:/products";
   }

   @GetMapping("/{id}/view")
   public String view(@PathVariable int id, Model model) {
      model.addAttribute("product", productDAO.findById(id));
      return "/view";
   }

   @GetMapping("/search")
   public String findByName(@RequestParam String aloso,Model model){
      List<Product> products = productDAO.findByName(aloso);
      model.addAttribute("products",products);
      return "/index";
   }

}
