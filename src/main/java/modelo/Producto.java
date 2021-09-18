package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_productos")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@Column(name = "idprod" )
	private String idProducto;
	private String descripcion;
	private int stock;
	private double precio;
	@Column(name = "idcategoria" )
	private int idCategoria;
	private int estado;
	

	
}
