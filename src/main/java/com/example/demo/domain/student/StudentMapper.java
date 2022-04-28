package com.example.demo.domain.student;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentMapper {


    Student requestToStudent(NewStudentRequest newStudentRequest);

    NewStudentRequest studentToNewStudentRequest(Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentFromNewStudentRequest(NewStudentRequest newStudentRequest, @MappingTarget Student student);
}
