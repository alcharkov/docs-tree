DROP TABLE IF EXISTS document;

CREATE TABLE document (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  parent_id VARCHAR(250) DEFAULT NULL,
  document_name VARCHAR(250) NOT NULL,
  document_file VARCHAR(250) NOT NULL
);

INSERT INTO document (parent_id, document_name, document_file) VALUES
  (null, 'First document', '/home/user/doc1.txt'),
  ('1', 'Second document', '/home/user/doc1.txt'),
  ('2', 'Third document', '/home/user/doc1.txt');