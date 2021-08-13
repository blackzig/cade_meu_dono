package cade_meu_dono.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animal_midia_nl")
@DiscriminatorValue("UNL")
public class AnimalMidiaNL extends AnimalMidia {

	public AnimalMidiaNL() {
	}

	@ManyToOne
	@JoinColumn(name = "adnl_id")
	private AnimalDesaparecidoNL animalDesaparecidoNL;

}
