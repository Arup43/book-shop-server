package com.internship.bookshop.controller;

import com.internship.bookshop.entity.BookShop;
import com.internship.bookshop.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookShopController {

    @Autowired
    private BookShopService bookShopService;

    @GetMapping("/bookshops")
    public List<BookShop> fetchBookShops() {
        return bookShopService.fetchBookShops();
    }

    @GetMapping("/bookshops/{id}")
    public BookShop fetchBookShopById(@PathVariable("id") Long bookshopId) {
        return bookShopService.fetchBookShopById(bookshopId);
    }


    @GetMapping("/bookshops/{title}")
    public BookShop fetchBookShopByTitle(@PathVariable("title") String title) {
        return bookShopService.fetchBookShopByTitle(title);
    }

    @DeleteMapping("/bookshops")
    public String deleteAllBookShop() {
        bookShopService.deleteAllBookShop();
        return "All Bookshop deleted successfully!";
    }

    @DeleteMapping("bookshops/{id}")
    public String deleteByBookShopId(@PathVariable("id") Long id) {
        bookShopService.deleteByBookShopId(id);
        return "Bookshop deleted successfully!";
    }

    @PostMapping("/bookshops")
    public BookShop saveBookShop(@RequestBody BookShop bookShop) {
        return bookShopService.saveBookShop(bookShop);
    }

    @PutMapping("/bookshops/{id}")
    public BookShop updateBookShop(@RequestBody BookShop bookShop) {
        return bookShopService.updateBookShop(bookShop);
    }
}
