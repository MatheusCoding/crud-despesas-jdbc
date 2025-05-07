//CRIADO E COMENTADO POR MATHEUS DE OLIVEIRA MEDEIROS
package org.example.dao;

import java.util.List;
import org.example.model.Categoria;
import org.example.model.Despesa;

import java.util.Optional;

    //  INTERFACES CRUD

public interface IDespesaDAO {
    Despesa save (Despesa despesa);
    Despesa update (Despesa despesa);
    void delete (Long id);
    List<Despesa> findAll();
    Optional<Despesa> findById (Long id);
    List<Despesa> findByCategoria (Categoria categoria);
}
