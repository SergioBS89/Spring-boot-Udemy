package com.maven.crud_jpa.models.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes") // Nombre de la tabla en la BBDD
public class Cliente implements Serializable {

    @Id // Indica que es el primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicamos que es autoIncrementable
    private Long id;

    @Column(length = 20) // Podemos personalizar cada columna con esta anotacion
    private String nombre;
    private String apellidos;
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE) // Indicamos el tipo de fecha
    private Date createAt;

    private static final long serialVersionUID = 1L;

    //METODO PARA INSERTAR FECHA AUTOMATICAMENTE AL CREAR REGISTRO, ACTUALIZAR
    @PrePersist
    @PreUpdate
    public void prePersist(){
        createAt= new Date();
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Date return the createAt
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

}