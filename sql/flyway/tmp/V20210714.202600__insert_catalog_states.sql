SET IDENTITY_INSERT META_CATALOG ON;


INSERT INTO META_CATALOG
  (id_catalog, desc_catalog, name_catalog)
VALUES (
  1, 'list of states in mexico','states'
);

SET IDENTITY_INSERT META_CATALOG OFF;

SET IDENTITY_INSERT META_CATALOG_VALUES ON;

INSERT INTO META_CATALOG_VALUES
  (id_catalog_value, value_catalog, label_catalog, status, id_catalog)
VALUES
  (1, 'AGUASCALIENTES', 'AGUASCALIENTES', 1, 1),
  (2, 'Baja California', 'Baja California', 1, 1),
  (3, 'Baja California Sur', 'Baja California Sur', 1, 1),
  (4, 'Campeche', 'Campeche', 1, 1);

SET IDENTITY_INSERT META_CATALOG_VALUES OFF;
