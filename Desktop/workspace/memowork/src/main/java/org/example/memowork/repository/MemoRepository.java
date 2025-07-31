package org.example.memowork.repository;

import org.example.memowork.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo,  Long> {
}
