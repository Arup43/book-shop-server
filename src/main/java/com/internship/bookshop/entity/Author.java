package com.internship.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "author_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "author_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "author_mobile")
        )
})
public class Author {
    private String name;
    private String email;
    private String mobile;
}
