package br.com.fiap.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "Account")
@SequenceGenerator(name = "SQ_Account", sequenceName = "SQ_Account", allocationSize = 1)
public class Account {

	@Id
	@Column(name = "id") // Id do cliente
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_Account")
	private Integer id;

	@Column(name = "name", nullable = false) // Nome do cliente
	private String name;

	@Column(name = "postal_code_id", nullable = false) // Depois essa vai ser a PK da tabela PostalCode
	private Integer postalCodeId;

	@Column(name = "document", nullable = false) // Documento do Cliente
	private String document;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDate dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDate lastUpdate;

	public Account() {

	}

	public Account(Integer id, String name, Integer postalCodeId, String document, LocalDate dateCreated,
			LocalDate lastUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.postalCodeId = postalCodeId;
		this.document = document;
		this.dateCreated = dateCreated;
		this.lastUpdate = lastUpdate;
	}

	public Account(Integer id, String name, Integer postalCodeId, String document, LocalDate lastUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.postalCodeId = postalCodeId;
		this.document = document;
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

	public Integer getPostalCodeId() {
		return postalCodeId;
	}

	public void setPostalCodeId(Integer postalCodeId) {
		this.postalCodeId = postalCodeId;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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
