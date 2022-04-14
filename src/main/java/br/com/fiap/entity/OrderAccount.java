package br.com.fiap.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "order_account")
@SequenceGenerator(name = "order", sequenceName = "SQ_order", allocationSize = 1)
public class OrderAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order")
	private Integer id;

	@Column(name = "account_id", nullable = false) // id do account, futura PK da tabela account
	private Integer accountId;

	@Column(name = "sku_id", nullable = false) // id da sku, futura PK da tabela sku
	private Integer skuId;
	
	@Column(nullable = false)
	private Status status;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDateTime dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDateTime lastUpdate;

	public OrderAccount() {

	}

	public OrderAccount(Integer accountId, Integer skuId, Status status, LocalDateTime dateCreated,
			LocalDateTime lastUpdate) {
		super();
		this.accountId = accountId;
		this.skuId = skuId;
		this.status = status;
		this.dateCreated = dateCreated;
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
