package com.ecole.MySchoo.ServiceImpl;

import com.ecole.MySchoo.dto.TeacherResponseDto;
import com.ecole.MySchoo.model.Gender;
import com.ecole.MySchoo.model.Teacher;
import com.ecole.MySchoo.repository.TeacherRepository;
import com.ecole.MySchoo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher createTeacher(TeacherResponseDto teacherResponseDto) {
        Teacher teacher =new Teacher();
        teacher.setFirstName(teacherResponseDto.getFirstName());
        teacher.setLastName(teacherResponseDto.getLastName());
        teacher.setGender(Gender.valueOf(teacherResponseDto.getGender()));
        teacher.setAddress(teacherResponseDto.getAddress());
        teacher.setEmail(teacherResponseDto.getEmail());
        teacher.setPhone(teacherResponseDto.getPhone());
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, TeacherResponseDto teacherResponseDto) {
        Teacher teacher=teacherRepository.findById(id).get();
        teacher.setFirstName(teacherResponseDto.getFirstName());
        teacher.setLastName(teacherResponseDto.getLastName());
        teacher.setGender(Gender.valueOf(teacherResponseDto.getGender()));
        teacher.setAddress(teacherResponseDto.getAddress());
        teacher.setEmail(teacherResponseDto.getEmail());
        teacher.setPhone(teacherResponseDto.getPhone());
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
    teacherRepository.deleteById(id);
    }
}
