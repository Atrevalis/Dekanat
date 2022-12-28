package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Mark;
import com.dekanat.dekanat.server.repository.DepartmentRepository;
import com.dekanat.dekanat.server.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    public void createMark(int thatMark) {
        Mark mark = new Mark();
        mark.setMark(thatMark);

        markRepository.save(mark);
    }

    public void deleteMark(Mark mark) {
        markRepository.delete(mark);
    }

   // public List<Department> findAll(){
   //     return departmentRepository.findAll();
    //}
}
