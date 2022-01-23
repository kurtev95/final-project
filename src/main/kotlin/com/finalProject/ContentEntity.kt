package com.finalProject

import javax.persistence.*

@Entity
class ContentEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0 ,
    val content: String
)