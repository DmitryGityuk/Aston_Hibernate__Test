package com.aston_hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "surname", nullable = false, length = 30)
    private String surname;
    @Column(name = "position_id", nullable = true)
    private Integer positionId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Position positionsByPositionId;

    @JsonIgnore
    @OneToMany(mappedBy = "employeesByEmployeeId")
    private List<EmployeesToProjects> employeesToProjectsById;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employees = (Employee) o;

        if (id != employees.id) return false;
        if (name != null ? !name.equals(employees.name) : employees.name != null) return false;
        if (surname != null ? !surname.equals(employees.surname) : employees.surname != null) return false;
        if (positionId != null ? !positionId.equals(employees.positionId) : employees.positionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (positionId != null ? positionId.hashCode() : 0);
        return result;
    }
}
