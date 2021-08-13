package cade_meu_dono.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comentarios_nl")
@DiscriminatorValue("UNL") // usuário não logada
public class ComentarioNL extends Comentario {

	public ComentarioNL() {
	}

}
