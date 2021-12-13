package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "prod_id_col")
	private Integer prodId;
	@Column(name = "prod_name_col")
	private String prodName;
	@Column(name = "prod_cost_col")
	private Double prodCost;
	@Column(name = "prod_img_col")
	private String prodImg;
	@Column(name = "prod_stock_col")
	private Integer prodStock;
	@Column(name = "prod_note_col")
	private String prodNotes;

}
