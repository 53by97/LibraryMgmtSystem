package com.ct.lms.spring.daos;

import java.util.List;

import com.ct.lms.beans.BookDetails;

public interface BookDAO {

	BookDetails add(String title, String author, String publisher);

	List<BookDetails> searchByTitle(String text);

	List<BookDetails> searchByAuthor(String text);

}
