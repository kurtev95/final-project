package com.finalProject


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/content")
class Controller(
    val contentService: ContentService
) {

//
//    @GetMapping
//    fun getText(): String {
//        return "test"
//    }
//

    @GetMapping("/content/{id}")
    fun getContent(@PathVariable id: String): ContentEntity {
        return contentService.getById(id.toLong())
    }

    @PostMapping
    fun createText(input: String): ContentEntity {
        return contentService.createEntity(input)
    }
}
