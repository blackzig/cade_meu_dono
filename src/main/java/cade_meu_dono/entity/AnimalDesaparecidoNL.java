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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "animal_desaparecido_nl")
public class AnimalDesaparecidoNL {

	public AnimalDesaparecidoNL() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adnl_id")
	private Long id;

	@Column(name = "adnl_latitude", nullable = false, length = 16)
	private String latitude;

	@Column(name = "adnl_longitude", nullable = false, length = 16)
	private String longitude;

	@Column(name = "adnl_encontrou_em", nullable = false)
	@CreationTimestamp
	private Calendar dataAviso;

	@Enumerated(EnumType.STRING)
	@Column(name = "adnl_status", nullable = true, columnDefinition = "varchar(255) default 'SERA_DE_ALGUEM'")
	private Status status;

	@Lob
	@Column(name = "adnl_descricao", nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "animalDesaparecidoNL")
	private List<AnimalMidiaNL> desaparecidoMidiasNL;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Calendar getDataAviso() {
		return dataAviso;
	}

	public void setDataAviso(Calendar dataAviso) {
		this.dataAviso = dataAviso;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AnimalMidiaNL> getDesaparecidoMidiasNL() {
		return desaparecidoMidiasNL;
	}

	public void setDesaparecidoMidiasNL(List<AnimalMidiaNL> desaparecidoMidiasNL) {
		this.desaparecidoMidiasNL = desaparecidoMidiasNL;
	}

}
