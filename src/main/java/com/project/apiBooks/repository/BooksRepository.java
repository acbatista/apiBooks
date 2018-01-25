package com.project.apiBooks.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.apiBooks.domain.Book;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
