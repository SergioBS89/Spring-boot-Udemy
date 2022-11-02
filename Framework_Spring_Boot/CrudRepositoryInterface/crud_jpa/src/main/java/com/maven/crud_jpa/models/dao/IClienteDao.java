package com.maven.crud_jpa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.maven.crud_jpa.models.entity.Cliente;




/* -------------------------------------------------------------------------- */
/*     CUANDO HACEMOS USO DE CRUD Repository DEBEMOS extenderLA LIBRERIA     */
/* -------------------------------------------------------------------------- */

// LA IMPORTANCIA DE TRABAJAR CON ESTA LIBRERIA ES LA RAPIDEZ Y EL POCO CODIGO NECESARIO PARA LA CREACION DE UN CRUD Y LA CANTIDAD DE 
// METODOS QUE TIENE PREDEFINIDOS (PINCHAR ENCIMA DE CRUD REPOSITORY PARA VER METODOS)

//LOS PARAMETROS DE CRUD REPOSITORY:
//1º = EL TIPO DE LA ENTIDAD QUE USAREMOS
//2º = TIPO DE ID O PRIMARY KEY
//NO NECESITA ANOTACIONES, ES UNA INTERFAZ ESPECIAL DE SPRING 
public interface IClienteDao extends CrudRepository<Cliente,Long>{
    

}