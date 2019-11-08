package lt.alcharkov.docstree.service

import lt.alcharkov.docstree.model.Document
import java.util.*

interface DocumentService {
    fun getDocumentHierarchy(id: Long): List<Document>
    fun saveDocument(document: Document) {
    }
}