package com.pd.api_redis_cache.service.repository;

import com.pd.api_redis_cache.service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "SELECT pg_try_advisory_lock(:id)", nativeQuery = true)
    boolean tryLock(Integer id);

    @Query(value = "SELECT pg_advisory_lock(:id)", nativeQuery = true)
    void lock(Integer id);

    @Query(value = "SELECT pg_advisory_unlock(:id)", nativeQuery = true)
    boolean relaseLock(Integer id);
@Query(value = "SELECT * from public.order where id =:id",nativeQuery = true)
    Optional<Order> findByIdo(Integer id);
}
