package com.example.demo.domain.student_balance;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentBalanceMapper {
    @Mapping(source = "groupBalanceId", target = "groupBalance.id")
    @Mapping(source = "groupBalanceBalance", target = "groupBalance.balance")
    @Mapping(source = "studentId", target = "student.id")
    StudentBalance studentBalanceResponseToStudentBalance(StudentBalanceResponse studentBalanceResponse);

    @InheritInverseConfiguration(name = "studentBalanceResponseToStudentBalance")
    StudentBalanceResponse studentBalanceToStudentBalanceResponse(StudentBalance studentBalance);

    @InheritConfiguration(name = "studentBalanceResponseToStudentBalance")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStudentBalanceFromStudentBalanceResponse(StudentBalanceResponse studentBalanceResponse, @MappingTarget StudentBalance studentBalance);
}
