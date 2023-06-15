package com.internship.bookshop.repository;

import com.internship.bookshop.entity.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShopRepository extends JpaRepository<BookShop, Long> {
    public BookShop findByShopName(String shopName);
}
