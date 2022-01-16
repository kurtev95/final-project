package com.finalProject

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(value = [MockitoExtension::class])
class EntityContentTest {

    @Mock
    lateinit var contentRepository: ContentRepository

    lateinit var contentService: ContentService

    @BeforeEach
    fun setup() {
        contentService = ContentService(contentRepository)
    }

    @Test
    fun testGetContentEntity() {

        whenever(contentRepository.getById(1)).thenReturn(ContentEntity(1, "test"))

        val response = contentService.getById(1)

        Assert.assertEquals("test", response.content)
    }
}