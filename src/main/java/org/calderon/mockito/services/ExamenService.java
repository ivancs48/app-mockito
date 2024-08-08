package org.calderon.mockito.services;

import org.calderon.mockito.models.Examen;

public interface ExamenService {

    Examen findExamenPorNombre(String nombre);

}
