package cade_meu_dono.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Animal {

	public Animal() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ani_id")
	private Long id;

	@Column(name = "ani_nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "ani_genero", nullable = false, length = 1)
	private String genero;

	@Temporal(TemporalType.DATE)
	@Column(name = "ani_nascimento", nullable = true)
	private Date nascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "ani_status", nullable = false, columnDefinition = "varchar(255) default 'VIVO'")
	private Status status;

	//@Formula(value = "YEAR(FROM_DAYS(TO_DAYS(NOW())-TO_DAYS(ani_nascimento))) AS ani_idade")
	//private int idade;

	@Column(name = "ani_cadastrado")
	@CreationTimestamp
	private Calendar dataCadastro;

	@Column(name = "ani_atualizado")
	@UpdateTimestamp
	private Calendar dataAtualizado;

	@OneToMany(mappedBy = "animal")
	private List<AnimalMidia> midias;

	@OneToOne(mappedBy = "animal")
	private AnimalDesaparecido animalDesaparecido;

	@ManyToMany(mappedBy = "animais")
	private List<Usuario> usuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
/*
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
*/
	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataAtualizado() {
		return dataAtualizado;
	}

	public void setDataAtualizado(Calendar dataAtualizado) {
		this.dataAtualizado = dataAtualizado;
	}

	public List<AnimalMidia> getMidias() {
		return midias;
	}

	public void setMidias(List<AnimalMidia> midias) {
		this.midias = midias;
	}

	public AnimalDesaparecido getAnimalDesaparecido() {
		return animalDesaparecido;
	}

	public void setAnimalDesaparecido(AnimalDesaparecido animalDesaparecido) {
		this.animalDesaparecido = animalDesaparecido;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
