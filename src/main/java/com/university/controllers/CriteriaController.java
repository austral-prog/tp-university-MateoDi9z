package com.university.controllers;

import com.university.CRUDRepository;
import com.university.models.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CriteriaController implements CRUDRepository<Criteria> {
    private final List<Criteria> criterias;

    public CriteriaController() { this.criterias = new ArrayList<>(); }

    /**
     * @param entity the entity to be created
     * @return
     */
    @Override
    public int create(Criteria entity) {
        Criteria found = this.criterias.stream()
                .filter(x -> x.equals(entity))
                .findFirst().orElse(null);

        if (found != null) {
            return found.getId();
        }

        criterias.add(entity);
        return entity.getId();
    }

    /**
     * @param params
     */
    @Override
    public void createWithParams(List<String> params) {
        // TODO: IMPLEMENT
    }

    /**
     * @param id the unique identifier of the entity to be read
     * @return
     */
    @Override
    public Criteria read(int id) {
        return criterias
                .stream()
                .filter(criteria -> criteria.getId() == id)
                .findFirst().orElse(null);
    }

    /**
     * @return
     */
    @Override
    public List<Criteria> readAll() { return criterias; }

    /**
     * @param id     the unique identifier of the entity to be updated
     * @param entity the updated entity information
     */
    @Override
    public void update(int id, Criteria entity) throws RuntimeException {
        Criteria oldCriteria = read(id);

        if (oldCriteria == null) {
            throw new RuntimeException("Criteria not found");
        }

        oldCriteria.setCriteriaValue(entity.getCriteriaValue());
        oldCriteria.setCriteria(entity.getCriteria());
        oldCriteria.setSubject(entity.getSubject());
        oldCriteria.setId(entity.getId());
    }

    /**
     * @param params
     */
    @Override
    public void updateWithParams(List<String> params) {
        // TODO: IMPLEMENT
    }

    /**
     * @param id the unique identifier of the entity to be deleted
     */
    @Override
    public void delete(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID");
            return;
        }

        if (read(id) == null) {
            System.out.println("Criteria not found");
            return;
        }

        criterias.removeIf(criteria -> criteria.getId() == id);
        System.out.println("Criteria Removed Successfully");
    }

    public Criteria findCriteria(String subject, String evaluationName) {
        return criterias
                .stream()
                .filter(criteria -> criteria.getSubject().equals(subject) &&
                        criteria.getEvaluation().equals(evaluationName))
                .findFirst().orElse(null);
    }

    /**
     * @return
     */
    @Override
    public String getIdentifier() { return "Criteria"; }

    /**
     * @return
     */
    @Override
    public Class<Criteria> getEntityClass() { return Criteria.class; }
}
