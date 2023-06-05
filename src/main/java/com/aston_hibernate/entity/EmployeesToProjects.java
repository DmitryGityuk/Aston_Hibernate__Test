package com.aston_hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employees_to_projects", schema = "public", catalog = "aston")
@IdClass(EmployeesToProjectsPK.class)
public class EmployeesToProjects {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id", nullable = false)
    private int employeeId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "project_id", nullable = false)
    private int projectId;
    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    private Employee employeesByEmployeeId;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false, referencedColumnName = "id", nullable = false)
    private Project projectsByProjectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesToProjects that = (EmployeesToProjects) o;

        if (employeeId != that.employeeId) return false;
        if (projectId != that.projectId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + projectId;
        return result;
    }
}
