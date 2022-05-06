package com.example.demo.domain.student_balance_log;

import com.example.demo.domain.student_balance.StudentBalance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentBalanceLogService {

    @Resource
    private StudentBalanceLogRepository studentBalanceLogRepository;


    public void addMoneyBalanceLog(BigDecimal amount, StudentBalance balance) {
        StudentBalanceLog studentBalanceLog = new StudentBalanceLog();
        studentBalanceLog.setStudentBalance(balance);
        studentBalanceLog.setAmount(amount);
        studentBalanceLog.setDateTime(Instant.now());
        studentBalanceLog.setType("i");
        studentBalanceLogRepository.save(studentBalanceLog);
    }

    public void addCreditBalanceLog(StudentBalanceLogRequest logRequest) {
        StudentBalanceLog studentBalanceLog = new StudentBalanceLog();
        studentBalanceLog.setStudentBalance(logRequest.getStudentBalance());
        studentBalanceLog.setExpence(logRequest.getExpense());
        studentBalanceLog.setDateTime(Instant.now());
        studentBalanceLog.setAmount(logRequest.getAmount());
        studentBalanceLog.setType("o");
        studentBalanceLogRepository.save(studentBalanceLog);

    }

    public List<StudentBalanceLogResponse> findStudentBalanceLogsByStudentId(Integer studentId) {
        List<StudentBalanceLog> logs = studentBalanceLogRepository.findByStudentId(studentId);
        List<StudentBalanceLogResponse> responses = new ArrayList<>();
        for (StudentBalanceLog log : logs) {
            StudentBalanceLogResponse response = new StudentBalanceLogResponse();
            response.setAmount(log.getAmount());
            response.setDateTime(log.getDateTime());
            response.setType(log.getType());
            if (response.getType().equals("i")) {
                response.setTransferName("Deposit");
                response.setDescription("Added funds");
            } else if (response.getType().equals("o")) {
                response.setTransferName(log.getExpence().getName());
                response.setDescription(log.getExpence().getDescription());
            }
            responses.add(response);
        }
        return responses;
    }
}
