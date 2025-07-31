package org.example.memowork.controller;

import lombok.RequiredArgsConstructor;
import org.example.memowork.dto.MemoRequestDto;
import org.example.memowork.dto.MemoResponse;
import org.example.memowork.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
    //생성
    @PostMapping("/memo")
    public MemoResponse saveMemo(
            @RequestBody MemoRequestDto memoRequestDto
    ) {
        return memoService.save(memoRequestDto);
    }
    //단건 조회
    @GetMapping("/members/{memberId}")
    public MemoResponse getMember(
            @PathVariable Long memberId
    ) {
        return memoService.getMember(memberId);
    }

    //전체 조회
    @GetMapping("/memos")
    public List<MemoResponse> getMemos() {
        return memoService.getMemos();
    }

}
