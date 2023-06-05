package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Entity.Subject;
import com.mydemo.classroomapis.Repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void registerSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void updateSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
