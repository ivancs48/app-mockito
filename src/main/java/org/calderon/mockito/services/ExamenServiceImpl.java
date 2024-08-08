package org.calderon.mockito.services;

import org.calderon.mockito.models.Examen;
import org.calderon.mockito.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService {

    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen findExamenPorNombre(String nombre) {
        Optional<Examen> examenOptional = examenRepository.findAll().stream()
                .filter(e -> e.getNombre().equals(nombre))
                .findFirst();
        Examen examen = null;
        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow();
        }
        return examen;
    }

}
