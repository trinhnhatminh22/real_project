package com.ptt.mvc.common;

import com.ptt.mvc.model.Project;

public class Mapped {
    public static Project mappedProject(Project projectOld, Project projectNew){
        if(projectNew.getNumber() == 0){
            projectNew.setNumber(projectOld.getNumber());
        }
        if(projectNew.getStart() == null){
            projectNew.setStart(projectOld.getStart());
        }
        projectNew.setListTask(projectOld.getListTask());
        projectNew.setEmployees(projectOld.getEmployees());
        return projectNew;
    }


}
