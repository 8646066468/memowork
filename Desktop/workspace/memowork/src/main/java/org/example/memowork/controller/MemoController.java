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
    @GetMapping("/memo/{memoId}")
    public MemoResponse getMemo(
            @PathVariable Long memoId
    ) {
        return memoService.getMemo(memoId);
    }

    //전체 조회
    @GetMapping("/memos")
    public List<MemoResponse> getMemos() {
        return memoService.getMemos();
    }

    //단건 수정
    @PutMapping("/memo/{memoId}")
    public MemoResponse updateMemo(
            @PathVariable Long memoId,
            @RequestBody MemoRequestDto memoRequestDto
    ){
        return memoService.updateMemo(memoId, memoRequestDto);
    }

    //단건 삭제
    @DeleteMapping(("/memo/{memoId}"))
    public void deleteMemo(
            @PathVariable Long memoId
    ){
        memoService.deleteMemo(memoId);
    }
}
