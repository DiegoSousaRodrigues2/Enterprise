package br.com.fiap.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "order")
@SequenceGenerator(name = "order", sequenceName = "SQ_order", allocationSize = 1)
public class Order {

	@Id
	@Column(name = "id") // Id da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order")
	private Integer id;

	@Column(name = "account_id", nullable = false) // id do account, futura PK da tabela account
	private Integer accountId;

	@Column(name = "sku_id", nullable = false) // id da sku, futura PK da tabela sku
	private Integer skuId;

	@Column(name = "status", nullable = false) // status atual do pedido
	private Status status;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDate dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDate lastUpdate;

	public Order() {

	}

	public Order(Integer id, Integer accountId, Integer skuId, Status status, LocalDate dateCreated,
			LocalDate lastUpdate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.skuId = skuId;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastUpdate = lastUpdate;
	}

	public Order(Integer id, Integer accountId, Integer skuId, Status status, LocalDate lastUpdate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.skuId = skuId;
		this.status = status;
		this.lastUpdate = lastUpdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
