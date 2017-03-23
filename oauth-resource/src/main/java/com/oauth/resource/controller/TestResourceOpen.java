package com.oauth.resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open")
public class TestResourceOpen {

	@RequestMapping(value = "/resource1", method = RequestMethod.POST)
	public String resource1(@RequestParam String username, @RequestParam String token) {
		System.out.println("POST: " + username + "|" + token );
		return "resource1";
	}
	
	@RequestMapping(value = "/resource1", method = RequestMethod.GET)
	public String resource1Get(@RequestParam String username, @RequestParam String token) {
		System.out.println("GET: " + username + "|" + token );
		return "resource1";
	}

	@RequestMapping(value = "/resource2", method = RequestMethod.POST)
	public String resource2(@RequestParam String username, @RequestParam String token,
			@RequestHeader String signature) {
		System.out.println(username + "|" + token + "|" + signature);
		return "resource2";
	}

	@PreAuthorize("hasAuthority('ROLE_CLIENT')")
	@RequestMapping("/user/create1")
	public String resource13() {
		return "resource13";
	}

	@PreAuthorize("hasAuthority('ROLE_CLIENT')")
	@RequestMapping("/user/create")
	public Foo resource1s3(Foo foo) {
		return new Foo("foo", 1);
	}

	@PreAuthorize("hasAuthority('ROLE_FOO3')")
	@RequestMapping("/resource3")
	public String resource3() {
		return "resource3";
	}

	@RequestMapping("/resource4")
	public Foo resource4() {
		return new Foo("foo", 1);
	}

}
