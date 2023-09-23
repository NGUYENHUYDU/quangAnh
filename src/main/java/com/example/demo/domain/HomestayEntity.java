package com.example.demo.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Table(name = "homestay")
@Entity
@Where(clause = "is_delete = 0")
public class HomestayEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long categoryId;

    private String firstAddress;

    private String secondAddress;

    @ManyToMany(mappedBy = "homestay",cascade = CascadeType.ALL)
    List<ServiceEntity> services;

    @Column(name = "is_delete")
    private boolean isDelete;

    public HomestayEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public List<ServiceEntity> getServices() {
        return services;
    }

    public void setServices(List<ServiceEntity> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomestayEntity that = (HomestayEntity) o;
        return isDelete == that.isDelete && Objects.equals(id, that.id) && Objects.equals(categoryId, that.categoryId) && Objects.equals(firstAddress, that.firstAddress) && Objects.equals(secondAddress, that.secondAddress) && Objects.equals(services, that.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, firstAddress, secondAddress, services, isDelete);
    }

    @Override
    public String toString() {
        return "HomestayEntity{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", firstAddress='" + firstAddress + '\'' +
                ", secondAddress='" + secondAddress + '\'' +
                ", services=" + services +
                ", isDelete=" + isDelete +
                '}';
    }
}
