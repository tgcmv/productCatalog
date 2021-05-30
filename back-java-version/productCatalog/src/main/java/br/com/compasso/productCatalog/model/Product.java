package br.com.compasso.productCatalog.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; //TODO trocar id por string. gerar uuid
		
	@Column
	private String name;
	
	@Column
	private String description;
		
	@Column
	private BigDecimal price;
}
