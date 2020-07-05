package com.example.user.entity

import javax.persistence.*

@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false, updatable = true)
        var email: String
) {
}