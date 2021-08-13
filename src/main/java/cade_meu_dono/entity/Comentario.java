package cade_meu_dono.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "comentarios")
//@Inheritance(strategy = InheritanceType.JOINED) // insere os dados na tabela mãe e suas filhas
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // a tabela mãe e filhas serão independentes, sem nenhuma
// ligação
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // essa opção é a padrão. a tabela mãe e filha tem seus atribuots
// juntados para criar uma única tabela.
@DiscriminatorColumn(name = "tipo_comentario")
@DiscriminatorValue("UL") // usuário logado
public class Comentario {

	public Comentario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "com_id")
	private Long id;

	@Column(name = "com_pagina", nullable = false, length = 255)
	private String pagina;

	@Lob
	@Column(name = "com_comentario", nullable = false)
	private String comentarioConteudo;

	@Column(name = "com_cadastrado")
	@CreationTimestamp
	private Calendar dataCadastro;

	@Column(name = "com_atualizado")
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

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getComentarioConteudo() {
		return comentarioConteudo;
	}

	public void setComentarioConteudo(String comentarioConteudo) {
		this.comentarioConteudo = comentarioConteudo;
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
