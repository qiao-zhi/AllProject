ALTER TABLE evaluation_result ADD COLUMN checkDate DATE not null;
UPDATE evaluation_result SET checkDate='2016-08-04';