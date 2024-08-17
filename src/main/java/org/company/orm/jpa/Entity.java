package org.company.orm.jpa;

public interface Entity<T extends EntityId> {
    T getId();
}