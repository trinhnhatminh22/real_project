package com.ptt.mvc.service.impl;

import com.ptt.mvc.model.Project;
import com.ptt.mvc.repository.ProjectRepository;
import com.ptt.mvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProject() {
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }

    @Override
    public Project createProject(Project project) {
        Project projectCreated = projectRepository.save(project);
        return projectCreated;
    }

    @Override
    public void deleteProject(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()){
            projectRepository.delete(project.get());
        }
    }

    @Override
    public Project updateProject(Project project) {
        Project projectUpdated = projectRepository.save(project);
        return projectUpdated;
    }

    @Override
    public Project getProjectById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()){
            return project.get();
        }
        return null;
    }
}
