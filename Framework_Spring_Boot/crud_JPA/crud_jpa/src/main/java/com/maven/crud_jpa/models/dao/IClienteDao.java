package com.maven.crud_jpa.models.dao;
import java.util.List;
import com.maven.crud_jpa.models.entity.Cliente;






public interface IClienteDao {
    
    //Metodo que hace un SELECT de todos los registros de la base de datos
    public List<Cliente> findAll();

    //Metodo para crear INSERT
    public void save(Cliente cliente);

    //Metodo para editar
    public Cliente findOne(Long id);

    //metodo para eliminar
    public void remove (Long id);
}