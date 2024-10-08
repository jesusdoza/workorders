package org.company.orm.jpa;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntityId<T extends Serializable> implements Serializable, EntityId<T> {

    private T id;

    protected AbstractEntityId() {
    }

    protected AbstractEntityId(T id) {
        this.id = Objects.requireNonNull(id);
    }


    @Override
    public T getId() {
        return id;
    }

    @Override
    public String asString() {
        return id.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {

        boolean result = false;

        if (this == o) {
            result = true;

        } else if (o instanceof AbstractEntityId) {
            AbstractEntityId other = (AbstractEntityId) o;
            result = Objects.equals(id, other.id);

        }

        return result;
    }

    @Override
    public String toString() {
        return "AbstractEntityId{" +
                "id=" + id +
                '}';
    }
}
