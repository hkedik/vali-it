import com.example.demo.domain.group_info.GroupInfo;
import com.example.demo.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {


    public static final String INCORRECT_DETAILS = "Incorrect details";
    public static final String NOT_ALLOWED_LOG_IN_DETAILS = "Not allowed log-in details";


    public void isLoginOk(Optional<User> user) {
        if (user.isEmpty()) {
            throw new BusinessException(INCORRECT_DETAILS, NOT_ALLOWED_LOG_IN_DETAILS);
        }
    }

    public void groupExists(Optional<GroupInfo> group) {
        if (group.isPresent()) {
            throw new BusinessException("Group with that name already exists", "Change the group name");
        }
    }