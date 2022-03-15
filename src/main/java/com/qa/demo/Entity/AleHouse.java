package com.qa.demo.Entity;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AleHouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String food;
	
	@Column
	private String drink;
	
	@Column
	private int price;
	
	@Column
	private String name;

	@Column
	@NotNull
	private boolean GameOfGwent;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGameOfGwent() {
		return GameOfGwent;
	}

	public void setGameOfGwent(boolean gameOfGwent) {
		GameOfGwent = gameOfGwent;
	}
  
	public AleHouse() {}

	public AleHouse(long id, String food, String drink, int price, String name, boolean gameOfGwent) {
		super();
		this.id = id;
		this.food = food;
		this.drink = drink;
		this.price = price;
		this.name = name;
		GameOfGwent = gameOfGwent;
	}

	public AleHouse(String food, String drink, int price, String name, boolean gameOfGwent) {
		super();
		this.food = food;
		this.drink = drink;
		this.price = price;
		this.name = name;
		GameOfGwent = gameOfGwent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(GameOfGwent, drink, food, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AleHouse other = (AleHouse) obj;
		return GameOfGwent == other.GameOfGwent && Objects.equals(drink, other.drink)
				&& Objects.equals(food, other.food) && Objects.equals(name, other.name) && price == other.price;
	}

	@Override
	public String toString() {
		return "AleHouse [id=" + id + ", food=" + food + ", drink=" + drink + ", price=" + price + ", name=" + name
				+ ", GameOfGwent=" + GameOfGwent + "]";
	}
	
}