package com.finalProject

import org.springframework.stereotype.Service

@Service
class ContentService(
    val contentRepository: ContentRepository
) {
    fun getById(id: Long): ContentEntity {
        return contentRepository.getById(id)
    }

    fun createEntity(input: String): ContentEntity {
        return contentRepository.save(ContentEntity(content = input))
    }
}