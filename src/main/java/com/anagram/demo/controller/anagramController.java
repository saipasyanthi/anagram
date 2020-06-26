package com.anagram.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

import com.anagram.demo.service.AnagramService;


@RestController
public class anagramController {
	
	@Autowired
    private AnagramService anagramService;
	
	 @GetMapping("/anagrams/{string1}/{string2}")
    public ResponseEntity<JSONObject> checkAnagram(@PathVariable("string1") String string1,@PathVariable("string2") String string2) 
      {  		   
		 boolean checked=anagramService.verifyRequest(string1,string2);		 
		 if(checked==true) {		
			 boolean value=anagramService.getAnagramforStrings(string1,string2);
			 JSONObject json = new JSONObject();
			 json.put("areAnagrams", value);
		 return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
		 }
		 else
	    return new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);    	        
     }  
   
    @GetMapping("/anagrams/{string1}")
    public ResponseEntity<JSONObject> checkAnagramSingle(@PathVariable("string1") String string1)
      {        	
    	List<String>  value=anagramService.getAnagramforSingleString(string1);    	
    	 if(value!=null) {
    		 JSONObject json = new JSONObject();
			 json.put("anagrams", value);    	
    	 return new ResponseEntity<JSONObject>(json, new HttpHeaders(), HttpStatus.OK);
    	 }
    	 else
    		    return new ResponseEntity<JSONObject>(HttpStatus.BAD_REQUEST);     	 		
      	}
    
}
