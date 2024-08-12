package org.calderon.mockito.repositories;

import org.calderon.mockito.models.Examen;

import java.util.List;

public interface ExamenRepository {

    Examen guardar(Examen exam);
    List<Examen> findAll();

}
