package com.ct.lms.spring.daos;

import com.ct.lms.dao.beans.BookDetails;
import com.ct.lms.dto.beans.Book;

public interface BookDAO {

	BookDetails add(Book book);

}
