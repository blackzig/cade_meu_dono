package cade_meu_dono.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "noticias")
public class Noticia {

	public Noticia() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "not_id")
	private Long id;

	@Column(name = "not_foto", nullable = true, length = 255)
	private String foto;

	@Column(name = "not_titulo", nullable = false, length = 255)
	private String titulo;

	@Lob
	@Column(name = "not_noticia", nullable = false)
	private String noticiaConteudo;

	@Column(name = "not_cadastrado")
	@CreationTimestamp
	private Calendar dataCadastro;

	@Column(name = "not_atualizado")
	@UpdateTimestamp
	private Calendar dataAtualizado;

	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNoticiaConteudo() {
		return noticiaConteudo;
	}

	public void setNoticiaConteudo(String noticiaConteudo) {
		this.noticiaConteudo = noticiaConteudo;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
