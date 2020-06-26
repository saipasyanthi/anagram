package com.anagram.demo.service;

import java.util.List;

public interface AnagramService {
	
	  public boolean verifyRequest(String string);
	  
	  public boolean verifyRequest(String string1, String string2);
	  
	  public boolean getAnagramforStrings(String string1, String string2);
	  
	  public List<String> getAnagramforSingleString(String string1);
	
}
