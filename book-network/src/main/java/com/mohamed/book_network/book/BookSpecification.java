package com.mohamed.book_network.book;

import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book> withOwnerId(Integer ownerID) {
        return (root, query, cb) -> cb.equal(root.get("owner").get("id"), ownerID);
    }
}
