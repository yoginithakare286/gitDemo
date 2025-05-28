package com.yts.revaux.legacy.rfq.idao;

import com.yts.revaux.legacy.rfq.vo.UserVO;
import java.util.List;

public interface UserIDAO {
    List<UserVO> fetchAllUsers();
}
