package com.maven.crud_jpa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maven.crud_jpa.models.dao.IClienteDao;
// import com.maven.crud_jpa.models.dao.ClienteDaoImp;
import com.maven.crud_jpa.models.entity.Cliente;

//PATRON DE DISEÑO FACHADA 
//-Se usa para trabajar con los metodos propios y la interfaz de crudRepository de spring
//-Las anotaciones transactional van en este archivo
@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true) //Solo se permite la lectura de datos
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional //Para insertar no lleva propiedades
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
        
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente findOne(Long id) {
        // Retorna el registro o si no existe null
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        clienteDao.deleteById(id);
        
    }
    
}