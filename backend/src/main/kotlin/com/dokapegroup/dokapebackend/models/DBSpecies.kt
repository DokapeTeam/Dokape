package com.dokapegroup.dokapebackend.models

import com.dokapegroup.dokapebackend.models.abstract.BaseEntity
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table
class DBSpecies(
    @Id
    @SequenceGenerator(
        name = SPECIES_GENERATOR,
        sequenceName = SPECIES_GENERATOR,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = SPECIES_GENERATOR
    )
    override var id: Long? = null,
    var name: String,
    @OneToMany(mappedBy = "species")
    var speciesTypes: MutableList<DBSpeciesType>,
    override var createdAt: LocalDateTime = LocalDateTime.now(),
    override var updatedAt: LocalDateTime = LocalDateTime.now(),
) : BaseEntity() {
    companion object {
        private const val SPECIES_GENERATOR = "species_generator"
    }
}
