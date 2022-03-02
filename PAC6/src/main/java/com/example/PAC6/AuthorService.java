package com.example.PAC6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	static List <Author> authors = new ArrayList <Author> ();
	
	static {
		
		Author author1 = new Author ("Murakami", "Japón", new Dob (12,1,1949), 15, true);
		Author author2 = new Author ("Cervantes", "España", new Dob (29,9,1547), 5, false);
		Author author3 = new Author ("Mercè Rodoreda", "España", new Dob (10,10,1908), 20, false);
		authors.add(author1);
		authors.add(author2);
		authors.add(author3);
	}
	
	public List <Author> queryAuthor(){
		System.out.println("Authors" + authors);
		return authors;
	}
	
	public Author addAuthorToArray(Author author){
		
		authors.add(author);
		return author;
	}
	
	public String deleteAuthorFromArray(String name) {
		
		int index = findAuthorByName(name);
		authors.remove(index);
		return "Author deleted by name";
	}
	
	public String deleteAuthorFromArray(int index) {
		
		authors.remove(index);
		return "Author deleted by index";
	}
	
	public int findAuthorByName(String name) {
		
		int index = -1;
		for ( Author AuthorTemporal : authors) {
			if( AuthorTemporal.getName().equalsIgnoreCase(name)) {
				index = authors.indexOf(AuthorTemporal);
			}
		}
		return index;
	}
	
	public Author replaceAuthor (int indexAuthor, Author author) {
		
		authors.set(indexAuthor, author);
		return author;
	}
	
	public Author getAuthorByIndex (int index) {
		Author author = authors.get(index);
		return author;
	}
}