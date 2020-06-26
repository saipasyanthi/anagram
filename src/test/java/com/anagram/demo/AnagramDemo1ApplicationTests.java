package com.anagram.demo;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anagram.demo.service.AnagramService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnagramDemo1ApplicationTests {
	
	@Autowired
    private AnagramService anagramService;
	
	@Test
	public void testNonAlphanumericPositive()throws Exception {
		boolean check= anagramService.verifyRequest("keep");
		assertEquals(true,check);
	}
	
	@Test
	public void testNonAlphanumericNegative()throws Exception {
		boolean check= anagramService.verifyRequest("keep@3");
		assertEquals(false,check);
	}
	
	@Test
	public void testNonAlphanumeric01Positive()throws Exception {
		boolean check= anagramService.verifyRequest("keep","peek");
		assertEquals(true,check);
	}
	
	@Test
	public void testNonAlphanumeric01Negative()throws Exception {
		boolean check= anagramService.verifyRequest("keep@3","peek");
		assertEquals(false,check);
	}
	
	@Test
	public void testNonAlphanumeric02Negative()throws Exception {
		boolean check= anagramService.verifyRequest("keep@3","peek@3");
		assertEquals(false,check);
	}
	
	@Test
	public void testDoubleStrPositive()throws Exception {
		boolean check= anagramService.getAnagramforStrings("keep","peek");
		assertEquals(true,check);
	}
	
	@Test
	public void testDoubleStrNegative()throws Exception {
		boolean check= anagramService.getAnagramforStrings("test","peek");
		assertEquals(false,check);
	}
	
	@Test
	public void testSingleStrPositive()throws Exception {
		List<String> check= anagramService.getAnagramforSingleString("te");
		assertEquals(2,check.size());
	}
	@Test
	public void testSingleStrPositive01()throws Exception {
		List<String> check= anagramService.getAnagramforSingleString("test");
		assertEquals(24,check.size());
	}

}
