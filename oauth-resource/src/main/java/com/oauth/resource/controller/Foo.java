package com.oauth.resource.controller;

class Foo {
	private String name;
	private Integer rollNo;

	public Foo() {
	}

	public Foo(String name, Integer rollNo) {
	    this.name = name;
	    this.rollNo = rollNo;
	}

	public String getName() {
	    return name;
	}

	public Integer getRollNo() {
	    return rollNo;
	}
}