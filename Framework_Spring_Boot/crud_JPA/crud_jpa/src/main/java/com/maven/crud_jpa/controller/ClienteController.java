package com.maven.crud_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maven.crud_jpa.models.dao.IClienteDao;
import com.maven.crud_jpa.models.entity.Cliente;


@Controller
public class ClienteController {

@Autowired
//siempre que trabajemos con interfaces, es necesario crear el tipo mas generico posible
private IClienteDao clienteDao;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String listarClientes(Model model){
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("lista", clienteDao.findAll());
        return "listar";
    }
    @RequestMapping(value = "/insert")
    public String crear(Model model){
        Cliente cli = new Cliente();
        model.addAttribute("titulo", "Formulario para crear clientes");
        model.addAttribute("lista", cli);
        return "form_insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertar(Cliente cliente){
        clienteDao.save(cliente);
        return "redirect:/select";
    }

    @RequestMapping(value = "/insert/{id}")
    public String actualizar(@PathVariable(value = "id") Long id, Model model){
        Cliente cliente = null;
        if(id > 0){
           cliente = clienteDao.findOne(id);
        }else{
            return "redirect:/select";
        }
        model.addAttribute("titulo", "Editar cliente");
        model.addAttribute("lista", cliente);
        return "form_insert";
    }

    @RequestMapping(value = "/delete/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){

        if(id > 0){
            clienteDao.remove(id);
        }
        return "redirect:/select";
    }
}