package com.bitc.securityquiz.service;

import com.bitc.securityquiz.data.dto.AddMemberRequest;

public interface MemberService {
    String save (AddMemberRequest dto);
}
