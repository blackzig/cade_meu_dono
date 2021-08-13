package cade_meu_dono.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Usuario {

	public Usuario() {

	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;

	@Column(name = "usu_nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "usu_telefone", nullable = false, length = 24)
	private String telefone;

	@Column(name = "usu_foto", nullable = true, length = 255)
	private String foto;

	@Column(name = "usu_latitude", nullable = true, length = 16)
	private String latitude;

	@Column(name = "usu_longitude", nullable = true, length = 16)
	private String longitude;

	@Column(name = "usu_senha", nullable = false, length = 16)
	private String senha;

	@Column(name = "usu_cidade", nullable = false, length = 32)
	private String cidade;

	@Column(name = "usu_estado", nullable = false, length = 2)
	private String estado;

	@Column(name = "usu_cadastrado")
	@CreationTimestamp
	private Calendar dataCadastro;

	@Column(name = "usu_atualizado")
	@UpdateTimestamp
	private Calendar dataAtualizado;

	@OneToMany(mappedBy = "usuario")
	private List<Noticia> noticias;

	@OneToMany(mappedBy = "usuario")
	private List<Comentario> comentarios;

	@ManyToOne
	@JoinColumn(name = "ad_id")
	private AnimalDesaparecido animalDesaparecido;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "usu_id"), inverseJoinColumns = @JoinColumn(name = "ani_id"), name = "usuario_aninal")
	private List<Animal> animais;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public AnimalDesaparecido getAnimalDesaparecido() {
		return animalDesaparecido;
	}

	public void setAnimalDesaparecido(AnimalDesaparecido animalDesaparecido) {
		this.animalDesaparecido = animalDesaparecido;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

}
