package org.calderon.mockito.services;

import org.calderon.mockito.models.Examen;
import org.calderon.mockito.repositories.ExamenRepository;
import org.calderon.mockito.repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService {

    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository,
                             PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
        this.examenRepository = examenRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        return examenRepository.findAll().stream()
                .filter(e -> e.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if(examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public Examen guardar(Examen exam) {
        if(!exam.getPreguntas().isEmpty()){
            preguntaRepository.guardarVarias(exam.getPreguntas());
        }
        return examenRepository.guardar(exam);
    }

}
