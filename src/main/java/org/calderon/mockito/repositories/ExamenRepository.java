package org.calderon.mockito.repositories;

import org.calderon.mockito.models.Examen;

import java.util.List;

public interface ExamenRepository {

    List<Examen> findAll();

}
