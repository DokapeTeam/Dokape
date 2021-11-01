package com.dokapegroup.dokapebackend.user

import com.dokapegroup.dokapebackend.models.DBUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class DokapeUserDetails(val user: DBUser) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(user.role))
    }

    override fun getPassword(): String {
        return user.hashedPassword
    }

    override fun getUsername(): String {
        return user.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
