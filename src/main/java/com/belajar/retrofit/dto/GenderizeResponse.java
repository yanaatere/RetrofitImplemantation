package com.belajar.retrofit.dto;

public class GenderizeResponse {
	private String gender;
	private Double probability;
	private int count;
	private String name;

	public GenderizeResponse() {
	}

	public GenderizeResponse(String gender, Double probability, int count, String name) {
		this.gender = gender;
		this.probability = probability;
		this.count = count;
		this.name = name;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setProbability(Double probability){
		this.probability = probability;
	}

	public Double getProbability(){
		return probability;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Genderize Io Response {" +
			"gender = '" + gender + '\'' + 
			",probability = '" + probability + '\'' + 
			",count = '" + count + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}
