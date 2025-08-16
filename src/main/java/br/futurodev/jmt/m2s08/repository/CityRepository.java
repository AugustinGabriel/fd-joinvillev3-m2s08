package br.futurodev.jmt.m2s08.repository;

import br.futurodev.jmt.m2s08.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

    /* ************ */
    /* DerivedQuery */
    /* ************ */
    List<CityEntity> findByNameContainsIgnoreCaseOrderById(String name);
    List<CityEntity> findByEstadoSiglaIgnoreCaseOrderById(String sigla);
    List<CityEntity> findByNameContainsIgnoreCaseOrEstadoSiglaIgnoreCaseOrderById(String name, String sigla);

    /* **** */
    /* JPQL */
    /* **** */
    @Query("SELECT c " +
            "FROM CityEntity c " +
            "WHERE UPPER(c.name) LIKE UPPER('%' || :name || '%') " +
            "ORDER BY c.id")
    List<CityEntity> findByNameOrderById(String name);

    @Query("SELECT c " +
            "FROM CityEntity c " +
            "WHERE UPPER(c.estado.sigla) LIKE UPPER('%' || :estadoSigla || '%') " +
            "ORDER BY c.id")
    List<CityEntity> findByEstadoSiglaOrderById(String estadoSigla);

    @Query("SELECT c " +
            "FROM CityEntity c " +
            "WHERE UPPER(c.name)         LIKE UPPER('%' || :name        || '%') " +
            "   OR UPPER(c.estado.sigla) LIKE UPPER('%' || :estadoSigla || '%') " +
            "ORDER BY c.id")
    List<CityEntity> findByNameOrEstadoSiglaOrderById(String name, String estadoSigla);

    /* ********** */
    /* SQL Nativo */
    /* ********** */
    @Query(value = "SELECT * " +
            "FROM cities " +
            "WHERE UPPER(name) LIKE UPPER('%' || :name || '%') " +
            "ORDER BY id", nativeQuery = true)
    List<CityEntity> findByName(String name);

    @Query(value = "SELECT c.* " +
            "FROM cities c " +
            "JOIN estados e ON e.id = c.estado_id " +
            "WHERE UPPER(e.sigla) LIKE UPPER('%' || :estadoSigla || '%') " +
            "ORDER BY c.id", nativeQuery = true)
    List<CityEntity> findByEstadoSigla(String estadoSigla);

    @Query(value = "SELECT c.* " +
            "FROM cities c " +
            "JOIN estados e ON e.id = c.estado_id " +
            "WHERE UPPER(name)    LIKE UPPER('%' || :name        || '%') " +
            "   OR UPPER(e.sigla) LIKE UPPER('%' || :estadoSigla || '%') " +
            "ORDER BY c.id", nativeQuery = true)
    List<CityEntity> findByNameOrEstadoSigla(String name, String estadoSigla);

}
