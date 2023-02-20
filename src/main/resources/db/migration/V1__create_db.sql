CREATE TABLE Words
  (
    id        INT GENERATED ALWAYS AS IDENTITY,
    word       VARCHAR(20) UNIQUE
  );
