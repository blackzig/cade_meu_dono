package cade_meu_dono.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "animal_desaparecido")
public class AnimalDesaparecido {

	public AnimalDesaparecido() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ad_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "ad_status", nullable = true, columnDefinition = "default 'DESAPARECIDO'")
	private Status status;

	@Column(name = "ad_desapareceu_em", nullable = false)
	@CreationTimestamp
	private Calendar dataCadastro;

	@Column(name = "ad_encontrou_em", nullable = true)
	@UpdateTimestamp
	private Calendar dataAtualizado;

	@OneToOne
	@JoinColumn(name = "ani_id")
	private Animal animal;

	@OneToMany(mappedBy = "animalDesaparecido")
	private List<Usuario> usuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

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

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
