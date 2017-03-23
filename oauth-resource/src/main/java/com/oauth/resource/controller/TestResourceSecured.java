package com.oauth.resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class TestResourceSecured {

	@RequestMapping(value = "/resource1")
    public String resource1() {
	return "resource1";
    }

    @RequestMapping("/resource2")
    public String resource2() {
	return "resource2";
    }

    @PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @RequestMapping("/user/create1")
    public String resource13() {
	return "create1";
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
