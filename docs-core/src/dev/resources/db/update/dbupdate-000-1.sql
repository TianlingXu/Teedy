-- Use FILE so Lucene index persists across server restarts (dev persistence)
update T_CONFIG set CFG_VALUE_C = 'FILE' where CFG_ID_C = 'LUCENE_DIRECTORY_STORAGE';