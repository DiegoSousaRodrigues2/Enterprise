package br.com.fiap.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "postal_code")
@SequenceGenerator(name = "PostalCode", sequenceName = "SQ_PostalCode", allocationSize = 1)
public class PostalCode {

	@Id
	@Column(name = "id") // Id da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PostalCode")
	private Integer id;

	@Column(name = "zip_code", nullable = false) // CEP do endere�o
	private String zipCode;

	@Column(name = "address", nullable = true) // Endere�o
	private String address;

	@Column(name = "date_created", nullable = false) // Esse valor ser� fixo para evidenciar quando foi criado
	private LocalDate dateCreated;

	@Column(name = "last_update", nullable = false) // Esse ser� atualizado toda vez que for atualizado
	private LocalDate lastUpdate;

	public PostalCode() {

	}

	public PostalCode(Integer id, String zipCode, String address, LocalDate dateCreated, LocalDate lastUpdate) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.address = address;
		this.dateCreated = dateCreated;
		this.lastUpdate = lastUpdate;
	}
	
	public PostalCode(Integer id, String zipCode, String address, LocalDate lastUpdate) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.address = address;
		this.lastUpdate = lastUpdate;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
