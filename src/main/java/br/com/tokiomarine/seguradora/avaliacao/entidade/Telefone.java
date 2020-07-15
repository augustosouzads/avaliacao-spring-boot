package br.com.tokiomarine.seguradora.avaliacao.entidade;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Telefone {
	
	@Column(name = "ddd")
    @NotNull(message = "ddd é obrigatório")
	private Integer ddd;
	
	@Column(name = "numero")
    @NotNull(message = "numero é obrigatório")
	private Integer numero;
	
	
}
