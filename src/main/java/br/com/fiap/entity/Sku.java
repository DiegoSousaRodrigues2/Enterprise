package br.com.fiap.entity;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "sku")
@SequenceGenerator(name = "sku", sequenceName = "SQ_Sku", allocationSize = 1)
public class Sku {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sku")
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Double price;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDate dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDate lastUpdate;

	public Sku() {

	}

	public Sku(String name, Double price, LocalDate dateCreated, LocalDate lastUpdate) {
		super();
		this.name = name;
		this.price = price;
		this.dateCreated = dateCreated;
		this.lastUpdate = lastUpdate;
	}
	
	public Sku(String name, Double price, LocalDate lastUpdate) {
		super();
		this.name = name;
		this.price = price;
		this.lastUpdate = lastUpdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
