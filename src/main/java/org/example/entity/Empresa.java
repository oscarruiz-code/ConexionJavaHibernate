package org.example.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una empresa en el sistema.
 * Incluye detalles sobre la empresa, como su nombre, industria y departamentos asociados.
 *
 * @autor oscarruiz-code
 */
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "industria")
    private String industria;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Departamento> departamentos = new ArrayList<>();

    public Empresa() {}

    public Empresa(String nombre, String industria) {
        this.nombre = nombre;
        this.industria = industria;
    }

    public void addDepartamento(Departamento departamento) {
        departamentos.add(departamento);
        departamento.setEmpresa(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIndustria() {
        return industria;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
