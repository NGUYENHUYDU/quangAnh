package com.example.demo.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "category")
@Entity
@Where(clause = "is_delete = 0")
public class CategoryEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String homestayId;

    @Column(name = "is_delete")
    private boolean isDelete;//"1,2,3,4"

    public CategoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomestayId() {
        return homestayId;
    }

    public void setHomestayId(String homestayId) {
        this.homestayId = homestayId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return isDelete == that.isDelete && Objects.equals(id, that.id) && Objects.equals(homestayId, that.homestayId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homestayId, isDelete);
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", homestayId='" + homestayId + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
