package br.com.fiap.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "order_log")
@SequenceGenerator(name = "order_log", sequenceName = "order_log", allocationSize = 1)
public class OrderLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order")
	private Integer id;

	@Column(name = "order_log", nullable = false) // para qual status foi alterado
	private Status orderLog;

	private String comentario;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDateTime dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDateTime lastUpdate;

	public OrderLog() {

	}

	public OrderLog(Status orderLog, String comentario, LocalDateTime dateCreated, LocalDateTime lastUpdate) {
		super();
		this.orderLog = orderLog;
		this.comentario = comentario;
		this.dateCreated = dateCreated;
		this.lastUpdate = lastUpdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getOrderLog() {
		return orderLog;
	}

	public void setOrderLog(Status orderLog) {
		this.orderLog = orderLog;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
