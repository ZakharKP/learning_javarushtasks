package com.javarush.task.task38.task3802;

public class VeryComplexClass {
	public void veryComplexMethod() throws Exception {
		this.clone();
	}

	public static void main(String[] args) throws Exception {
		VeryComplexClass veryComplexClass = new VeryComplexClass();
		veryComplexClass.veryComplexMethod();
	}
}
