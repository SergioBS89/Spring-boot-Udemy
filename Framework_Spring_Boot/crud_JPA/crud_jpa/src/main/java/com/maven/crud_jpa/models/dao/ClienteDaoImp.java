package com.maven.crud_jpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maven.crud_jpa.models.entity.Cliente;

@Repository //Anotacion para marcar la clase como componenete de persistencia de datos (DAO)
public class ClienteDaoImp implements IClienteDao{

    /* ----------- METODO PARA HACER UN SELECT DE TODOS LOS REGISTROS ----------- */
    @PersistenceContext //Para el uso de la base de datos H2 (base de datos interna de spring)
    private EntityManager em;
    @Override
    @SuppressWarnings("unchecked") //Elimina el warning de return de abajo
    @Transactional(readOnly = true) //Solo se permite la lectura de datos
    public List<Cliente> findAll() {
        
        return em.createQuery("from Cliente").getResultList();
    }
/* -- METODO PARA INSERTAR O ACTUALIZAR EN FUNCION DE SI EXISTE O NO EL ID -- */
    @Override
    @Transactional //Para insertar no lleva propiedades
    public void save(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId() > 0){
            em.merge(cliente);
        }else{
        em.persist(cliente);
        }
    }
/* -------- METODO PARA BUSCAR UN CLIENTE POR ID EN LA BASE DE DATOS -------- */
    @Override
    @Transactional(readOnly=true)
    public Cliente findOne(Long id) {           
       
        return em.find(Cliente.class, id);
    }

    /* ------------- METODO PARA ELIMINAR BUSCANDO EL ID DEL CLIENTE ------------ */
    @Override
    @Transactional
    public void remove(Long id) {
        
        Cliente cliente = findOne(id);
        em.remove(cliente);
        
    }
    
}