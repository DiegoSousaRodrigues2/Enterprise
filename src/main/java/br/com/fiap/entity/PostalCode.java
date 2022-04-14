package br.com.fiap.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "postal_code")
@SequenceGenerator(name = "PostalCode", sequenceName = "SQ_PostalCode", allocationSize = 1)
public class PostalCode {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PostalCode")
	private Integer id;

	@Column(name = "zip_code", nullable = false) // CEP do endereço
	private String zipCode;

	@Column(nullable = true) // Endereço
	private String address;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDateTime dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDateTime lastUpdate;

	public PostalCode() {

	}

	public PostalCode(String zipCode, String address, LocalDateTime dateCreated, LocalDateTime lastUpdate) {
		super();
		this.zipCode = zipCode;
		this.address = address;
		this.dateCreated = dateCreated;
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

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
