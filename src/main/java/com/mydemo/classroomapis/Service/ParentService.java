package com.mydemo.classroomapis.Service;

import com.mydemo.classroomapis.Repository.ParentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    public String extractUsername(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
