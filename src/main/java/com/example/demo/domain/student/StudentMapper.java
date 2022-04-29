package com.example.demo.domain.student;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentMapper {
    Student requestToStudent(StudentInfoRequest studentInfoRequest);

    StudentInfoRequest studentToStudentInfoRequest(Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromStudentInfoRequest(StudentInfoRequest studentInfoRequest, @MappingTarget Student student);
}
