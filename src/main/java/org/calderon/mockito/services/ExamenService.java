package org.calderon.mockito.services;

import org.calderon.mockito.models.Examen;

import java.util.Optional;

public interface ExamenService {

    Optional<Examen> findExamenPorNombre(String nombre);

}
