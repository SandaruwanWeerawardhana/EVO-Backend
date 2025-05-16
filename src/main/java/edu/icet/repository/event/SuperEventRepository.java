package edu.icet.repository.event;

public interface SuperEventRepository<T> {
    T add (T entity);
    T update (T entity);
    T getByEventId (Long eventId);
}