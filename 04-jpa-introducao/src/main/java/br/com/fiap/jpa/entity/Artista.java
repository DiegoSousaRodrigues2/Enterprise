package br.com.fiap.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TB_ARTISTA")
@SequenceGenerator(name="artista",sequenceName = "SQ_TB_ARTISTA", allocationSize = 1)
public class Artista {

	@Id
	@Column(name="cd_artista")
	@GeneratedValue(generator = "artista", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name="nm_artista", nullable = false, length = 60)
	private String nome;

	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;

	@Lob
	@Column(name="fl_foto")
	private byte[] foto;

	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero_musical", length = 40, nullable = false)
	private GeneroMusica genero;

	@Column(name="st_cantor")
	private Boolean cantor;
	
	@Column(name="st_musico")
	private Boolean musico;
	
	@Column(name="nr_musicas")
	private Integer numeroMusicas;

	@Transient
	private Integer idade;
	
	//CTRL + 3 -> gcuf (construtores)
	//CTRL + 3 -> ggas (getters e setters)
	public Artista() {}
	
	public Artista(String nome, LocalDate dataNascimento, byte[] foto, 
			GeneroMusica genero, Boolean cantor,
			Boolean musico, Integer numeroMusicas) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
		this.cantor = cantor;
		this.musico = musico;
		this.numeroMusicas = numeroMusicas;
	}
	
	public Artista(Integer codigo, String nome, LocalDate dataNascimento, byte[] foto, 
			GeneroMusica genero, Boolean cantor,
			Boolean musico, Integer numeroMusicas) {
		this(nome, dataNascimento, foto, genero, cantor, musico, numeroMusicas);
		this.codigo = codigo;
	}
	
	//Método que é executado automáticamente
	@PrePersist //antes de cadastrar
	public void executar() {
		System.out.println("Cadastrando um artista...");
	}
	
	@PostLoad //depois de carregar o objeto
	public void carregar() {
		idade = 21;
		System.out.println("Carregando um artista...");
	}

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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public GeneroMusica getGenero() {
		return genero;
	}

	public void setGenero(GeneroMusica genero) {
		this.genero = genero;
	}

	public Boolean getCantor() {
		return cantor;
	}

	public void setCantor(Boolean cantor) {
		this.cantor = cantor;
	}

	public Boolean getMusico() {
		return musico;
	}

	public void setMusico(Boolean musico) {
		this.musico = musico;
	}

	public Integer getNumeroMusicas() {
		return numeroMusicas;
	}

	public void setNumeroMusicas(Integer numeroMusicas) {
		this.numeroMusicas = numeroMusicas;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}