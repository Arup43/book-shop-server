package com.internship.bookshop.service;

import com.internship.bookshop.entity.BookShop;

import java.util.List;

public interface BookShopService {
    public List<BookShop> fetchBookShops();

    public BookShop fetchBookShopById(Long bookshopId);

    public BookShop fetchBookShopByTitle(String title);

    public void deleteAllBookShop();

    public void deleteByBookShopId(Long id);

    public BookShop saveBookShop(BookShop bookShop);

    public BookShop updateBookShop(BookShop bookShop);
}
