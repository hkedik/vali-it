package com.example.demo.domain.student;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentMapper {
    Student requestToStudent(StudentInfoRequest studentInfoRequest);

    StudentInfoRequest studentToStudentInfoRequest(Student student);

    @Mapping(source = "id", target = "studentId")
    StudentInfoResponse studentToStudentInfoResponse(Student student);

   List <StudentInfoRequest> studentToStudentInfoRequest(List <Student> student);

   @Mapping(source = "id", target = "studentId")
   List <StudentInfoResponse> studentToStudentInfoResponse(List <Student> student);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromStudentInfoRequest(StudentInfoRequest studentInfoRequest, @MappingTarget Student student);
}
