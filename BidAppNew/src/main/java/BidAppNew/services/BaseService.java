package BidAppNew.services;

public interface BaseService<E, ID> {
        E save(E entity);
        E findById(ID id);
        E update(ID id);
}
