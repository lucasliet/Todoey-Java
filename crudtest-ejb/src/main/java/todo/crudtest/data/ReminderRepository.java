/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package todo.crudtest.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import todo.crudtest.model.Reminder;

@ApplicationScoped
public class ReminderRepository {

    @Inject
    private EntityManager em;

    public Reminder findById(Long id) {
        return em.find(Reminder.class, id);
    }

    public Reminder findByTitle(String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteria = cb.createQuery(Reminder.class);
        Root<Reminder> reminder = criteria.from(Reminder.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(reminder).where(cb.equal(reminder.get(reminder_.name), email));
        criteria.select(reminder).where(cb.equal(reminder.get("title"), title));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Reminder> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteria = cb.createQuery(Reminder.class);
        Root<Reminder> reminder = criteria.from(Reminder.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(reminder).orderBy(cb.asc(reminder.get(reminder_.name)));
        criteria.select(reminder).orderBy(cb.asc(reminder.get("title")));
        return em.createQuery(criteria).getResultList();
    }
}
