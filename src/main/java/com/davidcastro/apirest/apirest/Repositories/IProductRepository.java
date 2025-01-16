package com.davidcastro.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidcastro.apirest.apirest.Entities.Product;

//La interfaz IProductRepository extiende (hereda) de JpaRepository
//Product: Especifica la entidad con la que trabajará este repositorio. En este caso, Product es la entidad.
//Long: Especifica el tipo del ID de la entidad Product. En este caso, el ID es de tipo Long.
public interface IProductRepository extends JpaRepository<Product,Long> {

}
/*
    La interfaz JpaRepository proporciona varios métodos predeterminados que puedes usar para gestionar la persistencia de datos (JPA) sin necesidad de implementarlos tú mismo. Algunos de estos métodos incluyen:

    save(S entity): Guarda una entidad, insertándola o actualizándola.
    findById(ID id): Encuentra una entidad por su ID.
    findAll(): Encuentra todas las entidades.
    deleteById(ID id): Elimina una entidad por su ID.
    count(): Cuenta el número de entidades.

 */
