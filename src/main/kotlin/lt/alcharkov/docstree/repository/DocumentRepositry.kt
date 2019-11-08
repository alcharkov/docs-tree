package lt.alcharkov.docstree.repository

import lt.alcharkov.docstree.model.Document
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocumentRepositry: JpaRepository<Document, Long> {
}