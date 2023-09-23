package com.example.demo.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Table(name = "service")
@Entity
@Where(clause = "is_delete = 0")
public class ServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "service",cascade = CascadeType.ALL)
    List<HomestayEntity> homestays;

    @Column(name = "is_delete")
    private boolean isDelete;

    public ServiceEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HomestayEntity> getHomestays() {
        return homestays;
    }

    public void setHomestays(List<HomestayEntity> homestays) {
        this.homestays = homestays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return isDelete == that.isDelete && Objects.equals(id, that.id) && Objects.equals(homestays, that.homestays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homestays, isDelete);
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", homestays=" + homestays +
                ", isDelete=" + isDelete +
                '}';
    }
}
