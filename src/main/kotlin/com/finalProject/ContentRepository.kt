package com.finalProject

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentRepository:JpaRepository<ContentEntity,Long> {
}