package org.example.memowork.service;

import lombok.RequiredArgsConstructor;
import org.example.memowork.dto.MemoRequestDto;
import org.example.memowork.dto.MemoResponse;
import org.example.memowork.entity.Memo;
import org.example.memowork.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memorepository;

    @Transactional
    public MemoResponse save(MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto.getTitle(), memoRequestDto.getContent());
        Memo savememo = memorepository.save(memo);

        return new MemoResponse(savememo.getId(), savememo.getTitle(), savememo.getContent());
    }
    //단건 조회
    @Transactional(readOnly = true)
    public MemoResponse getMemo(long id) {
        Memo memo = memorepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 메모는 없다니까?"));
        return new MemoResponse(
                memo.getId(),
                memo.getTitle(),
                memo.getContent()
        );
    }

    //전체 조회
    @Transactional(readOnly = true)
    public List<MemoResponse> getMemos() {
        List<Memo> memoList = memorepository.findAll();

        List<MemoResponse> memoResponseList = new ArrayList<>();
        for (Memo memo : memoList) {
            MemoResponse memoResponse = new MemoResponse(memo.getId(), memo.getTitle(), memo.getContent());
            memoResponseList.add(memoResponse);
        }
        return memoResponseList;
    }

    //단건 수정
    @Transactional
    public MemoResponse updateMemo(Long id, MemoRequestDto memberRequest) {
        Memo member = memorepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("그런 메모 없어요잉"));
        member.updateMemo(memberRequest.getTitle(), memberRequest.getContent());

        return new MemoResponse(member.getId(), member.getTitle(), member.getContent());
    }

}
