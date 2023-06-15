package com.internship.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookshopId;
    private Integer shopNumber;
    private String shopName;
    private String location;
    private String contactNumber;
    private String email;
}
