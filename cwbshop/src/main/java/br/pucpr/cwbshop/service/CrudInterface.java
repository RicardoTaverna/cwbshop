package br.pucpr.cwbshop.service;


import java.util.List;
import java.util.Optional;

/**
 * The interface Crud interface.
 *
 * @param <T> the type parameter
 */
public interface CrudInterface<T>  {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<T> findAll();

    /**
     * Save optional.
     *
     * @param entity the entity
     * @return the optional
     */
    Optional<T> save(T entity);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<T> findById(long id);

    /**
     * Delete.
     *
     * @param entity the entity
     */
    void delete(T entity);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(long id);

    /**
     * Count long.
     *
     * @return the long
     */
    long count();


}
