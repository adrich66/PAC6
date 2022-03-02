package com.example.PAC6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apilibrary")
public class AuthorRestController {
	
	
	@Autowired
	AuthorService authorservice;
	
	@GetMapping("authors")
	public ResponseEntity<Iterable <Author>> getAllAuthors(){
		
		var headers = new HttpHeaders();
		headers.add("ResponseGet", "getAllAuthors executed");
		headers.add("version", "1.0 Api Rest Author Object");
		
		return ResponseEntity.accepted().headers(headers).body(authorservice.queryAuthor());
	}
	
	@PostMapping(path = "/addAuthor", consumes = "application/json" )
	public ResponseEntity <Author> createAuthor(@RequestBody Author author) {
		
		System.out.println("This is the object that gets from client/postman in java class author: " +  author);
		
		Author authorSaved = authorservice.addAuthorToArray(author);
		
		var headers = new HttpHeaders();
		headers.add("ResponseCreate", "createAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", "author created");
		
		return ResponseEntity.accepted().headers(headers).body(authorSaved);
		
	}
	
	@DeleteMapping ("/deleteAuthor/name{}")
	public ResponseEntity<Author> deleteAuthor  (@PathVariable String name ) {
		
		String responsedelete = ""; 
		int indexAuthor = authorservice.findAuthorByName (name);
		Author authortodelete = null;
		
		if ( indexAuthor != -1 ) 
			{
			authortodelete = authorservice.getAuthorByIndex(indexAuthor);
			authorservice.deleteAuthorFromArray(indexAuthor);
			responsedelete = responsedelete + "author: " + name + " - deleted #succes";
			}
		else 
			{
			System.out.println("Author not found, not deleted");
			responsedelete = responsedelete + "author: " + name  + " - not deleted author not found #fail";
			}
		
		var headers = new HttpHeaders();
		headers.add("ResponseDeleted", "deleteAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", responsedelete);
		
		return ResponseEntity.accepted().headers(headers).body(authortodelete);
	}
	
	@PostMapping("/replaceAuthor/{name}")
	public ResponseEntity<Author> updateAuthor(@PathVariable String name, @RequestBody Author authorFromRest ) {
		
		String responseUpdate = "";
		Author authorToUpdate = null;

		int indexAuthor = authorservice.findAuthorByName (name);
		if ( indexAuthor == -1 ) 
		{
			responseUpdate = responseUpdate + "author not found";
		} else {
			
			authorToUpdate = authorservice.getAuthorByIndex(indexAuthor);
			
			responseUpdate += "author found";
			boolean updated = false;
			
			if  (authorFromRest.getCountry() != null) {
				responseUpdate += " - country name value updated: " + authorFromRest.getCountry() +  "( old value: " + authorToUpdate.getCountry() + ")" ;
				authorToUpdate.setCountry(authorFromRest.getCountry());
				updated = true;
			}
			if  (authorFromRest.getDob() != null) {
				responseUpdate += " - dob value updated: " + authorFromRest.getDob() +  "( old value: " + authorToUpdate.getDob() + ")" ;
				authorToUpdate.setDob(authorFromRest.getDob());
				updated = true;
			}
			if  (authorFromRest.getQtyBooks() != 0) {
				responseUpdate += " - country name value updated: " + authorFromRest.getQtyBooks() +  "( old value: " + authorToUpdate.getQtyBooks() + ")" ;
				authorToUpdate.setQtyBooks(authorFromRest.getQtyBooks());
				updated = true;
			}
			if  (authorFromRest.getAlive() == true || authorFromRest.getAlive() == false) {
				responseUpdate += " - alive boolean value updated: " + authorFromRest.getAlive() +  "( old value: " + authorToUpdate.getAlive() + ")" ;
				authorToUpdate.setAlive(authorFromRest.getAlive());
				updated = true;
			}
			
			if (!updated) responseUpdate += " - try to update but any field updated - something wrong happened";
			else authorservice.replaceAuthor (indexAuthor, authorToUpdate);
		}
		
		var headers = new HttpHeaders();
		headers.add("ResponseUpdate", "updateAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", responseUpdate);
		
		return ResponseEntity.accepted().headers(headers).body(authorToUpdate);	
	}
	
 	
}