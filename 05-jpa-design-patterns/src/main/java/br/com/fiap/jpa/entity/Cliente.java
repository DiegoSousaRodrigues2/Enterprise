package br.com.fiap.jpa.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="cliente",sequenceName = "SQ_TB_CLIENTE",allocationSize = 1)
public class Cliente {

	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private Integer codigo;
	
	@Column(name="nm_cliente", nullable = false, length = 80)
	private String nome;
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20)
	private Genero genero;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}