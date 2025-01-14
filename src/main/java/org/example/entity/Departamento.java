package org.example.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un departamento en una empresa.
 * Incluye detalles sobre el departamento, como su nombre y empleados asociados.
 *
 * @autor oscarruiz-code
 */
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento() {}

    public Departamento(String nombre, Empresa empresa) {
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(this);
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
