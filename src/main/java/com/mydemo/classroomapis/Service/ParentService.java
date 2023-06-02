package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepository;


    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<String> getParent() {
        return null;
    }


}
