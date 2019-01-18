package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String uuid;
    @Version
    private Integer version;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(Long id){
        this.id = id;
    }

    @PrePersist
    public void init() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractBaseEntity other = (AbstractBaseEntity) obj;
        if (uuid == null) {
            return other.uuid == null;
        } else return uuid.equals(other.uuid);
    }
}
