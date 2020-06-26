package com.anagram.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class AnagramServiceImpl implements AnagramService{

	  public  char[] charArray= null;
	  public   List<String> anagrams=new ArrayList(); 	  
	  
	  public boolean verifyRequest(String string) {	
		  return  string.matches("^[A-Za-z]+$");
	  }
	  
	  public boolean verifyRequest(String string1, String string2) {
		    boolean str1= verifyRequest(string1);
			boolean str2= verifyRequest(string2);			 
			boolean checked= str1&&str2;
			return checked;
	  }
	
 	 public boolean getAnagramforStrings(String string1, String string2) {
	 	
		 boolean status = true;  
         if (string1.length() != string2.length()) {  
             status = false;  
         } else {  
             char[] ArrayS1 = string1.toLowerCase().toCharArray();  
             char[] ArrayS2 = string2.toLowerCase().toCharArray();  
             Arrays.sort(ArrayS1);  
             Arrays.sort(ArrayS2);  
             status = Arrays.equals(ArrayS1, ArrayS2);  
         }  		
          return status;		
	  }
	  public List<String> getAnagramforSingleString(String string1) {
		
		boolean checked= verifyRequest(string1);		
		if(checked==true) {
		charArray=null;
		anagrams=new ArrayList(); 
		charArray = string1.toCharArray();			
		  doAnagram(charArray.length); 
		  return anagrams;
		}
		else {
			return null;
		}		  
		  }		 
		  private void doAnagram(int newsize) {
			  if (newsize == 1) { return ; } 
			  for (int i = 0; i < newsize; i++) { 
				  doAnagram(newsize - 1); 
				  if (newsize == 2) { 
					  for(int j = 0; j< charArray.length; j++) { 
						  }
					  String str = new String(charArray);				
					  anagrams.add(str); 
		              } 
				  int k;
				  int pointAt = charArray.length - newsize;
				  char temp = charArray[pointAt];		  
		   for (k = pointAt + 1; k < charArray.length; k++) {
			  charArray[k - 1] = charArray[k]; 
			  } 
		    charArray[k - 1] = temp;
		  }		  
			   
	}
}
