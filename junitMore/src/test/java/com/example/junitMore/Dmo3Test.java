package com.example.junitMore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Dmo3Test {


    @Nested
    class IprefBook{

        record Book(String name, String author){}

        List<Book> books = List.of(new Book("A","Author"),
                new Book("ac","Dvc"));

        @Test
        void assertFun(){

            Assertions.assertThat(books).hasSize(2)
                    .filteredOn(b->b.author.startsWith("Dv"))
                    .hasSize(1)
                    .extracting(Book::author)
                    .containsExactly("Dvc");

        }
    }
}
