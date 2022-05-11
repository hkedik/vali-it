package com.example.demo.domain.student;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-11T12:34:15+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student requestToStudent(StudentInfoRequest studentInfoRequest) {
        if ( studentInfoRequest == null ) {
            return null;
        }

        Student student = new Student();

        student.setFirstName( studentInfoRequest.getFirstName() );
        student.setLastName( studentInfoRequest.getLastName() );
        student.setDateOfBirth( studentInfoRequest.getDateOfBirth() );

        return student;
    }

    @Override
    public StudentInfoRequest studentToStudentInfoRequest(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentInfoRequest studentInfoRequest = new StudentInfoRequest();

        studentInfoRequest.setFirstName( student.getFirstName() );
        studentInfoRequest.setLastName( student.getLastName() );
        studentInfoRequest.setDateOfBirth( student.getDateOfBirth() );

        return studentInfoRequest;
    }

    @Override
    public StudentInfoResponse studentToStudentInfoResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentInfoResponse studentInfoResponse = new StudentInfoResponse();

        studentInfoResponse.setStudentId( student.getId() );
        studentInfoResponse.setFirstName( student.getFirstName() );
        studentInfoResponse.setLastName( student.getLastName() );
        studentInfoResponse.setActive( student.getActive() );

        return studentInfoResponse;
    }

    @Override
    public StudentInfoResponse toStudentInfo(StudentInfoRequest request) {
        if ( request == null ) {
            return null;
        }

        StudentInfoResponse studentInfoResponse = new StudentInfoResponse();

        studentInfoResponse.setFirstName( request.getFirstName() );
        studentInfoResponse.setLastName( request.getLastName() );

        return studentInfoResponse;
    }

    @Override
    public List<StudentInfoRequest> studentToStudentInfoRequest(List<Student> student) {
        if ( student == null ) {
            return null;
        }

        List<StudentInfoRequest> list = new ArrayList<StudentInfoRequest>( student.size() );
        for ( Student student1 : student ) {
            list.add( studentToStudentInfoRequest( student1 ) );
        }

        return list;
    }

    @Override
    public List<StudentInfoResponse> studentToStudentInfoResponse(List<Student> student) {
        if ( student == null ) {
            return null;
        }

        List<StudentInfoResponse> list = new ArrayList<StudentInfoResponse>( student.size() );
        for ( Student student1 : student ) {
            list.add( studentToStudentInfoResponse( student1 ) );
        }

        return list;
    }

    @Override
    public void updateStudentFromStudentInfoRequest(StudentInfoRequest studentInfoRequest, Student student) {
        if ( studentInfoRequest == null ) {
            return;
        }

        if ( studentInfoRequest.getFirstName() != null ) {
            student.setFirstName( studentInfoRequest.getFirstName() );
        }
        if ( studentInfoRequest.getLastName() != null ) {
            student.setLastName( studentInfoRequest.getLastName() );
        }
        if ( studentInfoRequest.getDateOfBirth() != null ) {
            student.setDateOfBirth( studentInfoRequest.getDateOfBirth() );
        }
    }
}
