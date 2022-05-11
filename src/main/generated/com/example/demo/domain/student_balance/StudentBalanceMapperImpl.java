package com.example.demo.domain.student_balance;

import com.example.demo.domain.group_balance.GroupBalance;
import com.example.demo.domain.student.Student;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-11T12:34:15+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class StudentBalanceMapperImpl implements StudentBalanceMapper {

    @Override
    public StudentBalance studentBalanceResponseToStudentBalance(StudentBalanceResponse studentBalanceResponse) {
        if ( studentBalanceResponse == null ) {
            return null;
        }

        StudentBalance studentBalance = new StudentBalance();

        studentBalance.setGroupBalance( studentBalanceResponseToGroupBalance( studentBalanceResponse ) );
        studentBalance.setStudent( studentBalanceResponseToStudent( studentBalanceResponse ) );
        studentBalance.setId( studentBalanceResponse.getId() );
        studentBalance.setBalance( studentBalanceResponse.getBalance() );

        return studentBalance;
    }

    @Override
    public StudentBalanceResponse studentBalanceToStudentBalanceResponse(StudentBalance studentBalance) {
        if ( studentBalance == null ) {
            return null;
        }

        Integer groupBalanceId = null;
        BigDecimal groupBalanceBalance = null;
        Integer studentId = null;
        Integer id = null;
        BigDecimal balance = null;

        groupBalanceId = studentBalanceGroupBalanceId( studentBalance );
        groupBalanceBalance = studentBalanceGroupBalanceBalance( studentBalance );
        studentId = studentBalanceStudentId( studentBalance );
        id = studentBalance.getId();
        balance = studentBalance.getBalance();

        StudentBalanceResponse studentBalanceResponse = new StudentBalanceResponse( id, groupBalanceId, groupBalanceBalance, studentId, balance );

        return studentBalanceResponse;
    }

    @Override
    public void updateStudentBalanceFromStudentBalanceResponse(StudentBalanceResponse studentBalanceResponse, StudentBalance studentBalance) {
        if ( studentBalanceResponse == null ) {
            return;
        }

        if ( studentBalance.getGroupBalance() == null ) {
            studentBalance.setGroupBalance( new GroupBalance() );
        }
        studentBalanceResponseToGroupBalance1( studentBalanceResponse, studentBalance.getGroupBalance() );
        if ( studentBalance.getStudent() == null ) {
            studentBalance.setStudent( new Student() );
        }
        studentBalanceResponseToStudent1( studentBalanceResponse, studentBalance.getStudent() );
        if ( studentBalanceResponse.getId() != null ) {
            studentBalance.setId( studentBalanceResponse.getId() );
        }
        if ( studentBalanceResponse.getBalance() != null ) {
            studentBalance.setBalance( studentBalanceResponse.getBalance() );
        }
    }

    protected GroupBalance studentBalanceResponseToGroupBalance(StudentBalanceResponse studentBalanceResponse) {
        if ( studentBalanceResponse == null ) {
            return null;
        }

        GroupBalance groupBalance = new GroupBalance();

        groupBalance.setId( studentBalanceResponse.getGroupBalanceId() );
        groupBalance.setBalance( studentBalanceResponse.getGroupBalanceBalance() );

        return groupBalance;
    }

    protected Student studentBalanceResponseToStudent(StudentBalanceResponse studentBalanceResponse) {
        if ( studentBalanceResponse == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentBalanceResponse.getStudentId() );

        return student;
    }

    private Integer studentBalanceGroupBalanceId(StudentBalance studentBalance) {
        if ( studentBalance == null ) {
            return null;
        }
        GroupBalance groupBalance = studentBalance.getGroupBalance();
        if ( groupBalance == null ) {
            return null;
        }
        Integer id = groupBalance.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private BigDecimal studentBalanceGroupBalanceBalance(StudentBalance studentBalance) {
        if ( studentBalance == null ) {
            return null;
        }
        GroupBalance groupBalance = studentBalance.getGroupBalance();
        if ( groupBalance == null ) {
            return null;
        }
        BigDecimal balance = groupBalance.getBalance();
        if ( balance == null ) {
            return null;
        }
        return balance;
    }

    private Integer studentBalanceStudentId(StudentBalance studentBalance) {
        if ( studentBalance == null ) {
            return null;
        }
        Student student = studentBalance.getStudent();
        if ( student == null ) {
            return null;
        }
        Integer id = student.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void studentBalanceResponseToGroupBalance1(StudentBalanceResponse studentBalanceResponse, GroupBalance mappingTarget) {
        if ( studentBalanceResponse == null ) {
            return;
        }

        if ( studentBalanceResponse.getGroupBalanceId() != null ) {
            mappingTarget.setId( studentBalanceResponse.getGroupBalanceId() );
        }
        if ( studentBalanceResponse.getGroupBalanceBalance() != null ) {
            mappingTarget.setBalance( studentBalanceResponse.getGroupBalanceBalance() );
        }
    }

    protected void studentBalanceResponseToStudent1(StudentBalanceResponse studentBalanceResponse, Student mappingTarget) {
        if ( studentBalanceResponse == null ) {
            return;
        }

        if ( studentBalanceResponse.getStudentId() != null ) {
            mappingTarget.setId( studentBalanceResponse.getStudentId() );
        }
    }
}
