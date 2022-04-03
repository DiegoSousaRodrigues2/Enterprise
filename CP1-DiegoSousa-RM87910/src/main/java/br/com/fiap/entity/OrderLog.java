package br.com.fiap.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "order_log")
@SequenceGenerator(name = "order_log", sequenceName = "order_log", allocationSize = 1)
public class OrderLog {

	@Id
	@Column(name = "id") // id da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order")
	private Integer id;

	@Column(name = "order_log", nullable = false) // para qual status foi alterado
	private Integer orderLog;

	@Column(name = "comentario", nullable = true) // Comentario de mudança de status, pode ser nulo
	private String comentario;

	@Column(name = "date_created", nullable = false) // Esse valor será fixo para evidenciar quando foi criado
	private LocalDate dateCreated;

	@Column(name = "last_update", nullable = false) // Esse será atualizado toda vez que for atualizado
	private LocalDate lastUpdate;

	public OrderLog() {

	}

	public OrderLog(Integer orderLog, String comentario, LocalDate dateCreated, LocalDate lastUpdate) {
		super();
		this.orderLog = orderLog;
		this.comentario = comentario;
		this.dateCreated = dateCreated;
		this.lastUpdate = lastUpdate;
	}
	
	public OrderLog(Integer orderLog, String comentario, LocalDate lastUpdate) {
		super();
		this.orderLog = orderLog;
		this.comentario = comentario;
		this.lastUpdate = lastUpdate;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderLog() {
		return orderLog;
	}

	public void setOrderLog(Integer orderLog) {
		this.orderLog = orderLog;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
