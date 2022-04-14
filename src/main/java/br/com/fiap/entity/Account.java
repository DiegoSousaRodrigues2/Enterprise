package br.com.fiap.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "account")
@SequenceGenerator(name = "SQ_Account", sequenceName = "SQ_Account", allocationSize = 1)
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_Account")
	private Integer id;

	@Column(nullable = false) // Nome do cliente
	private String name;

	@Column(name = "postal_code_id", nullable = false) // Depois essa vai ser a PK da tabela PostalCode
	private Integer postalCodeId;

	@Column(nullable = false) // Documento do Cliente
	private String document;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDateTime dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDateTime lastUpdate;

	public Account() {

	}

	public Account(String name, Integer postalCodeId, String document, LocalDateTime dateCreated,
			LocalDateTime lastUpdate) {
		super();
		this.name = name;
		this.postalCodeId = postalCodeId;
		this.document = document;
		this.dateCreated = dateCreated;
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
