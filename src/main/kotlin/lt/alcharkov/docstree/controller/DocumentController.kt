package lt.alcharkov.docstree.controller

import lt.alcharkov.docstree.model.Document
import lt.alcharkov.docstree.service.DocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
private class DocumentController() {

    @Autowired
    lateinit var documentService: DocumentService

    @PostMapping("/add")
    fun addDocument(@RequestBody document: Document) {
        return documentService.saveDocument(document)
    }

    @GetMapping("/document/{id}")
    fun getDocumentHierarchy(@PathVariable("id") id: Long): List<Document> {
        return documentService.getDocumentHierarchy(id)
    }
}
