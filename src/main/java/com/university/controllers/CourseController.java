package com.university.controllers;

import com.university.CRUDRepository;
import com.university.models.Course.Course;
import com.university.models.Student;

import java.util.ArrayList;
import java.util.List;


public class CourseController implements CRUDRepository<Course> {
        private final List<Course> courses;

        public CourseController() {
            this.courses = new ArrayList<>();
        }

        /**
         * @param entity the entity to be created
         */
        public void create(Course entity) {
            courses.add(entity);
        }

        @Override
        public void createWithParams(List<String> params) {
            try {
                Course course = new Course(Integer.parseInt(params.get(1)), params.get(2),null, null);

                int id = Integer.parseInt(params.getFirst());
                if (id <= 0) throw new NumberFormatException("Invalid ID");

                course.setId(id);
                this.create(course);

                System.out.println("Course Created Successfully");
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID");
            }
        }

        /**
         * @param id the unique identifier of the entity to be read
         * @return found course
         */
        @Override
        public Course read(int id) {
            return courses
                    .stream()
                    .filter(course -> course.getId() == id)
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public List<Course> readAll() {
            return courses;
        }

        /**
         * @param id     the unique identifier of the entity to be updated
         * @param entity the updated entity information
         */
        @Override
        public void update(int id, Course entity) throws RuntimeException {
            Course oldCourse = courses.stream()
                    .filter(s -> s.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (oldCourse == null) {
                throw new RuntimeException("Course not found");
            }

            oldCourse.setClassroom(entity.getClassroom());
            oldCourse.setSubject(entity.getSubject());
            oldCourse.setId(entity.getId());
        }

        @Override
        public void updateWithParams(List<String> params) {
            try {
                Course course = new Course(Integer.parseInt(params.get(1)), params.get(2), null, null);

                int id = Integer.parseInt(params.getFirst());
                if (id <= 0) throw new NumberFormatException("Invalid ID");

                course.setId(id);
                this.update(id, course);

                System.out.println("Course updated Successfully");
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID");
            } catch (RuntimeException e) {
                System.out.println("Not found");
            }
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
                System.out.println("Course not found");
                return;
            }

            courses.removeIf(course -> course.getId() == id);
            System.out.println("Course Removed Successfully");
        }

        @Override
        public String getIdentifier() {
            return "Course";
        }

        @Override
        public Class<Course> getEntityClass() {
            return Course.class;
        }
    }

