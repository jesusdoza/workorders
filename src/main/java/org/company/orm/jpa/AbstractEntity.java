package org.company.orm.jpa;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;


@MappedSuperclass
public abstract class AbstractEntity<T extends EntityId> implements Entity<T> {
    @EmbeddedId
    private T id;

    protected AbstractEntity() {
    }

    public AbstractEntity(T id) {
        if (id != null) {
            this.id = id;
        }
    }


    @Override
    public T getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else if (obj instanceof AbstractEntity) {
            AbstractEntity other = (AbstractEntity) obj;
            result = Objects.equals(id, other.id);
        }
        return result;
    }


    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}
